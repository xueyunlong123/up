package algorithms.sort;

/**
 * Created by xueyunlong on 17-8-30.
 * 选择算法排序:最好时间复杂度和最坏时间复杂度都为O(n^2)
 */
public class Select_Sort {
    public static void main(String[] args) {
        int[] ints = {31,41,59,26,41,58};
        for (int i = 0; i < ints.length; i++) {
            int temp = 0;
            int index = i;
            //select min num
            for (int j = i; j < ints.length; j++) {
                if (temp < ints[j]){
                    temp = ints[j];
                    index = j;
                }
            }
            ints[index] = ints[i];
            ints[i] = temp;
        }
    }
}
