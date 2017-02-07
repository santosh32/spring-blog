package in.spring4buddies.application.model;

public class Account {
	int accountId;
	String name;
	double balance;

	public Account() {

	}

	public Account(int accoutId, String name, double balance) {
		super();
		this.accountId = accoutId;
		this.name = name;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accoutId) {
		this.accountId = accoutId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", name=" + name + ", balance=" + balance + "]";
	}

}
