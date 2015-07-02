/* ListSorts.java */

import list.*;

public class ListSorts {

  private final static int SORTSIZE = 1000000;

  /**
   *  makeQueueOfQueues() makes a queue of queues, each containing one item
   *  of q.  Upon completion of this method, q is empty.
   *  @param q is a LinkedQueue of objects.
   *  @return a LinkedQueue containing LinkedQueue objects, each of which
   *    contains one object from q.
   **/
  public static LinkedQueue makeQueueOfQueues(LinkedQueue q) {
    // Replace the following line with your solution.
    LinkedQueue result=new LinkedQueue();
    try{
    	 while(q.size()!=0){	
    	 	LinkedQueue queue=new LinkedQueue();
    	 	queue.enqueue(q.dequeue());
    		result.enqueue(queue);
   		 }
    }catch (QueueEmptyException e){
    	e.printStackTrace();
    } 
    return result;
  }

  /**
   *  mergeSortedQueues() merges two sorted queues into a third.  On completion
   *  of this method, q1 and q2 are empty, and their items have been merged
   *  into the returned queue.
   *  @param q1 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @param q2 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @return a LinkedQueue containing all the Comparable objects from q1 
   *   and q2 (and nothing else), sorted from smallest to largest.
   **/
  public static LinkedQueue mergeSortedQueues(LinkedQueue q1, LinkedQueue q2) {
    // Replace the following line with your solution.
    LinkedQueue result=new LinkedQueue();
   
    while(true){
    	if(q1.size()==0&&q2.size()==0){
    		break;
    	}else if(q1.size()==0){
    		result.append(q2);
    		break;
    	}else if(q2.size()==0){
    		result.append(q1);
    		break;
    	}else{
    		 try{
    		 	while(q1.size()!=0&&q2.size()!=0){
   			 	 if(((Comparable) q1.front()).compareTo(q2.front())<=0){
   			 	 	result.enqueue(q1.dequeue());
   				 }else {
   				 	result.enqueue(q2.dequeue());
   				 }
   				 }
    		 }catch(QueueEmptyException e){
    		 	e.printStackTrace();
    		 }	 
    	}

    }
    return result;
  }

  /**
   *  partition() partitions qIn using the pivot item.  On completion of
   *  this method, qIn is empty, and its items have been moved to qSmall,
   *  qEquals, and qLarge, according to their relationship to the pivot.
   *  @param qIn is a LinkedQueue of Comparable objects.
   *  @param pivot is a Comparable item used for partitioning.
   *  @param qSmall is a LinkedQueue, in which all items less than pivot
   *    will be enqueued.
   *  @param qEquals is a LinkedQueue, in which all items equal to the pivot
   *    will be enqueued.
   *  @param qLarge is a LinkedQueue, in which all items greater than pivot
   *    will be enqueued.  
   **/   
  public static void partition(LinkedQueue qIn, Comparable pivot, 
                               LinkedQueue qSmall, LinkedQueue qEquals, 
                               LinkedQueue qLarge) {
    // Your solution here.
    try{
	    	while(qIn.size()!=0){
	    	Object buffer=qIn.dequeue();
	    	if(pivot.compareTo(buffer)>0){
	    		qSmall.enqueue(buffer);
	    	}else if(pivot.compareTo(buffer)==0){
	    		qEquals.enqueue(buffer);
	    	}else{
	    		qLarge.enqueue(buffer);
    	}
 	   }
    }catch (QueueEmptyException e){
    	e.printStackTrace();
    }
 
  }

  /**
   *  mergeSort() sorts q from smallest to largest using mergesort.
   *  @param q is a LinkedQueue of Comparable objects.
   **/
  public static void mergeSort(LinkedQueue q) {
    // Your solution here.
    if(q.size()==0||q.size()==1)
    	return;
    else{	
    	  try{
		    	  LinkedQueue result=makeQueueOfQueues(q);
			  	  while(result.size()>1){
			    	LinkedQueue buffer1=(LinkedQueue)result.dequeue();
			    	LinkedQueue buffer2=(LinkedQueue)result.dequeue();
			    	result.enqueue(mergeSortedQueues(buffer1,buffer2));
			   	 }
			   	 q.append((LinkedQueue)result.dequeue());
    	  }catch(Exception e){
    	  	e.printStackTrace();
    	  }
    	 
	   	 return;
    }
   
  }

  /**
   *  quickSort() sorts q from smallest to largest using quicksort.
   *  @param q is a LinkedQueue of Comparable objects.
   **/
  public static void quickSort(LinkedQueue q) {
    // Your solution here.
    LinkedQueue small=new LinkedQueue();
    LinkedQueue equal=new LinkedQueue();
    LinkedQueue great=new LinkedQueue();
    if(q.size()==1||q.size()==0)
    	return;
    Object pivot=q.nth((int)(q.size()*Math.random()-1));
    partition(q, (Comparable)pivot,small,equal,great);
    quickSort(small);
    quickSort(great);
    q.append(small);
    q.append(equal);
    q.append(great);
    return ;
  }

  /**
   *  makeRandom() builds a LinkedQueue of the indicated size containing
   *  Integer items.  The items are randomly chosen between 0 and size - 1.
   *  @param size is the size of the resulting LinkedQueue.
   **/
  public static LinkedQueue makeRandom(int size) {
    LinkedQueue q = new LinkedQueue();
    for (int i = 0; i < size; i++) {
      q.enqueue(new Integer((int) (size * Math.random())));
    }
    return q;
  }

  /**
   *  main() performs some tests on mergesort and quicksort.  Feel free to add
   *  more tests of your own to make sure your algorithms works on boundary
   *  cases.  Your test code will not be graded.
   **/
  public static void main(String [] args) {

    LinkedQueue q = makeRandom(1);
    System.out.println(q.toString());

    mergeSort(q);
    System.out.println(q.toString());

    q = makeRandom(1);
    System.out.println(q.toString());
    quickSort(q);
    System.out.println(q.toString());

    // Remove these comments for Part III.
    Timer stopWatch = new Timer();
    q = makeRandom(SORTSIZE);
    stopWatch.start();
    mergeSort(q);
    stopWatch.stop();
    System.out.println("Mergesort time, " + SORTSIZE + " Integers:  " +
                       stopWatch.elapsed() + " msec.");

    stopWatch.reset();
    q = makeRandom(SORTSIZE);
    stopWatch.start();
    quickSort(q);
    stopWatch.stop();
    System.out.println("Quicksort time, " + SORTSIZE + " Integers:  " +
                       stopWatch.elapsed() + " msec.");
    //
  }

}