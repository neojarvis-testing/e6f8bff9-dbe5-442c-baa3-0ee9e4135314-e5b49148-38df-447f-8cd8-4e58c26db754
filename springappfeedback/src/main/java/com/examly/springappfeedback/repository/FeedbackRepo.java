package com.examly.springappfeedback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springappfeedback.model.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Long> {

    List<Feedback> findByUser_UserId(Long userId);
        
}
