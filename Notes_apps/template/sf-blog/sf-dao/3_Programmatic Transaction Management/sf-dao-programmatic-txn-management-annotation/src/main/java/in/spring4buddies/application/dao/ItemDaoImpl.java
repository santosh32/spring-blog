package in.spring4buddies.application.dao;

import in.spring4buddies.application.dao.helper.ItemRowMapper;
import in.spring4buddies.application.model.Item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class ItemDaoImpl implements ItemDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	PlatformTransactionManager transactionManager;

	@Override
	public List<Item> getItems() {
		String sql = "SELECT * FROM items";
		List<Item> items = jdbcTemplate.query(sql, new ItemRowMapper());
		return items;
	}

	@Override
	public void addItem(Item item) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
		try {
			String sql = "INSERT INTO items(item_id, item_name, item_desc, item_price) VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, new Object[] { item.getItemId(), item.getItemName(), item.getItemDesc(), item.getItemPrice() });
			transactionManager.commit(transactionStatus);
		} catch (Exception ex) {
			transactionManager.rollback(transactionStatus);
		}
	}

	@Override
	public void updateItem(Item item) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
		try {
			String sql = "UPDATE items SET item_name=?, item_desc=?, item_price=? WHERE item_id=?";
			jdbcTemplate.update(sql, new Object[] { item.getItemName(), item.getItemDesc(), item.getItemPrice(), item.getItemId() });
			transactionManager.commit(transactionStatus);
		} catch (Exception ex) {
			transactionManager.rollback(transactionStatus);
		}
	}

	@Override
	public void deleteItem(Item item) throws Exception {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
		try {
			String sql = "DELETE FROM items WHERE item_id=?";
			jdbcTemplate.update(sql, new Object[] { item.getItemId() });
			transactionManager.commit(transactionStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
			transactionManager.rollback(transactionStatus);
		}
	}
}