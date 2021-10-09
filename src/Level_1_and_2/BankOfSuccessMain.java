package Level_1_and_2;

import java.time.LocalDate;
import java.util.Scanner;

public class BankOfSuccessMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to Bank of Success");
		System.out.println();
		System.out.println("Openning an Account");
		System.out.println("Choose the Type of Account");
		System.out.println("1. Savings");
		System.out.println("2. Current");
		int choice = scan.nextInt();
		if(choice == 1) {
			Scanner scan1 = new Scanner(System.in);
			boolean isopened = false;
//			creating object of savings
			Savings savings = new Savings();
			System.out.println("Enter Name");
			String name = scan1.next();
			
			System.out.println("Enter Gender");
			String gender = scan1.next();
			
			System.out.println("Enter Date Of Birth");
			LocalDate date = LocalDate.of(scan1.nextInt(), scan1.nextInt(), scan1.nextInt());
			
			System.out.println("Enter Phone Number");
			String phoneNumber = scan1.next();
			
			savings.setName(name);
			savings.setGender(gender);
			savings.setDate0fBirth(date);
			
			savings.setGender(phoneNumber);
			try {
				isopened = savings.open();
			} catch (AccountAlreadyActiveException e) {
				System.out.println(e.getMessage());
			}
			if(isopened) {
				System.out.println("Savings Account Opened successfully");
			}
		}else if(choice == 2) {

			Scanner scan2 = new Scanner(System.in);
			boolean isopened=false;
//			creating object for current
			Current current = new Current();
			
			System.out.println("Enter Company Name");
			String comName = scan2.nextLine();
			current.setCompanyName(comName);
			
			System.out.println("Enter Website");
			String website = scan2.nextLine();
			current.setWebsite(website);
			
			System.out.println("Enter Registration Number");
			String regnumber = scan2.nextLine();
			current.setRegNum(regnumber);
			
			try {
				isopened = current.open();
			} catch (AccountAlreadyActiveException e) {
				System.out.println(e.getMessage());
			}
			if(isopened) {
				System.out.println("Current Account Opened successfully");
			}
		}
	
	}

}
