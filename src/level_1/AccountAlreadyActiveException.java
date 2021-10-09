package level_1;

public class AccountAlreadyActiveException extends Exception{

	public AccountAlreadyActiveException() {
		
	}
	public AccountAlreadyActiveException(String message) {
		super(message);
	}

}
