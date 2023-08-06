package com.simplilearn.hibernate.mapping.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ANSWER")
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "ANSWER")
	private String answer;
	
	@Column(name = "POSTER_NAME")
	private String posterName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getPosterName() {
		return posterName;
	}
	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}
	@Override
	public String toString() {
		return "Answer [id=" + id + ", answer=" + answer + ", posterName=" + posterName + "]";
	}
}
