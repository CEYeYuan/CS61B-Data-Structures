public class BadTransactionException extends Exception{
	int badtransaction;
	public  BadTransactionException(int value){
        super(value+" must be positive!");
		badtransaction=value;
	}
}