package cst438;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

// Contains variables/annotations corresponding to form elements 
@Entity
public class MovieRating {

	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=3, max=25)
	private String title;
	
	@NotNull
	@Min(1)
	@Max(5)
	private int rating;

	@NotNull
	@Size(min=3, max=25)
	private String userName;
	
	private String date = new java.util.Date().toString();

	// Transient makes element non-persistent, not added to DB
	@Transient
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	private String time = java.time.LocalTime.now().format(formatter).toString();



	public MovieRating() {
		
	}
	
	public MovieRating(long id, String title, int rating, String userName, String date, String time) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.userName = userName;
		this.date = date;
		this.time = time;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}	
	
	
}
