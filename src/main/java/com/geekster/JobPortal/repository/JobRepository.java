package com.geekster.JobPortal.repository;
import com.geekster.JobPortal.model.Job;
import com.geekster.JobPortal.model.JobType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {
    // No additional methods required for basic CRUD operations
    List<Job> findByLocation(String location);
    List<Job> findByJobType(JobType jobType);
    List<Job> findByCompanyName(String companyName);
}