package pks.example.modernize.util.quartz;

import java.util.ArrayList;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


// not gonna work 'cause quartz creates the new class to run it....
public class JobSet extends ArrayList<Job> implements Job {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		for (Job job : this) {
			job.execute(context);
		}
	}
}
