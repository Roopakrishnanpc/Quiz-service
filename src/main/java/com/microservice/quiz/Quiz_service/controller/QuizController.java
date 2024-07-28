package com.microservice.quiz.Quiz_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.quiz.Quiz_service.Bean.QuestionWrapper;
import com.microservice.quiz.Quiz_service.Bean.ValidationResponse;
import com.microservice.quiz.Quiz_service.DTO.QuizDto;
import com.microservice.quiz.Quiz_service.service.QuizService;




@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	QuizService quizService;
	@GetMapping("/create")//quiz/create?category=Java&noOfQuestions=5&title=HelloWorld
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto)
	{
			return quizService.createQuiz(quizDto.getCategory(),quizDto.getNoOfQuestions(),quizDto.getTitle());
	}
	@GetMapping("/getQuiz/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id)
	{
			return quizService.getQuizQuestions(id);
	}
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<ValidationResponse> validationrespone)
	{
			return quizService.submitQuizAndValidation(id,validationrespone);
	}
}
