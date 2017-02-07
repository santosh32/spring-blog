package in.spring4buddies.application.service;

public interface BankService {

	double getBalance(int accountId);

	void withdraw(int accountId, double amount) throws Exception;

	void deposit(int accountId, double amount) throws Exception;

	void transfer(int primaryAccId, int beneficiaryAccId, double amount) throws Exception;
}
