package com.example.JobHub.entity;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String industry;
    private String headquarters;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Job> jobs;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    public Company(Long companyId) {
		this.id = companyId;
	}

	// Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", industry=" + industry + ", headquarters=" + headquarters
				+ ", jobs=" + jobs + ", reviews=" + reviews + "]";
	}

	public Company(Long id, String name, String industry, String headquarters, List<Job> jobs, List<Review> reviews) {
		super();
		this.id = id;
		this.name = name;
		this.industry = industry;
		this.headquarters = headquarters;
		this.jobs = jobs;
		this.reviews = reviews;
	}

	public Company() {
		super();
	}
    
}
