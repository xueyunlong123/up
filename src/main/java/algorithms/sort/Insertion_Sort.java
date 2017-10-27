package algorithms.sort;

/**
 * Created by xueyunlong on 17-8-30.
 * 插入排序算法:该算法的最坏时间复杂度为O(n^2),最好时间复杂度为O(n)
 */
public class Insertion_Sort {
    public static void main(String[] args) {
        int[] ints = {31,41,59,26,41,58};

        for (int i = 1; i < ints.length; i++) {
            int j = i -1;
            int temp = ints[i];
            while (j >= 0 && ints[j] < temp){
                ints[j+1] = ints[j];
                j --;
            }
            ints[j+1] = temp;
        }
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
