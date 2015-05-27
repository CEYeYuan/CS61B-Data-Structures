class X{
	static int x=6;
	public static int returnsame(){
		return 6;
	}
}
class Y extends X{
	public static int returnsame(){
		return 12;
	}

}
class other{
	
	public static void main(String[] args){
		Y y=new Y();
		X x=new X();
		int out=X.x;
        System.out.println(out);


	}
}