package algorithms.sort;

import java.util.Arrays;

/**
 * Created by xueyunlong on 17-9-11.
 * 堆排序:时间复杂度为nlgn.原址排序
 堆排序就是把最大堆堆顶的最大数取出，将剩余的堆继续调整为最大堆，再次将堆顶的最大数取出，这个过程持续到剩余数只有一个时结束。
 在堆中定义以下几种操作：
    最大堆调整（Max-Heapify）：将堆的末端子节点作调整，使得子节点永远小于父节点
    创建最大堆（Build-Max-Heap）：将堆所有数据重新排序，使其成为最大堆
    堆排序（Heap-Sort）：移除位在第一个数据的根节点，并做最大堆调整的递归运算
 */
public class Heap_Sort {

    /*
    * 从i开始维护最大堆的性质
    * */
    private void MaxHeapify(int[] a, int i, int heapSize){
        int leftIndex = (i << 1) +1;
        int rightIndex = leftIndex + 1;
        int largest;
        if (leftIndex < heapSize && a[leftIndex] > a[i]){
            largest = leftIndex;
        }else {
            largest = i;
        }
        if (rightIndex < heapSize && a[rightIndex] > a[largest]){
            largest = rightIndex;
        }
        if (largest != i){
            swap(a,i,largest);
            MaxHeapify(a,largest,heapSize);
        }
    }
    /*
    * 构建最大堆
    * */
    private void buildMaxHeap(int[] a, int heapSize){
        int mid = heapSize >> 1;
        for (int i = mid; i >= 0; i--) {
            MaxHeapify(a,i,heapSize);
        }
    }
    /*
    * 最大堆排序
    * */
    private void heapSort(int[] a){
        int heapSize = a.length;
        buildMaxHeap(a,heapSize);
        for (int i = a.length -1; i >= 0; i--) {
            swap(a,0,i);
            heapSize = heapSize -1;
            MaxHeapify(a,0,heapSize);
        }
    }

    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] ints = {0,41,59,26,41,58,1,222,5};
        Heap_Sort heap_sort = new Heap_Sort();
        heap_sort.heapSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
