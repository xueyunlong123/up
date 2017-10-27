package algorithms.sort;

/**
 * Created by xueyunlong on 17-8-31.
 * 归并排序算法:最坏时间复杂度为:nlgn
 */
public class Merge_Sort {
    private static int[] ints = {0,41,59,26,41,58,1,222,5};
    public static void main(String[] args) {
        Merge_Sort merge_sort = new Merge_Sort();
        merge_sort.mergeSort(ints,0,ints.length-1);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    /*
    * 递归
    * */
    private void mergeSort(int[] ints,int p,int r){
        if (p < r){
            int q = (r+p) >> 1;
            mergeSort(ints,p,q);
            mergeSort(ints,q+1,r);
            merge(ints,p,q,r);
        }
    }
    /*
    * 排序
    * */
    private void merge(int[] ints, int p, int q, int r){
        int[] left = new int[12];
        int[] right = new int[12];
        int n1 = q - p + 1;
        int n2 = r -q;
        System.arraycopy(ints, p, left, 0, n1);
        System.arraycopy(ints, q+1, right, 0, n2);
        int leftNum = 0 ;
        int rightNum =0 ;
        for (int i = p; i <= r; i++) {
            if (left[leftNum] > right[rightNum]){
                ints[i] = left[leftNum];
                leftNum ++;
            }else {
                ints[i] = right[rightNum];
                rightNum ++;
            }
        }
    }
}
