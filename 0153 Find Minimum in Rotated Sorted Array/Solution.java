class Solution {
  public int findMin(int[] nums) {
    int low = 0;
    int high = nums.length - 1;

    while (low < high) { // ** <= runtime error out of bounds
      if (nums[low] < nums[high]) { // array is already sorted if nums[low] < nums[high]
        return nums[low];
      }
      int mid = low + (high - low) / 2;
      // check if mid value is less than right and left values 
      // also check mid == 0 and not mid > 0 --> to consider index 0 
      
      // check mid == 0     and      mid == length - 1
      //        ^                     ^  
      //  its not nums[mid]           its not nums[mid]
      if ((mid == 0 || nums[mid] < nums[mid - 1]) && (nums[mid] == nums.length - 1 || nums[mid] < nums[mid + 1])) {
        return nums[mid];
      }
      if (nums[low] <= nums[mid]) { // ** <= and not only <  .... or check nums[mid] < nums[high] with low/high reversed
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return nums[low];
  }
}
