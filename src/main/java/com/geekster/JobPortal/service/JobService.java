package com.geekster.JobPortal.service;

import com.geekster.JobPortal.model.Job;
import com.geekster.JobPortal.model.JobType;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface JobService {
    Job saveJob(Job job);
    Job getJobById(Long id) throws ChangeSetPersister.NotFoundException;
    void deleteJob(Long id);

    List<Job> getJobsByLocation(String location);

    List<Job> getJobsByJobType(JobType jobType);

    List<Job> getJobsByCompanyName(String companyName);

    List<Job> getAllJobs();

}