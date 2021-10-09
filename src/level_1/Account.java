package level_1;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public abstract class Account {

	private int accountNumber;
	private String name;
	private int pinNumber;
	private double balance;
	protected boolean isActive;
	protected boolean isClosed;
	private LocalDate activatedDate;
	private LocalDate closedDate;
	private double amount;
	private privilege Privilege;
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isClosed() {
		return isClosed;
	}

	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDate getActivatedDate() {
		return activatedDate;
	}

	public void setActivatedDate(LocalDate activatedDate) {
		this.activatedDate = activatedDate;
	}

	public LocalDate getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(LocalDate closedDate) {
		this.closedDate = closedDate;
	}

	public privilege getPrivilege() {
		return Privilege;
	}

	public void setPrivilege(privilege privilege) {
		Privilege = privilege;
	}
	
	public boolean checkfundAvailability(double amount) throws inSufficientBalanceException {
		boolean isAvailable = false;
		if(this.getBalance()<amount) {
			throw new inSufficientBalanceException("Insufficient Balance");
		}else {
			isAvailable=true;
		}
		return isAvailable;
	}
	
	
	public boolean checkIfPinNumberIsValid(int pinNumber) throws invalidPinNumber {
		boolean isvalid = false;
		 if(this.getPinNumber() == pinNumber) {
			 isvalid = true;
		 }else {
			 throw new invalidPinNumber("Invalid Pin");
		 }
		
		return isvalid;
	}	
	public boolean isAccountActive(Account Account) {
		boolean isAccountActive = false;
		if(Account.isActive) {
			isAccountActive = true;
		}
		return isAccountActive;
	}
	public abstract boolean open() throws  level_1.AccountAlreadyActiveException ;
}
