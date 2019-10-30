package com.springDemo.banquespringbatch.web;

import com.springDemo.banquespringbatch.BankTransactionItemAnalyticsProcessor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JobRestController {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private BankTransactionItemAnalyticsProcessor bankTransactionItemAnalyticsProcessor;
    @Autowired
    private Job job;
    @GetMapping("/startJob")
    public BatchStatus load()  throws Exception{
        Map<String, JobParameter>  params= new HashMap<>();
        params.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(params);
        JobExecution jobExecution=jobLauncher.run(job, jobParameters);

        while (jobExecution.isRunning()) {
            System.out.println("..........");
        }
        return jobExecution.getStatus();

    }
    @GetMapping("/analytics")
    public Map<String,Double> analytics() {
        Map<String,Double> map=new HashMap<>();
        map.put("totalCredit", bankTransactionItemAnalyticsProcessor.getTotalCredit());
        map.put("totalDebit", bankTransactionItemAnalyticsProcessor.getTotalDebit());
    return map;
    }
}
