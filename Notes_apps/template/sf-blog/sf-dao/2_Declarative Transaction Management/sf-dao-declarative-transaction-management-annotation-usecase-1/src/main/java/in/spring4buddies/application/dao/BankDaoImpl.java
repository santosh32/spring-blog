package in.spring4buddies.application.dao;

import in.spring4buddies.application.dao.helper.AccountRowMapper;
import in.spring4buddies.application.model.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BankDaoImpl implements BankDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Account getBalance(int accountId) {
		String sql = "SELECT * FROM ACCOUNT WHERE ACC_ID=?";
		return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), accountId);
	}

	@Override
	public void withdraw(Account account) {
		String sql = "UPDATE ACCOUNT SET BALANCE=? WHERE ACC_ID=?";
		jdbcTemplate.update(sql, new Object[] { account.getBalance(), account.getAccountId() });
	}

	@Override
	public void deposit(Account account) {
		String sql = "UPDATE ACCOUNT SET BALANCE=? WHERE ACC_ID=?";
		jdbcTemplate.update(sql, new Object[] { account.getBalance(), account.getAccountId() });
	}

	@Override
	public void transfer(Account primary, Account beneficiary) {
		withdraw(primary);
		deposit(beneficiary);
	}
}