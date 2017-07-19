package ejbs;

//import emailhashmap.AppContXMLMethods;
/*import emailhashmap.A;
import emailhashmap.B;
import emailhashmap.SingletonListBean;*/
import genMethods.GenMethods;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.jms.BytesMessage;
import javax.jms.JMSException;

import parsers.Parsers;

import DAO.SPLDAO;
import Objects.Passenger;
import Objects.Waitlist;
/**
 * Bean implementation class for Enterprise Bean: MDBBean
 */

public class MDBBeanBean implements javax.ejb.MessageDrivenBean,
		javax.jms.MessageListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.ejb.MessageDrivenContext fMessageDrivenCtx;

	/**
	 * getMessageDrivenContext
	 */
	public javax.ejb.MessageDrivenContext getMessageDrivenContext() {
		return fMessageDrivenCtx;
	}

	/**
	 * setMessageDrivenContext
	 */
	public void setMessageDrivenContext(javax.ejb.MessageDrivenContext ctx) {
		fMessageDrivenCtx = ctx;
	}

	/**
	 * ejbCreate
	 */
	public void ejbCreate() {
	}

	/**
	 * onMessage
	 */

	public void onMessage(javax.jms.Message msg) {
		try {
			if (msg instanceof javax.jms.TextMessage) {
				System.out.println(((javax.jms.TextMessage) msg).getText());
			} else if (msg instanceof javax.jms.BytesMessage) {

				BytesMessage byteMsg = (BytesMessage) msg;
				int len = 0;
				try {
					len = (int) byteMsg.getBodyLength();
				} catch (JMSException e) {
					// e.printStackTrace();
					System.err.print("JMS Excetion onMessage.");
				}

				byte[] msgBytes = new byte[len];

				try {
					byteMsg.readBytes(msgBytes);
				} catch (JMSException e) {
					e.printStackTrace();
				}

				String s = new String(msgBytes);
			//	System.out.println(s);

				ArrayList<Passenger> pAR = new ArrayList<Passenger>();
				ArrayList<Waitlist> wL = new ArrayList<Waitlist>();

				/////
				
				String lookForFlightInfoStreamString = "F|";
				int flightPositionInt = s.indexOf(lookForFlightInfoStreamString);
				s = s.substring(flightPositionInt-2);
				
				////
				
				ArrayList<String> list = new ArrayList<String>(Arrays.asList(s
						.split("\\|")));

				// passenger table parse/load

				pAR = parsers.Parsers.parsePassengerToObjects(list);

				for (int i = 0; i < pAR.size(); i++) {
				//	GenMethods.printPassenger(pAR.get(i));
				}

				java.sql.Date sqlDate = new java.sql.Date(
						new java.util.Date().getTime());

				Timestamp ts = null;
				try {
					ts = GenMethods.timeZonetoEST();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}// null;

				// ts = new java.sql.Timestamp(new
				// java.util.Date().getTime());// FILE_RCVD_LTS
				try {
					System.out.println("PassArrayDB2Load attempting..");
					SPLDAO.PassArrayDB2Load(pAR, ts, sqlDate.toString());
				} catch (SQLException e) {
					System.err
							.print("SQL EXCEPTION in PassArrayDB2Load method.");
					// e.printStackTrace();
				}
				try {
					SPLDAO.loadRemarkstoDB2(pAR, sqlDate.toString(), ts);
				} catch (SQLException e) {
					System.err.print("SQL EXCEPTION IN REMARKS");

					// e.printStackTrace();
				}
				wL = Parsers.waitlistListLoad(list);// , ts);

				if (!wL.isEmpty()) {
					for (int i = 0; i < wL.size(); i++) {
				//		GenMethods.printWaitlist(wL.get(i));
					}
				}
				if (!wL.isEmpty()) {
					try {
					//	System.out.println("WL Loading...");
						SPLDAO.PassArrayDB2LoadWL(wL, ts, sqlDate.toString());
					} catch (SQLException e) {
						System.err.print("SQL EXCEPTION IN WL");
						// e.printStackTrace();
					}
				}

				System.out.println(" WL Complete.");

				// //////

			} else {
				System.out.println("Unknown Message Type. ");
			}

		} catch (javax.jms.JMSException e) {
			System.out.println(" MDB: Error occurred ");
			e.printStackTrace();
		}
	}

	/**
	 * ejbRemove
	 */
	public void ejbRemove() {
	}

}
