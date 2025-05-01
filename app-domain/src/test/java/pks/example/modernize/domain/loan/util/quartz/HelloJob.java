package pks.example.modernize.domain.loan.util.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloJob implements Job {
	static Logger log_tst = LoggerFactory.getLogger(HelloJob.class);

	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			log_tst.info("hello triggered by: " + context.getTrigger().getKey().toString());
			Thread.sleep(2000L);
		} catch (Exception ex) {
			JobExecutionException jxe = new JobExecutionException(ex.getMessage());
			throw jxe;
		}
	}
}
