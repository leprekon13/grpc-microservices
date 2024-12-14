package com.example.tracking;

import com.example.tracking.Tracking.GetTrackingInfoRequest;
import com.example.tracking.Tracking.GetTrackingInfoResponse;
import com.example.tracking.Tracking.TrackOrderRequest;
import com.example.tracking.Tracking.TrackOrderResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TrackingServiceServer {

    private final int port = 50054;
    private final Server server;

    public TrackingServiceServer() {
        this.server = ServerBuilder
                .forPort(port)
                .addService(new TrackingServiceImpl())
                .build();
    }

    public void start() throws IOException {
        server.start();
        System.out.println("TrackingServiceServer started on port " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("Shutting down gRPC server...");
            TrackingServiceServer.this.stop();
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
        final TrackingServiceServer server = new TrackingServiceServer();
        server.start();
        server.blockUntilShutdown();
    }

    static class TrackingServiceImpl extends TrackingServiceGrpc.TrackingServiceImplBase {

        private final Map<String, String> trackingData = new HashMap<>();

        public TrackingServiceImpl() {
            // Предварительные данные отслеживания
            trackingData.put("order-1", "In Transit");
            trackingData.put("order-2", "Delivered");
            trackingData.put("order-3", "Awaiting Pickup");
        }

        @Override
        public void trackOrder(TrackOrderRequest request, StreamObserver<TrackOrderResponse> responseObserver) {
            String orderId = request.getOrderId();
            String status = trackingData.getOrDefault(orderId, "Unknown Order ID");

            TrackOrderResponse response = TrackOrderResponse.newBuilder()
                    .setOrderId(orderId)
                    .setStatus(status)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void getTrackingInfo(GetTrackingInfoRequest request, StreamObserver<GetTrackingInfoResponse> responseObserver) {
            String orderId = request.getOrderId();

            if (trackingData.containsKey(orderId)) {
                String status = trackingData.get(orderId);

                GetTrackingInfoResponse response = GetTrackingInfoResponse.newBuilder()
                        .setOrderId(orderId)
                        .setStatus(status)
                        .setEstimatedDelivery("2024-12-20")
                        .build();

                responseObserver.onNext(response);
            } else {
                responseObserver.onError(new IllegalArgumentException("Tracking information not found for order ID: " + orderId));
            }

            responseObserver.onCompleted();
        }
    }
}
