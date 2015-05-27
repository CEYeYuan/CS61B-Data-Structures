class X{
	int x=1;
}
class Y extends X{
	int y=2;
}
class other{

  public static void main(String[] args){
    X x=new Y();
    Y y=new Y();
     if (x instanceof X){
      System.out.println("X,test the static type");
    }
    else{
      System.out.println("Y,test the dynamic type");
    }
    
   
    
  	}
}

   
    


