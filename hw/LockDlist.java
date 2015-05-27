package list;
class LockDlist extends DList{
	public void lockNode(DListNode node){
		node=new LockDListNode(node.item,node.prev,node.next);
	}
    public void remove(DListNode node) {
    // Your solution here.
    if (node==null ||size==0||node instanceof LockDListNode){
      return;
    }
    else{
      node.prev.next=node.next;
      node.next.prev=node.prev;
      size--;
    }
  }
}
class LockDListNode extends DListNode{
	LockDListNode(Object i, DListNode p, DListNode n) {
     super(i,p,n);   

  	}
}