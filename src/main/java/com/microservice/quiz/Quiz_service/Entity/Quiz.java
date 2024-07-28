package com.microservice.quiz.Quiz_service.Entity;

import jakarta.persistence.ElementCollection;


import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
//@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String category;
	@Transient
	//@Access(AccessType.FIELD)
	private Integer noOfQuestions;
	private String title;
//	@ManyToMany
//	private List<Question> question;
	@ElementCollection
	private List<Integer> questionID;

	
//	public Quiz(Integer id, String category, Integer noOfQuestions, String title) {//, List<Question> question) {
//		super();
//		this.id = id;
//		this.category = category;
//		this.noOfQuestions = noOfQuestions;
//		this.title = title;
//		//this.question = question;
//	}
	
//	@Override
//	public String toString() {
//		return "Quiz [id=" + id + ", category=" + category + ", noOfQuestions=" + noOfQuestions + ", title=" + title
//				+ "]";
//	}

//	public Quiz(Integer id, String category, Integer noOfQuestions, String title, Iterable<Integer> questionID) {
//		super();
//		this.id = id;
//		this.category = category;
//		this.noOfQuestions = noOfQuestions;
//		this.title = title;
//		this.questionID = questionID;
//	}

//	public List<Question> getQuestion() {
//		return question;
//	}
//	public void setQuestion(List<Question> question) {
//		this.question = question;
//	}
	
}
