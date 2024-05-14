package problems;

// https://leetcode.com/problems/search-a-2d-matrix/description/
// Time O(log(m*n)) - Space(O(1)) or (~same)
// Time O(log(m) + log(n)) - Space O(1)

public class SearchA2dMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {return false;}

        int l = 0, r = matrix.length - 1;

        while (l <= r) {
            int k = l + (r - l) / 2;
            if (matrix[k][0] == target) {
                return true;
            } else if (matrix[k][0] < target) {
                int il = 0, ir = matrix[k].length - 1;
                while (il <= ir) {
                    int ik = il + (ir - il) / 2;
                    if (matrix[k][ik] == target) {
                        return true;
                    } else if (matrix[k][ik] > target) {
                        ir = ik - 1;
                    } else {
                        il = ik + 1;
                    }
                }
                l = k + 1;
            } else {
                r = k - 1;
            }
        }
        return false;
    }
}
