package com.example.JobHub.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JobHub.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    // Custom queries can be added here if needed
}

