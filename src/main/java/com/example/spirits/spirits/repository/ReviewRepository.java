package com.example.spirits.spirits.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spirits.spirits.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    public Review save(Review review);
    public Optional<Review> findById(int reviewId);
    public List<Review> findAll();
}
