package in.spring4buddies.application.model;

import java.io.File;

public class Photo {

	private long photoId;
	private File clobImage;
	private File blogImage;

	public Photo() {
	}

	public Photo(long photoId, File clobImage, File blogImage) {
		super();
		this.photoId = photoId;
		this.clobImage = clobImage;
		this.blogImage = blogImage;
	}

	public long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(long photoId) {
		this.photoId = photoId;
	}

	public File getClobImage() {
		return clobImage;
	}

	public void setClobImage(File clobImage) {
		this.clobImage = clobImage;
	}

	public File getBlogImage() {
		return blogImage;
	}

	public void setBlogImage(File blogImage) {
		this.blogImage = blogImage;
	}

	@Override
	public String toString() {
		return "Photo [photoId=" + photoId + ", clobImage=" + clobImage + ", blogImage=" + blogImage + "]";
	}

}