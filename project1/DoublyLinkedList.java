public class DoublyLinkedList{
	public ListNode  head;
	private ListNode current;
	public DoublyLinkedList(){
		head=new ListNode();
		head.prev=head;
		head.next=head;
		current=head;
	}
	public DoublyLinkedList(int red,int green,int blue,int length){
		head=new ListNode();
		ListNode first=new ListNode(red,green,blue,length);
		first.toIndex=length;
		head.next=first;
		head.prev=first;
		first.next=head;
		first.prev=head;
		current=first;
	}
	public void insertAfter(int red,int green,int blue,int length){
		ListNode newNode=new ListNode(red,green,blue,length);
		newNode.toIndex=current.toIndex+length;
		current.next=newNode;
		newNode.next=head;
		newNode.prev=current;
		current=newNode;
	}
}