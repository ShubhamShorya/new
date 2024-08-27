package com.example.app;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="Materialmodel")
public class Materialmodel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String bookname;
	private String category;
	private String subject;
	private String subjectcode;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String pdf;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSubjectcode() {
		return subjectcode;
	}
	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	
//	@Override
//	public String toString() {
//		return "Event [id=" + id + ", eventname=" + eventname + ", description=" 
//	            + description + ", eventday=" + eventday + ", image="
//				+ image + "]";
//	}
	

}
