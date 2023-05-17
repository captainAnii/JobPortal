package com.geekster.JobPortal.controller;

import com.geekster.JobPortal.model.Job;
import com.geekster.JobPortal.model.JobType;
import com.geekster.JobPortal.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping(value = "/addJob")
    public Job createJob(@Valid @RequestBody Job job) {
        return jobService.saveJob(job);
    }

    @GetMapping("/{id}")
    public Job getJob(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return jobService.getJobById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/byLocation")
    public List<Job> getJobsByLocation(@RequestParam("location") String location) {
        return jobService.getJobsByLocation(location);
    }
    @GetMapping("/byJobType")
    public List<Job> getJobsByJobType(@RequestParam("jobType") JobType jobType) {
        return jobService.getJobsByJobType(jobType);
    }

    @GetMapping("/byCompanyName")
    public List<Job> getJobsByCompanyName(@RequestParam("companyName") String companyName) {
        return jobService.getJobsByCompanyName(companyName);
    }
    @GetMapping("/getAllJobs")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }
}