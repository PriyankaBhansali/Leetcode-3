// https://leetcode.com/problems/minimum-falling-path-sum/

// Using DP
class Solution {
  public int minFallingPathSum(int[][] matrix) {
    int row = matrix.length;
    int column = matrix[0].length;
    int dp[][] = new int [row][column];

    for (int i = 0; i < column; i++) {
      dp[0][i] = matrix[0][i];
    }

    for (int i = 1; i < row; i++) {
      for (int j = 0; j < column; j++) {
        if (j == 0) {
          dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
        } else if (j == column - 1) {
          dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
        } else {
          dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i-1][j+1]);
        }
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < column; i++) {
      min = Math.min(min, dp[column-1][i]);
    }
    return min;
  }
}

// Using Recursion

// Can be solved using recursion but not preferred. Problem: we keep solving redundant problems in recursion and can 
// be memoised(optimised) by using a HashMap or DP - they cache the values so it can be reused without calculating again and again.
class Solution {
  public int minFallingPathSum(int[][] matrix) {
    int r = matrix.length;
    int c = matrix[0].length;
    int min = Integer.MAX_VALUE;
    
    for (int i = 0; i < c; i++) {
      min = Math.min(min, rec(0, i, matrix));
    }
    return min;
  }

  private static int rec(int i, int j, int arr[][]) {
    int r = arr.length;
    int c = arr[0].length;
    // 2 base cases:
    // 1st one: when row gets greater than the rows in matrix
    // 2nd one: when column goes more left or more right than the columns in matrix
    if (i == r) {
      return 0;
    }
    if (j < 0 || j >= c) {
      return Integer.MAX_VALUE;
    }
    int op1 =  rec(i+1, j-1, arr);
    int op2 =  rec(i+1, j,   arr);  
    int op3 =  rec(i+1, j+1, arr);

    return arr[i][j] + Math.min(op1, Math.min(op2, op3));
  }
}

// Using HashMap - above code to be slightly modified
class Solution {
  public int minFallingPathSum(int[][] matrix) {
    int r = matrix.length;
    int c = matrix[0].length;
    int min = Integer.MAX_VALUE;

    HashMap<String, Integer> map = new HashMap();
    
    for (int i = 0; i < c; i++) {
      min = Math.min(min, rec(0, i, matrix, map));
    }
    return min;
  }

  private static int rec(int i, int j, int arr[][], HashMap<String, Integer> map) {
    int r = arr.length;
    int c = arr[0].length;
    // 2 base cases:
    // 1st one: when row gets greater than the rows in matrix
    // 2nd one: when column goes more left or more right than the columns in matrix
    if (i == r) {
      return 0;
    }
    if (j < 0 || j >= c) {
      return Integer.MAX_VALUE;
    }

    String key = i + "some_nonempty_string" + j;
    if (map.containsKey(key)) { // if key already present return it else save it before return
      return map.get(key);
    }

    int op1 =  rec(i+1, j-1, arr, map);
    int op2 =  rec(i+1, j,   arr, map);  
    int op3 =  rec(i+1, j+1, arr, map);

    map.put(key, arr[i][j] + Math.min(op1, Math.min(op2, op3))); // saving here before return

    return arr[i][j] + Math.min(op1, Math.min(op2, op3));
  }
} 