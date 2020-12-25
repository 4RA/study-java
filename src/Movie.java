import java.awt.Image;

public class Movie extends Item {
		private String director;	//감독
		private String actor;		//배우
		private String genre;		//장르
		private String grade;		//등급	
		
		public Movie(String name, int star, String summary,String comments, int openYear,
				String director, String actor, String genre, String grade) {
		super(name, star, summary,comments, openYear);
		this.director = director;
		this.actor = actor;
		this.grade = grade;
		this.genre = genre;
	}

		public String getDirector() {
			return director;
		}

		public void setDirector(String director) {
			this.director = director;
		}

		public String getActor() {
			return actor;
		}

		public void setActor(String actor) {
			this.actor = actor;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}
}