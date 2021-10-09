package Level_3;

public class Transfer {

	private Account  fromAccount;
	private Account  toAccount;
	private double amount;
	public Transfer(Savings savings1, Savings savings2, double trannsferamount) {
		fromAccount = savings1;
		 toAccount  = savings2;
		 amount=trannsferamount;
	}
	public Account getFromAccount() {
		return fromAccount;
	}
	public void setFromAcount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Account getToAccount() {
		return toAccount;
	}
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
