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
import org.springframework.stereotype.Repository;

@Repository
public class PhotoDaoImpl implements PhotoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String SQL_INSERT_PHOTO = "INSERT INTO Photo (photo_id, clob_data, blog_data) VALUES (?, ?, ?)";

	@Override
	public void addPhoto(final Photo photo) throws Exception {

		final File blobIn = photo.getBlogImage();
		final InputStream blobIs = new FileInputStream(blobIn);

		final File clobIn = photo.getClobImage();
		final InputStream clobIs = new FileInputStream(clobIn);
		final InputStreamReader clobReader = new InputStreamReader(clobIs);

		jdbcTemplate.execute(SQL_INSERT_PHOTO, new AbstractLobCreatingPreparedStatementCallback(null) {
			protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException {
				ps.setLong(1, photo.getPhotoId());
				lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int) clobIn.length());
				lobCreator.setBlobAsBinaryStream(ps, 3, blobIs, (int) blobIn.length());
			}
		});
		blobIs.close();
		clobReader.close();

	}
}