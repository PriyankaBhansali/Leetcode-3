// https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

// Time complexity : O(logT), where T is an index of target value.
// Space complexity : O(1) since it's a constant space solution.

class Solution {
  public int search(ArrayReader reader, int target) {
    if (reader.get(0) == target) {
      return 0;
    }
    int low = 0;
    int high = 1;

    while (reader.get(high) < target) { // <= not needed here eg: in first iteration if 1 < 1 is false so low <= high will take care of it 
      low = high;
      high = high * 2;
    }

    while (low <= high) {
      int mid = (low + high) / 2;
      if (reader.get(mid) == target) {
        return mid;
      }
      if (target < reader.get(mid)) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }
}