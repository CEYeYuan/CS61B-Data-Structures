package list;
class LockDList extends DList{

	public void lockNode(DListNode node) { 
		((LockDListNode)node).isLocked=true;
	 }
	protected DListNode newNode(Object item, DListNode prev, DListNode next) {
    	return new LockDListNode(item, prev, next);
 	}
 	public void remove(DListNode node) {
    // Your solution here.
    if(((LockDListNode)node).isLocked)
      return;
  	else
  		super.remove(node);
  	}
}