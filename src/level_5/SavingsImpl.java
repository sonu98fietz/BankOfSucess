package level_5;

import java.time.LocalDate;

public class SavingsImpl implements AccountImpl {

	public boolean open(Account account) throws AccountAlreadyActiveException {
		Savings savings = (Savings) account;
		boolean isOpened = false;
		if(savings.isActive()) {
			throw new AccountAlreadyActiveException("Account is Already Active");
		}
		boolean isValid= false;
		try {
			isValid = checkAgeValidity(savings.getDate0fBirth());
			isOpened = true;
		}catch(AgeValidityException ex) {
			isOpened =false;
		}
		isOpened = activateAccount(isValid,savings);
		return isOpened;
	}
	
	
	public boolean activateAccount(boolean isOpened,Savings savings) {
		if(isOpened) {
			savings.setActive(isOpened);
			savings.setActivatedDate(LocalDate.now());
			isOpened = true;
		}
		return isOpened;
	}
	public boolean checkAgeValidity(LocalDate date0fBirth) throws AgeValidityException{
		boolean isValidAge = false;
		if(LocalDate.now().getYear()-date0fBirth.getYear()<18) {
			isValidAge= true;
			throw new AgeValidityException("Age is less than 18");
		}
		return isValidAge;
	}
}
