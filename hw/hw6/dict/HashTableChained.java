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

public class HashTableChained implements Dictionary {

  /**
   *  Place any data fields here.
   **/

  ListNode[] dict;
  int size;
  int buckets;
  int collision;


  /** 
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime numoer, and shoot for a load factor between 0.5 and 1.)
   **/
  public int numOfCollision(){
    return collision;
  }
  public HashTableChained(int sizeEstimate) {
    // Your solution here.
    buckets=prime(sizeEstimate);
    dict=new ListNode[buckets];
  }

private static int prime(int input){
  	boolean[] arr=new boolean[input+1];
  	for (int i=0;i<arr.length;i++){
  		arr[i]=true;
  	}
  	for (int i=2;i<=Math.sqrt(2*input);i++){
  		for(int j=(input/i)*i;j<=2*input;j+=i){
  			if(j>=input&&j<=2*input){
  				arr[j-input]=false;
  				//System.out.print("Executed");
  			}
  		}
  	}
  	for(int k=0;k<arr.length;k++){
  		if(arr[k]==true){
  			System.out.print(k+input+" ");
  		}
  	}
  	System.out.print('\n');

  	return best(arr,input);
  }

  private static int best(boolean[] input,int offset){
  	int low=input.length/2;
  	int high=input.length/2;
  	for(int i=0;i<=input.length/2;i++){
  		if(input[low])
  			return offset+low;
  		else if(input[high])
  			return offset+high;
  		else{
  			low--;
  			high++;
  		}
  	}
  	return -1;
  }

  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
    // Your solution here.
    buckets=prime(75);
    dict=new ListNode[buckets];
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
  	int result=Math.abs(code*17+191)%prime(10000);
  	result=Math.abs(result)%buckets;
  	return result;
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
    return size==0;
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
    Entry e=new Entry(key,value);
    size++;
    int index=compFunction(key.hashCode());
    if(dict[index]==null){
    	dict[index]=new ListNode(e);
    }else{
      collision++;
    	ListNode node=dict[index];
    	while(node.next!=null){
    		node=node.next;
    	}
    	
    	node.next=new ListNode(e);
    }
    return e;
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
     int index=compFunction(key.hashCode());
    if(dict[index]==null){return null;}
    else{
    	ListNode node=dict[index];
    	while(node!=null){
    		if(node.item.key().equals(key))
    			return node.item;
    		else
    			node=node.next;
    	}
    	return null;
    }
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
    int index=compFunction(key.hashCode());
    if(dict[index]==null){return null;}
    else{
    	ListNode node=dict[index];
    	while(node!=null){
    		if(node.item.key().equals(key)){
    			ListNode current=node;
    			ListNode head=dict[index];
    			while(head.next!=current){
    				head=head.next;
    			}
    			head.next=head.next.next;
    			size--;
    			return current.item;
    		}
    		else
    			node=node.next;
    	}
    	return null;
    }
  }

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    // Your solution here.
    size=0;
    dict=new ListNode[buckets];
  }

}
