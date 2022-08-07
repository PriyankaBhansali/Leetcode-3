// https://leetcode.com/problems/unique-paths/

// Time complexity: O(m.n)
// Space complexity: O(m.n)

class Solution {
  public int uniquePaths(int m, int n) {
    int[][] matrix = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          matrix[i][j] = 1;
        } else {
          matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
        }
      }
    }
    return matrix[m-1][n-1];
  }
}

// Recursion
// Not preferred because it will cause error - Time Limit Exceeded
// Time complexity = 2^m.n
class Solution {
  public int uniquePaths(int m, int n) {
    if (m == 1 || n == 1) {
      return 1;
    }
    return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
  }
}