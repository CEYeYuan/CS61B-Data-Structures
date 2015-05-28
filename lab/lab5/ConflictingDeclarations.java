/*
Suppose a subclass inherits a method implementation from a superclass, and
implements a Java interface (that's the "interface" keyword) that contains
a method with the same name and prototype.

(a)  Will Java compile the result?   
	 yes only if the method in the superclass is public 
(b)  What if the method declaration in the interface has a different return
     type?   
     can't be done. always confilct; it seems compiler doesn't care the return 
     type; if the signature are the same, they're considered as same method. Even
     two method has the same signature and one is implemented one is not, when we 
     try to implemented the method in the interface, compiler always complain the 
     return type doesn't math(compiler misunderstond that "I wants to overide the
     method in the super class")
(c)  What if the method declaration in the interface has the same return type,
     but a signature with a different parameter type?
     need implement the interface
(d)  What if the method declaration in the interface has the same return type,
     and the same number of parameters and parameter types, but those
     parameters have different names?
     same as Q1;parameter name doesn't matter, as long as the method in the superclass
     is public
*/
class parent_class{
	int p1;
	public int printPara(int input){
		System.out.println(input);
		return 1;
	}
}
interface parent_interface{
	void printPara(int a);
}
class sub extends parent_class implements parent_interface{
	//public void printPara(int input){return input;}

}