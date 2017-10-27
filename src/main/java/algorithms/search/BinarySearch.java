package algorithms.search;

/**
 * Created by xueyunlong on 17-8-31.
 * 有序数组-二分查找:最坏时间复杂度为:lgn,先来一波伪代码
 Binary-search(A[],int searchNum)
 int temp = A[].length / 2
 let B[] be new array
    if A[temp] > searchNum
        for b = 0 to temp-1
            B[b] = A[b]
        Binary-search(B[],searchNum)
    else A[temp] < searchNum
        for b = temp to A[].length
            B[b] = A[b]
        Binary-search(B[],searchNum)
    else A[temp] = searchNum
        return temp
    else
        return not found
 */
public class BinarySearch {
}
