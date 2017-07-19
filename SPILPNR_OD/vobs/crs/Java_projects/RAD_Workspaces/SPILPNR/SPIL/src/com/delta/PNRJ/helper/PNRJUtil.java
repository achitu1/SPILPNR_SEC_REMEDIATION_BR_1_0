package com.delta.PNRJ.helper;





import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Date;



import com.delta.PNRJ.actions.PNRJ002_LookupDefaultSubmitAction;

import com.nwa.PRA.logger.Logger;



public class PNRJUtil {



	//private static final String SERVICE_URL = "endpoint.url";

	public static String formatDate(String value) {

		

		String result = null;

		

		if(value == null) {

			return null;

		}

		

		value = value.replace('-', '/');

		Logger.log(PNRJUtil.class, Logger.LEVEL_DEBUG, "value = [" + value + "]");

		

		try {

			SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yy");

			SimpleDateFormat formatter2 = new SimpleDateFormat("MM/dd/yyyy");

			formatter1.setLenient(false);

			formatter2.setLenient(false);



			Date date = formatter1.parse(value);

			result = formatter2.format(date);

		}

		catch(Exception e) {

			Logger.log(PNRJUtil.class, Logger.LEVEL_ERROR, e.getMessage());

		}

		

		return result;

	}

	//written by Hari Somagatta to solve long PNR display issues.

	//If PNR has more than 100 lines display first hundred and last 900 lines only.

	public static ArrayList<String> displayPNRText1(int totalPnrLines, String pnrTextString){

		

		int posLoc = 0;

		int lines2Display =1000;

		int remainingLines = totalPnrLines - lines2Display;

		int firstFewLines =0;

		int noOfCharsPerline = 133;

		Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "Total number of lines :"+ totalPnrLines);

		Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "Max Lines that can display is:"+ lines2Display);

		ArrayList<String> pnrTextList = new ArrayList<String>();

		//If the number of lines are more than 1000, then get first 1000 lines only(for passenger information)

		if(remainingLines >0){

			//posLoc = (firstFewLines * noOfCharsPerline);

			firstFewLines =1000;

			//pnrTextList.add("******************** PNR HAS MORE THAN 1000 LINES, HENCE DISPLAYING FIRST 100 LINES AND LAST 900 LINES ONLY   ************************");

			pnrTextList.add("***PNR HAS MORE THAN 1000 LINES, DISPLAYING FIRST 1000 LINES ONLY. TO GET FULL PNR CLICK EMAIL LINK ABOVE.***");

			for (int lineNum = 0; lineNum < firstFewLines; lineNum++) {

				if (lineNum==firstFewLines-1) {

					//pnrTextList.add(pnrTextString.substring(posLoc));

					pnrTextList.add("*********************************************** FIRST HUNDRED LINES END HERE    *****************************************************");

				} else {

					if(pnrTextString.length() >= posLoc+noOfCharsPerline){

					pnrTextList.add(pnrTextString.substring(posLoc, posLoc+noOfCharsPerline));

					posLoc = posLoc+noOfCharsPerline;

					}

				}

			}

			Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "First :"+ firstFewLines +" lines loaded.");

		}

		

		//get the last 900 lines

		if(remainingLines >0){

				posLoc = ((remainingLines+firstFewLines) * noOfCharsPerline);

				Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "posLoc :"+ posLoc );

		}else{

			remainingLines = 0 ; 

		}		

		

		

		Logger.log(PNRJ002_LookupDefaultSubmitAction.class, Logger.LEVEL_DEBUG, "Start line :"+ (remainingLines+firstFewLines));

		for (int lineNum = (remainingLines+firstFewLines); lineNum < totalPnrLines; lineNum++) {			

			

			if (lineNum==totalPnrLines-1) {

				pnrTextList.add(pnrTextString.substring(posLoc));

			} else {

				if(pnrTextString.length() > posLoc+noOfCharsPerline){

					//System.out.println("line "+lineNum +"-"+pnrTextString.substring(posLoc, posLoc+noOfCharsPerline));

					pnrTextList.add(pnrTextString.substring(posLoc, posLoc+noOfCharsPerline));

					posLoc = posLoc+noOfCharsPerline;

					//posLoc = posLoc+noOfCharsPerline;

				}

			}

			

		}

		

		return pnrTextList;

	}
//On demand begins
	public static ArrayList<String> OnDemandgetPNRText2Display(int totalPnrLines, String pnrTextString){

		ArrayList<String> pnrTextList = new ArrayList<String>();

		int posLoc = 0;

		if(totalPnrLines > 1000){

			pnrTextList.add("***PNR HAS MORE THAN 1000 LINES, DISPLAYING FIRST 1000 LINES ONLY. TO GET FULL PNR CLICK EMAIL LINK ABOVE.***");

		}

		

		for (int lineno = 0; lineno < totalPnrLines; lineno++) {

			

			if (lineno==totalPnrLines-1) {

				String x = pnrTextString.substring((pnrTextString.length()-2),(pnrTextString.length()-1));

				String text;

				if(x.equals("")){

					text =pnrTextString.substring(posLoc,(pnrTextString.length()-2));

				}else {

					text =pnrTextString.substring(posLoc);

				}

				pnrTextList.add(text);

			}else if(lineno == 1000){

				break;

			}else {

				pnrTextList.add(pnrTextString.substring(posLoc, posLoc+133));

				posLoc = posLoc+133;

			}

							

				

		}

		

		return pnrTextList;

	}
	//on demand ends
	

	public static ArrayList<String> getPNRText2Display(int totalPnrLines, String pnrTextString){

		ArrayList<String> pnrTextList = new ArrayList<String>();

		int posLoc = 0;

		if(totalPnrLines > 1000){

			pnrTextList.add("***PNR HAS MORE THAN 1000 LINES, DISPLAYING FIRST 1000 LINES ONLY. TO GET FULL PNR CLICK EMAIL LINK ABOVE.***");

		}

		

		for (int lineno = 0; lineno < totalPnrLines; lineno++) {

			

			if (lineno==totalPnrLines-1) {

				String x = pnrTextString.substring((pnrTextString.length()-2),(pnrTextString.length()-1));

				String text;

				if(x.equals("")){

					text =pnrTextString.substring(posLoc,(pnrTextString.length()-2));

				}else {

					text =pnrTextString.substring(posLoc);

				}

				pnrTextList.add(text);

			}else if(lineno == 1000){

				break;

			}else {

				pnrTextList.add(pnrTextString.substring(posLoc, posLoc+133));

				posLoc = posLoc+133;

			}

							

				

		}

		

		return pnrTextList;

	}

	

}

