package com.geekster.JobPortal.service;

import com.geekster.JobPortal.model.Job;
import com.geekster.JobPortal.model.JobType;
import com.geekster.JobPortal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) throws ChangeSetPersister.NotFoundException {
        return jobRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
    public List<Job> getJobsByLocation(String location) {
        return jobRepository.findByLocation(location);
    }
    public List<Job> getJobsByJobType(JobType jobType) {
        return jobRepository.findByJobType(jobType);
    }
    public List<Job> getJobsByCompanyName(String companyName) {
        return jobRepository.findByCompanyName(companyName);
    }
    public List<Job> getAllJobs() {
        return (List<Job>) jobRepository.findAll();
    }
}