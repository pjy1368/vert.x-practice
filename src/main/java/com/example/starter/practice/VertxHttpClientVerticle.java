package com.example.starter.practice;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.http.HttpMethod;

public class VertxHttpClientVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        HttpClient httpClient = vertx.createHttpClient();
        httpClient.request(HttpMethod.GET, 9999, "localhost", "?name=jin", req -> {
            if (req.succeeded()) {
                HttpClientRequest request = req.result();
                request.send(body -> {
                    if (body.succeeded()) {
                        HttpClientResponse response = body.result();
                        System.out.println("Received response with status code " + response.statusCode());
                    } else {
                        System.out.println("Something went wrong " + body.cause().getMessage());
                    }
                });
            }
        });
    }
}
