// https://leetcode.com/problems/search-a-2d-matrix/

// Time complexity : O(log(mn)) since it's a standard binary search.
// Space complexity : O(1).

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }
    int m = matrix.length;
    int n = matrix[0].length;
    int low = 0;
    int high = m * n - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      int row = mid / n;
      int column = mid % n;
      if (matrix[row][column] == target) {
        return true;
      }
      if (target < matrix[row][column]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return false;
  }
}