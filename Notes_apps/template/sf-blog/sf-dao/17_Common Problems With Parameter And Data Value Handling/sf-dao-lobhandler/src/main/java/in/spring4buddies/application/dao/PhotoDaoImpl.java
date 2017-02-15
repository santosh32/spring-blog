package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Photo;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
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

	private String SQL_SELECT_PHOTO = "select photo_id, clob_data, blob_data, b_file_name, c_file_name from Photo";

	@Override
	public Photo getById(long photoId) throws Exception {

		return jdbcTemplate.queryForObject(SQL_SELECT_PHOTO, new RowMapper<Photo>() {
			public Photo mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Photo photo = new Photo();
				photo.setPhotoId(rs.getLong("photo_id"));
				try {
					File blobFile = new File(rs.getString("c_file_name"));
					FileUtils.writeByteArrayToFile(blobFile, lobHandler.getBlobAsBytes(rs, "blob_data"));
					photo.setBlogImage(blobFile);

					File clobFile = new File(rs.getString("b_file_name"));
					FileUtils.writeStringToFile(clobFile, lobHandler.getClobAsString(rs, "clob_data"));
					photo.setClobImage(clobFile);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}

				return photo;
			}
		});
	}
}