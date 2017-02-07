package in.spring4buddies.application.service;

public interface BankService {

	double getBalance(int accountId);

	void withdraw(int accountId, double amount);

	void deposit(int accountId, double amount);

	void transfer(int primaryAccId, int beneficiaryAccId, double amount);
}
