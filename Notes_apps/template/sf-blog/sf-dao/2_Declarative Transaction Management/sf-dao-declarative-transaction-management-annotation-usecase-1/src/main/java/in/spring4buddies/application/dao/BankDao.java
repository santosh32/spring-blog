package in.spring4buddies.application.dao;

public interface BankDao {

	double getBalance(int accountId);

	void withdraw(int accountId, double amount) throws Exception;

	void deposit(int accountId, double amount) throws Exception;

	void transfer(int primaryAccId, int beneficiaryAccId, double amount) throws Exception;
}
