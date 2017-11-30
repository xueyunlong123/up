###CompleteFuture

> get()

```
    public Future<String> calculateAsync(){
            CompletableFuture<String> completableFuture
                    = new CompletableFuture<>();
    
            Executors.newCachedThreadPool().submit(() -> {
                Thread.sleep(500);
                completableFuture.complete("Hello");
                return null;
            });
    
            return completableFuture;
        }
    
        public static void main(String[] args) {
            Future<String> stringFuture = new CalculateAsync().calculateAsync();
            try {
            
            //这里通过get获取future中的元素，是阻塞的（blocking），在future中的耗时任务没有呗执行完的时候，主线程会一直阻塞着等待结果
                String s = stringFuture.get();
                System.out.println(s);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
```

> cancel()

```
    
    当我们阻塞在future.get()时，future被取消，那么将会抛出异常：
    Exception in thread "main" java.util.concurrent.CancellationException
    	at java.util.concurrent.CompletableFuture.cancel(CompletableFuture.java:2263)
    	at ayscprogram.CalculateAsync.lambda$calculateAsync$0(CalculateAsync.java:19)
    	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
    	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    	at java.lang.Thread.run(Thread.java:748)
```

> supplyAsync()

```
    supplyAsync 方法，为了提供了一个很便捷的执行任务的方法而来的，默认采用的线程池是:
         /**
         * Default executor -- ForkJoinPool.commonPool() unless it cannot
         * support parallelism.
         */
        private static final Executor asyncPool = useCommonPool ?
            ForkJoinPool.commonPool() : new ThreadPerTaskExecutor();
    private Future<String> supplyAsync(){
           return CompletableFuture.supplyAsync(() -> "supplyAsync");
       }
    
```

> thenApply()
```
    thenApply 方法是上一个任务执行过之后，触发的一个操作。可以返回CompletableFuture<String>来从中获取一个结果。
    private Future thenApply(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello ")
                .thenApply(s -> s + " world");
        return future;
    }
```
> thenAccept()
```
    thenAccpet 同样是来处理上一stage返回的数据，但仅仅是处理数据，并不返回数据。允许当前任务中数据被继续消费。
    private Future<Void> thenAccept(){
            return CompletableFuture.supplyAsync(() -> "hello")
                    .thenAccept(s -> System.out.println(s + "world"));
    }
```
> thenRun()
```
    我们不需要返回的数据，同样也不想让当前任务中的数据被继续消费，只是为了关闭当前任务
    private Future<Void> thenRun(){
            return CompletableFuture.supplyAsync(() -> "hello")
                    .thenRun(() -> System.out.println("game over"));
    }
    
```

