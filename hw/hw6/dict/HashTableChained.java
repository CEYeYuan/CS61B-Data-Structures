/* HashTableChained.java */

package dict;

/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/


class ListNode extends Entry{
  ListNode next;
  ListNode prev;
  ListNode(){
    key=null;
    value=null;
    next=null;
    prev=null;
  }
  ListNode(Object k,Object v){
    key=k;
    value=v;
    next=null;
    prev=null;
  }
  ListNode insertNode(Object k,Object v){
     ListNode node=next;
      while(node!=null){
        node=node.next;
      }
     
      node.next=new ListNode(k,v);
      node.next.prev=this;
      return node.next;

    
  }
}

public class HashTableChained implements Dictionary {

  /**
   *  Place any data fields here.
   **/
     ListNode [] hashtable;
     int size;



  /** 
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/

  public boolean isPrime(int i){
    if (i<2){
      return false;
    }
    else{
      for (int j=2;j<=i/2;j++){
        if (i%j==0){
          return false;
        }
      }
    return true;
    }
  }

  public HashTableChained(int sizeEstimate) {
    // Your solution here.
    int min,max,sizeUsed;
    min=sizeEstimate;
    max=2*sizeEstimate;
    sizeUsed=sizeEstimate;
    for (int i=min;i<=max;i++){
      if (isPrime(i)){
        sizeUsed=i;
        break;
      }
    }
    hashtable=new ListNode [sizeUsed];
    size=sizeUsed;
  }

  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
    // Your solution here.
    hashtable=new ListNode[101];
    size=101;
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
    // Replace the following line with your solution.
    return (code-Integer.MIN_VALUE)*(Integer.MAX_VALUE-Integer.MIN_VALUE)*(size-1);
  }

  /** 
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    // Replace the following line with your solution.
    return size;
  }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    // Replace the following line with your solution.
    return (size<=0);
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  public Entry insert(Object key, Object value) {
    // Replace the following line with your solution.
    if (hashtable[compFunction(key.hashCode())]==null){
      hashtable[compFunction(key.hashCode())].key=key;
      hashtable[compFunction(key.hashCode())].value=value;
      hashtable[compFunction(key.hashCode())].next=null;
      hashtable[compFunction(key.hashCode())].prev=null;
      return hashtable[compFunction(key.hashCode())];
    }
    else{
      ListNode node=hashtable[compFunction(key.hashCode())].insertNode(key,value);
      return node;
    }
    size++;
  }

  /** 
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  public Entry find(Object key) {
    // Replace the following line with your solution.
    ListNode node=hashtable[compFunction(key.hashCode())];
    while(node!=null){
      if (node.key==key){
        return node;
      }
      node=node.next;
    }
    return null;
  }

  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    // Replace the following line with your solution.
     ListNode node=find(key);
     if (node==null){
      return;
     }
     else{
      ListNode node=hashtable[compFunction(key.hashCode())];


     }
  }

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    // Your solution here.
  }

}
