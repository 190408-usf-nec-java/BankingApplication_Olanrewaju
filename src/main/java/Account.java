import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account implements BankAccount{
	
	private String fristname;
	private String lastname;
	private int socialSecurity;
	private int account;
	private String username;
	private String password;
	private int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getFristname() {
		return fristname;
	}

	public void setFristname(String fristname) {
		this.fristname = fristname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(int socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account() {
		super();
	}

	public Account(String fristname, String lastname, int socialSecurity, int account, String username,
			String password) {
		super();
		this.fristname = fristname;
		this.lastname = lastname;
		this.socialSecurity = socialSecurity;
		this.account = account;
		this.username = username;
		this.password = password;
	}

	public void Signup(String firstname, String lastname, int socialSecurity, String username, String password) {
		// TODO Auto-generated method stub
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO users_users (firstname, lastname, social_security, username, userpassword) VALUES " + 
		"(?, ?, ?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setInt(3, socialSecurity);
			ps.setString(4, username);
			ps.setString(5, password);

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void login(String username, String password, int socialSecurity) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM users_users WHERE username=? and userpassword=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
			this.fristname = rs.getString("firstname");
			this.lastname = rs.getString("lastname");
			this.socialSecurity = rs.getInt("social_security");
			this.username = username;
			this.password = password;
			}
			
			try  {
				String sql1 = "SELECT * FROM users_users JOIN users_account ON users_users.social_security =? and users_account.social_security =?";
				PreparedStatement ps1 = conn.prepareStatement(sql1);

				ps1.setInt(1, socialSecurity);
				ps1.setInt(2, socialSecurity);
				
			
				ResultSet rs1= ps1.executeQuery();
				if(rs1.next()) {
				this.account = rs1.getInt("account_number");
				this.amount = rs1.getInt("amount");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			
			}
			
		}
		// TODO Auto-generated method stub
 catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	public void createAccount(String firstname, String lastname, int socialSecurity, int account, int amount) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO users_account (firstname, lastname, social_security, account_number, amount) VALUES " + 
		"(?, ?, ?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setInt(3, socialSecurity);
			ps.setInt(4, account);
			ps.setInt(5, amount);

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	public void deposit(int money, int account) {
		// TODO Auto-generated method stub
		this.amount = this.amount + money;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE users_account set amount=? where account_number=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, this.amount);
			ps.setInt(2, account);
			

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void withdraw(int money, int account) {
		// TODO Auto-generated method stub
		this.amount = this.amount - money;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE users_account set firstname=? where account_number=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, this.amount);
			ps.setInt(2, account);
			

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void transfer(int money, int accountfrom, int accountto) {
		// TODO Auto-generated method stub
		withdraw(money, accountfrom);
		int amount1 = 0; 
				//amount1 = amount1 + money;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM users_account WHERE account_number=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, accountto);
			
			
			ResultSet rs1= ps.executeQuery();
			if(rs1.next()) {
			amount1 = rs1.getInt("amount");
			amount1 = amount1 + money;
			}
			try  {
				String sql1 = "UPDATE users_account set amount=? where account_number=?";
				PreparedStatement ps1 = conn.prepareStatement(sql1);

				ps1.setInt(1, amount1);
				ps1.setInt(2, accountto);
				

				ps1.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public int balance(int account) {
		// TODO Auto-generated method stub
		if(this.account == 0 || this.username.equals(null)) {
			System.out.println("invalid entry");
		}
		else {
		return this.amount;
		}
		return 0;
	}


	
	
}
