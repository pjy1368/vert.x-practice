package com.example.starter.practice;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class EventBusSenderVerticle extends AbstractVerticle {

    public void start(Promise<Void> startPromise) {
        vertx.eventBus().publish("anAddress", "message 2");
        vertx.eventBus().send   ("anAddress", "message 1");
    }
}