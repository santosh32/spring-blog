package in.spring4buddies.application.dao;

import in.spring4buddies.application.dao.helper.ItemRowMapper;
import in.spring4buddies.application.model.Item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ItemDaoImpl implements ItemDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Item> getItems() {
		String sql = "SELECT * FROM items";
		return jdbcTemplate.query(sql, new ItemRowMapper());
	}

	@Override
	public void addItem(Item item) {
		String sql = "INSERT INTO items(item_id, item_name, item_desc, item_price) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { item.getItemId(), item.getItemName(), item.getItemDesc(), item.getItemPrice() });
	}

	@Override
	public void updateItem(Item item) {
		String sql = "UPDATE items SET item_name=?, item_desc=?, item_price=? WHERE item_id=?";
		jdbcTemplate.update(sql, new Object[] { item.getItemName(), item.getItemDesc(), item.getItemPrice(), item.getItemId() });
	}

	@Override
	public void deleteItem(Item item) throws Exception {
		String sql = "DELETE FROM items WHERE item_id=?";
		jdbcTemplate.update(sql, new Object[] { item.getItemId() });
		throw new Exception();
	}
}