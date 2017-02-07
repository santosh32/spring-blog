package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Account;

public interface BankService {

	Account getBalance(int accountId);

	void withdraw(Account account);

	void deposit(Account account);

	void transfer(Account primary, Account beneficiary);
}
