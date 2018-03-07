package algorithms;

import java.util.ArrayList;

/**
 * Created by xyl on 2018/1/31.
 */
public class PrintMatrix {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix.length == 1){
            for (int i = 0; i < matrix[0].length; i++) {
                result.add(matrix[0][i]);
            }
            return result;
        }
        while (matrix[0].length > 1){
            for (int i = 0; i < matrix[0].length; i++) {
                result.add(matrix[0][i]);
            }
            //旋转数组
            int [][] tmp = new int[matrix[0].length][matrix.length-1];
            for (int i = matrix[0].length -1 ; i >= 0; i--) {
                for (int j = 1; j < matrix.length; j++) {
                    tmp[matrix[0].length -1 - i][j-1] = matrix[j][i];
                }
            }
            matrix = tmp;
        }
        for (int[] aMatrix : matrix) {
            result.add(aMatrix[0]);
        }
        return result;
    }

    public static void main(String[] args) {
        int [][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        PrintMatrix.printMatrix(a);
    }

}
