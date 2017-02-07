package in.spring4buddies.application.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BankDaoImpl implements BankDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public double getBalance(int accountId) {
		String sql = "SELECT balance FROM ACCOUNT WHERE ACC_ID=?";
		return jdbcTemplate.queryForObject(sql, Double.class, accountId);
	}

	@Override
	public void withdraw(int accountId, double amount) throws Exception {
		double balance = getBalance(accountId);
		String sql = "UPDATE ACCOUNT SET BALANCE=? WHERE ACC_ID=?";
		jdbcTemplate.update(sql, new Object[] { balance - amount, accountId });
		throw new Exception("WithDraw failed");
	}

	@Override
	public void deposit(int accountId, double amount) throws Exception {
		double balance = getBalance(accountId);
		String sql = "UPDATE ACCOUNT SET BALANCE=? WHERE ACC_ID=?";
		jdbcTemplate.update(sql, new Object[] { balance + amount, accountId });
	}

	@Override
	public void transfer(int primaryAccId, int beneficiaryAccId, double amount) throws Exception {
		withdraw(primaryAccId, amount);
		deposit(beneficiaryAccId, amount);
	}
}