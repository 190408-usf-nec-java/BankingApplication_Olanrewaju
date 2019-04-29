import java.awt.List;

public interface BankAccount {
 void Signup(String firstname, String lastname, int socialSecurity, String username, String password);
 
 void login(String username, String Password, int socialSecurity);
 
 void createAccount(String firstname, String lastname, int socialSecurity, int account, int amount);
 
 void deposit(int money, int account);
 
 void withdraw(int money, int account);
 
 void transfer(int money, int accountfrom, int accountto);
 
 int balance(int account);
 
}
