package level_5;

import java.time.LocalDate;
import java.util.Scanner;

public class AccountForm {

	public void load() throws Exception {
		System.out.println("Welcome to Bank Of Success ");
		System.out.println();
		showForm();
		String choice = getChoice();		
		if(choice.equalsIgnoreCase("1")) {
			Open();
		}else if(choice.equalsIgnoreCase("2")) {
			Deposit();
		}else if(choice.equalsIgnoreCase("3")) {
			Withdraw();
		}else if(choice.equalsIgnoreCase("4")) {
			Transfer();
		}else if(choice.equalsIgnoreCase("5")) {
			Close();
		}
	}
	public void showForm() {
		
		System.out.println("Hello . What do you want to do today ?");
		System.out.println();
		System.out.println("1. Open");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Tansfer");
		System.out.println("5. Close");
		
	}
	public String getChoice() {
		System.out.println();
		System.out.println("Please Enter the Choice : ");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();
		return choice;
	}
	
	public void Open() throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Type of Account : ");
		System.out.println("savings");
		System.out.println("current");
		String type = scanner.nextLine();
		Account account = getAccountInformation();
		
		boolean isOpened = false;
		try {
			isOpened = new AccountManager().open(account,type);
			if(isOpened) {
				System.out.println("Account Opened Successfully");
			}
		}catch(AccountAlreadyActiveException ex) {
			System.out.println(ex.getMessage());
		}	
	}
	public Account getAccountInformation() {
		Scanner scanner = new Scanner(System.in);
		Savings savings = new Savings();
		Current current = null;
		
		
		System.out.println("Enter Name");
		String name = scanner.nextLine();
		
		System.out.println("Enter Gender");
		String gender = scanner.nextLine();
		
		System.out.println("Choice privilege");
		System.out.println("PREMIUM");
		System.out.println("GOLD ");
		System.out.println("SILVER");
		String privilegegiven = scanner.nextLine();
			
		System.out.println("Enter Pin Number");
		String pinNumber = scanner.nextLine();
		System.out.println("Enter Date of Birth");
		LocalDate date = LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
		savings.setName(name);
		System.out.println(savings.getName());
		privilege Privilege = null;
		if(privilegegiven.equalsIgnoreCase("PREMIUM")) {
			Privilege =  privilege.PREMIUM;
		}else if(privilegegiven.equalsIgnoreCase("GOLD")) {
			Privilege =  privilege.GOLD;
		}else if(privilegegiven.equalsIgnoreCase("SILVER")) {
			Privilege =  privilege.SILVER; 
		savings.setPrivilege(Privilege);	
		savings.setPinNumber(Integer.getInteger(pinNumber));
		System.out.println("here");
		savings.setDate0fBirth(date);
		System.out.println(savings.getName());
		System.out.println(savings.getDate0fBirth());
	   }
		return savings;
	}
	
	public void Deposit() {
		
	}
	public void Withdraw() {
		
	}
	public void Transfer() {
		
	}
	public void Close() {
		
	}
}
