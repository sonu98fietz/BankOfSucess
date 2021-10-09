package level_5;

public class AccountAlreadyActiveException extends Exception{

	public AccountAlreadyActiveException() {
		
	}
	public AccountAlreadyActiveException(String message) {
		super(message);
	}

}
