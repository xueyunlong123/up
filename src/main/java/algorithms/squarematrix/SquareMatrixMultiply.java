package algorithms.squarematrix;

/**
 * Created by xueyunlong on 17-9-6.
 * 方型矩阵相乘
 */
public class SquareMatrixMultiply {
    public static void main(String[] args) {
        int[][] matrix1 =
                {{1,2,3},
                 {1,2,3},
                 {1,2,3}};
        int[][] matrix2 =
                {{1,2,3},
                 {1,2,3},
                 {1,2,3}};
        int[][] matrix3 =
                {{1,2,3},
                 {1,2,3},
                 {1,2,3}};
        SquareMatrixMultiply squareMatrixMultiply = new SquareMatrixMultiply();
        matrix3 = squareMatrixMultiply.multiply(matrix1,matrix2,matrix3);
        System.out.println(matrix3);
    }
    private int[][] multiply(int[][] matrix1,int[][] matrix2,int[][] matrix3){
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < matrix1.length; k++) {
                    sum +=matrix1[i][k]*matrix1[k][i];
                }
                matrix3[i][j]=sum;
            }
        }
        return matrix3;
    }

}
