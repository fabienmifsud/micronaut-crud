package com.fmi.micronaut.security;

import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.annotation.Nullable;
import javax.inject.Singleton;
import java.util.Arrays;

@Singleton
public class BasicMockAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        return Flowable.create(emitter -> {
            if (authenticationRequest.getIdentity().equals("standardUser") &&
                    authenticationRequest.getSecret().equals("standardUser")) {
                emitter.onNext(new UserDetails((String) authenticationRequest.getIdentity(), Arrays.asList("USER")));
                emitter.onComplete();
            } else if (authenticationRequest.getIdentity().equals("adminUser") &&
                    authenticationRequest.getSecret().equals("adminUser")) {
                emitter.onNext(new UserDetails((String) authenticationRequest.getIdentity(), Arrays.asList("ADMIN")));
                emitter.onComplete();
            } else {
                emitter.onError(new AuthenticationException(new AuthenticationFailed()));
            }
        }, BackpressureStrategy.ERROR);
    }
}