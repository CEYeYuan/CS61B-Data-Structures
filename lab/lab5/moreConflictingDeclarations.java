/*More Conflicting Declarations (1 point)
--------------------------------------------------
Suppose a subclass inherits a "public static final" constant from a superclass,
and implements a Java interface that contains a "public static final" constant
with the same name.

(a)  Will Java compile the result?  Does it make any difference whether the
     constant in the superclass and the constant in the interface have the
     same value?
     it always gets compiled
(b)  Write a main() method in the subclass that accesses the constant using the
     same name used in the superclass and the Java interface.  Will Java
     compile the result?  Does it make any difference whether the constant in
     the superclass and the constant in the interface have the same value?
	
	 No
     reference to Jan is ambiguous, both variable Jan in parent_class and variable 
     Jan in parent_interface match
(c)  Figure out how to modify your main() method so that it accesses and prints
     one of the two conflicting values.  (Look to the Lecture 9 notes for
     clues.)  Make sure your code compiles and runs without errors.
	 System.out.println(parent_interface.Jan);
     System.out.println(parent_class.Jan);
*/
class parent_class{
	public static final int  Jan=1;
}
interface parent_interface{
	public static final int Jan=2;
}
class sub extends parent_class implements parent_interface{
	public static void main (String[] args){
		System.out.println(parent_interface.Jan);
	}

}