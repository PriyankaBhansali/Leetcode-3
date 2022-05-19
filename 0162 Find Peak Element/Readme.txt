For solution 2:
When middle element is greater than middle + 1 th element then we are in descending part of the array. 
Hence, we need to search in the left side of the array INCLUDING the middle element because 
it can be the peak element. So here end = mid.

When middle element is smaller than middle + 1 th element then we are in ascending part of the array. 
Hence, we need to search in the right side of the array and middle element is NOT required because 
it is already the smaller element. So here start = mid + 1.

Loop Breaking condition- When both start and end will point to the same index. 
And this will be the peak element. So that's why :- while(start < end)

Since START AND END WILL POINT TO SAME ELEMENT AT THE END, that is the peak element so we are returning start.