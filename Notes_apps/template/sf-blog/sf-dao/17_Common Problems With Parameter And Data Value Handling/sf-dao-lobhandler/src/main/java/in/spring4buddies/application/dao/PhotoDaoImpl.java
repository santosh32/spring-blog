package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Photo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
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

	private String SQL_SELECT_PHOTO = "select photo_id, clob_data, blob_data from Photo";

	@Override
	public Photo getById(long photoId) throws Exception {

		System.out.println();

		Photo photo = jdbcTemplate.queryForObject(SQL_SELECT_PHOTO, new RowMapper<Photo>() {
			public Photo mapRow(ResultSet rs, int i) throws SQLException {
				Photo photo = new Photo();
				photo.setPhotoId(rs.getLong("photo_id"));
				Reader clobData = lobHandler.getClobAsCharacterStream(rs, "clob_data");
				try {
					File blobFile = new File("/output/blob.jpeg");
					FileUtils.copyInputStreamToFile(lobHandler.getBlobAsBinaryStream(rs, "blob_data"), blobFile);
					photo.setBlogImage(blobFile);
					// FileUtils.copyInputStreamToFile(clobData, new
					// File("/output/clob.jpeg"));

				} catch (IOException e) {
				}
				return photo;
			}
		});

		return photo;
	}
}