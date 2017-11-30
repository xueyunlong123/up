package ayscprogram;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by xyl on 11/30/17.
 */
public class CalculateAsync {
    private Future<String> calculateAsync(){
        CompletableFuture<String> completableFuture
                = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
//            completableFuture.complete("Hello");
            completableFuture.cancel(true);
            return null;
        });

        return completableFuture;
    }

    private Future<String> supplyAsync(){
        return CompletableFuture.supplyAsync(() -> "supplyAsync");
    }

    private Future<String> thenApply(){
        return CompletableFuture.supplyAsync(() -> "hello ")
                .thenApply(s -> s + " world");
    }
    private Future<Void> thenAccept(){
        return CompletableFuture.supplyAsync(() -> "hello")
                .thenAccept(s -> System.out.println(s + "world"));
    }
    private Future<Void> thenRun(){
        return CompletableFuture.supplyAsync(() -> "hello")
                .thenRun(() -> System.out.println("game over"));
    }
    public static void main(String[] args) {
        Future<Void> stringFuture = new CalculateAsync().thenRun();
        try {
            stringFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
