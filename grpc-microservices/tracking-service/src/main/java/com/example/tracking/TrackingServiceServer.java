package com.example.tracking;

import com.example.tracking.Tracking.GetTrackingInfoRequest;
import com.example.tracking.Tracking.GetTrackingInfoResponse;
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

        private final Map<String, TrackOrderResponse> trackingData = new HashMap<>();

        public TrackingServiceImpl() {
            // Добавление фиктивных данных для тестирования
            trackingData.put("order-123", TrackOrderResponse.newBuilder()
                    .setOrderId("order-123")
                    .setStatus("IN_TRANSIT")
                    .setEstimatedDelivery("2024-12-20")
                    .build());

            trackingData.put("order-456", TrackOrderResponse.newBuilder()
                    .setOrderId("order-456")
                    .setStatus("DELIVERED")
                    .setEstimatedDelivery("2024-12-15")
                    .build());
        }

        @Override
        public void getTrackingInfo(GetTrackingInfoRequest request, StreamObserver<GetTrackingInfoResponse> responseObserver) {
            String orderId = request.getOrderId();
            TrackOrderResponse trackingInfo = trackingData.getOrDefault(orderId,
                    TrackOrderResponse.newBuilder()
                            .setOrderId(orderId)
                            .setStatus("Unknown Order ID")
                            .build());

            GetTrackingInfoResponse response = GetTrackingInfoResponse.newBuilder()
                    .setTrackingInfo(trackingInfo)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
