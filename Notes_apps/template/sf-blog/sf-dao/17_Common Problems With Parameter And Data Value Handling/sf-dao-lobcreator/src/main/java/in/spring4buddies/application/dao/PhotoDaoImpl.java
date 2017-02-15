package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Photo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

@Repository
public class PhotoDaoImpl implements PhotoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private LobHandler lobHandler;

	private String SQL_INSERT_PHOTO = "INSERT INTO Photo (photo_id, clob_data, blob_data, b_file_name, c_file_name) VALUES (?, ?, ?, ?, ?)";

	@Override
	public void addPhoto(final Photo photo) throws Exception {

		final File userImage = photo.getUserImage();
		final InputStream blobIs = new FileInputStream(userImage);

		final File userProfile = photo.getUserProfile();
		final InputStream clobIs = new FileInputStream(userProfile);
		final InputStreamReader clobReader = new InputStreamReader(clobIs);

		jdbcTemplate.execute(SQL_INSERT_PHOTO, new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException {
				ps.setLong(1, photo.getPhotoId());
				lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int) userProfile.length());
				lobCreator.setBlobAsBinaryStream(ps, 3, blobIs, (int) userImage.length());
				ps.setString(4, userImage.getName());
				ps.setString(5, userProfile.getName());
			}
		});
		blobIs.close();
		clobReader.close();

	}
}