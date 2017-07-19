package com.delta.SPLJ.decorators;

import org.displaytag.decorator.TableDecorator;

import com.delta.PRA.SPLJ.data.SPLData;

/**
 * @author ann yamat
 * Jan 2006
 * 
 */
public class SPLdecorator extends TableDecorator {

  SPLData data;
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
