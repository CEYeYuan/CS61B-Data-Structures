class X{
	public static final int cons=6;
}
interface Y{
	public static final int cons=6;
	
}
class Z extends X implements Y{
	public static void main(String[] args){
	int x=X.cons;
	System.out.print("x="+": "+x);
}
}