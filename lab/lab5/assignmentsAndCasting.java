/*
Let Y be a subclass of X, and let y and x be variables of classes Y and X
respectively.  From lecture, you know that the assignment "x = y" is valid, but
the assignment "y = (Y) x" requires a cast to compile, and will cause a
run-time error if x references an object that isn't a Y.

What about arrays of objects?  Suppose xa is an array of X's, and ya is an
array of Y's.

(a)  At compile-time, can we assign xa to ya, and vice versa?  When is a cast
     required?  1.no 2.yes ya=(Y[])xa;
(b)  At run-time, if ya references an array of Y's, can we assign it to xa?
     Can we then assign it back from xa to ya?  1.ya 2.need cast, but can run(
     run time check dynamic type, compile time check static type)
(c)  If xa references an array of X's (that are not Y's), can we assign it to
     ya?  Can we then assign it back from ya to xa?  Does it make a difference
     if the array of type X[] references objects that are all of class Y?  Why
     do you think this is the case?
     1.even after casting, still can not run 2.can compile and run
     3.still need cast
*/
class X{
	int x;
}
class Y extends X{
	int y=10;
	public void printY(){
		System.out.println(y);
	}
}
class test{
	public static void main(String [] args){
		X[] xa=new Y[5];
		Y[] ya=new Y[5];
		ya=(Y[])xa;
		
	}
}