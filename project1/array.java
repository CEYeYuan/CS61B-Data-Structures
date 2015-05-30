import java.util.*;
class array{
	public static void main (String [] args){
		int[] a1=new int[]{1,2,3};
		int[] a2=new int[]{1,2,3};
		if (a1==a2)
			System.out.println("array == means .equals()");
		else
			System.out.println("array == means exactly the same object/address");
		if (a1.equals(a2))//doesn't work, same as ==
			System.out.println("we're in the equality of .equals()");
		if (Arrays.equals(a1,a2))//works	
			System.out.println("we're in the equality of .equals()");

	}
}