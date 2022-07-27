// https://www.geeksforgeeks.org/find-the-missing-number/
// https://leetcode.com/problems/missing-number/

// https://www.youtube.com/watch?v=6KHW7ZQwtCA - why we use XOR here (since there will be no overflow and extra space)

class Solution {
  public int missingNumber(int[] nums) {
    int missing = nums.length;
    for (int i = 0; i < nums.length; i++) {
        missing ^= i ^ nums[i];
    }
    return missing;
  }
}


// containing numbers in range of 0 to 6 so 7 numbers in all of which 1 is missing
// so you have 7 numbers say --> nums[i] = 6, 4, 2, 3, 7, 0, 1
// nums.length = 7
// index - 0 1 2 3 4 5 6

// XOR nums[i] and i  ALONG with nums.length
// 7  ^  6 ^ 4 ^ 2 ^ 3 ^ 7 ^ 0 ^ 1   ^  0 ^ 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 

// XOR of same value is 0 so remaining value will be 5

//Method 2:
// XOR all the array elements, let the result of XOR be X1 - 6, 4, 2, 3, 7, 0, 1
// XOR all the numbers from 0 to n - including 7 (or 1 to n + 1), let XOR be X2 - 0 1 2 3 4 5 6 7 (1 2 3 4 5 6 7 8 for 1 to n + 1)
// XOR of X1 and X2 gives the missing number