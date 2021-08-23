package com.example.starter.practice;

import io.vertx.core.Vertx;

public class MainVerticle {

    public static void main(String[] args) throws InterruptedException {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new VertxHttpServerVerticleWithRouter());
    }
}
