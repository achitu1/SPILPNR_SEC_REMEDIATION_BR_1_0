package emailhashmap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContXMLMethods {


	  public static void SpringApplicationContextExample()
	  {
		  System.out.println("<<--Calling SpringApplicationContextExample-->>");
	ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");  
	SingletonListBean SL = (SingletonListBean) context.getBean("SingletonListBean");
	SL.printBean();

	    // open/read the application context file
	/*    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SingletonListBean SLB = (SingletonListBean) ctx.getBean("SingletonListBean");
		SLB.printBean();
*/

	  }
	
}
