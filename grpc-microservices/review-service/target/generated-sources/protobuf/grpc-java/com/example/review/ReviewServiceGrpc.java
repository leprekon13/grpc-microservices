package com.example.review;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Сервис для управления отзывами
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: review.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ReviewServiceGrpc {

  private ReviewServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.review.ReviewService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.review.ReviewOuterClass.AddReviewRequest,
      com.example.review.ReviewOuterClass.ReviewResponse> getAddReviewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddReview",
      requestType = com.example.review.ReviewOuterClass.AddReviewRequest.class,
      responseType = com.example.review.ReviewOuterClass.ReviewResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.review.ReviewOuterClass.AddReviewRequest,
      com.example.review.ReviewOuterClass.ReviewResponse> getAddReviewMethod() {
    io.grpc.MethodDescriptor<com.example.review.ReviewOuterClass.AddReviewRequest, com.example.review.ReviewOuterClass.ReviewResponse> getAddReviewMethod;
    if ((getAddReviewMethod = ReviewServiceGrpc.getAddReviewMethod) == null) {
      synchronized (ReviewServiceGrpc.class) {
        if ((getAddReviewMethod = ReviewServiceGrpc.getAddReviewMethod) == null) {
          ReviewServiceGrpc.getAddReviewMethod = getAddReviewMethod =
              io.grpc.MethodDescriptor.<com.example.review.ReviewOuterClass.AddReviewRequest, com.example.review.ReviewOuterClass.ReviewResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddReview"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.review.ReviewOuterClass.AddReviewRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.review.ReviewOuterClass.ReviewResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReviewServiceMethodDescriptorSupplier("AddReview"))
              .build();
        }
      }
    }
    return getAddReviewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.review.ReviewOuterClass.GetReviewsRequest,
      com.example.review.ReviewOuterClass.ReviewsResponse> getGetReviewsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReviews",
      requestType = com.example.review.ReviewOuterClass.GetReviewsRequest.class,
      responseType = com.example.review.ReviewOuterClass.ReviewsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.review.ReviewOuterClass.GetReviewsRequest,
      com.example.review.ReviewOuterClass.ReviewsResponse> getGetReviewsMethod() {
    io.grpc.MethodDescriptor<com.example.review.ReviewOuterClass.GetReviewsRequest, com.example.review.ReviewOuterClass.ReviewsResponse> getGetReviewsMethod;
    if ((getGetReviewsMethod = ReviewServiceGrpc.getGetReviewsMethod) == null) {
      synchronized (ReviewServiceGrpc.class) {
        if ((getGetReviewsMethod = ReviewServiceGrpc.getGetReviewsMethod) == null) {
          ReviewServiceGrpc.getGetReviewsMethod = getGetReviewsMethod =
              io.grpc.MethodDescriptor.<com.example.review.ReviewOuterClass.GetReviewsRequest, com.example.review.ReviewOuterClass.ReviewsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReviews"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.review.ReviewOuterClass.GetReviewsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.review.ReviewOuterClass.ReviewsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReviewServiceMethodDescriptorSupplier("GetReviews"))
              .build();
        }
      }
    }
    return getGetReviewsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReviewServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReviewServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReviewServiceStub>() {
        @java.lang.Override
        public ReviewServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReviewServiceStub(channel, callOptions);
        }
      };
    return ReviewServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReviewServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReviewServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReviewServiceBlockingStub>() {
        @java.lang.Override
        public ReviewServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReviewServiceBlockingStub(channel, callOptions);
        }
      };
    return ReviewServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReviewServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReviewServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReviewServiceFutureStub>() {
        @java.lang.Override
        public ReviewServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReviewServiceFutureStub(channel, callOptions);
        }
      };
    return ReviewServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Сервис для управления отзывами
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void addReview(com.example.review.ReviewOuterClass.AddReviewRequest request,
        io.grpc.stub.StreamObserver<com.example.review.ReviewOuterClass.ReviewResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddReviewMethod(), responseObserver);
    }

    /**
     */
    default void getReviews(com.example.review.ReviewOuterClass.GetReviewsRequest request,
        io.grpc.stub.StreamObserver<com.example.review.ReviewOuterClass.ReviewsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetReviewsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ReviewService.
   * <pre>
   * Сервис для управления отзывами
   * </pre>
   */
  public static abstract class ReviewServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ReviewServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ReviewService.
   * <pre>
   * Сервис для управления отзывами
   * </pre>
   */
  public static final class ReviewServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ReviewServiceStub> {
    private ReviewServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReviewServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReviewServiceStub(channel, callOptions);
    }

    /**
     */
    public void addReview(com.example.review.ReviewOuterClass.AddReviewRequest request,
        io.grpc.stub.StreamObserver<com.example.review.ReviewOuterClass.ReviewResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddReviewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReviews(com.example.review.ReviewOuterClass.GetReviewsRequest request,
        io.grpc.stub.StreamObserver<com.example.review.ReviewOuterClass.ReviewsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReviewsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ReviewService.
   * <pre>
   * Сервис для управления отзывами
   * </pre>
   */
  public static final class ReviewServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ReviewServiceBlockingStub> {
    private ReviewServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReviewServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReviewServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.review.ReviewOuterClass.ReviewResponse addReview(com.example.review.ReviewOuterClass.AddReviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddReviewMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.review.ReviewOuterClass.ReviewsResponse getReviews(com.example.review.ReviewOuterClass.GetReviewsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReviewsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ReviewService.
   * <pre>
   * Сервис для управления отзывами
   * </pre>
   */
  public static final class ReviewServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ReviewServiceFutureStub> {
    private ReviewServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReviewServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReviewServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.review.ReviewOuterClass.ReviewResponse> addReview(
        com.example.review.ReviewOuterClass.AddReviewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddReviewMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.review.ReviewOuterClass.ReviewsResponse> getReviews(
        com.example.review.ReviewOuterClass.GetReviewsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReviewsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_REVIEW = 0;
  private static final int METHODID_GET_REVIEWS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_REVIEW:
          serviceImpl.addReview((com.example.review.ReviewOuterClass.AddReviewRequest) request,
              (io.grpc.stub.StreamObserver<com.example.review.ReviewOuterClass.ReviewResponse>) responseObserver);
          break;
        case METHODID_GET_REVIEWS:
          serviceImpl.getReviews((com.example.review.ReviewOuterClass.GetReviewsRequest) request,
              (io.grpc.stub.StreamObserver<com.example.review.ReviewOuterClass.ReviewsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAddReviewMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.review.ReviewOuterClass.AddReviewRequest,
              com.example.review.ReviewOuterClass.ReviewResponse>(
                service, METHODID_ADD_REVIEW)))
        .addMethod(
          getGetReviewsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.review.ReviewOuterClass.GetReviewsRequest,
              com.example.review.ReviewOuterClass.ReviewsResponse>(
                service, METHODID_GET_REVIEWS)))
        .build();
  }

  private static abstract class ReviewServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReviewServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.review.ReviewOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReviewService");
    }
  }

  private static final class ReviewServiceFileDescriptorSupplier
      extends ReviewServiceBaseDescriptorSupplier {
    ReviewServiceFileDescriptorSupplier() {}
  }

  private static final class ReviewServiceMethodDescriptorSupplier
      extends ReviewServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReviewServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ReviewServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReviewServiceFileDescriptorSupplier())
              .addMethod(getAddReviewMethod())
              .addMethod(getGetReviewsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
