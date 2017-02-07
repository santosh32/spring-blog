package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.BankDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
public class BankServiceImpl implements BankService {

	@Autowired
	BankDao bankDao;

	@Transactional(readOnly = true)
	@Override
	public double getBalance(int accountId) {
		return bankDao.getBalance(accountId);
	}

	@Override
	public void withdraw(int accountId, double amount) {
		bankDao.withdraw(accountId, amount);
	}

	@Override
	public void deposit(int accountId, double amount) {
		bankDao.deposit(accountId, amount);
	}

	@Override
	public void transfer(int primaryAccId, int beneficiaryAccId, double amount) {
		bankDao.transfer(primaryAccId, beneficiaryAccId, amount);
	}
}