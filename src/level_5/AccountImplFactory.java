package level_5;

public class AccountImplFactory {

	public static AccountImpl create(String type) throws InvalidAccountChoiceexception {
		AccountImpl accountImpl = null;
		
		if(type.equalsIgnoreCase("Savings")) {
			accountImpl = new SavingsImpl();
		}else if(type.equalsIgnoreCase("Current")) {
			accountImpl = new CurrentImpl();
		}else {
			throw new InvalidAccountChoiceexception("Invalid choice");
		}
		return accountImpl;
	}
}
