package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Account;

public interface BankDao {

	Account getBalance(int accountId);

	void withdraw(Account account);

	void deposit(Account account);

	void transfer(Account primary, Account beneficiary);
}
