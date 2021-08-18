package com.example.starter.practice;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;

public class VertxHttpServerVerticle extends AbstractVerticle {

    private HttpServer httpServer;

    @Override
    public void start() throws Exception {
        httpServer = vertx.createHttpServer();
        httpServer.requestHandler(request -> {
            System.out.println("incoming request!");

            Buffer fullRequestBody = Buffer.buffer();
            if (request.method() == HttpMethod.GET) {
                fullRequestBody.appendBuffer(Buffer.buffer(request.getParam("name")));
            }
            if (request.method() == HttpMethod.POST) {
                request.handler(fullRequestBody::appendBuffer);
                request.endHandler(buffer -> System.out.println(fullRequestBody));
            }

            HttpServerResponse response = request.response();
            response.setStatusCode(200);
            response.headers()
                .add("Content-Type", "text/html");

            response.end("Vert.x is alive!");
        });
        httpServer.listen(9999);
    }
}
