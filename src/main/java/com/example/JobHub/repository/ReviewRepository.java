package com.example.JobHub.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JobHub.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Find all reviews for a specific company
    List<Review> findByCompanyId(Long companyId);

    // Find a specific review by ID and company ID
    Optional<Review> findByIdAndCompanyId(Long id, Long companyId);
}

