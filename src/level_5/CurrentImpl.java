package level_5;

import java.time.LocalDate;

public class CurrentImpl implements AccountImpl {

	public boolean open(Account account) throws AccountAlreadyActiveException {
		boolean isOpened = false;
		Current current = (Current) account ;
		
		if(current.isActive()) {
			throw new AccountAlreadyActiveException("Account is Already Active");
		}
		boolean isValid= false;
		try {
			isValid = checkRegistrationNumberValidity(current.getRegNum());
			isOpened = true;
		}catch(RegistrationNumberValidityException ex) {
			isOpened =false;
		}
		isOpened = activateAccount(isValid,current);
		return isOpened;
	}
	private boolean activateAccount(boolean isOpened,Current current) {
		boolean isActivated = false;
		if(isOpened) {
			current.setActive(isOpened);
			current.setActivatedDate(LocalDate.now());
			isActivated = true;
		}
		return isActivated;
	}
	private boolean checkRegistrationNumberValidity(int regnum) throws RegistrationNumberValidityException{
		boolean isValidAge = true;
		if(regnum == 0) {
			isValidAge= false;
			throw new RegistrationNumberValidityException("Registration Number is not valid");
		}
		return isValidAge;
	}
}
