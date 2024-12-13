package com.example.user;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserServiceServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new UserServiceImpl())
                .build();

        System.out.println("Starting UserServiceServer on port 50051...");
        server.start();
        System.out.println("UserServiceServer started.");
        server.awaitTermination();
    }

    static class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
        private final Map<String, User.UserResponse> users = new HashMap<>();

        @Override
        public void createUser(User.CreateUserRequest request, StreamObserver<User.UserResponse> responseObserver) {
            String userId = "user-" + (users.size() + 1);
            User.UserResponse user = User.UserResponse.newBuilder()
                    .setUserId(userId)
                    .setName(request.getName())
                    .setEmail(request.getEmail())
                    .build();

            users.put(userId, user);

            responseObserver.onNext(user);
            responseObserver.onCompleted();
        }

        @Override
        public void getUser(User.GetUserRequest request, StreamObserver<User.UserResponse> responseObserver) {
            User.UserResponse user = users.get(request.getUserId());

            if (user == null) {
                responseObserver.onError(new RuntimeException("User not found: " + request.getUserId()));
                return;
            }

            responseObserver.onNext(user);
            responseObserver.onCompleted();
        }
    }
}

