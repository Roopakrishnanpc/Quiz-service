package com.microservice.quiz.Quiz_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.quiz.Quiz_service.Bean.QuestionWrapper;
import com.microservice.quiz.Quiz_service.Bean.ValidationResponse;
import com.microservice.quiz.Quiz_service.DAO.QuizDao;
import com.microservice.quiz.Quiz_service.DTO.QuizDto;
import com.microservice.quiz.Quiz_service.Entity.Quiz;
import com.microservice.quiz.Quiz_service.feign.QuizInterface;


@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;

	@Autowired
	QuizInterface quizInterface;
    public ResponseEntity<String> createQuiz(String category,int noOfQuestions, String title) {
        try {
          //  RestTemplate template;
        	//getbody - rersponseentity 
            List<Integer> questions = (List<Integer>) quizInterface.createQuestionsIDForQuiz(category, noOfQuestions).getBody();
            //generalte url - RestTemplate
            
            if (!questions.iterator().hasNext()) {
                return new ResponseEntity<>("No questions available for the category.", HttpStatus.BAD_REQUEST);
            }

           
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setCategory(category);
            quiz.setQuestionID(questions); 

          
            quizDao.save(quiz);

            return new ResponseEntity<>("Quiz created successfully with title: " + title, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the error and return a 500 Internal Server Error status
            e.printStackTrace();
            return new ResponseEntity<>("An error occurred while creating the quiz.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer questionId){//(int id) {
        // Fetch the quiz by id
        Quiz optionalQuiz = quizDao.findById(questionId).get();

        // Check if the quiz is present
        if (optionalQuiz==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Retrieve questions from the quiz
       // Quiz quiz=optionalQuiz.get();
        Iterable<Integer> questionIds = optionalQuiz.getQuestionID();
        // Convert to QuestionWrapper list because we are displaying oly questiontitle choices to user
        //but question will have everything
        ResponseEntity<List<QuestionWrapper>> questions =  quizInterface.createQuestionsForQuiz(questionIds);
 


        // Return response entity with the list of QuestionWrapper
        return questions;
    }
	public ResponseEntity<Integer> submitQuizAndValidation(int id, List<ValidationResponse> validationrespone) {
		// TODO Auto-generated method stub
		try {
		
		//getting questions for each id from quiz
		ResponseEntity<Integer> result =quizInterface.getResult(validationrespone);
		
		return result;
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		
			return new ResponseEntity<>(400, HttpStatus.BAD_REQUEST);
		}
	}

}
