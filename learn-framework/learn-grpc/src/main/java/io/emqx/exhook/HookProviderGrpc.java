package io.emqx.exhook;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: exhook.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HookProviderGrpc {

  private HookProviderGrpc() {}

  public static final String SERVICE_NAME = "emqx.exhook.v2.HookProvider";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ProviderLoadedRequest,
      LoadedResponse> getOnProviderLoadedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnProviderLoaded",
      requestType = ProviderLoadedRequest.class,
      responseType = LoadedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ProviderLoadedRequest,
      LoadedResponse> getOnProviderLoadedMethod() {
    io.grpc.MethodDescriptor<ProviderLoadedRequest, LoadedResponse> getOnProviderLoadedMethod;
    if ((getOnProviderLoadedMethod = HookProviderGrpc.getOnProviderLoadedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnProviderLoadedMethod = HookProviderGrpc.getOnProviderLoadedMethod) == null) {
          HookProviderGrpc.getOnProviderLoadedMethod = getOnProviderLoadedMethod =
              io.grpc.MethodDescriptor.<ProviderLoadedRequest, LoadedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnProviderLoaded"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ProviderLoadedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LoadedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnProviderLoaded"))
              .build();
        }
      }
    }
    return getOnProviderLoadedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ProviderUnloadedRequest,
      EmptySuccess> getOnProviderUnloadedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnProviderUnloaded",
      requestType = ProviderUnloadedRequest.class,
      responseType = EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ProviderUnloadedRequest,
      EmptySuccess> getOnProviderUnloadedMethod() {
    io.grpc.MethodDescriptor<ProviderUnloadedRequest, EmptySuccess> getOnProviderUnloadedMethod;
    if ((getOnProviderUnloadedMethod = HookProviderGrpc.getOnProviderUnloadedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnProviderUnloadedMethod = HookProviderGrpc.getOnProviderUnloadedMethod) == null) {
          HookProviderGrpc.getOnProviderUnloadedMethod = getOnProviderUnloadedMethod =
              io.grpc.MethodDescriptor.<ProviderUnloadedRequest, EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnProviderUnloaded"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ProviderUnloadedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnProviderUnloaded"))
              .build();
        }
      }
    }
    return getOnProviderUnloadedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ClientConnectRequest,
      EmptySuccess> getOnClientConnectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnClientConnect",
      requestType = ClientConnectRequest.class,
      responseType = EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ClientConnectRequest,
      EmptySuccess> getOnClientConnectMethod() {
    io.grpc.MethodDescriptor<ClientConnectRequest, EmptySuccess> getOnClientConnectMethod;
    if ((getOnClientConnectMethod = HookProviderGrpc.getOnClientConnectMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnClientConnectMethod = HookProviderGrpc.getOnClientConnectMethod) == null) {
          HookProviderGrpc.getOnClientConnectMethod = getOnClientConnectMethod =
              io.grpc.MethodDescriptor.<ClientConnectRequest, EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnClientConnect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ClientConnectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnClientConnect"))
              .build();
        }
      }
    }
    return getOnClientConnectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ClientConnackRequest,
      EmptySuccess> getOnClientConnackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnClientConnack",
      requestType = ClientConnackRequest.class,
      responseType = EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ClientConnackRequest,
      EmptySuccess> getOnClientConnackMethod() {
    io.grpc.MethodDescriptor<ClientConnackRequest, EmptySuccess> getOnClientConnackMethod;
    if ((getOnClientConnackMethod = HookProviderGrpc.getOnClientConnackMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnClientConnackMethod = HookProviderGrpc.getOnClientConnackMethod) == null) {
          HookProviderGrpc.getOnClientConnackMethod = getOnClientConnackMethod =
              io.grpc.MethodDescriptor.<ClientConnackRequest, EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnClientConnack"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ClientConnackRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnClientConnack"))
              .build();
        }
      }
    }
    return getOnClientConnackMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ClientConnectedRequest,
      EmptySuccess> getOnClientConnectedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnClientConnected",
      requestType = ClientConnectedRequest.class,
      responseType = EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ClientConnectedRequest,
      EmptySuccess> getOnClientConnectedMethod() {
    io.grpc.MethodDescriptor<ClientConnectedRequest, EmptySuccess> getOnClientConnectedMethod;
    if ((getOnClientConnectedMethod = HookProviderGrpc.getOnClientConnectedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnClientConnectedMethod = HookProviderGrpc.getOnClientConnectedMethod) == null) {
          HookProviderGrpc.getOnClientConnectedMethod = getOnClientConnectedMethod =
              io.grpc.MethodDescriptor.<ClientConnectedRequest, EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnClientConnected"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ClientConnectedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnClientConnected"))
              .build();
        }
      }
    }
    return getOnClientConnectedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ClientDisconnectedRequest,
      EmptySuccess> getOnClientDisconnectedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnClientDisconnected",
      requestType = ClientDisconnectedRequest.class,
      responseType = EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ClientDisconnectedRequest,
      EmptySuccess> getOnClientDisconnectedMethod() {
    io.grpc.MethodDescriptor<ClientDisconnectedRequest, EmptySuccess> getOnClientDisconnectedMethod;
    if ((getOnClientDisconnectedMethod = HookProviderGrpc.getOnClientDisconnectedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnClientDisconnectedMethod = HookProviderGrpc.getOnClientDisconnectedMethod) == null) {
          HookProviderGrpc.getOnClientDisconnectedMethod = getOnClientDisconnectedMethod =
              io.grpc.MethodDescriptor.<ClientDisconnectedRequest, EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnClientDisconnected"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ClientDisconnectedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnClientDisconnected"))
              .build();
        }
      }
    }
    return getOnClientDisconnectedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ClientAuthenticateRequest,
      ValuedResponse> getOnClientAuthenticateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnClientAuthenticate",
      requestType = ClientAuthenticateRequest.class,
      responseType = ValuedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ClientAuthenticateRequest,
      ValuedResponse> getOnClientAuthenticateMethod() {
    io.grpc.MethodDescriptor<ClientAuthenticateRequest, ValuedResponse> getOnClientAuthenticateMethod;
    if ((getOnClientAuthenticateMethod = HookProviderGrpc.getOnClientAuthenticateMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnClientAuthenticateMethod = HookProviderGrpc.getOnClientAuthenticateMethod) == null) {
          HookProviderGrpc.getOnClientAuthenticateMethod = getOnClientAuthenticateMethod =
              io.grpc.MethodDescriptor.<ClientAuthenticateRequest, ValuedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnClientAuthenticate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ClientAuthenticateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ValuedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnClientAuthenticate"))
              .build();
        }
      }
    }
    return getOnClientAuthenticateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ClientAuthorizeRequest,
      ValuedResponse> getOnClientAuthorizeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnClientAuthorize",
      requestType = ClientAuthorizeRequest.class,
      responseType = ValuedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ClientAuthorizeRequest,
      ValuedResponse> getOnClientAuthorizeMethod() {
    io.grpc.MethodDescriptor<ClientAuthorizeRequest, ValuedResponse> getOnClientAuthorizeMethod;
    if ((getOnClientAuthorizeMethod = HookProviderGrpc.getOnClientAuthorizeMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnClientAuthorizeMethod = HookProviderGrpc.getOnClientAuthorizeMethod) == null) {
          HookProviderGrpc.getOnClientAuthorizeMethod = getOnClientAuthorizeMethod =
              io.grpc.MethodDescriptor.<ClientAuthorizeRequest, ValuedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnClientAuthorize"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ClientAuthorizeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ValuedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnClientAuthorize"))
              .build();
        }
      }
    }
    return getOnClientAuthorizeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ClientSubscribeRequest,
      EmptySuccess> getOnClientSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnClientSubscribe",
      requestType = ClientSubscribeRequest.class,
      responseType = EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ClientSubscribeRequest,
      EmptySuccess> getOnClientSubscribeMethod() {
    io.grpc.MethodDescriptor<ClientSubscribeRequest, EmptySuccess> getOnClientSubscribeMethod;
    if ((getOnClientSubscribeMethod = HookProviderGrpc.getOnClientSubscribeMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnClientSubscribeMethod = HookProviderGrpc.getOnClientSubscribeMethod) == null) {
          HookProviderGrpc.getOnClientSubscribeMethod = getOnClientSubscribeMethod =
              io.grpc.MethodDescriptor.<ClientSubscribeRequest, EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnClientSubscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ClientSubscribeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnClientSubscribe"))
              .build();
        }
      }
    }
    return getOnClientSubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ClientUnsubscribeRequest,
      EmptySuccess> getOnClientUnsubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnClientUnsubscribe",
      requestType = ClientUnsubscribeRequest.class,
      responseType = EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ClientUnsubscribeRequest,
      EmptySuccess> getOnClientUnsubscribeMethod() {
    io.grpc.MethodDescriptor<ClientUnsubscribeRequest, EmptySuccess> getOnClientUnsubscribeMethod;
    if ((getOnClientUnsubscribeMethod = HookProviderGrpc.getOnClientUnsubscribeMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnClientUnsubscribeMethod = HookProviderGrpc.getOnClientUnsubscribeMethod) == null) {
          HookProviderGrpc.getOnClientUnsubscribeMethod = getOnClientUnsubscribeMethod =
              io.grpc.MethodDescriptor.<ClientUnsubscribeRequest, EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnClientUnsubscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ClientUnsubscribeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnClientUnsubscribe"))
              .build();
        }
      }
    }
    return getOnClientUnsubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SessionCreatedRequest,
      EmptySuccess> getOnSessionCreatedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnSessionCreated",
      requestType = SessionCreatedRequest.class,
      responseType = EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SessionCreatedRequest,
      EmptySuccess> getOnSessionCreatedMethod() {
    io.grpc.MethodDescriptor<SessionCreatedRequest, EmptySuccess> getOnSessionCreatedMethod;
    if ((getOnSessionCreatedMethod = HookProviderGrpc.getOnSessionCreatedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnSessionCreatedMethod = HookProviderGrpc.getOnSessionCreatedMethod) == null) {
          HookProviderGrpc.getOnSessionCreatedMethod = getOnSessionCreatedMethod =
              io.grpc.MethodDescriptor.<SessionCreatedRequest, EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnSessionCreated"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SessionCreatedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnSessionCreated"))
              .build();
        }
      }
    }
    return getOnSessionCreatedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SessionSubscribedRequest,
      EmptySuccess> getOnSessionSubscribedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnSessionSubscribed",
      requestType = SessionSubscribedRequest.class,
      responseType = EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SessionSubscribedRequest,
      EmptySuccess> getOnSessionSubscribedMethod() {
    io.grpc.MethodDescriptor<SessionSubscribedRequest, EmptySuccess> getOnSessionSubscribedMethod;
    if ((getOnSessionSubscribedMethod = HookProviderGrpc.getOnSessionSubscribedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnSessionSubscribedMethod = HookProviderGrpc.getOnSessionSubscribedMethod) == null) {
          HookProviderGrpc.getOnSessionSubscribedMethod = getOnSessionSubscribedMethod =
              io.grpc.MethodDescriptor.<SessionSubscribedRequest, EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnSessionSubscribed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SessionSubscribedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnSessionSubscribed"))
              .build();
        }
      }
    }
    return getOnSessionSubscribedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SessionUnsubscribedRequest,
      EmptySuccess> getOnSessionUnsubscribedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnSessionUnsubscribed",
      requestType = SessionUnsubscribedRequest.class,
      responseType = EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SessionUnsubscribedRequest,
      EmptySuccess> getOnSessionUnsubscribedMethod() {
    io.grpc.MethodDescriptor<SessionUnsubscribedRequest, EmptySuccess> getOnSessionUnsubscribedMethod;
    if ((getOnSessionUnsubscribedMethod = HookProviderGrpc.getOnSessionUnsubscribedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnSessionUnsubscribedMethod = HookProviderGrpc.getOnSessionUnsubscribedMethod) == null) {
          HookProviderGrpc.getOnSessionUnsubscribedMethod = getOnSessionUnsubscribedMethod =
              io.grpc.MethodDescriptor.<SessionUnsubscribedRequest, EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnSessionUnsubscribed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SessionUnsubscribedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnSessionUnsubscribed"))
              .build();
        }
      }
    }
    return getOnSessionUnsubscribedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SessionResumedRequest,
      EmptySuccess> getOnSessionResumedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnSessionResumed",
      requestType = SessionResumedRequest.class,
      responseType = EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SessionResumedRequest,
      EmptySuccess> getOnSessionResumedMethod() {
    io.grpc.MethodDescriptor<SessionResumedRequest, EmptySuccess> getOnSessionResumedMethod;
    if ((getOnSessionResumedMethod = HookProviderGrpc.getOnSessionResumedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnSessionResumedMethod = HookProviderGrpc.getOnSessionResumedMethod) == null) {
          HookProviderGrpc.getOnSessionResumedMethod = getOnSessionResumedMethod =
              io.grpc.MethodDescriptor.<SessionResumedRequest, EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnSessionResumed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SessionResumedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnSessionResumed"))
              .build();
        }
      }
    }
    return getOnSessionResumedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SessionDiscardedRequest,
      EmptySuccess> getOnSessionDiscardedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnSessionDiscarded",
      requestType = SessionDiscardedRequest.class,
      responseType = EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SessionDiscardedRequest,
      EmptySuccess> getOnSessionDiscardedMethod() {
    io.grpc.MethodDescriptor<SessionDiscardedRequest, EmptySuccess> getOnSessionDiscardedMethod;
    if ((getOnSessionDiscardedMethod = HookProviderGrpc.getOnSessionDiscardedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnSessionDiscardedMethod = HookProviderGrpc.getOnSessionDiscardedMethod) == null) {
          HookProviderGrpc.getOnSessionDiscardedMethod = getOnSessionDiscardedMethod =
              io.grpc.MethodDescriptor.<SessionDiscardedRequest, EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnSessionDiscarded"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SessionDiscardedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnSessionDiscarded"))
              .build();
        }
      }
    }
    return getOnSessionDiscardedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SessionTakenoverRequest,
      EmptySuccess> getOnSessionTakenoverMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnSessionTakenover",
      requestType = SessionTakenoverRequest.class,
      responseType = EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SessionTakenoverRequest,
      EmptySuccess> getOnSessionTakenoverMethod() {
    io.grpc.MethodDescriptor<SessionTakenoverRequest, EmptySuccess> getOnSessionTakenoverMethod;
    if ((getOnSessionTakenoverMethod = HookProviderGrpc.getOnSessionTakenoverMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnSessionTakenoverMethod = HookProviderGrpc.getOnSessionTakenoverMethod) == null) {
          HookProviderGrpc.getOnSessionTakenoverMethod = getOnSessionTakenoverMethod =
              io.grpc.MethodDescriptor.<SessionTakenoverRequest, EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnSessionTakenover"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SessionTakenoverRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnSessionTakenover"))
              .build();
        }
      }
    }
    return getOnSessionTakenoverMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SessionTerminatedRequest,
      EmptySuccess> getOnSessionTerminatedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnSessionTerminated",
      requestType = SessionTerminatedRequest.class,
      responseType = EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SessionTerminatedRequest,
      EmptySuccess> getOnSessionTerminatedMethod() {
    io.grpc.MethodDescriptor<SessionTerminatedRequest, EmptySuccess> getOnSessionTerminatedMethod;
    if ((getOnSessionTerminatedMethod = HookProviderGrpc.getOnSessionTerminatedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnSessionTerminatedMethod = HookProviderGrpc.getOnSessionTerminatedMethod) == null) {
          HookProviderGrpc.getOnSessionTerminatedMethod = getOnSessionTerminatedMethod =
              io.grpc.MethodDescriptor.<SessionTerminatedRequest, EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnSessionTerminated"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SessionTerminatedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnSessionTerminated"))
              .build();
        }
      }
    }
    return getOnSessionTerminatedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<MessagePublishRequest,
      ValuedResponse> getOnMessagePublishMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnMessagePublish",
      requestType = MessagePublishRequest.class,
      responseType = ValuedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<MessagePublishRequest,
      ValuedResponse> getOnMessagePublishMethod() {
    io.grpc.MethodDescriptor<MessagePublishRequest, ValuedResponse> getOnMessagePublishMethod;
    if ((getOnMessagePublishMethod = HookProviderGrpc.getOnMessagePublishMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnMessagePublishMethod = HookProviderGrpc.getOnMessagePublishMethod) == null) {
          HookProviderGrpc.getOnMessagePublishMethod = getOnMessagePublishMethod =
              io.grpc.MethodDescriptor.<MessagePublishRequest, ValuedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnMessagePublish"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  MessagePublishRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ValuedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnMessagePublish"))
              .build();
        }
      }
    }
    return getOnMessagePublishMethod;
  }

  private static volatile io.grpc.MethodDescriptor<MessageDeliveredRequest,
      EmptySuccess> getOnMessageDeliveredMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnMessageDelivered",
      requestType = MessageDeliveredRequest.class,
      responseType = EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<MessageDeliveredRequest,
      EmptySuccess> getOnMessageDeliveredMethod() {
    io.grpc.MethodDescriptor<MessageDeliveredRequest, EmptySuccess> getOnMessageDeliveredMethod;
    if ((getOnMessageDeliveredMethod = HookProviderGrpc.getOnMessageDeliveredMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnMessageDeliveredMethod = HookProviderGrpc.getOnMessageDeliveredMethod) == null) {
          HookProviderGrpc.getOnMessageDeliveredMethod = getOnMessageDeliveredMethod =
              io.grpc.MethodDescriptor.<MessageDeliveredRequest, EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnMessageDelivered"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  MessageDeliveredRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnMessageDelivered"))
              .build();
        }
      }
    }
    return getOnMessageDeliveredMethod;
  }

  private static volatile io.grpc.MethodDescriptor<MessageDroppedRequest,
      EmptySuccess> getOnMessageDroppedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnMessageDropped",
      requestType = MessageDroppedRequest.class,
      responseType = EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<MessageDroppedRequest,
      EmptySuccess> getOnMessageDroppedMethod() {
    io.grpc.MethodDescriptor<MessageDroppedRequest, EmptySuccess> getOnMessageDroppedMethod;
    if ((getOnMessageDroppedMethod = HookProviderGrpc.getOnMessageDroppedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnMessageDroppedMethod = HookProviderGrpc.getOnMessageDroppedMethod) == null) {
          HookProviderGrpc.getOnMessageDroppedMethod = getOnMessageDroppedMethod =
              io.grpc.MethodDescriptor.<MessageDroppedRequest, EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnMessageDropped"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  MessageDroppedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnMessageDropped"))
              .build();
        }
      }
    }
    return getOnMessageDroppedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<MessageAckedRequest,
      EmptySuccess> getOnMessageAckedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnMessageAcked",
      requestType = MessageAckedRequest.class,
      responseType = EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<MessageAckedRequest,
      EmptySuccess> getOnMessageAckedMethod() {
    io.grpc.MethodDescriptor<MessageAckedRequest, EmptySuccess> getOnMessageAckedMethod;
    if ((getOnMessageAckedMethod = HookProviderGrpc.getOnMessageAckedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnMessageAckedMethod = HookProviderGrpc.getOnMessageAckedMethod) == null) {
          HookProviderGrpc.getOnMessageAckedMethod = getOnMessageAckedMethod =
              io.grpc.MethodDescriptor.<MessageAckedRequest, EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnMessageAcked"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  MessageAckedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnMessageAcked"))
              .build();
        }
      }
    }
    return getOnMessageAckedMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HookProviderStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HookProviderStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HookProviderStub>() {
        @Override
        public HookProviderStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HookProviderStub(channel, callOptions);
        }
      };
    return HookProviderStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HookProviderBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HookProviderBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HookProviderBlockingStub>() {
        @Override
        public HookProviderBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HookProviderBlockingStub(channel, callOptions);
        }
      };
    return HookProviderBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HookProviderFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HookProviderFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HookProviderFutureStub>() {
        @Override
        public HookProviderFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HookProviderFutureStub(channel, callOptions);
        }
      };
    return HookProviderFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class HookProviderImplBase implements io.grpc.BindableService {

    /**
     */
    public void onProviderLoaded(ProviderLoadedRequest request,
                                 io.grpc.stub.StreamObserver<LoadedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnProviderLoadedMethod(), responseObserver);
    }

    /**
     */
    public void onProviderUnloaded(ProviderUnloadedRequest request,
                                   io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnProviderUnloadedMethod(), responseObserver);
    }

    /**
     */
    public void onClientConnect(ClientConnectRequest request,
                                io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnClientConnectMethod(), responseObserver);
    }

    /**
     */
    public void onClientConnack(ClientConnackRequest request,
                                io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnClientConnackMethod(), responseObserver);
    }

    /**
     */
    public void onClientConnected(ClientConnectedRequest request,
                                  io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnClientConnectedMethod(), responseObserver);
    }

    /**
     */
    public void onClientDisconnected(ClientDisconnectedRequest request,
                                     io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnClientDisconnectedMethod(), responseObserver);
    }

    /**
     */
    public void onClientAuthenticate(ClientAuthenticateRequest request,
                                     io.grpc.stub.StreamObserver<ValuedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnClientAuthenticateMethod(), responseObserver);
    }

    /**
     */
    public void onClientAuthorize(ClientAuthorizeRequest request,
                                  io.grpc.stub.StreamObserver<ValuedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnClientAuthorizeMethod(), responseObserver);
    }

    /**
     */
    public void onClientSubscribe(ClientSubscribeRequest request,
                                  io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnClientSubscribeMethod(), responseObserver);
    }

    /**
     */
    public void onClientUnsubscribe(ClientUnsubscribeRequest request,
                                    io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnClientUnsubscribeMethod(), responseObserver);
    }

    /**
     */
    public void onSessionCreated(SessionCreatedRequest request,
                                 io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnSessionCreatedMethod(), responseObserver);
    }

    /**
     */
    public void onSessionSubscribed(SessionSubscribedRequest request,
                                    io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnSessionSubscribedMethod(), responseObserver);
    }

    /**
     */
    public void onSessionUnsubscribed(SessionUnsubscribedRequest request,
                                      io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnSessionUnsubscribedMethod(), responseObserver);
    }

    /**
     */
    public void onSessionResumed(SessionResumedRequest request,
                                 io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnSessionResumedMethod(), responseObserver);
    }

    /**
     */
    public void onSessionDiscarded(SessionDiscardedRequest request,
                                   io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnSessionDiscardedMethod(), responseObserver);
    }

    /**
     */
    public void onSessionTakenover(SessionTakenoverRequest request,
                                   io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnSessionTakenoverMethod(), responseObserver);
    }

    /**
     */
    public void onSessionTerminated(SessionTerminatedRequest request,
                                    io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnSessionTerminatedMethod(), responseObserver);
    }

    /**
     */
    public void onMessagePublish(MessagePublishRequest request,
                                 io.grpc.stub.StreamObserver<ValuedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnMessagePublishMethod(), responseObserver);
    }

    /**
     */
    public void onMessageDelivered(MessageDeliveredRequest request,
                                   io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnMessageDeliveredMethod(), responseObserver);
    }

    /**
     */
    public void onMessageDropped(MessageDroppedRequest request,
                                 io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnMessageDroppedMethod(), responseObserver);
    }

    /**
     */
    public void onMessageAcked(MessageAckedRequest request,
                               io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnMessageAckedMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOnProviderLoadedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ProviderLoadedRequest,
                LoadedResponse>(
                  this, METHODID_ON_PROVIDER_LOADED)))
          .addMethod(
            getOnProviderUnloadedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ProviderUnloadedRequest,
                EmptySuccess>(
                  this, METHODID_ON_PROVIDER_UNLOADED)))
          .addMethod(
            getOnClientConnectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ClientConnectRequest,
                EmptySuccess>(
                  this, METHODID_ON_CLIENT_CONNECT)))
          .addMethod(
            getOnClientConnackMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ClientConnackRequest,
                EmptySuccess>(
                  this, METHODID_ON_CLIENT_CONNACK)))
          .addMethod(
            getOnClientConnectedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ClientConnectedRequest,
                EmptySuccess>(
                  this, METHODID_ON_CLIENT_CONNECTED)))
          .addMethod(
            getOnClientDisconnectedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ClientDisconnectedRequest,
                EmptySuccess>(
                  this, METHODID_ON_CLIENT_DISCONNECTED)))
          .addMethod(
            getOnClientAuthenticateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ClientAuthenticateRequest,
                ValuedResponse>(
                  this, METHODID_ON_CLIENT_AUTHENTICATE)))
          .addMethod(
            getOnClientAuthorizeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ClientAuthorizeRequest,
                ValuedResponse>(
                  this, METHODID_ON_CLIENT_AUTHORIZE)))
          .addMethod(
            getOnClientSubscribeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ClientSubscribeRequest,
                EmptySuccess>(
                  this, METHODID_ON_CLIENT_SUBSCRIBE)))
          .addMethod(
            getOnClientUnsubscribeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ClientUnsubscribeRequest,
                EmptySuccess>(
                  this, METHODID_ON_CLIENT_UNSUBSCRIBE)))
          .addMethod(
            getOnSessionCreatedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                SessionCreatedRequest,
                EmptySuccess>(
                  this, METHODID_ON_SESSION_CREATED)))
          .addMethod(
            getOnSessionSubscribedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                SessionSubscribedRequest,
                EmptySuccess>(
                  this, METHODID_ON_SESSION_SUBSCRIBED)))
          .addMethod(
            getOnSessionUnsubscribedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                SessionUnsubscribedRequest,
                EmptySuccess>(
                  this, METHODID_ON_SESSION_UNSUBSCRIBED)))
          .addMethod(
            getOnSessionResumedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                SessionResumedRequest,
                EmptySuccess>(
                  this, METHODID_ON_SESSION_RESUMED)))
          .addMethod(
            getOnSessionDiscardedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                SessionDiscardedRequest,
                EmptySuccess>(
                  this, METHODID_ON_SESSION_DISCARDED)))
          .addMethod(
            getOnSessionTakenoverMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                SessionTakenoverRequest,
                EmptySuccess>(
                  this, METHODID_ON_SESSION_TAKENOVER)))
          .addMethod(
            getOnSessionTerminatedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                SessionTerminatedRequest,
                EmptySuccess>(
                  this, METHODID_ON_SESSION_TERMINATED)))
          .addMethod(
            getOnMessagePublishMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                MessagePublishRequest,
                ValuedResponse>(
                  this, METHODID_ON_MESSAGE_PUBLISH)))
          .addMethod(
            getOnMessageDeliveredMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                MessageDeliveredRequest,
                EmptySuccess>(
                  this, METHODID_ON_MESSAGE_DELIVERED)))
          .addMethod(
            getOnMessageDroppedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                MessageDroppedRequest,
                EmptySuccess>(
                  this, METHODID_ON_MESSAGE_DROPPED)))
          .addMethod(
            getOnMessageAckedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                MessageAckedRequest,
                EmptySuccess>(
                  this, METHODID_ON_MESSAGE_ACKED)))
          .build();
    }
  }

  /**
   */
  public static final class HookProviderStub extends io.grpc.stub.AbstractAsyncStub<HookProviderStub> {
    private HookProviderStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected HookProviderStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HookProviderStub(channel, callOptions);
    }

    /**
     */
    public void onProviderLoaded(ProviderLoadedRequest request,
                                 io.grpc.stub.StreamObserver<LoadedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnProviderLoadedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onProviderUnloaded(ProviderUnloadedRequest request,
                                   io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnProviderUnloadedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onClientConnect(ClientConnectRequest request,
                                io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnClientConnectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onClientConnack(ClientConnackRequest request,
                                io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnClientConnackMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onClientConnected(ClientConnectedRequest request,
                                  io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnClientConnectedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onClientDisconnected(ClientDisconnectedRequest request,
                                     io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnClientDisconnectedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onClientAuthenticate(ClientAuthenticateRequest request,
                                     io.grpc.stub.StreamObserver<ValuedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnClientAuthenticateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onClientAuthorize(ClientAuthorizeRequest request,
                                  io.grpc.stub.StreamObserver<ValuedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnClientAuthorizeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onClientSubscribe(ClientSubscribeRequest request,
                                  io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnClientSubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onClientUnsubscribe(ClientUnsubscribeRequest request,
                                    io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnClientUnsubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onSessionCreated(SessionCreatedRequest request,
                                 io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnSessionCreatedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onSessionSubscribed(SessionSubscribedRequest request,
                                    io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnSessionSubscribedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onSessionUnsubscribed(SessionUnsubscribedRequest request,
                                      io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnSessionUnsubscribedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onSessionResumed(SessionResumedRequest request,
                                 io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnSessionResumedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onSessionDiscarded(SessionDiscardedRequest request,
                                   io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnSessionDiscardedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onSessionTakenover(SessionTakenoverRequest request,
                                   io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnSessionTakenoverMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onSessionTerminated(SessionTerminatedRequest request,
                                    io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnSessionTerminatedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onMessagePublish(MessagePublishRequest request,
                                 io.grpc.stub.StreamObserver<ValuedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnMessagePublishMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onMessageDelivered(MessageDeliveredRequest request,
                                   io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnMessageDeliveredMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onMessageDropped(MessageDroppedRequest request,
                                 io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnMessageDroppedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onMessageAcked(MessageAckedRequest request,
                               io.grpc.stub.StreamObserver<EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnMessageAckedMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HookProviderBlockingStub extends io.grpc.stub.AbstractBlockingStub<HookProviderBlockingStub> {
    private HookProviderBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected HookProviderBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HookProviderBlockingStub(channel, callOptions);
    }

    /**
     */
    public LoadedResponse onProviderLoaded(ProviderLoadedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnProviderLoadedMethod(), getCallOptions(), request);
    }

    /**
     */
    public EmptySuccess onProviderUnloaded(ProviderUnloadedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnProviderUnloadedMethod(), getCallOptions(), request);
    }

    /**
     */
    public EmptySuccess onClientConnect(ClientConnectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnClientConnectMethod(), getCallOptions(), request);
    }

    /**
     */
    public EmptySuccess onClientConnack(ClientConnackRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnClientConnackMethod(), getCallOptions(), request);
    }

    /**
     */
    public EmptySuccess onClientConnected(ClientConnectedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnClientConnectedMethod(), getCallOptions(), request);
    }

    /**
     */
    public EmptySuccess onClientDisconnected(ClientDisconnectedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnClientDisconnectedMethod(), getCallOptions(), request);
    }

    /**
     */
    public ValuedResponse onClientAuthenticate(ClientAuthenticateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnClientAuthenticateMethod(), getCallOptions(), request);
    }

    /**
     */
    public ValuedResponse onClientAuthorize(ClientAuthorizeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnClientAuthorizeMethod(), getCallOptions(), request);
    }

    /**
     */
    public EmptySuccess onClientSubscribe(ClientSubscribeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnClientSubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public EmptySuccess onClientUnsubscribe(ClientUnsubscribeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnClientUnsubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public EmptySuccess onSessionCreated(SessionCreatedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnSessionCreatedMethod(), getCallOptions(), request);
    }

    /**
     */
    public EmptySuccess onSessionSubscribed(SessionSubscribedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnSessionSubscribedMethod(), getCallOptions(), request);
    }

    /**
     */
    public EmptySuccess onSessionUnsubscribed(SessionUnsubscribedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnSessionUnsubscribedMethod(), getCallOptions(), request);
    }

    /**
     */
    public EmptySuccess onSessionResumed(SessionResumedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnSessionResumedMethod(), getCallOptions(), request);
    }

    /**
     */
    public EmptySuccess onSessionDiscarded(SessionDiscardedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnSessionDiscardedMethod(), getCallOptions(), request);
    }

    /**
     */
    public EmptySuccess onSessionTakenover(SessionTakenoverRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnSessionTakenoverMethod(), getCallOptions(), request);
    }

    /**
     */
    public EmptySuccess onSessionTerminated(SessionTerminatedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnSessionTerminatedMethod(), getCallOptions(), request);
    }

    /**
     */
    public ValuedResponse onMessagePublish(MessagePublishRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnMessagePublishMethod(), getCallOptions(), request);
    }

    /**
     */
    public EmptySuccess onMessageDelivered(MessageDeliveredRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnMessageDeliveredMethod(), getCallOptions(), request);
    }

    /**
     */
    public EmptySuccess onMessageDropped(MessageDroppedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnMessageDroppedMethod(), getCallOptions(), request);
    }

    /**
     */
    public EmptySuccess onMessageAcked(MessageAckedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnMessageAckedMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HookProviderFutureStub extends io.grpc.stub.AbstractFutureStub<HookProviderFutureStub> {
    private HookProviderFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected HookProviderFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HookProviderFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<LoadedResponse> onProviderLoaded(
        ProviderLoadedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnProviderLoadedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EmptySuccess> onProviderUnloaded(
        ProviderUnloadedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnProviderUnloadedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EmptySuccess> onClientConnect(
        ClientConnectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnClientConnectMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EmptySuccess> onClientConnack(
        ClientConnackRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnClientConnackMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EmptySuccess> onClientConnected(
        ClientConnectedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnClientConnectedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EmptySuccess> onClientDisconnected(
        ClientDisconnectedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnClientDisconnectedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ValuedResponse> onClientAuthenticate(
        ClientAuthenticateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnClientAuthenticateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ValuedResponse> onClientAuthorize(
        ClientAuthorizeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnClientAuthorizeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EmptySuccess> onClientSubscribe(
        ClientSubscribeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnClientSubscribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EmptySuccess> onClientUnsubscribe(
        ClientUnsubscribeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnClientUnsubscribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EmptySuccess> onSessionCreated(
        SessionCreatedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnSessionCreatedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EmptySuccess> onSessionSubscribed(
        SessionSubscribedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnSessionSubscribedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EmptySuccess> onSessionUnsubscribed(
        SessionUnsubscribedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnSessionUnsubscribedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EmptySuccess> onSessionResumed(
        SessionResumedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnSessionResumedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EmptySuccess> onSessionDiscarded(
        SessionDiscardedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnSessionDiscardedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EmptySuccess> onSessionTakenover(
        SessionTakenoverRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnSessionTakenoverMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EmptySuccess> onSessionTerminated(
        SessionTerminatedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnSessionTerminatedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ValuedResponse> onMessagePublish(
        MessagePublishRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnMessagePublishMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EmptySuccess> onMessageDelivered(
        MessageDeliveredRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnMessageDeliveredMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EmptySuccess> onMessageDropped(
        MessageDroppedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnMessageDroppedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<EmptySuccess> onMessageAcked(
        MessageAckedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnMessageAckedMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ON_PROVIDER_LOADED = 0;
  private static final int METHODID_ON_PROVIDER_UNLOADED = 1;
  private static final int METHODID_ON_CLIENT_CONNECT = 2;
  private static final int METHODID_ON_CLIENT_CONNACK = 3;
  private static final int METHODID_ON_CLIENT_CONNECTED = 4;
  private static final int METHODID_ON_CLIENT_DISCONNECTED = 5;
  private static final int METHODID_ON_CLIENT_AUTHENTICATE = 6;
  private static final int METHODID_ON_CLIENT_AUTHORIZE = 7;
  private static final int METHODID_ON_CLIENT_SUBSCRIBE = 8;
  private static final int METHODID_ON_CLIENT_UNSUBSCRIBE = 9;
  private static final int METHODID_ON_SESSION_CREATED = 10;
  private static final int METHODID_ON_SESSION_SUBSCRIBED = 11;
  private static final int METHODID_ON_SESSION_UNSUBSCRIBED = 12;
  private static final int METHODID_ON_SESSION_RESUMED = 13;
  private static final int METHODID_ON_SESSION_DISCARDED = 14;
  private static final int METHODID_ON_SESSION_TAKENOVER = 15;
  private static final int METHODID_ON_SESSION_TERMINATED = 16;
  private static final int METHODID_ON_MESSAGE_PUBLISH = 17;
  private static final int METHODID_ON_MESSAGE_DELIVERED = 18;
  private static final int METHODID_ON_MESSAGE_DROPPED = 19;
  private static final int METHODID_ON_MESSAGE_ACKED = 20;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HookProviderImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HookProviderImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ON_PROVIDER_LOADED:
          serviceImpl.onProviderLoaded((ProviderLoadedRequest) request,
              (io.grpc.stub.StreamObserver<LoadedResponse>) responseObserver);
          break;
        case METHODID_ON_PROVIDER_UNLOADED:
          serviceImpl.onProviderUnloaded((ProviderUnloadedRequest) request,
              (io.grpc.stub.StreamObserver<EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_CLIENT_CONNECT:
          serviceImpl.onClientConnect((ClientConnectRequest) request,
              (io.grpc.stub.StreamObserver<EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_CLIENT_CONNACK:
          serviceImpl.onClientConnack((ClientConnackRequest) request,
              (io.grpc.stub.StreamObserver<EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_CLIENT_CONNECTED:
          serviceImpl.onClientConnected((ClientConnectedRequest) request,
              (io.grpc.stub.StreamObserver<EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_CLIENT_DISCONNECTED:
          serviceImpl.onClientDisconnected((ClientDisconnectedRequest) request,
              (io.grpc.stub.StreamObserver<EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_CLIENT_AUTHENTICATE:
          serviceImpl.onClientAuthenticate((ClientAuthenticateRequest) request,
              (io.grpc.stub.StreamObserver<ValuedResponse>) responseObserver);
          break;
        case METHODID_ON_CLIENT_AUTHORIZE:
          serviceImpl.onClientAuthorize((ClientAuthorizeRequest) request,
              (io.grpc.stub.StreamObserver<ValuedResponse>) responseObserver);
          break;
        case METHODID_ON_CLIENT_SUBSCRIBE:
          serviceImpl.onClientSubscribe((ClientSubscribeRequest) request,
              (io.grpc.stub.StreamObserver<EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_CLIENT_UNSUBSCRIBE:
          serviceImpl.onClientUnsubscribe((ClientUnsubscribeRequest) request,
              (io.grpc.stub.StreamObserver<EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_SESSION_CREATED:
          serviceImpl.onSessionCreated((SessionCreatedRequest) request,
              (io.grpc.stub.StreamObserver<EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_SESSION_SUBSCRIBED:
          serviceImpl.onSessionSubscribed((SessionSubscribedRequest) request,
              (io.grpc.stub.StreamObserver<EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_SESSION_UNSUBSCRIBED:
          serviceImpl.onSessionUnsubscribed((SessionUnsubscribedRequest) request,
              (io.grpc.stub.StreamObserver<EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_SESSION_RESUMED:
          serviceImpl.onSessionResumed((SessionResumedRequest) request,
              (io.grpc.stub.StreamObserver<EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_SESSION_DISCARDED:
          serviceImpl.onSessionDiscarded((SessionDiscardedRequest) request,
              (io.grpc.stub.StreamObserver<EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_SESSION_TAKENOVER:
          serviceImpl.onSessionTakenover((SessionTakenoverRequest) request,
              (io.grpc.stub.StreamObserver<EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_SESSION_TERMINATED:
          serviceImpl.onSessionTerminated((SessionTerminatedRequest) request,
              (io.grpc.stub.StreamObserver<EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_MESSAGE_PUBLISH:
          serviceImpl.onMessagePublish((MessagePublishRequest) request,
              (io.grpc.stub.StreamObserver<ValuedResponse>) responseObserver);
          break;
        case METHODID_ON_MESSAGE_DELIVERED:
          serviceImpl.onMessageDelivered((MessageDeliveredRequest) request,
              (io.grpc.stub.StreamObserver<EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_MESSAGE_DROPPED:
          serviceImpl.onMessageDropped((MessageDroppedRequest) request,
              (io.grpc.stub.StreamObserver<EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_MESSAGE_ACKED:
          serviceImpl.onMessageAcked((MessageAckedRequest) request,
              (io.grpc.stub.StreamObserver<EmptySuccess>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HookProviderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HookProviderBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return EmqxExHookProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HookProviderImpl");
    }
  }

  private static final class HookProviderFileDescriptorSupplier
      extends HookProviderBaseDescriptorSupplier {
    HookProviderFileDescriptorSupplier() {}
  }

  private static final class HookProviderMethodDescriptorSupplier
      extends HookProviderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HookProviderMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HookProviderGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HookProviderFileDescriptorSupplier())
              .addMethod(getOnProviderLoadedMethod())
              .addMethod(getOnProviderUnloadedMethod())
              .addMethod(getOnClientConnectMethod())
              .addMethod(getOnClientConnackMethod())
              .addMethod(getOnClientConnectedMethod())
              .addMethod(getOnClientDisconnectedMethod())
              .addMethod(getOnClientAuthenticateMethod())
              .addMethod(getOnClientAuthorizeMethod())
              .addMethod(getOnClientSubscribeMethod())
              .addMethod(getOnClientUnsubscribeMethod())
              .addMethod(getOnSessionCreatedMethod())
              .addMethod(getOnSessionSubscribedMethod())
              .addMethod(getOnSessionUnsubscribedMethod())
              .addMethod(getOnSessionResumedMethod())
              .addMethod(getOnSessionDiscardedMethod())
              .addMethod(getOnSessionTakenoverMethod())
              .addMethod(getOnSessionTerminatedMethod())
              .addMethod(getOnMessagePublishMethod())
              .addMethod(getOnMessageDeliveredMethod())
              .addMethod(getOnMessageDroppedMethod())
              .addMethod(getOnMessageAckedMethod())
              .build();
        }
      }
    }
    return result;
  }
}
