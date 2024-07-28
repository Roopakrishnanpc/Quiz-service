package com.microservice.quiz.Quiz_service.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.quiz.Quiz_service.DTO.QuizDto;
import com.microservice.quiz.Quiz_service.Entity.Quiz;


@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {

	

}
