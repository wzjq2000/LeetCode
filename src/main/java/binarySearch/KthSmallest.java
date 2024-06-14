package binarySearch;

public class KthSmallest {
    public static int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix.length - 1];
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            int m = splitMatrix(matrix, mid);
            if (m < k) {
                left = mid + 1;
            } else if (m >= k) {
                right = mid - 1;
            }
        }
        return left;
    }

    public static int splitMatrix(int[][] matrix, int arg) {  // arg是分割矩阵的根据
        int n = matrix.length;
        int count = 0;

        int col = 0;
        int row = n - 1;
        while (row >= 0 && col <= n - 1) {
            int c = matrix[row][col];
            if (c <= arg) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 27}};
        System.out.println(kthSmallest(matrix, 8));
    }
}
