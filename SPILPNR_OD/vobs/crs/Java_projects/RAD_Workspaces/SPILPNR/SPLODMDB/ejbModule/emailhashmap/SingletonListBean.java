package emailhashmap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingletonListBean {
	private String userId;
	private String flightNumber;
	private String depDate;
	private String depAirport;
	private String email;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDepDate() {
		return depDate;
	}
	public void setDepDate(String depDate) {
		this.depDate = depDate;
	}
	public String getDepAirport() {
		return depAirport;
	}
	public void setDepAirport(String depAirport) {
		this.depAirport = depAirport;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void printBean() {
			System.out.println( " Email: "
					+ email + " Dep. Airport Code: "
					+ depAirport + " Flight Number: "
					+ flightNumber + " Dep Date: "
					+ depDate);
		
	}
	public void updateSpringBean() {
	ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");  
	SingletonListBean SL = (SingletonListBean) context.getBean("SingletonListBean");
	SL.setDepAirport("ATL");
	SL.setDepDate("FEB28");
	SL.setFlightNumber("9999");
	SL.setEmail("Alex@google.com");
	SL.printBean();
	}
}
