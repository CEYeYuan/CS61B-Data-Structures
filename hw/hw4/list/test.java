package list;
class test{
	public static void main(String[] args){
    DList list=new LockDList();
    System.out.println(list.toString());
    list.insertFront("2");
     System.out.println(list.toString());
    list.insertFront("1");
    System.out.println(list.toString());
    list.insertBack("3");
    System.out.println(list.toString());
     list.insertBack("4");
    System.out.println(list.toString());
    DListNode first=list.front();
    list.insertBefore("0",first);
    System.out.println(list.toString());
    first=list.front();
    list.insertAfter("1.5",first.next);
    System.out.println(list.toString());
    list.remove(first.next.next);
    System.out.println(list.toString());
    first=list.front();
    ((LockDList)list).lockNode(first);
    list.remove(first);
    System.out.println(list.toString());

  }
}