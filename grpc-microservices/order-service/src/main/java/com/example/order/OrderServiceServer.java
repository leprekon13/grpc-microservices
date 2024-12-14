package com.example.order;

import com.example.order.Order.CreateOrderRequest;
import com.example.order.Order.GetOrderRequest;
import com.example.order.Order.OrderResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class OrderServiceServer {

    private final int port = 50052;
    private final Server server;

    public OrderServiceServer() {
        this.server = ServerBuilder
                .forPort(port)
                .addService(new OrderServiceImpl())
                .build();
    }

    public void start() throws IOException {
        server.start();
        System.out.println("OrderServiceServer started on port " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("Shutting down gRPC server...");
            OrderServiceServer.this.stop();
            System.err.println("Server shut down.");
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final OrderServiceServer server = new OrderServiceServer();
        server.start();
        server.blockUntilShutdown();
    }

    static class OrderServiceImpl extends OrderServiceGrpc.OrderServiceImplBase {

        private final Map<String, OrderResponse> orders = new HashMap<>();

        @Override
        public void createOrder(CreateOrderRequest request, StreamObserver<OrderResponse> responseObserver) {
            // Генерация уникального идентификатора для заказа
            String orderId = UUID.randomUUID().toString();

            // Создание объекта ответа
            Order.OrderResponse order = OrderResponse.newBuilder()
                    .setOrderId(orderId)
                    .setUserId(request.getUserId())
                    .setProductId(request.getProductId())
                    .setQuantity(request.getQuantity())
                    .setStatus("CREATED")
                    .build();

            // Сохранение заказа в локальном хранилище
            orders.put(orderId, order);

            // Отправка ответа клиенту
            responseObserver.onNext(order);
            responseObserver.onCompleted();
        }

        @Override
        public void getOrder(GetOrderRequest request, StreamObserver<OrderResponse> responseObserver) {
            String orderId = request.getOrderId();

            // Проверка наличия заказа
            if (orders.containsKey(orderId)) {
                OrderResponse order = orders.get(orderId);
                responseObserver.onNext(order);
            } else {
                responseObserver.onError(new IllegalArgumentException("Order not found for ID: " + orderId));
            }

            responseObserver.onCompleted();
        }
    }
}
