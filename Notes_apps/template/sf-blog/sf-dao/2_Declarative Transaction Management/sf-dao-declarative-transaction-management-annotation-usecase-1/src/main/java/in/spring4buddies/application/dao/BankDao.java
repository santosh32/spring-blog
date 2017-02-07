package in.spring4buddies.application.dao;

public interface BankDao {

	double getBalance(int accountId);

	void withdraw(int accountId, double amount);

	void deposit(int accountId, double amount);

	void transfer(int primaryAccId, int beneficiaryAccId, double amount);
}
