/**
 * 
 */
package com.delta.jobs;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author f77219
 * 
 */
public class CreditCardSchedular {

	SchedulerFactory sf = new StdSchedulerFactory();
	private int startHour = 16;// 8pm
	private int startMinute = 07;// 8pm
	private int startSecond = 00;// 8pm

	/**
	 * 
	 */
	public CreditCardSchedular() {

	}

	public void startCreditCardSchedular() {

		try {
			System.out
					.println("In CreditCardSchedular - startCreditCardSchedular()");
			Scheduler sched = sf.getScheduler();
			JobDetail jd = new JobDetail("myjob", Scheduler.DEFAULT_GROUP,
					CreditCardEncryptorJob.class);
			if (!sched.isStarted()) {

				Date startTime = null;
				Calendar now = Calendar.getInstance();
				Calendar cal = new GregorianCalendar(now.get(Calendar.YEAR),now.get(Calendar.MONTH)
						,now.get(Calendar.DATE));
				cal.set(Calendar.HOUR, startHour);
				cal.set(Calendar.MINUTE, startMinute);
				cal.set(Calendar.SECOND, startSecond);
				startTime = cal.getTime();
				System.out
				.println("Job will start at "+startTime);
//				SimpleTrigger st = new SimpleTrigger("mytrigger",
//						Scheduler.DEFAULT_GROUP, startTime, null, 0, 0L);
				
				SimpleTrigger st = new SimpleTrigger("mytrigger",
						Scheduler.DEFAULT_GROUP, new Date(), null, 0, 0L);
				
				sched.scheduleJob(jd, st);
				sched.start();

			} else if (sched.isPaused()) {

				sched.resumeJob("myjob", "mytrigger");
			}
		} catch (SchedulerException se) {
			se.printStackTrace();
		}

	}

	public void stopCreditCardSchedular() {

		SchedulerFactory sf = new StdSchedulerFactory();
		try {
			Scheduler sched = sf.getScheduler();

			if (sched.isStarted()) {
				JobDetail jd = new JobDetail("myjob", Scheduler.DEFAULT_GROUP,
						CreditCardEncryptorJob.class);
				Thread.sleep(3000L);
				System.out.println("Job is stopping....");
				sched.pauseJob(jd.getName(), jd.getGroup());
				sched.deleteJob(jd.getName(), jd.getGroup());
				sched.shutdown();
				// sched.interrupt(jd.getName(), jd.getGroup());
			}
		} catch (SchedulerException se) {
			se.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Job has been interrupted");
		}

	}
}
