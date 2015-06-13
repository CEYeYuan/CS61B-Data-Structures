package dict;
public class ListNode{
	public  Entry item;
	ListNode next;
	public ListNode(Object key,Object value){
		item=new Entry(key,value);
	}
	public ListNode(Entry e){
		item=e;
	}
}