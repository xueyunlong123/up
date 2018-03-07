package algorithms;

/**
 * Created by xyl on 2018/1/25.
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (char c : binaryString.toCharArray()) {
            if (c == '1') count ++;
        }
        return count;
    }
}
