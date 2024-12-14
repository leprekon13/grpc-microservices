package com.example.review;

import com.example.review.ReviewOuterClass.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ReviewServiceServer {

    private final Server server;

    public ReviewServiceServer(int port) {
        server = ServerBuilder.forPort(port)
                .addService(new ReviewServiceImpl())
                .build();
    }

    public void start() throws IOException {
        server.start();
        System.out.println("ReviewServiceServer started on port " + server.getPort());
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down server...");
            ReviewServiceServer.this.stop();
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public void awaitTermination() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ReviewServiceServer server = new ReviewServiceServer(50055);
        server.start();
        server.awaitTermination();
    }

    static class ReviewServiceImpl extends ReviewServiceGrpc.ReviewServiceImplBase {
        private final ConcurrentMap<String, List<Review>> reviewsByProduct = new ConcurrentHashMap<>();

        @Override
        public void addReview(AddReviewRequest request, StreamObserver<ReviewResponse> responseObserver) {
            Review review = Review.newBuilder()
                    .setUserId(request.getUserId())
                    .setRating(request.getRating())
                    .setComment(request.getComment())
                    .build();

            reviewsByProduct.computeIfAbsent(request.getProductId(), k -> new ArrayList<>()).add(review);

            ReviewResponse response = ReviewResponse.newBuilder()
                    .setStatus("Review added successfully")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void getReviews(GetReviewsRequest request, StreamObserver<ReviewsResponse> responseObserver) {
            List<Review> reviews = reviewsByProduct.getOrDefault(request.getProductId(), new ArrayList<>());
            ReviewsResponse response = ReviewsResponse.newBuilder()
                    .addAllReviews(reviews)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
