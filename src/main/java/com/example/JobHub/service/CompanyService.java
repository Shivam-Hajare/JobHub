package com.example.JobHub.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JobHub.entity.Company;
import com.example.JobHub.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    public Company updateCompany(Long id, Company companyDetails) {
        return companyRepository.findById(id).map(company -> {
            company.setName(companyDetails.getName());
            company.setIndustry(companyDetails.getIndustry());
            company.setHeadquarters(companyDetails.getHeadquarters());
            return companyRepository.save(company);
        }).orElseGet(() -> {
            companyDetails.setId(id);
            return companyRepository.save(companyDetails);
        });
    }
}
