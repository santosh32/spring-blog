package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.BankDao;
import in.spring4buddies.application.model.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
public class BankServiceImpl implements BankService {

	@Autowired
	BankDao bankDao;

	@Transactional(readOnly = true)
	@Override
	public Account getBalance(int accountId) {
		return bankDao.getBalance(accountId);
	}

	@Override
	public void withdraw(Account account) {
		bankDao.withdraw(account);
	}

	@Override
	public void deposit(Account account) {
		bankDao.deposit(account);
	}

	@Override
	public void transfer(Account primary, Account beneficiary) {
		bankDao.transfer(primary, beneficiary);
	}
}