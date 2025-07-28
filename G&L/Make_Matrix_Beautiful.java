
/*
Explanation:
A beautiful matrix is defined as a square matrix in which the sum of elements in every row and every column is equal. Given a square matrix mat[][], your task is to determine the minimum number of operations required to make the matrix beautiful.
In one operation, you are allowed to increment the value of any single cell by 1.
*/

class Solution {
    public static int balanceSums(int[][] mat) {
        int n=mat.length;
         int[] rowSum = new int[n];
        int[] colSum = new int[n];
        int maxSum = 0;

        // Calculate row sums and column sums
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }

        // Find the maximum sum among rows and columns
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, rowSum[i]);
            maxSum = Math.max(maxSum, colSum[i]);
        }

        // Calculate total number of operations needed
        int operations = 0;
        for (int i = 0; i < n; i++) {
            operations += maxSum - rowSum[i];
        }

        return operations;
    }
}
