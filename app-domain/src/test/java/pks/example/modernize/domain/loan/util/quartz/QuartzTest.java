package pks.example.modernize.domain.loan.util.quartz;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.quartz.DateBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuartzTest {
	static Logger log_tst = LoggerFactory.getLogger(QuartzTest.class);

	@BeforeEach
	public void setUp() {}

	@AfterEach
	public void tearDown() {}

	/**
	 * This shows that the job executions that are ready to run are still sorted
	 * deterministically by the trigger key <group>.<name> with the default group
	 * sorted lower.  This enables the use of quartz as a basic sequential job
	 * queue in additional to the use as a scheduler.
	 */
	@Test
	public void simpleQuartzTest() {

		Scheduler scheduler = null;
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			// scheduler.standby();

			Date toStart = DateBuilder.evenSecondDateAfterNow();
			for ( int i = 0; i < 25; i++ ) {
				JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("HELLO-" + String.valueOf(i)).build();
				Trigger tgr = TriggerBuilder.newTrigger().withIdentity(UUID.randomUUID().toString()).startAt(toStart).build();
				scheduler.scheduleJob(job, tgr);
			}

			// scheduler.start();

			try {
				Thread.sleep(45L * 1000L);
			} catch (Exception ex) {
				log_tst.error("Squawk: " + ex.getMessage());
			}

			scheduler.shutdown();

		} catch (SchedulerException qse) {

		} finally {

		}
	}
}
