class Solution {
    public void setZeroes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // 1. Pick a safe marker that does not exist in mat
        int marker = Integer.MIN_VALUE;
        while (contains(mat, marker)) {
            marker++; // Increment until an unused number is found
        }

        // 2. Mark rows and columns with the guaranteed safe marker
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    mark_row(i, mat, marker);
                    mark_col(j, mat, marker);
                }
            }
        }

        // 3. Convert all marker values to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == marker) {
                    mat[i][j] = 0;
                }
            }
        }
    }

    private boolean contains(int[][] mat, int target) {
        for (int[] row : mat) {
            for (int val : row) {
                if (val == target) return true;
            }
        }
        return false;
    }

    public void mark_row(int x, int[][] mat, int marker) {
        for (int i = 0; i < mat[0].length; i++) {
            if (mat[x][i] != 0) {
                mat[x][i] = marker;
            }
        }
    }

    public void mark_col(int y, int[][] mat, int marker) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][y] != 0) {
                mat[i][y] = marker;
            }
        }
    }
}