/**
 * 
 */
package com.delta.jobs;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author f77219
 * 
 */
public class CreditCardEncryptorJob implements Job {

	/**
	 * 
	 */
	

	public CreditCardEncryptorJob() {

	}

	public void execute(JobExecutionContext context)
			throws JobExecutionException {

		System.out.println("Credit card Encryption job started at : "
				+ new Date());
		//Call servlet to process the requests.
		
		URL aURL;
		try {
			aURL = new URL("http://crsi11.delta.com:17243/SPIL/CreditCardEncryptorSOAServlet");
		  
		URLConnection aConnection = aURL.openConnection();   
		aConnection.setDoInput(true);   
		aConnection.setDoOutput(true);   
		aConnection.setUseCaches(false);   
		aConnection.setDefaultUseCaches(false);   
		aConnection.setRequestProperty("Content-Type","application/octet-stream");   
		 
		ObjectOutputStream out = new ObjectOutputStream(aConnection   
		.getOutputStream());   
		out.flush();   
		out.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}	
}
