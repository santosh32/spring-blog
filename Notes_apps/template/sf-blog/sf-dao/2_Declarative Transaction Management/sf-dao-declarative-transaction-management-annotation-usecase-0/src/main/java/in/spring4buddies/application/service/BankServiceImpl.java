package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.BankDao;

import org.springframework.beans.factory.annotation.Autowired;

public class BankServiceImpl implements BankService {

	@Autowired
	BankDao bankDao;

	@Override
	public double getBalance(int accountId) {
		return bankDao.getBalance(accountId);
	}

	@Override
	public void withdraw(int accountId, double amount) throws Exception {
		bankDao.withdraw(accountId, amount);
	}

	@Override
	public void deposit(int accountId, double amount) throws Exception {
		bankDao.deposit(accountId, amount);
	}

	@Override
	public void transfer(int primaryAccId, int beneficiaryAccId, double amount) throws Exception {
		bankDao.transfer(primaryAccId, beneficiaryAccId, amount);
	}
}