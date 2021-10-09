package level_5;

public class AccountManager {

	public boolean open(Account account,String type) throws Exception {
		boolean isopened = false;
		AccountImpl accountImpl = AccountImplFactory.create(type);
		try {
			isopened = accountImpl.open(account);
		}catch(AccountAlreadyActiveException ex) {
			System.out.println(ex.getMessage());
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return isopened;
	}
}
