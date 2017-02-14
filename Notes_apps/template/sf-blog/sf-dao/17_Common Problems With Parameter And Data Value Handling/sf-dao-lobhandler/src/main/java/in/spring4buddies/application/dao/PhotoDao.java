package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Photo;

public interface PhotoDao {

	Photo getById(long photoId) throws Exception;

}