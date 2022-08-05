// https://leetcode.com/problems/two-sum/

// Time complexity: O(n)
// Space complexity: O(n)

// Solution 1: One-pass Hash Table
class Solution {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap();

    for (int i = 0; i < nums.length; i++) {
      int temp = target - nums[i];
      if (map.containsKey(temp)) {
        return new int[] { map.get(temp), i };
      }
      map.put(nums[i], i);
    }
    return null;
  }
}

// Solution 2: Two-pass Hash Table
class Solution {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap();

    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      int temp = target - nums[i];
      if (map.containsKey(temp) && map.get(temp) != i) {
        return new int[] { map.get(temp), i };
      }
    }
    return null;
  }
}