package com.example.payment;

import com.example.payment.Payment.PaymentRequest;
import com.example.payment.Payment.PaymentResponse;
import com.example.payment.Payment.PaymentStatusRequest;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PaymentServiceServer {

    private final int port = 50053;
    private final Server server;

    public PaymentServiceServer() {
        this.server = ServerBuilder
                .forPort(port)
                .addService(new PaymentServiceImpl())
                .build();
    }

    public void start() throws IOException {
        server.start();
        System.out.println("PaymentServiceServer started on port " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("Shutting down gRPC server...");
            PaymentServiceServer.this.stop();
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
        final PaymentServiceServer server = new PaymentServiceServer();
        server.start();
        server.blockUntilShutdown();
    }

    static class PaymentServiceImpl extends PaymentServiceGrpc.PaymentServiceImplBase {

        private final Map<String, PaymentResponse> payments = new HashMap<>();

        @Override
        public void processPayment(PaymentRequest request, StreamObserver<PaymentResponse> responseObserver) {
            // Генерация уникального идентификатора платежа
            String paymentId = UUID.randomUUID().toString();

            // Создание объекта ответа
            PaymentResponse payment = PaymentResponse.newBuilder()
                    .setPaymentId(paymentId)
                    .setUserId(request.getUserId())
                    .setOrderId(request.getOrderId())
                    .setAmount(request.getAmount())
                    .setStatus("PROCESSED")
                    .build();

            // Сохранение платежа в локальном хранилище
            payments.put(paymentId, payment);

            // Отправка ответа клиенту
            responseObserver.onNext(payment);
            responseObserver.onCompleted();
        }

        @Override
        public void checkPaymentStatus(PaymentStatusRequest request, StreamObserver<PaymentResponse> responseObserver) {
            String paymentId = request.getPaymentId();

            // Проверка наличия платежа
            if (payments.containsKey(paymentId)) {
                PaymentResponse payment = payments.get(paymentId);
                responseObserver.onNext(payment);
            } else {
                responseObserver.onError(new IllegalArgumentException("Payment not found for ID: " + paymentId));
            }

            responseObserver.onCompleted();
        }
    }
}
