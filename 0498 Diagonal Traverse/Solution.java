// https://leetcode.com/problems/diagonal-traverse/

// Time Complexity: O(mn)
// Space Complexity: O(1)

class Solution {
  public int[] findDiagonalOrder(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;

    int[] output_arr = new int [m*n];
    int i = 0;

    boolean dir = true;
    int r = 0, c = 0;

    while (i < m*n) {
      output_arr[i] = mat[r][c];

      if (dir) {
        if (c == n-1) {
          r++;
          dir = false;
        } else if(r == 0) { // common mistake if r == 0 is checked before c == n-1
          c++;
          dir = false;
        } else {
          r--;
          c++;
        }
      } else {
        if (r == m-1) {
          c++;
          dir = true;
        } else if (c == 0) {
          r++;
          dir = true;
        } else {
          r++;
          c--;
        }
      }
      i++;
    }

    return output_arr;
  }
}