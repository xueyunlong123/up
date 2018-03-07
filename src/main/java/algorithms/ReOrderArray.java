package algorithms;

/**
 * Created by xyl on 2018/1/26.
 */
public class ReOrderArray {
    public static void reOrderArray(int [] array) {
        int [] oddArray = new int[array.length];
        int [] evenArray = new int[array.length];
        int oddIndex = 0;
        int evenIndex = 0;
        for (int i : array) {
            if (i % 2 == 1){
                oddArray[oddIndex] = i;
                oddIndex ++;
            }else {
                evenArray[evenIndex] = i;
                evenIndex ++;
            }
        }

        for (int i = 0; i < oddArray.length; i++) {
            array[i] = oddArray[i];
        }
        for (int i = 0; i < evenIndex; i++) {
            array[i + oddIndex] = evenArray[i];
        }
    }

    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6,7};
        ReOrderArray.reOrderArray(a);

    }
}
