package com.example.JobHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.JobHub.entity.Review;
import com.example.JobHub.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getReviewsByCompanyId(@PathVariable Long companyId) {
        List<Review> reviews = reviewService.getReviewsByCompanyId(companyId);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return reviewService.getReviewById(companyId, reviewId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@PathVariable Long companyId, @RequestBody Review review) {
        Review createdReview = reviewService.createReview(companyId, review);
        return ResponseEntity.ok(createdReview);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review reviewDetails) {
        return ResponseEntity.ok(reviewService.updateReview(companyId, reviewId, reviewDetails));
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        reviewService.deleteReview(companyId, reviewId);
        return ResponseEntity.ok().build();
    }
}
