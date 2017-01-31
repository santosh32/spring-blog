package in.spring4buddies.application.dao.helper;

import in.spring4buddies.application.model.Item;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class ItemExtracter implements ResultSetExtractor<Item> {

	@Override
	public Item extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		Item item = new Item();
		item.setItemId(resultSet.getInt(1));
		item.setItemName(resultSet.getString(2));
		item.setItemDesc(resultSet.getString(3));
		item.setItemPrice(resultSet.getDouble(4));
		return item;
	}
}