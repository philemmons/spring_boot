package com.amigoscode.demo.comic;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//  mapping the class to a table in the database
@Entity
@Table
public class Comic {
	// note - class type for Long, Integer, and Boolean
	@Id
	@SequenceGenerator(
			name= "comic_sequence",
			sequenceName = "comic_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "comic_sequence"
	)
	private Long id;
	private String title;
	private LocalDate publishDate;
	private Integer issue;
	private Boolean significant;
	
	public Comic() {
	}

	public Comic(Long id, String title, LocalDate publishDate, Integer issue, Boolean significant) {
		this.id = id;
		this.title = title;
		this.publishDate = publishDate;
		this.issue = issue;
		this.significant = significant;
	}

	public Comic(String title, LocalDate publishDate, Integer issue, Boolean significant) {
		this.title = title;
		this.publishDate = publishDate;
		this.issue = issue;
		this.significant = significant;
	}

	@Override
	public String toString() {
		return "Comic [id=" + id + 
				", title=" + title + 
				", publishDate=" + publishDate + 
				", issue=" + issue
				+ ", significant=" + significant + 
				"]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public Integer getIssue() {
		return issue;
	}

	public void setIssue(Integer issue) {
		this.issue = issue;
	}

	public Boolean getSignificant() {
		return significant;
	}

	public void setSignificant(Boolean significant) {
		this.significant = significant;
	}
}