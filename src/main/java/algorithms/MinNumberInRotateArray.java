package algorithms;

/**
 * Created by xyl on 2018/1/22.
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length - 1;
        while (left != right){
            int mid = left + (right - left) / 2 ;
            if (array[mid] > array[right]){
                left = mid + 1;
            }else if (array[mid] == array[right]){
                right = right - 1;
            }else {
                right = mid;
            }
        }
        return array[left];
    }

}
