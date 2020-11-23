package com.test.job.conf;

import javax.sql.DataSource;

import org.jobrunr.configuration.JobRunr;
import org.jobrunr.dashboard.JobRunrDashboardWebServer;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.server.JobActivator;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.sql.common.SqlStorageProviderFactory;
import org.jobrunr.utils.mapper.JsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration {

	// The`spring-boot-starter-web` provides Jackson as JobMapper
//	@Bean
//	public JobScheduler initJobRunr(DataSource dataSource, JobActivator jobActivator) {
	// JobRunr.configure()
//	    .useStorageProvider(new DefaultSqlStorageProvider(dataSource, DatabaseOptions.SKIP_CREATE))
//	    .useDefaultBackgroundJobServer()
//	    .initialize();

//		return JobRunr.configure().useStorageProvider(SqlStorageProviderFactory.using(dataSource))
//				.useJobActivator(jobActivator).useDefaultBackgroundJobServer().useDashboard().initialize();
//	}

}
