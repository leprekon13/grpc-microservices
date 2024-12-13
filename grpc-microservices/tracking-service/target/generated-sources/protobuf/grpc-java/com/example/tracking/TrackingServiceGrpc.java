package com.example.tracking;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: tracking.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TrackingServiceGrpc {

  private TrackingServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.tracking.TrackingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.tracking.Tracking.TrackingInfoRequest,
      com.example.tracking.Tracking.TrackingResponse> getAddTrackingInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddTrackingInfo",
      requestType = com.example.tracking.Tracking.TrackingInfoRequest.class,
      responseType = com.example.tracking.Tracking.TrackingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.tracking.Tracking.TrackingInfoRequest,
      com.example.tracking.Tracking.TrackingResponse> getAddTrackingInfoMethod() {
    io.grpc.MethodDescriptor<com.example.tracking.Tracking.TrackingInfoRequest, com.example.tracking.Tracking.TrackingResponse> getAddTrackingInfoMethod;
    if ((getAddTrackingInfoMethod = TrackingServiceGrpc.getAddTrackingInfoMethod) == null) {
      synchronized (TrackingServiceGrpc.class) {
        if ((getAddTrackingInfoMethod = TrackingServiceGrpc.getAddTrackingInfoMethod) == null) {
          TrackingServiceGrpc.getAddTrackingInfoMethod = getAddTrackingInfoMethod =
              io.grpc.MethodDescriptor.<com.example.tracking.Tracking.TrackingInfoRequest, com.example.tracking.Tracking.TrackingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddTrackingInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.tracking.Tracking.TrackingInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.tracking.Tracking.TrackingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TrackingServiceMethodDescriptorSupplier("AddTrackingInfo"))
              .build();
        }
      }
    }
    return getAddTrackingInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.tracking.Tracking.TrackingInfoRequest,
      com.example.tracking.Tracking.TrackingResponse> getGetTrackingInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTrackingInfo",
      requestType = com.example.tracking.Tracking.TrackingInfoRequest.class,
      responseType = com.example.tracking.Tracking.TrackingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.tracking.Tracking.TrackingInfoRequest,
      com.example.tracking.Tracking.TrackingResponse> getGetTrackingInfoMethod() {
    io.grpc.MethodDescriptor<com.example.tracking.Tracking.TrackingInfoRequest, com.example.tracking.Tracking.TrackingResponse> getGetTrackingInfoMethod;
    if ((getGetTrackingInfoMethod = TrackingServiceGrpc.getGetTrackingInfoMethod) == null) {
      synchronized (TrackingServiceGrpc.class) {
        if ((getGetTrackingInfoMethod = TrackingServiceGrpc.getGetTrackingInfoMethod) == null) {
          TrackingServiceGrpc.getGetTrackingInfoMethod = getGetTrackingInfoMethod =
              io.grpc.MethodDescriptor.<com.example.tracking.Tracking.TrackingInfoRequest, com.example.tracking.Tracking.TrackingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTrackingInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.tracking.Tracking.TrackingInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.tracking.Tracking.TrackingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TrackingServiceMethodDescriptorSupplier("GetTrackingInfo"))
              .build();
        }
      }
    }
    return getGetTrackingInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TrackingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TrackingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TrackingServiceStub>() {
        @java.lang.Override
        public TrackingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TrackingServiceStub(channel, callOptions);
        }
      };
    return TrackingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TrackingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TrackingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TrackingServiceBlockingStub>() {
        @java.lang.Override
        public TrackingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TrackingServiceBlockingStub(channel, callOptions);
        }
      };
    return TrackingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TrackingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TrackingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TrackingServiceFutureStub>() {
        @java.lang.Override
        public TrackingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TrackingServiceFutureStub(channel, callOptions);
        }
      };
    return TrackingServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void addTrackingInfo(com.example.tracking.Tracking.TrackingInfoRequest request,
        io.grpc.stub.StreamObserver<com.example.tracking.Tracking.TrackingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddTrackingInfoMethod(), responseObserver);
    }

    /**
     */
    default void getTrackingInfo(com.example.tracking.Tracking.TrackingInfoRequest request,
        io.grpc.stub.StreamObserver<com.example.tracking.Tracking.TrackingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTrackingInfoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TrackingService.
   */
  public static abstract class TrackingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TrackingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TrackingService.
   */
  public static final class TrackingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<TrackingServiceStub> {
    private TrackingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrackingServiceStub(channel, callOptions);
    }

    /**
     */
    public void addTrackingInfo(com.example.tracking.Tracking.TrackingInfoRequest request,
        io.grpc.stub.StreamObserver<com.example.tracking.Tracking.TrackingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddTrackingInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTrackingInfo(com.example.tracking.Tracking.TrackingInfoRequest request,
        io.grpc.stub.StreamObserver<com.example.tracking.Tracking.TrackingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTrackingInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TrackingService.
   */
  public static final class TrackingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TrackingServiceBlockingStub> {
    private TrackingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrackingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.tracking.Tracking.TrackingResponse addTrackingInfo(com.example.tracking.Tracking.TrackingInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddTrackingInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.tracking.Tracking.TrackingResponse getTrackingInfo(com.example.tracking.Tracking.TrackingInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTrackingInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TrackingService.
   */
  public static final class TrackingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<TrackingServiceFutureStub> {
    private TrackingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrackingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.tracking.Tracking.TrackingResponse> addTrackingInfo(
        com.example.tracking.Tracking.TrackingInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddTrackingInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.tracking.Tracking.TrackingResponse> getTrackingInfo(
        com.example.tracking.Tracking.TrackingInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTrackingInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_TRACKING_INFO = 0;
  private static final int METHODID_GET_TRACKING_INFO = 1;

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
        case METHODID_ADD_TRACKING_INFO:
          serviceImpl.addTrackingInfo((com.example.tracking.Tracking.TrackingInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.example.tracking.Tracking.TrackingResponse>) responseObserver);
          break;
        case METHODID_GET_TRACKING_INFO:
          serviceImpl.getTrackingInfo((com.example.tracking.Tracking.TrackingInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.example.tracking.Tracking.TrackingResponse>) responseObserver);
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
          getAddTrackingInfoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.tracking.Tracking.TrackingInfoRequest,
              com.example.tracking.Tracking.TrackingResponse>(
                service, METHODID_ADD_TRACKING_INFO)))
        .addMethod(
          getGetTrackingInfoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.tracking.Tracking.TrackingInfoRequest,
              com.example.tracking.Tracking.TrackingResponse>(
                service, METHODID_GET_TRACKING_INFO)))
        .build();
  }

  private static abstract class TrackingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TrackingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.tracking.Tracking.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TrackingService");
    }
  }

  private static final class TrackingServiceFileDescriptorSupplier
      extends TrackingServiceBaseDescriptorSupplier {
    TrackingServiceFileDescriptorSupplier() {}
  }

  private static final class TrackingServiceMethodDescriptorSupplier
      extends TrackingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TrackingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TrackingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TrackingServiceFileDescriptorSupplier())
              .addMethod(getAddTrackingInfoMethod())
              .addMethod(getGetTrackingInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
