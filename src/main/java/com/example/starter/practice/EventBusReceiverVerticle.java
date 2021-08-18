package com.example.starter.practice;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class EventBusReceiverVerticle extends AbstractVerticle {

    private final String name;

    public EventBusReceiverVerticle(String name) {
        this.name = name;
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        vertx.eventBus().consumer("anAddress", message -> System.out.println(name + " received message: " + message.body()));
    }
}
