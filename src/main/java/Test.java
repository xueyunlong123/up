import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xueyunlong on 17-8-22.
 *
 */
public class Test implements Serializable{
    public static void main(String[] args) {

        System.out.println(1 << 6);
        System.out.println(Integer.toBinaryString(268451904));
        ArrayDeque arrayQueue = new ArrayDeque(15);
        System.out.println(268435456+64+16384);
        Pattern pattern = Pattern.compile("P01|P02|P11");
        Matcher matcher = pattern.matcher("P01");
        if (matcher.find()){
            System.out.println(matcher.matches());
        }
        System.out.println(536870912 & 0);
        long s =0x405d1a7414a4d2b3L;
//        double l = 116.4074464;
        double l = 39.912325;
        System.out.println(Double.longBitsToDouble(0x405d1a7414a4d2b3L));
        long bit = Double.doubleToLongBits(l);
        System.out.println(Long.toHexString(bit));
        System.out.println("程序员节日快乐哦".substring(7,8));
    }
}
