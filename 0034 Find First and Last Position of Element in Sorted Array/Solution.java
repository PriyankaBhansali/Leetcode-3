// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// Time Complexity: log(n) 
// Space: O(1)

class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] result = new int[2];
    result[0] = findStartingIndex(nums, target);
    result[1] = findEndingIndex(nums, target);
    return result;
  }

  public int findStartingIndex(int []nums, int target) {
    int index = -1; // return -1 if not found
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] >= target) { // ">=" because we want to keep looking for duplicates too on LEFT side
        high = mid - 1;
      } else {
        low = mid + 1;
      }
      if (nums[mid] == target) {
        index = mid;
      }
    }
    return index;
  }

  public int findEndingIndex(int []nums, int target) {
    int index = -1; // return -1 if not found
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] <= target) { // "<=" because we want to keep looking for duplicates too on RIGHT side
        low = mid + 1;
      } else {
        high = mid - 1;
      }
      if (nums[mid] == target) {
        index = mid;
      }
    }
    return index;
  }
}

// 3 4  5 5  5 5 5 6 6