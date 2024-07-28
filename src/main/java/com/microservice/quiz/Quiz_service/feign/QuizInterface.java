package com.microservice.quiz.Quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservice.quiz.Quiz_service.Bean.QuestionWrapper;
import com.microservice.quiz.Quiz_service.Bean.ValidationResponse;



@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
	@GetMapping("question/createID")//quiz/create?category=Java&noOfQuestions=5&title=HelloWorld
	public ResponseEntity<Iterable<Integer>> createQuestionsIDForQuiz(@RequestParam String category,@RequestParam Integer noOfQuestions);//,@RequestParam String title);
	@PostMapping("question/createQuestions")
	//quiz/create?category=Java&noOfQuestions=5&title=HelloWorld
	public ResponseEntity<List<QuestionWrapper>> createQuestionsForQuiz(@RequestBody Iterable<Integer> questionId);//,@RequestParam String title);
	@PostMapping("question/getResult")
	public ResponseEntity<Integer> getResult(@RequestBody List<ValidationResponse> response);
}
