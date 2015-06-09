public class BadTransactionException extends Exception{
	BadTransactionException(){}
	BadTransactionException(int amt){
		super("Invalid transaction ammount: "+amt);
	}
}