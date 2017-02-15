package in.spring4buddies.application.model;

import java.io.File;

public class Photo {
	
	private long photoId;
	private File userProfile;
	private File userImage;

	public Photo() {
	}

	public Photo(long photoId, File userProfile, File userImage) {
		super();
		this.photoId = photoId;
		this.userProfile = userProfile;
		this.userImage = userImage;
	}

	public long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(long photoId) {
		this.photoId = photoId;
	}

	public File getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(File userProfile) {
		this.userProfile = userProfile;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	@Override
	public String toString() {
		return "Photo [photoId=" + photoId + ", userProfile=" + userProfile + ", userImage=" + userImage + "]";
	}

}