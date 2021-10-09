import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public  abstract class Account {

	private int accountNumber;
	private String name;
	private int pinNumber;
	private double balance;
	protected boolean isActive;
	protected boolean isClosed;
	private LocalDate activatedDate;
	private LocalDate closedDate;
	private double amount;
	
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

	private privilege Privilege;
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
	
	public boolean close() throws AccountAlreadyActiveException {
		boolean isClosed = false;
		if(!this.isClosed()) {
			throw new AccountAlreadyActiveException("Account is Already closed");
		}else {
			isClosed= false;
		}
		
		return isClosed;
	}
	public boolean checkfundAvailability(double amount) throws inSufficientBalanceException {
		boolean isAvailable = false;
		if(this.getBalance()<amount) {
			throw new inSufficientBalanceException("Insufficient Balance");
		}
		return isAvailable;
	}
	public boolean withdraw(double amount,int pinNumber,Transfer transfer) throws accountIsInActiveException,inSufficientBalanceException, invalidPinNumber {
		boolean iswithdraw = false;
		if(isAccountActive(transfer.getFromAccount())) {
			if(transfer.getFromAccount().getPinNumber() == pinNumber) {
				if(transfer.getFromAccount().getAmount()>=amount) {
					setAmount(getAmount()-amount);
					iswithdraw = true;
				}else {
					throw new inSufficientBalanceException("In-Sufficient Balance");
				}
			}else {
				throw new invalidPinNumber("In-valid Pin Number");
			}
		}else {
			throw new accountIsInActiveException("Account is Inactive");
		}
		
		return iswithdraw;
	}
	public boolean deposit(double amount,Transfer transfer) throws accountIsInActiveException {
		boolean isdeposit = false;
		if(isAccountActive(transfer.getFromAccount())) {
			transfer.getToAccount().setAmount(transfer.getToAccount().getAmount()+amount);
			transfer.getFromAccount().setAmount(transfer.getFromAccount().getAmount()-amount);
			isdeposit= true;
		}else {
			throw new accountIsInActiveException("Account is Inactive");
		}
		
		return isdeposit;
	}
	public boolean checkDailyTransferLimit(Account account,double amount) throws invalidPrivilegeException {
		boolean isAvailable = false;
		List<Transfer> transfers = new ArrayList<Transfer>();
		double dailyTransferLimit = AccountPrivilegeManager.getPrivilegeLimit(account.getPrivilege());
		TransferLog log =new TransferLog();
		transfers = log.getTransfers(account);
		double transferDone = 0.0;
		
		if(transfers !=null) {
			for(Transfer transfer: transfers) {
				transferDone += transfer.getAmount();
			}
			System.out.println(transferDone );
		}
		if(transferDone<dailyTransferLimit+amount) {
			isAvailable = true;
		}
		return isAvailable;
	}
	
	public boolean isAccountActive(Account Account) {
		boolean isAccountActive = false;
		if(Account.isActive) {
			isAccountActive = true;
		}
		return isAccountActive;
	}
	
	public boolean transfer(Transfer transfer) throws accountIsInActiveException, inSufficientBalanceException, invalidPinNumber, invalidPrivilegeException {
		boolean istranfered = false;
		if(isAccountActive(transfer.getFromAccount())) {
			if(isAccountActive(transfer.getToAccount())) {
				if(checkDailyTransferLimit(transfer.getFromAccount(),transfer.getAmount())) {
					if(withdraw(transfer.getAmount(),transfer.getFromAccount().getPinNumber(), transfer) ) {
						if(deposit(transfer.getAmount(), transfer)) {
							istranfered=true;
							TransferLog log =new TransferLog();
							log.logTransfer(transfer);
						}
					}
				}
			}
		}
		return istranfered;
	}

	public abstract boolean open() throws AccountAlreadyActiveException ;
		
	
	
	
	
}
