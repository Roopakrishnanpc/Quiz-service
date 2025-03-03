package com.microservice.quiz.Quiz_service.Bean;

public class QuestionWrapper {
	private Integer id;
    private String questionTitle;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getChoice1() {
		return choice1;
	}
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}
	public String getChoice2() {
		return choice2;
	}
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}
	public String getChoice3() {
		return choice3;
	}
	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}
	public String getChoice4() {
		return choice4;
	}
	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}
	@Override
	public String toString() {
		return "QuestionWrapper [questionTitle=" + questionTitle + ", choice1=" + choice1 + ", choice2=" + choice2
				+ ", choice3=" + choice3 + ", choice4=" + choice4 + "]";
	}
	public QuestionWrapper(int id, String questionTitle, String choice1, String choice2, String choice3, String choice4) {
		super();
		this.id=id;
		this.questionTitle = questionTitle;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
	}
	public QuestionWrapper(String questionTitle, String choice1, String choice2, String choice3, String choice4) {
		super();
		//this.id=id;
		this.questionTitle = questionTitle;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
	}
	public QuestionWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
}
