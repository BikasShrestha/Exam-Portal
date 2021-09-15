package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
