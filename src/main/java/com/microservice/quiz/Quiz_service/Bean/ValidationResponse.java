package com.microservice.quiz.Quiz_service.Bean;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@Getter
@RequiredArgsConstructor
public class ValidationResponse {
	private Integer id;
	private String result;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "ValidationResponse [id=" + id + ", result=" + result + "]";
	}
	public ValidationResponse(Integer id, String result) {
		super();
		this.id = id;
		this.result = result;
	}

	
}
