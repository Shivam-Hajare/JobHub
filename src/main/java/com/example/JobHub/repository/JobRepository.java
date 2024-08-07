package com.example.JobHub.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JobHub.entity.Job;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    // Custom query to find all jobs by company ID
    List<Job> findByCompanyId(Long companyId);
}

