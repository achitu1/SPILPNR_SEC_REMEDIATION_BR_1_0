package com.delta.SPLJ.decorators;

import org.displaytag.decorator.TableDecorator;

import com.delta.PRA.SPLJ.data.SPLData;

/**
 * @author ann yamat
 * Jan 2006
 * 
 */
public class SPLdecoratorWaitlist extends TableDecorator {

  SPLData data;
  // adds hidden fields to scroll List
    public String getWaitlistSequence(){
	data= (SPLData) getCurrentRowObject();
	String WNum =data.getWaitlistSequence();
	
	while(true){
		if(WNum.charAt(0)=='0'){
			WNum=WNum.substring(1,WNum.length());
			WNum=WNum.trim();
		}else{
			break;
		}
	}
	StringBuffer WNumBuff= new StringBuffer("<input type=\"hidden\" name=\"hidWaitlistNum\" value=\"" + data.getWaitlistSequence() + "\">");
	WNumBuff.append(WNum);
	return WNumBuff.toString();  
  }
    
  // adds hidden fields to scroll List
	public String getFlightNumber(){
	data= (SPLData) getCurrentRowObject();
	String flightNum =data.getFlightNumber();
	StringBuffer flightNumBuff= new StringBuffer(flightNum);
	flightNumBuff.append("<input type=\"hidden\" name=\"legOrigApCode\" value=\"" + data.getLegOrigApCode() + "\">");
	flightNumBuff.append("<input type=\"hidden\" name=\"seqNum\" value=\"" + data.getSeqNum() + "\">");
	return flightNumBuff.toString();  
  } 
}
