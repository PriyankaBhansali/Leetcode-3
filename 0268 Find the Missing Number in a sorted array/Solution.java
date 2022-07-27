// https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/

class Solution {
  public int search(int arr[]) {
    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      // If the middle element is not on
      // the middle index, then the missing element is mid + 1.
      if (mid + 1 != arr[mid] && mid == arr[mid - 1]) {
        return mid + 1;
      }

      // The missing element is not to the left. So search the right.
      if (arr[mid] == mid + 1) {
        low = mid + 1;
      } else {  // The missing element is not to the right. So search the left.
        high = mid - 1;
      }
    }
    return -1;
  }
}

public class Test {
  public static void main (String[] args) {
  int arr[] = { 1, 3, 4, 5, 6, 7 };
  Solution obj = new Solution();
  System.out.println("Missing number: " + obj.search(arr));
  }
}


// row 1: index and row 2: elements

// 0 1 2 3 4 5
// 1 3 4 5 6 7

// mid  = 2
// high = 1
// mid  = 0
// low = 1
// mid  = 1
// Missing number: 2

// 0 1
// 1 3

// mid = 0
// low = 1
// mid = 1
// Missing number: 2

// Can be done with some minor modifications as well - refer below

class Solution {
  public int search(int arr[]) {
    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      System.out.println("mid = " + mid);
      if (mid + 1 != arr[mid] && mid == arr[mid - 1]) {
        return mid + 1;
      }
      if (arr[mid] > mid + 1) {
        high = mid;
        System.out.println("high = " + high);
      } else {
         low = mid + 1;
         System.out.println("low = " + low);
        
      }
    }
    return -1;
  }
}

// 0 1 2 3 4 5
// 1 3 4 5 6 7

// mid = 2
// high = 2
// mid = 1
// Missing number: 2

// 0 1
// 1 3

// mid = 0
// low = 1
// mid = 1
// Missing number: 2