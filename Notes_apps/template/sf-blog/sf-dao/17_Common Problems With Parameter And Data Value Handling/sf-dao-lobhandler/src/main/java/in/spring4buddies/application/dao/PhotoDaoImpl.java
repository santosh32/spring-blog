package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Photo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

@Repository
public class PhotoDaoImpl implements PhotoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private LobHandler lobHandler;

	private String SQL_SELECT_PHOTO = "select photo_id, clobImage, blogImage from Photo";

	@Override
	public Photo getById(long photoId) throws Exception {

		List<Map<String, Object>> list = jdbcTemplate.query(SQL_SELECT_PHOTO, new RowMapper<Map<String, Object>>() {
			public Map<String, Object> mapRow(ResultSet rs, int i) throws SQLException {

				Map<String, Object> results = new HashMap<String, Object>();

				String clobText = lobHandler.getClobAsString(rs, "clobImage");
				results.put("CLOB", clobText);

				byte[] blobBytes = lobHandler.getBlobAsBytes(rs, "blogImage");
				results.put("BLOB", blobBytes);
				return results;
			}
		});

		return null;
	}
}