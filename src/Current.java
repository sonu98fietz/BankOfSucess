import java.time.LocalDate;

public class Current extends Account {

	private String companyName;
	private String website;
	private int regNum;
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getRegNum() {
		return regNum;
	}
	public void setRegNum(int regNum) {
		this.regNum = regNum;
	}
	
	public boolean open() throws AccountAlreadyActiveException {
		boolean isOpened = false;
		if(this.isActive()) {
			throw new AccountAlreadyActiveException("Account is Alraedy Active");
		}
		boolean isValid= false;
		try {
			isValid = checkRegistrationNumberValidity(this.getRegNum());
			isOpened = true;
		}catch(RegistrationNumberValidityException ex) {
			isOpened =false;
		}
		isOpened = activateAccount(isValid);
		return isOpened;
	}
	private boolean activateAccount(boolean isOpened) {
		boolean isActivated = false;
		if(isOpened) {
			this.setActive(isOpened);
			this.setActivatedDate(LocalDate.now());
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
