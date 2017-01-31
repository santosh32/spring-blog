package in.spring4buddies.application.dao;

import in.spring4buddies.application.dao.helper.ItemRowMapper;
import in.spring4buddies.application.model.Item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class ItemDaoImpl implements ItemDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	TransactionTemplate transactionTemplate;

	@Override
	public List<Item> getItems() {
		String sql = "SELECT * FROM items";
		return jdbcTemplate.query(sql, new ItemRowMapper());
	}

	@Override
	public void addItem(final Item item) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				try {
					String sql = "INSERT INTO items(item_id, item_name, item_desc, item_price) VALUES (?, ?, ?, ?)";
					jdbcTemplate.update(sql, new Object[] { item.getItemId(), item.getItemName(), item.getItemDesc(), item.getItemPrice() });
				} catch (Exception e) {
					transactionStatus.setRollbackOnly();
				}
			}
		});
	}

	@Override
	public void updateItem(final Item item) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				try {
					String sql = "UPDATE items SET item_name=?, item_desc=?, item_price=? WHERE item_id=?";
					jdbcTemplate.update(sql, new Object[] { item.getItemName(), item.getItemDesc(), item.getItemPrice(), item.getItemId() });
				} catch (Exception e) {
					transactionStatus.setRollbackOnly();
				}
			}
		});
	}

	@Override
	public void deleteItem(final Item item) throws Exception {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				try {
					String sql = "DELETE FROM items WHERE item_id=?";
					jdbcTemplate.update(sql, new Object[] { item.getItemId() });
				} catch (Exception e) {
					transactionStatus.setRollbackOnly();
				}
			}
		});
	}
}