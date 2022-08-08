// https://leetcode.com/problems/unique-paths-ii/

// Time complexity: O(m.n)
// Space complexity: O(m.n)

class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];

    // fill first column
    boolean flag = false;
    for (int i = 0; i < m; i++) {
      if (flag || obstacleGrid[i][0] == 1) {
        dp[i][0] = 0;
        flag = true;
      } else {
        dp[i][0] = 1;
      }
    }

    // fill first row
    flag = false;
    for (int i = 0; i < n; i++) {
      if (flag || obstacleGrid[0][i] == 1) {
        dp[0][i] = 0;
        flag = true;
      } else {
        dp[0][i] = 1;
      }
    }

    // since first row and column are already filled, we can start with 2nd row and 2nd column
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (obstacleGrid[i][j] == 1) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
      }
    }

    return dp[m-1][n-1];
  }
}

// Time complexity: O(m.n)
// Space complexity: O(1) since we use same obstacleGrid as our dp array

class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;

    if (obstacleGrid[0][0] == 1) { // necessary here
      return 0;
    }

    // fill first column
    boolean flag = false;
    for (int i = 0; i < m; i++) {
      if (flag || obstacleGrid[i][0] == 1) {
        obstacleGrid[i][0] = 0;
        flag = true;
      } else {
        obstacleGrid[i][0] = 1;
      }
    }

    // fill first row
    flag = false;
    for (int i = 1; i < n; i++) { // start filling with i = 1 and not i = 0
      if (flag || obstacleGrid[0][i] == 1) {
        obstacleGrid[0][i] = 0;
        flag = true;
      } else {
        obstacleGrid[0][i] = 1;
      }
    }

    // since first row and column are already filled, we can start with 2nd row and 2nd column
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (obstacleGrid[i][j] == 1) {
          obstacleGrid[i][j] = 0;
        } else {
          obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
        }
      }
    }

    return obstacleGrid[m-1][n-1];
  }
}