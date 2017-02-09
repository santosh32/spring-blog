package in.spring4buddies.application.dao.helper;

import in.spring4buddies.application.model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AccountRowMapper implements RowMapper<Account> {

	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setAccountId(rs.getInt("acc_id"));
		account.setName(rs.getString("name"));
		account.setBalance(rs.getDouble("balance"));
		return account;
	}
}