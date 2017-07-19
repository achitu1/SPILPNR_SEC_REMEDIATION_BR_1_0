/*
 * Created on Dec 14, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.delta.SPLJ.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.delta.PNRJ.helper.PNRJUtil;
import com.nwa.PRA.logger.Logger;

/**
 * @author jra
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SPLJUtil {
	public static String formatDate(String value) {

		String result = null;
		
		if(value == null) {
			return null;
		}
		
		value = value.replace('-', '/');
		Logger.log(PNRJUtil.class, Logger.LEVEL_DEBUG, "value = [" + value + "]");
		
		try {
			SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yy");
			//SimpleDateFormat formatter2 = new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
			formatter1.setLenient(false);
			formatter2.setLenient(false);

			Date date = formatter1.parse(value);
			result = formatter2.format(date);
		}
		catch(Exception e) {
			Logger.log(PNRJUtil.class, Logger.LEVEL_ERROR, e.getMessage());
		}
		
		return result;
//		String yearMonthDay = "";
//		
//		// MM-DD-CCYY
//		if (value.length() > 0) {
//			String year = value.substring(6);
//			String month = value.substring(0, 2);
//			String day = value.substring(3, 5);
//			
//			yearMonthDay = year + "-" + month + "-" + day;
//		} 
//		Logger.log(SPLJUtil.class, Logger.LEVEL_DEBUG, "YEARMONTHDAY=" + yearMonthDay);
//		// CCYY-MM-DD
//		return yearMonthDay;
	}
}
