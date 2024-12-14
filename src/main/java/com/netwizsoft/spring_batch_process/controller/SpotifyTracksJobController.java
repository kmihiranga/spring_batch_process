package com.netwizsoft.spring_batch_process.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
@Slf4j
public class SpotifyTracksJobController {

   private final JobLauncher jobLauncher;

   private final Job job;

   @PostMapping("/importData")
   public String jobLauncher() {

       final JobParameters jobParameters = new JobParametersBuilder()
               .addLong("startAt", System.currentTimeMillis()).toJobParameters();

       try {

           // launch the job
           final JobExecution jobExecution = jobLauncher.run(job, jobParameters);

           // return job status
           return jobExecution.getStatus().toString();

       } catch (JobInstanceAlreadyCompleteException | JobExecutionAlreadyRunningException
                | JobParametersInvalidException | JobRestartException exception) {
           log.error(exception.getMessage());
           exception.printStackTrace();
           return "Job failed with exception: " + exception.getMessage();
       }
   }
}
