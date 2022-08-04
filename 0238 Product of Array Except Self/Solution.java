// https://leetcode.com/problems/product-of-array-except-self/

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] left_products = new int[n];
    int[] right_products = new int[n];

    int[] output_arr = new int[n];
    left_products[0] = 1;
    right_products[n-1] = 1;

    for (int i = 1; i < n; i++) {
      left_products[i] = left_products[i-1] * nums[i-1];
    }

    for (int i = n-2; i >= 0; i--) {
      right_products[i] = right_products[i+1] * nums[i+1];
    }

    for (int i = 0; i < n; i++) {
      output_arr[i] = left_products[i] * right_products[i];
    }

    return output_arr;
  }
}

// Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;

    int[] output_arr = new int[n];
    output_arr[0] = 1;

    for (int i = 1; i < n; i++) {
      output_arr[i] = output_arr[i-1] * nums[i-1];
    }

    int R = 1;
    for (int i = n-1; i >= 0; i--) {
      output_arr[i] = output_arr[i] * R;
      R = R * nums[i];
    }

    return output_arr;
  }
}