package com.example.JobHub.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JobHub.entity.Company;
import com.example.JobHub.entity.Review;
import com.example.JobHub.exception.ResourceNotFoundException;
import com.example.JobHub.repository.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviewsByCompanyId(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    public Optional<Review> getReviewById(Long companyId, Long reviewId) {
        return reviewRepository.findByIdAndCompanyId(reviewId, companyId);
    }

    public Review createReview(Long companyId, Review review) {
        review.setCompany(new Company(companyId)); // assuming Company class has a constructor accepting ID
        return reviewRepository.save(review);
    }

    public void deleteReview(Long companyId, Long reviewId) {
        reviewRepository.findByIdAndCompanyId(reviewId, companyId).ifPresent(reviewRepository::delete);
    }

    public Review updateReview(Long companyId, Long reviewId, Review reviewDetails) {
        return reviewRepository.findByIdAndCompanyId(reviewId, companyId).map(review -> {
            review.setComment(reviewDetails.getComment());
            review.setRating(reviewDetails.getRating());
            return reviewRepository.save(review);
        }).orElseThrow(() -> new ResourceNotFoundException("Review not found"));
    }
}
