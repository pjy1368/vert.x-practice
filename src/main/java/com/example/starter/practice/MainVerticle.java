package com.example.starter.practice;

import io.vertx.core.Vertx;

public class MainVerticle {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new MyVertice());
        vertx.deployVerticle(new BasicVerticle(), event -> System.out.println("BasicVerticle deployment complete"));
    }
}
