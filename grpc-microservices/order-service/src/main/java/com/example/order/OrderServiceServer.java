package com.example.order;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OrderServiceServer {

    private static final int PORT = 50052;

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(PORT)
                .addService(new OrderServiceImpl())
                .build();

        System.out.println("Starting OrderServiceServer on port " + PORT + "...");
        server.start();
        System.out.println("OrderServiceServer started.");
        server.awaitTermination();
    }

    static class OrderServiceImpl extends OrderServiceGrpc.OrderServiceImplBase {

        private final Map<String, Order.OrderResponse> orderDatabase = new HashMap<>();

        @Override
        public void createOrder(Order.CreateOrderRequest request, StreamObserver<Order.OrderResponse> responseObserver) {
            String orderId = "order-" + (orderDatabase.size() + 1);
            Order.OrderResponse orderResponse = Order.OrderResponse.newBuilder()
                    .setOrderId(orderId)
                    .setProductName(request.getProductName())
                    .setQuantity(request.getQuantity())
                    .setStatus("CREATED")
                    .build();

            orderDatabase.put(orderId, orderResponse);

            responseObserver.onNext(orderResponse);
            responseObserver.onCompleted();
        }

        @Override
        public void getOrder(Order.GetOrderRequest request, StreamObserver<Order.OrderResponse> responseObserver) {
            String orderId = request.getOrderId();
            Order.OrderResponse orderResponse = orderDatabase.get(orderId);

            if (orderResponse != null) {
                responseObserver.onNext(orderResponse);
            } else {
                responseObserver.onError(new Throwable("Order not found with ID: " + orderId));
            }
            responseObserver.onCompleted();
        }
    }
}

