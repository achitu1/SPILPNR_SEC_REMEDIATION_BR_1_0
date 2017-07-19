package emailhashmap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContXMLMethods {


	  public static void SpringApplicationContextExample()
	  {
		  try{System.out.println("<<--Calling SpringApplicationContextExample-->>");
	ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");  
	SingletonListBean SL = (SingletonListBean) context.getBean("SingletonListBean");
	SL.printBean();
		  }
		  catch(Throwable t){
			  System.out.println(t);
		  }
	    // open/read the application context file
		  try{
	    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SingletonListBean SLB = (SingletonListBean) ctx.getBean("SingletonListBean");
		SLB.printBean();
		  }
catch(Throwable t){
	System.out.println(t);
}
	  }
	
}
