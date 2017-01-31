package in.spring4buddies.application.dao.helper;

import in.spring4buddies.application.model.Item;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ItemRowMapper implements RowMapper<Item> {

	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		Item item = new Item();
		item.setItemId(rs.getInt("item_id"));
		item.setItemName(rs.getString("item_name"));
		item.setItemDesc(rs.getString("item_desc"));
		item.setItemPrice(rs.getDouble("item_price"));
		return item;
	}

}