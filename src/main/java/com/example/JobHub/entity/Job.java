package com.example.JobHub.entity;

import jakarta.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private String salary;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description=" + description + ", location=" + location
				+ ", salary=" + salary + ", company=" + company + "]";
	}

	public Job(Long id, String title, String description, String location, String salary, Company company) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
		this.salary = salary;
		this.company = company;
	}

	public Job() {
		super();
	}
    
}
