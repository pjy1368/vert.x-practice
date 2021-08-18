package com.example.starter.practice;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class MainVerticle {

    public static void main(String[] args) throws InterruptedException {
        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));

        vertx.deployVerticle(new EventBusReceiverVerticle("R1"));
        vertx.deployVerticle(new EventBusReceiverVerticle("R2"));

        Thread.sleep(3000);
        vertx.deployVerticle(new EventBusSenderVerticle());
    }
}
