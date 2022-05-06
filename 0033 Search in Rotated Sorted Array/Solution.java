// https://leetcode.com/problems/search-in-rotated-sorted-array/

// Time complexity: O(logN)
// Space complexity: O(1)

class Solution {
  public int search(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    }
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      // if left array is sorted
      if (nums[low] <= nums[mid]) { // *** <= and not only < ; applies for all below cases
        if (nums[low] <= target && nums[mid] >= target) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else { // right array is sorted
        if (nums[mid] <= target && nums[high] >= target) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }
    return -1;
  }
}

// Recursive
class Solution {
  public int search(int[] nums, int target) {
    return binarySearch(nums, 0, nums.length - 1, target);
  }

  public int binarySearch(int[] nums, int low, int high, int target) {
    if (low > high) {
      return -1;
    }
    int mid = (low + high) / 2;
    if (nums[mid] == target) {
      return mid;
    }

    if (nums[low] <= nums[mid]) { // if left array is sorted
      if (nums[low] <= target && nums[mid] >= target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    } else { // right array is sorted
      if (nums[mid] <= target && nums[high] >= target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return binarySearch(nums, low, high, target);

  }
}