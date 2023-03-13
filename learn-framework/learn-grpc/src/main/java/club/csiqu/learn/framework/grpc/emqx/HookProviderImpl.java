package club.csiqu.learn.framework.grpc.emqx;

import io.emqx.exhook.ClientAuthenticateRequest;
import io.emqx.exhook.ClientConnectRequest;
import io.emqx.exhook.EmptySuccess;
import io.emqx.exhook.HookProviderGrpc;
import io.emqx.exhook.HookSpec;
import io.emqx.exhook.LoadedResponse;
import io.emqx.exhook.ProviderLoadedRequest;
import io.emqx.exhook.ValuedResponse;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author Siqu Chen 2023/3/13
 * @since 1.0
 */
public class HookProviderImpl extends HookProviderGrpc.HookProviderImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(HookProviderImpl.class);

    @Override
    public void onProviderLoaded(ProviderLoadedRequest request, StreamObserver<LoadedResponse> responseObserver) {
        LOGGER.debug("onProviderLoaded:{}", request);
        HookSpec[] specs = {
                HookSpec.newBuilder().setName("client.connect").build(),
                HookSpec.newBuilder().setName("client.authenticate").build(),
        };
        LoadedResponse reply = LoadedResponse.newBuilder().addAllHooks(Arrays.asList(specs)).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void onClientConnect(ClientConnectRequest request, StreamObserver<EmptySuccess> responseObserver) {
        LOGGER.debug("onClientConnect: {}", request);
        EmptySuccess reply = EmptySuccess.newBuilder().build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void onClientAuthenticate(ClientAuthenticateRequest request, StreamObserver<ValuedResponse> responseObserver) {
        LOGGER.debug("onClientAuthenticate: {}", request);
        if (!request.getClientinfo().getClientid().startsWith("chen")) {
            responseObserver.onError(new Exception());
        } else {
            ValuedResponse reply = ValuedResponse.newBuilder()
                    .setBoolResult(true)
                    .setType(ValuedResponse.ResponsedType.CONTINUE)
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}
