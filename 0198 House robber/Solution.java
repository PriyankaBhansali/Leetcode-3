// https://leetcode.com/problems/house-robber/solution/




https://www.youtube.com/watch?v=pchOMyPbp0I
+ screenshot in downloads - in readme file


// Approach 1: Recursion with Memoization
// Time Complexity: O(N) 
// Space Complexity: O(N) 
class Solution {
  public int rob(int[] nums) {
    return robFrom(nums, 0);
  }

  private int robFrom(int[] wealth, int currentIndex) {
    if (currentIndex >= wealth.length) {
      return 0;
    }
    int stealCurrent = wealth[currentIndex] + robFrom(wealth, currentIndex + 2);
    int skipCurrent = robFrom(wealth, currentIndex + 1);

    return Math.max(stealCurrent, skipCurrent);
  }
}

// The above code runs fine but it exceeds time limit so memoization is used to fix and optimize this as below
class Solution {
  private Integer dp[];

  public int rob(int[] nums) {
    dp = new Integer [nums.length];
    return robFrom(nums, 0);
  }

  private int robFrom(int[] wealth, int currentIndex) {
    if (currentIndex >= wealth.length) {
      return 0;
    }

    if (dp[currentIndex] != null) { // *Integer dp[]* is required for this comparison - will not work if dp[] is initialized as *int dp[]*
      return dp[currentIndex];
    }

    int stealCurrent = wealth[currentIndex] + robFrom(wealth, currentIndex + 2);
    int skipCurrent = robFrom(wealth, currentIndex + 1);

    return dp[currentIndex] = Math.max(stealCurrent, skipCurrent);
  }
}


// Approach 2: Dynamic Programming

// The recursive approach may run into trouble when the recursion stack grows too large. It may also run into trouble because, 
// for each recursive call, the compiler must do additional work to maintain the call stack (function variables, etc.) which 
// results in unwanted overhead. The dynamic programming approach is simply a tabular formulation of the ideas presented above.

// Time Complexity: O(N) since we have a loop from N - 2 ⋯ 0 and we simply use the pre-calculated values of our 
// dynamic programming table for calculating the current value in the table which is a constant time operation.

// Space Complexity: O(N) which is used by the table. So what is the real advantage of this solution over the 
// previous solution(Recursion with Memoization)? In this case, we dont have a recursion stack. When the number of houses is large, 
// a recursion stack can become a serious limitation, because the recursion stack size will be huge and 
// the compiler will eventually run into stack-overflow problems (no pun intended!).

class Solution {
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int dp[] = new int [nums.length + 1];
    dp[0] = 0;
    dp[1] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
    }
    return dp[nums.length];

  }
}

// ...same as above .. slight modification
class Solution {
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    if (nums.length == 1) {
      return nums[0];
    }

    int dp[] = new int [nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[nums.length - 1];

  }
}

// Approach 3: Optimized Dynamic Programming - Greedy Approach explained by https://www.youtube.com/watch?v=VT4bZV24QNo

// Time Complexity: O(N) since we have a loop from N - 2 ⋯ 0 and we use the precalculated values of our dynamic 
// programming table to calculate the current value in the table which is a constant time operation.

// Space Complexity: O(1) since we are not using a table to store our values. Simply using two variables will 
// suffice for our calculations.

class Solution {
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    // let the first nums element be currently chosen so notChosen's current value will be 0
    int chosen = nums[0];
    int notChosen = 0;

    for (int i = 0; i < nums.length; i++) {
      int nextChosen = notChosen + nums[i];
      int nextNotChosen = Math.max(chosen, notChosen);
      
      chosen = nextChosen;
      notChosen = nextNotChosen;
    }

    return Math.max(chosen, notChosen);
  }
}