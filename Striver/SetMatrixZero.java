package Striver;

// https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        int row[] = new int[matrix.length];
        int col[] = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (row[i]==1 || col[j]==1) matrix[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        
    }

    public void setZeroes0Space(int[][] matrix) {
        boolean firstRowIsZero = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRowIsZero = true;
                break;
            }
        }
        if (firstRowIsZero) return;
        for (int i = 1; i < matrix.length; i++) {

        }
    }
}
