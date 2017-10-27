package algorithms;

/**
 * Created by xueyunlong on 17-9-4.
 * 寻找连续最大和子数组算法:采用分治策略,最坏时间复杂度O(nlgn)
 * 心得:寻找最大和子数组算法,主要采用了分治策略,运用递归的方式,将大问题分解为小的问题,对一次问题的求解的时间复杂度为O(n).
 * 这样,将一个时间复杂度为O(n^2),分解为了O(n)*O(lgn),这一点和二分查找的原理是一样的.
 */
public class FindMaxiMumSubArray {
    public static void main(String[] args) {
        int[] ints = {0,31,41,59,-26,41,-58,10,-10};
        FindMaxiMumSubArray findMaxiMumSubArray = new FindMaxiMumSubArray();
        MaxiMumSubArray maxiMumSubArray = findMaxiMumSubArray.findMaxiMumSubArray(ints,1,ints.length-1);
        System.out.println(maxiMumSubArray.getSum());
    }

    /*
    * 寻找最大和子数组
    * */
    private MaxiMumSubArray findMaxiMumSubArray(int[] ints, int low, int high){
        if (low == high){
            return new MaxiMumSubArray(low,high,ints[low]);
        }else {
            int mid = (low + high) >> 1;
            MaxiMumSubArray leftSum = findMaxiMumSubArray(ints,low,mid);
            MaxiMumSubArray rightSum = findMaxiMumSubArray(ints,mid + 1,high);
            MaxiMumSubArray crossingSum = findMaxCrossingSubArray(ints,low,high);
            if (leftSum.getSum() > rightSum.getSum() && leftSum.getSum() > crossingSum.getSum()){
                return leftSum;
            }else if (rightSum.getSum() > leftSum.getSum() && rightSum.getSum() > crossingSum.getSum()){
                return rightSum;
            }else {
                return crossingSum;
            }
        }
    }
    /*
    * 寻找跨过中间节点的最大子数组
    * */
    private MaxiMumSubArray findMaxCrossingSubArray(int[] ints, int low, int high){
        int leftSum = Integer.MIN_VALUE,rightSum = Integer.MIN_VALUE;
        int sum;
        int left = 0,right = 0;
        int mid = (low + high) >> 1;
        for (int i = mid; i >= low; i--) {
            if (leftSum + ints[i] > leftSum){
                leftSum = leftSum + ints[i];
                left = i;
            }
        }
        for (int i = mid + 1; i <= high; i++) {
            if (rightSum + ints[i] > rightSum){
                rightSum = rightSum + ints[i];
                right = i;
            }
        }
        sum = leftSum + rightSum;
        return new MaxiMumSubArray(left,right,sum);
    }

    class MaxiMumSubArray{
        int low;

        public int getLow() {
            return low;
        }

        public void setLow(int low) {
            this.low = low;
        }

        public MaxiMumSubArray(int low, int high, int sum) {
            this.low = low;
            this.high = high;
            this.sum = sum;
        }

        public int getHigh() {
            return high;
        }

        public void setHigh(int high) {
            this.high = high;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        int high;
        int sum;
    }
}
