package cn.hsiangsun.wallet.rpc.wallet;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: wallet.proto")
public final class AddressGrpc {

  private AddressGrpc() {}

  public static final String SERVICE_NAME = "wallet.Address";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cn.hsiangsun.wallet.rpc.wallet.AddressRequest,
      cn.hsiangsun.wallet.rpc.wallet.AddressResponse> getGenerateAddressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateAddress",
      requestType = cn.hsiangsun.wallet.rpc.wallet.AddressRequest.class,
      responseType = cn.hsiangsun.wallet.rpc.wallet.AddressResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.hsiangsun.wallet.rpc.wallet.AddressRequest,
      cn.hsiangsun.wallet.rpc.wallet.AddressResponse> getGenerateAddressMethod() {
    io.grpc.MethodDescriptor<cn.hsiangsun.wallet.rpc.wallet.AddressRequest, cn.hsiangsun.wallet.rpc.wallet.AddressResponse> getGenerateAddressMethod;
    if ((getGenerateAddressMethod = AddressGrpc.getGenerateAddressMethod) == null) {
      synchronized (AddressGrpc.class) {
        if ((getGenerateAddressMethod = AddressGrpc.getGenerateAddressMethod) == null) {
          AddressGrpc.getGenerateAddressMethod = getGenerateAddressMethod = 
              io.grpc.MethodDescriptor.<cn.hsiangsun.wallet.rpc.wallet.AddressRequest, cn.hsiangsun.wallet.rpc.wallet.AddressResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "wallet.Address", "GenerateAddress"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.hsiangsun.wallet.rpc.wallet.AddressRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.hsiangsun.wallet.rpc.wallet.AddressResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AddressMethodDescriptorSupplier("GenerateAddress"))
                  .build();
          }
        }
     }
     return getGenerateAddressMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AddressStub newStub(io.grpc.Channel channel) {
    return new AddressStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AddressBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AddressBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AddressFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AddressFutureStub(channel);
  }

  /**
   */
  public static abstract class AddressImplBase implements io.grpc.BindableService {

    /**
     */
    public void generateAddress(cn.hsiangsun.wallet.rpc.wallet.AddressRequest request,
        io.grpc.stub.StreamObserver<cn.hsiangsun.wallet.rpc.wallet.AddressResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGenerateAddressMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGenerateAddressMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.hsiangsun.wallet.rpc.wallet.AddressRequest,
                cn.hsiangsun.wallet.rpc.wallet.AddressResponse>(
                  this, METHODID_GENERATE_ADDRESS)))
          .build();
    }
  }

  /**
   */
  public static final class AddressStub extends io.grpc.stub.AbstractStub<AddressStub> {
    private AddressStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AddressStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddressStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AddressStub(channel, callOptions);
    }

    /**
     */
    public void generateAddress(cn.hsiangsun.wallet.rpc.wallet.AddressRequest request,
        io.grpc.stub.StreamObserver<cn.hsiangsun.wallet.rpc.wallet.AddressResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGenerateAddressMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AddressBlockingStub extends io.grpc.stub.AbstractStub<AddressBlockingStub> {
    private AddressBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AddressBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddressBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AddressBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.hsiangsun.wallet.rpc.wallet.AddressResponse generateAddress(cn.hsiangsun.wallet.rpc.wallet.AddressRequest request) {
      return blockingUnaryCall(
          getChannel(), getGenerateAddressMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AddressFutureStub extends io.grpc.stub.AbstractStub<AddressFutureStub> {
    private AddressFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AddressFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddressFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AddressFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.hsiangsun.wallet.rpc.wallet.AddressResponse> generateAddress(
        cn.hsiangsun.wallet.rpc.wallet.AddressRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGenerateAddressMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_ADDRESS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AddressImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AddressImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE_ADDRESS:
          serviceImpl.generateAddress((cn.hsiangsun.wallet.rpc.wallet.AddressRequest) request,
              (io.grpc.stub.StreamObserver<cn.hsiangsun.wallet.rpc.wallet.AddressResponse>) responseObserver);
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

  private static abstract class AddressBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AddressBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.hsiangsun.wallet.rpc.wallet.WalletProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Address");
    }
  }

  private static final class AddressFileDescriptorSupplier
      extends AddressBaseDescriptorSupplier {
    AddressFileDescriptorSupplier() {}
  }

  private static final class AddressMethodDescriptorSupplier
      extends AddressBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AddressMethodDescriptorSupplier(String methodName) {
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
      synchronized (AddressGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AddressFileDescriptorSupplier())
              .addMethod(getGenerateAddressMethod())
              .build();
        }
      }
    }
    return result;
  }
}
