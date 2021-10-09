import java.time.LocalDate;

public class Savings extends Account {

	private LocalDate Date0fBirth;
	private String Gender;
	private int PhoneNUM;
	
	public LocalDate getDate0fBirth() {
		return Date0fBirth;
	}
	public void setDate0fBirth(LocalDate date0fBirth) {
		Date0fBirth = date0fBirth;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getPhoneNUM() {
		return PhoneNUM;
	}
	public void setPhoneNUM(int phoneNUM) {
		PhoneNUM = phoneNUM;
	}
	
	public boolean open() throws AccountAlreadyActiveException {
		boolean isOpened = false;
		if(this.isActive()) {
			throw new AccountAlreadyActiveException("Account is Already Active");
		}
		boolean isValid= false;
		try {
			isValid = checkAgeValidity(this.Date0fBirth);
			isOpened = true;
		}catch(AgeValidityException ex) {
			isOpened =false;
		}
		isOpened = activateAccount(isValid);
		return isOpened;
	}
	
	
	public boolean activateAccount(boolean isOpened) {
		if(isOpened) {
			this.setActive(isOpened);
			this.setActivatedDate(LocalDate.now());
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
