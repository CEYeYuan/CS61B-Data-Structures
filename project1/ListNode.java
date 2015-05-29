public class ListNode{
	public int color[];
	public int length;
	public int toIndex;
	//toIndex means after the current node, how much pixel have we already covered
	public ListNode next;
	public ListNode prev;
	public ListNode(){
	//only used for construct a head !!! Also, every field is set to 0
		this(-1,-1,-1,0);
	}
	public ListNode(int red,int green,int blue,int length){
		color=new int[3];
		color[0]=red;
		color[1]=green;
		color[2]=blue;
		this.length=length;
	}
}