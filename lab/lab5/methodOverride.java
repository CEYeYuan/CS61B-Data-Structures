/*
 Method Overriding (1 point)
-------------------------------------
Consider a subclass that has a method that overrides a method with the same
prototype in its superclass.

(a)  Define a variable whose static type is the subclass and which references
     an object of the subclass.  If we cast the variable to the superclass type
     before calling the overridden method

        ((Superclass) subclassvariable).method();

     does Java call the superclass method or the subclass method?
     subclass method; because of dynamic method lookup
(b)  Define a variable whose static type is the superclass and which references
     an object of the superclass (but not the subclass).  If we cast the
     variable to the subclass type before calling the method, does Java call
     the superclass method or the subclass method?

     can complile, but for the runtime, there's a classCastException; when we do
     the cast, what we really do is tell java compiler, this reference is actually
     an object of subclass. If that's true, we'll call the subclass method(because of
     dynamic method look up). But if not, we'll be casting an object, which will 
     lead to the exception

(c)  Suppose you have an object whose class is the subclass.  Can you figure
     out a way to call the superclass method on that object without having to
     go through the subclass method of the same name?
     no way, because of dynamic method lookup
*/

class parent{
	int i;
	void print1(){
		System.out.println(1);
	}
}
class sub extends parent{
	void print1(){
		System.out.println(2);
	}
}
class test{
	public static void main(String [] args){
		sub sub_object=new sub();
		((parent)sub_object).print1();
	
	}
}