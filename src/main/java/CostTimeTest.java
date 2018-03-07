import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/**
 * Created by xyl on 2018/2/1.
 */
public class CostTimeTest {


    public static final Func2<Integer, Integer, Integer> INTEGER_SUM =
            (integer, integer2) -> integer + integer2;

    public static final Func1<Observable<Integer>, Observable<Integer>> WINDOW_SUM =
            window -> window.scan(INTEGER_SUM).skip(14);

    public static final Func1<Observable<Integer>, Observable<Integer>> INNER_BUCKET_SUM =
            integerObservable -> integerObservable.reduce(0, INTEGER_SUM);

    public static void main(String[] args) throws InterruptedException {
        PublishSubject<Integer> publishSubject = PublishSubject.create();
        SerializedSubject<Integer, Integer> serializedSubject = publishSubject.toSerialized();
        AtomicInteger sum = new AtomicInteger();

        serializedSubject
                .window(1, TimeUnit.SECONDS) // 5秒作为一个基本块
                .flatMap(INNER_BUCKET_SUM)           // 基本块内数据求和
                .window(15, 1)           // 3个块作为一个窗口，滚动布数为1
                .flatMap(WINDOW_SUM)                 // 窗口数据求和
                .subscribe((Integer integer) ->{
                            System.out.println("["+Thread.currentThread().getName()+"] call ...... "+integer+"");
                            sum.set(integer);
                        }
                );

        // 缓慢发送数据，观察效果
        for (int i=0; i<100; ++i) {
            if (new Random().nextInt(1000) > 100) {
                serializedSubject.onNext(1);
            }
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("当前 数值为 ：{}"+ sum.get());
        }

    }
}
