// https://leetcode.com/problems/design-hashset/

// Solution 1 - mostly not a preferred one
class MyHashSet {
  // initialise the array - ** outside the constructor
  boolean hashset;
  public MyHashSet() {
    hashset = new boolean[1000001];
  }
  
  public void add(int key) {
    hashset[key] = true;
  }
  
  public void remove(int key) {
    hashset[key] = false;
  }
  
  public boolean contains(int key) {
    return hashset[key];
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

// Solution 2 - preferred one

/*
Create a fixed set of "buckets"
Map the range of inputs to these buckets
To handle collisions, use a List for each bucket

Space and time complexity - depends on the "table size", load factor and rehashing
*/
class MyHashSet {
  private final int MAX_VALUE = 1000000;
  private final int ARRAY_SIZE = 100;
  private List<List<Integer>> parentList; // to create a hashset

  public MyHashSet() {
    // the arrayList is going to be initialized with array size - forcing it to b 100 elements
    parentList = new ArrayList<>(ARRAY_SIZE);
    // each element in the parent list is a linked list but we will not initialize it right away but will make them as null
    for (int i = 0; i < ARRAY_SIZE; i++) {
      parentList.add(null);
    }
  }
  
  public void add(int key) {
    /* map it to one bucket in my parentList
    get the childlist - basically see what is the list in that bucket - is it an empty list or does it already have a linked list
    if no one has been there before for that bucket so we need to initialise a new linkedList, add the key to the list - first element in the list
    Now set it to that bucket - the index that we mapped is going to contain the newly added list
    else
    we need to check first if the child linkedList already containts the element that we are trying to add since we don't want to add duplicate elements in a SET
    add if the key isn't present - if key is present don't do anything (we are not inserting duplicates)

    remove the key from the linkedList and not the location.. suppose the key is 5, we don't want to remove the 5th place element
    but remove the Integer Object with the value 5 so we use "remove(Integer.valueOf(key))" and not remove(key)
    */
    int index = key % ARRAY_SIZE;
    List<Integer> childList = parentList.get(index);

    if (childList == null) {
      List<Integer> list = new LinkedList<>();
      list.add(key); 

      parentList.set(index, list);
    } else {
      if (!childList.contains(key))
      childList.add(key);
    }
  }
  
  public void remove(int key) {
    int index = key % ARRAY_SIZE;
    List<Integer> childList = parentList.get(index);
    if (childList != null) {
      childList.remove(Integer.valueOf(key));
    }
  }
  
  public boolean contains(int key) {
    int index = key % ARRAY_SIZE;
    List<Integer> childList = parentList.get(index);
    if (childList != null) {
      return childList.contains(key);
    }
    return false;
  }
}