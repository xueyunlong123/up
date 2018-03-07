package hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.netflix.hystrix.exception.HystrixTimeoutException;

import java.util.Map;

/**
 * Created by xyl on 2018/2/26.
 */
public class CommandHelloFailure extends HystrixCommand<String> {

    private final String name;

    public CommandHelloFailure(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("CircuitBreakerTestGroup"))
                        .andCommandKey(HystrixCommandKey.Factory.asKey("CircuitBreakerTestKey"))
                        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("CircuitBreakerTest"))
                        .andThreadPoolPropertiesDefaults(	// 配置线程池
                                HystrixThreadPoolProperties.Setter()
                                        .withCoreSize(200)	// 配置线程池里的线程数，设置足够多线程，以防未熔断却打满threadpool
                        )
                        .andCommandPropertiesDefaults(	// 配置熔断器
                                HystrixCommandProperties.Setter()
                                        .withCircuitBreakerEnabled(true)
                                        .withCircuitBreakerRequestVolumeThreshold(3)
                                        .withCircuitBreakerErrorThresholdPercentage(80)
//                		.withCircuitBreakerForceOpen(true)	// 置为true时，所有请求都将被拒绝，直接到fallback
//                		.withCircuitBreakerForceClosed(true)	// 置为true时，将忽略错误
//                		.withExecutionIsolationStrategy(ExecutionIsolationStrategy.SEMAPHORE)	// 信号量隔离
//                		.withExecutionTimeoutInMilliseconds(5000)
                        )
        );
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        System.out.println("running run():" + name);
        int num = Integer.valueOf(name);
        if(num % 2 == 0 && num < 10) {	// 直接返回
            return name;
        } else {	// 无限循环模拟超时
            throw new HystrixTimeoutException();
        }
//		return name;
    }

    @Override
    protected String getFallback() {
        return "CircuitBreaker fallback: " + name;
    }

    public static void main(String[] args) {
            for(int i = 0; i < 50; i++) {
                try {
                    System.out.println("===========" + new CommandHelloFailure(String.valueOf(i)).execute());
//	        		try {
//	            		TimeUnit.MILLISECONDS.sleep(1000);
//	            	}catch(Exception e) {}
//	        		Future<String> future = new HystrixCommand4CircuitBreakerTest("Hlx"+i).queue();
//	        		System.out.println("===========" + future);
                } catch(Exception e) {
                    System.out.println("run()抛出HystrixBadRequestException时，被捕获到这里" + e.getCause());
                }
            }

            System.out.println("------开始打印现有线程---------");
            Map<Thread, StackTraceElement[]> map=Thread.getAllStackTraces();
            for (Thread thread : map.keySet()) {
                System.out.println(thread.getName());
            }
            System.out.println("thread num: " + map.size());

        }
    }
