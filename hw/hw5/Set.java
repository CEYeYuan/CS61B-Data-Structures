/* Set.java */

import list.*;
//import java.util.*;

/**
 *  A Set is a collection of Comparable elements stored in sorted order.
 *  Duplicate elements are not permitted in a Set.
 **/
public class Set {
  /* Fill in the data fields here. */
  List set;

  /**
   * Set ADT invariants:
   *  1)  The Set's elements must be precisely the elements of the List.
   *  2)  The List must always contain Comparable elements, and those elements 
   *      must always be sorted in ascending order.
   *  3)  No two elements in the List may be equal according to compareTo().
   **/

  /**
   *  Constructs an empty Set. 
   *
   *  Performance:  runs in O(1) time.
   **/
  public Set() { 
    // Your solution here.
    set=new DList();
  }

  /**
   *  cardinality() returns the number of elements in this Set.
   *
   *  Performance:  runs in O(1) time.
   **/
  public int cardinality() {
    // Replace the following line with your solution.
    return set.length();
  }

  /**
   *  insert() inserts a Comparable element into this Set.
   *
   *  Sets are maintained in sorted order.  The ordering is specified by the
   *  compareTo() method of the java.lang.Comparable interface.
   *
   *  Performance:  runs in O(this.cardinality()) time.
   **/
  public void insert(Comparable c) {
    // Your solution here.
    try{
    	if (set.length()==0){
    		set.insertFront(c);
        return ;
      }
      boolean inserted=false;
    	ListNode head=set.front(); 
    	while(true){
    		if (c.compareTo(head.item())==0)
    			return;
    		else if(c.compareTo(head.item())>0){
          if(head.next().isValidNode())
    			 head=head.next();
          else
            break;
        }
   		 	else{
    			head.insertBefore(c);
          inserted=true;
    			return;
    		}
    	}
      if(!inserted){
        head.insertAfter(c);
      }
    }catch(InvalidNodeException i){
    	i.printStackTrace();
    }
    
  }

  /**
   *  union() modifies this Set so that it contains all the elements it
   *  started with, plus all the elements of s.  The Set s is NOT modified.
   *  Make sure that duplicate elements are not created.
   *
   *  Performance:  Must run in O(this.cardinality() + s.cardinality()) time.
   *
   *  Your implementation should NOT copy elements of s or "this", though it
   *  will copy _references_ to the elements of s.  Your implementation will
   *  create new _nodes_ for the elements of s that are added to "this", but
   *  you should reuse the nodes that are already part of "this".
   *
   *  DO NOT MODIFY THE SET s.
   *  DO NOT ATTEMPT TO COPY ELEMENTS; just copy _references_ to them.
   **/
  public void union(Set s) {
    // Your solution here.
    ListNode a=set.front();
    ListNode b=s.set.front();
    try{
      while(a.next().isValidNode()&&(b.next().isValidNode())){
     
          if(((Comparable)a.item()).compareTo(b.item())<0&&((Comparable)a.next().item()).compareTo(b.item())<0){
            a=a.next();
          }
         else if(((Comparable)a.item()).compareTo(b.item())<0&&((Comparable)a.next().item()).compareTo(b.item())>0){
            a.insertAfter(b.item());
            b=b.next();
            a=a.next();
          }
          else if(((Comparable)a.item()).compareTo(b.item())<0&&((Comparable)a.next().item()).compareTo(b.item())==0){
            b=b.next();
            a=a.next();
          }else{
            if(((Comparable)a.item()).compareTo(b.item())==0){
               b=b.next();
                a=a.next();
            }else{
              a.insertBefore(b.item());
              b=b.next();
            }
          }
      }
      
      if(!a.next().isValidNode()){
        while(b.isValidNode()&&((Comparable)a.item()).compareTo(b.item())<0){
          a.insertAfter(b.item());
          b=b.next();
          a=a.next();
        }
      }

    }
    catch (InvalidNodeException invalid){
      invalid.printStackTrace();
    }
  }

  /**
   *  intersect() modifies this Set so that it contains the intersection of
   *  its own elements and the elements of s.  The Set s is NOT modified.
   *
   *  Performance:  Must run in O(this.cardinality() + s.cardinality()) time.
   *
   *  Do not construct any new ListNodes during the execution of intersect.
   *  Reuse the nodes of "this" that will be in the intersection.
   *
   *  DO NOT MODIFY THE SET s.
   *  DO NOT CONSTRUCT ANY NEW NODES.
   *  DO NOT ATTEMPT TO COPY ELEMENTS.
   **/
  public void intersect(Set s) {
    // Your solution here.
    ListNode a=set.front();
    ListNode b=s.set.front();
    ListNode current;
    try{
      while(a.isValidNode()){
        if(b.isValidNode()){
          if(((Comparable)a.item()).compareTo(b.item())>0){
            b=b.next();
          }else{
            if(((Comparable)a.item()).compareTo(b.item())==0){
            b=b.next();
            a=a.next();
            }else{
              current=a.next();
              a.remove();
              a=current;  
            }
          }
        }else{
          current=a.next();
          a.remove();
          a=current;
        }
      }

    }catch (InvalidNodeException i){
      i.printStackTrace();
    }
  }

  /**
   *  toString() returns a String representation of this Set.  The String must
   *  have the following format:
   *    {  } for an empty Set.  No spaces before "{" or after "}"; two spaces
   *            between them.
   *    {  1  2  3  } for a Set of three Integer elements.  No spaces before
   *            "{" or after "}"; two spaces before and after each element.
   *            Elements are printed with their own toString method, whatever
   *            that may be.  The elements must appear in sorted order, from
   *            lowest to highest according to the compareTo() method.
   *
   *  WARNING:  THE AUTOGRADER EXPECTS YOU TO PRINT SETS IN _EXACTLY_ THIS
   *            FORMAT, RIGHT UP TO THE TWO SPACES BETWEEN ELEMENTS.  ANY
   *            DEVIATIONS WILL LOSE POINTS.
   **/
  public String toString() {
    // Replace the following line with your solution.
    ListNode head=set.front();
    String s="[";
    try{
      while(head.isValidNode()){
      s=s+head.item()+" ";
      head=head.next();
      }
      s=s+"]";  
    }catch(InvalidNodeException i){
      i.printStackTrace();
    }
    
    return s;
  }

  public static void main(String[] argv) {
    Set s = new Set();
    s.insert(new Integer(3));
    s.insert(new Integer(4));
    s.insert(new Integer(3));
    s.insert(new Integer(5));
    s.insert(new Integer(10));
    System.out.println("Set s = " + s);
    System.out.println("s.cardinality() = " + s.cardinality());

    Set s2 = new Set();
    s2.insert(new Integer(1));
    s2.insert(new Integer(2));
    s2.insert(new Integer(5));
    s2.insert(new Integer(6));
    s2.insert(new Integer(7));
    s2.insert(new Integer(10));
    s2.insert(new Integer(12));
    System.out.println("Set s2 = " + s2);
    System.out.println("s2.cardinality() = " + s2.cardinality());

    Set s3 = new Set();
    s3.insert(new Integer(5));
    s3.insert(new Integer(3));
    s3.insert(new Integer(8));
    System.out.println("Set s3 = " + s3);
    System.out.println("s.cardinality() = " + s3.cardinality());

    s.union(s2);
    System.out.println("After s.union(s2), s = " + s);

    s.intersect(s3);
    System.out.println("After s.intersect(s3), s = " + s);

    System.out.println("s.cardinality() = " + s.cardinality());
    // You may want to add more (ungraded) test code here.
  }
}
