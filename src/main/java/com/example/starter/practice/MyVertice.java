package com.example.starter.practice;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class MyVertice extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        System.out.println("MyVerticle started!");
    }

    public void stop(Promise<Void> stopPromise) throws Exception {
        System.out.println("MyVerticle stopped!");
    }
}
