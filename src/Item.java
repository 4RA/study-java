import java.awt.Image;
import java.io.Serializable;

public class Item implements Serializable {
	private String name;
	private int star ; 	//별점
	private String summary;
	private String comments;
	private int openYear;	//출판년도
	private Image img;		//포스터, 이미지
	public Item(String name, int star, String summary,String comments, int openYear) {
		this.name = name;
		this.star = star;
		this.summary = summary;
		this.openYear = openYear;
		this.comments = comments;
		//this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getOpenYear() {
		return openYear;
	}
	public void setOpenYear(int openYear) {
		this.openYear = openYear;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}


	
}
