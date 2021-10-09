package Level_3;
import java.time.LocalDate;

public class bankMain {

	public static void main(String[] args) throws accountIsInActiveException, inSufficientBalanceException, invalidPinNumber, invalidPrivilegeException {
		
		Savings savings1 =new Savings();
		savings1.setName("SONU");
		LocalDate date1 =LocalDate.of(2000,12,1);
		savings1.setActivatedDate(date1);
		savings1.setAmount(10000);
		savings1.setPinNumber(1234);
		savings1.setPrivilege(privilege.GOLD);
		
		Savings savings2 =new Savings();
		savings2.setName("MONU");
		LocalDate date2 =LocalDate.of(2001,1,1);
		savings2.setActivatedDate(date2);
		savings2.setAmount(200);
		savings2.setPinNumber(12345);
		savings1.setPrivilege(privilege.SILVER);
		
		savings1.activateAccount(true);
		savings2.activateAccount(true);
		
		
		System.out.println("Accounts are Sucessfully Activated");
//		try {
//			savings1.withdraw(2000, 1234);
//			System.out.println("Sucessfully Withdrawed");
//		} catch (inSufficientBalanceException e) {
//			e.printStackTrace();
//		} catch (invalidPinNumber ex) {
//			ex.printStackTrace();
//		} catch (accountIsInActiveException e) {
//			e.printStackTrace();
//		}
//		try {
//			savings1.deposit(3000);
//			System.out.println("Sucessfully Deposited");
//		} catch (accountIsInActiveException e) {
//			e.printStackTrace();
//		}
		System.out.println("----------------------------------");
		
		boolean isTransferred1 = false;
		Transfer newTransfer1  = new Transfer(savings1,savings2,2020);
		isTransferred1 = savings1.transfer(newTransfer1);
		if(isTransferred1) {
			System.out.println("First Transfer is Successfull");
		}System.out.println();
		System.out.println("Account 1 Balance : "+savings1.getAmount());
		System.out.println("Account 2 Balance : "+savings2.getAmount());
		System.out.println("----------------------------------");
		System.out.println();
//		second transfer
		boolean isTransferred2 = false;
		Transfer newTransfer2  = new Transfer(savings1,savings2,500);
		isTransferred2 = savings1.transfer(newTransfer2);
		if(isTransferred2) {
			System.out.println("Second Transfer is Successfull");
		}System.out.println();
		
		System.out.println("----------------------------------");
		System.out.println();
		System.out.println("Account 1 Balance : "+savings1.getAmount());
		System.out.println("Account 2 Balance : "+savings2.getAmount());
	}

}
