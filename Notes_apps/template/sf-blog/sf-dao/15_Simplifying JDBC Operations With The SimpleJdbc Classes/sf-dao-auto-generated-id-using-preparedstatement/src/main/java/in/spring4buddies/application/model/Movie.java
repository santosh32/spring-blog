package in.spring4buddies.application.model;

public class Movie {

	private long id;
	private String title;
	private String director;
	private String genre;
	private String raiting;
	private String boxOffice;

	public Movie() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRaiting() {
		return raiting;
	}

	public void setRaiting(String raiting) {
		this.raiting = raiting;
	}

	public String getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(String boxOffice) {
		this.boxOffice = boxOffice;
	}

	public Movie(long id, String title, String director, String genre, String raiting, String boxOffice) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.raiting = raiting;
		this.boxOffice = boxOffice;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", director=" + director + ", genre=" + genre + ", raiting=" + raiting + ", boxOffice=" + boxOffice
				+ "]";
	}

}