package com.example.starter.practice;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class MainVerticle {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));

        vertx.deployVerticle(new MyVertice());
    }
}
