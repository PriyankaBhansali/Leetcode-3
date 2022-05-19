// https://leetcode.com/problems/find-peak-element/

// Time complexity:- O(LogN)
// Space complexity : O(1)

class Solution {
  public int findPeakElement(int[] nums) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      // check mid > left AND mid > right
      if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
        return mid;
      }
      if (nums[mid - 1] > nums[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1; 
      }
    }
    return -1;
  }
}

// While the above solution works, it will give runtime error when input is a single element
// To prevent that we need to have a check for "mid" value. Below is the code that will not
// throw runtime errors

class Solution {
  public int findPeakElement(int[] nums) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      // check mid == 0 *ORRR mid > left   *AND   mid == length - 1 *ORRR mid > right
      //        ^                                  ^  
      //   its not nums[mid]                      its not nums[mid]
      if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
        return mid;
      }
      // check mid > 0 *AND left > mid
      if (mid > 0 && nums[mid - 1] > nums[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1; 
      }
    }
    return -1;
  }
}

// Below is another way of doing it - solution 2
class Solution {
  public int findPeakElement(int[] nums) {
    int low = 0
    int high = nums.length - 1;

    while(low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] > nums[mid + 1]) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}

// Input: nums = [1,2,1,3,5,6,4]
// Output: 5
// Explanation: Your function can return either index number 1 where the peak element is 2, 
// or index number 5 where the peak element is 6.

// In a sorted array, last element is the greatest/peak element

// 40 33 24 15 20 12 60
// Output can be = 40 or 20 or 60

// 10 10 10 10
// Output = 10