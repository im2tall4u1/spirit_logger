package com.example.spirits.spirits.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spirits.spirits.model.Review;
import com.example.spirits.spirits.repository.ReviewRepository;

@CrossOrigin()
@RestController
public class ReviewController {
    @Autowired
    ReviewRepository reviewRepository;

    @ResponseBody
    @RequestMapping(value="/review", method=RequestMethod.POST)
    public ResponseEntity<Review> addReview(@RequestBody Review review){
        Review r = reviewRepository.save(review);
        return new ResponseEntity<Review>(r, HttpStatus.CREATED);
    }

    @RequestMapping(value="/review", method=RequestMethod.GET)
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> r = reviewRepository.findAll();
        return new ResponseEntity<List<Review>>(r, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/review/{reviewId}", method=RequestMethod.GET)
    public ResponseEntity<Review> getSingularReview(@PathVariable String reviewId){
        Optional<Review> r = reviewRepository.findById(Integer.parseInt(reviewId));
        return new ResponseEntity<Review>(r.get(), HttpStatus.ACCEPTED);
    }
}
