import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();
		String firstname;
		String lastname;
		int socialSecurity;
		int accountNumber;
		String username;
		String password;
		int amount;
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("choose one of the following below ==== "
		 		+ "but signup first then create account "
		 		+ "with an existing social security from signup");
		    System.out.println("login to withdraw, deposit, balance, transfer");
	        System.out.println("login");
	        System.out.println("signup");
	        System.out.println("create account");
	        System.out.println("transfer");
	        System.out.println("deposit");
	        System.out.println("withdraw");
	        System.out.println("balance");
	        String input = null;

	        do {
	        	 input = scanner.nextLine();
	        	 switch (input) {
	        	  case "signup":
	        		  System.out.println("firstname");
		                firstname = scanner.nextLine();
		                System.out.println("lastname");
		                lastname = scanner.nextLine();
		                System.out.println("social security");
		                while(!scanner.hasNextInt()) {
		                	System.out.println("enter valid entry");
		                    scanner.next();
		                }
		                socialSecurity = scanner.nextInt();
		                scanner.nextLine();
		                System.out.println("enter username");
		                username = scanner.nextLine();
		                System.out.println("enter password");
		                password = scanner.nextLine();
		               
		                account.Signup(firstname, lastname, socialSecurity, username, password);
		                
		                System.out.println("signup successful");
		                System.out.println("");
	        	    break;
	        	  case "create account":
	        		  System.out.println("firstname");
		                firstname = scanner.nextLine();
		                System.out.println("lastname");
		                lastname = scanner.nextLine();
		                System.out.println("social security");
		                while(!scanner.hasNextInt()) {
		                	System.out.println("enter valid entry");
		                    scanner.next();
		                }
		                socialSecurity = scanner.nextInt();
		                scanner.nextLine();
		                System.out.println("account number");
		                while(!scanner.hasNextInt()) {
		                	System.out.println("enter valid entry");
		                    scanner.next();
		                }
		                accountNumber = scanner.nextInt();
		                scanner.nextLine();
		                System.out.println("initial deposit greater than 0");
		                while(!scanner.hasNextInt()) {
		                	System.out.println("enter valid entry greater than 0");
		                    scanner.next();
		                }
		                amount = scanner.nextInt();
		                scanner.nextLine();
		                account.createAccount(firstname, lastname, socialSecurity, accountNumber, amount);
		               
		                System.out.println("create account successful");
	        	    break;
	        	  case "login":
	        		  System.out.println("username");
		                username = scanner.nextLine();
		                System.out.println("Password");
		                password = scanner.nextLine();
		                System.out.println("social security");
		                while(!scanner.hasNextInt()) {
		                	System.out.println("enter valid entry");
		                    scanner.next();
		                }
		                socialSecurity = scanner.nextInt();
		                scanner.nextLine();
		                account.login(username, password, socialSecurity);
		                int account1 = account.getAccount();
		                System.out.println("account balance= "+ account.balance(account1));
		               
		               
	        	    break;
	        	  case "deposit":
	        		  System.out.println("account number");
	        		  while(!scanner.hasNextInt()) {
		                	System.out.println("enter valid entry");
		                    scanner.next();
		                }
		                accountNumber = scanner.nextInt();
		                scanner.nextLine();
		                System.out.println("amount");
		                while(!scanner.hasNextInt()) {
		                	System.out.println("enter valid entry");
		                    scanner.next();
		                }
		                amount = scanner.nextInt();
		               
		                account.deposit(amount, accountNumber);
		                System.out.println("account balance= "+ account.balance(accountNumber));
		               
		               
	        	    break;
	        	  case "withdraw":
	        		  System.out.println("account number");
	        		  while(!scanner.hasNextInt()) {
		                	System.out.println("enter valid entry");
		                    scanner.next();
		                }
		                accountNumber = scanner.nextInt();
		                scanner.nextLine();
		                System.out.println("amount");
		                while(!scanner.hasNextInt()) {
		                	System.out.println("enter valid entry");
		                    scanner.next();
		                }
		                amount = scanner.nextInt();
		                scanner.nextLine();
		                account.withdraw(amount, accountNumber);
		                System.out.println("account balance= "+ account.balance(accountNumber));
	        	    break;
	        	  case "transfer":
	        		  System.out.println("account number from");
	        		  while(!scanner.hasNextInt()) {
		                	System.out.println("enter valid entry");
		                    scanner.next();
		                }
		                int accountNumberFrom = scanner.nextInt();
		                scanner.nextLine();
		                System.out.println("account number to");
		                while(!scanner.hasNextInt()) {
		                	System.out.println("enter valid entry");
		                    scanner.next();
		                }
		                int accountNumberTo = scanner.nextInt();
		                scanner.nextLine();
		                System.out.println("amount");
		                while(!scanner.hasNextInt()) {
		                	System.out.println("enter valid entry");
		                    scanner.next();
		                }
		                amount = scanner.nextInt();
		                scanner.nextLine();
		                account.transfer(amount, accountNumberFrom, accountNumberTo);
		                System.out.println("account balance= "+ account.balance(accountNumberFrom));
	        	    break;
	        	  case "balance":
	        		    System.out.println("account number");
	        		    while(!scanner.hasNextInt()) {
		                	System.out.println("enter valid entry");
		                    scanner.next();
		                }
		                accountNumber = scanner.nextInt();
		                scanner.nextLine();
		                System.out.println("account balance= "+ account.balance(accountNumber));
	        	    break;
	        	}
	        }
	           while((!input.equals(null)) || (!input.equals("")));
	}
}
