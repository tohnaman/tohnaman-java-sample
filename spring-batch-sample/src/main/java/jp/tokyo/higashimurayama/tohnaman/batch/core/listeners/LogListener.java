package jp.tokyo.higashimurayama.tohnaman.batch.core.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class LogListener implements JobExecutionListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogListener.class);

	@Override
	public void beforeJob(JobExecution jobExecution) {
		LOGGER.info("\n----- はじめ -----");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		LOGGER.info("\n----- おわり -----");
	}
}
