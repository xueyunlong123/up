package algorithms;

/**
 * Created by xyl on 2018/1/22.
 */
public class Fibonacci {
    private int Fibonacci(int n) {
        if (n < 0){
            return 0;
        }
        if (n == 1 || n == 2) return 1;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().Fibonacci(1000));
    }
}
