package list;
class LockDListNode extends DListNode{
	boolean isLocked;
	public LockDListNode(Object i, DListNode p, DListNode n){
		super(i,p,n);
		isLocked=false;
	}
}