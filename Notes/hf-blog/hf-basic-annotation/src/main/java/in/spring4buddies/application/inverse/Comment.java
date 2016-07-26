package in.spring4buddies.application.inverse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENT")
public class Comment {

	@Id
	@Column(name = "comment_id", unique = true, nullable = false)
	@SequenceGenerator(name = "seq", sequenceName = "comment_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private long id;

	@Column(name = "comment_name")
	private String commentName;

	@Column(name = "comment_desc")
	private String commentDesc;

	@ManyToOne(fetch = FetchType.LAZY)
	// @PrimaryKeyJoinColumn
	private Blog blog;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommentName() {
		return commentName;
	}

	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}

	public String getCommentDesc() {
		return commentDesc;
	}

	public void setCommentDesc(String commentDesc) {
		this.commentDesc = commentDesc;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commentDesc == null) ? 0 : commentDesc.hashCode());
		result = prime * result
				+ ((commentName == null) ? 0 : commentName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (commentDesc == null) {
			if (other.commentDesc != null)
				return false;
		} else if (!commentDesc.equals(other.commentDesc))
			return false;
		if (commentName == null) {
			if (other.commentName != null)
				return false;
		} else if (!commentName.equals(other.commentName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", commentName=" + commentName
				+ ", commentDesc=" + commentDesc + "]";
	}
}