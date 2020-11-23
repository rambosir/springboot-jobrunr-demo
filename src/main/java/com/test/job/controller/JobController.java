package com.test.job.controller;

import java.time.Duration;
import java.time.Instant;

import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.job.service.SampleJobService;

@RestController
public class JobController {

	@Autowired
	private JobScheduler jobScheduler;

	@Autowired
	private SampleJobService sampleJobService;

	@GetMapping("/run-job")
	public String runJob(@RequestParam(value = "name", defaultValue = "Hello World") String name) {

		jobScheduler.enqueue(() -> sampleJobService.execute(name));
		return "Job is enqueued.";

	}

	@GetMapping("/schedule-job")
	public String scheduleJob(@RequestParam(value = "name", defaultValue = "Hello World") String name,
			@RequestParam(value = "when", defaultValue = "PT3H") String when) {

		jobScheduler.schedule(() -> sampleJobService.execute(name), Instant.now().plus(Duration.parse(when)));

		return "Job is scheduled.";
	}

	@GetMapping("/schedule-job-cron")
	public String scheduleJobCron(@RequestParam(value = "name", defaultValue = "Hello World") String name,
			@RequestParam(value = "when", defaultValue = "PT3H") String when) {

		jobScheduler.scheduleRecurrently(() -> sampleJobService.execute(name), "0 * * * * *");

		// CronExpression.create(cron)

		return "Job is scheduled.";
	}

}
