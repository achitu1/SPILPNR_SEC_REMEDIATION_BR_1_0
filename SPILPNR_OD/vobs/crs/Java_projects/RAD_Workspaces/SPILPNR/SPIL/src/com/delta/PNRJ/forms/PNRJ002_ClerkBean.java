package com.delta.PNRJ.forms;

import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.ImageButtonBean;

import com.nwa.PRA.datehelper.DateHelper;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */
public class PNRJ002_ClerkBean extends ActionForm {

	//clerk variables
	private String pnrLocator = null;
	private String pnrMemo = null;
	private Vector pnrLines = null;
	private String pngrName = null;
	private String flightNbr = null;
	private String travelDte = null;
	
	private String retrieve_message = null;
	private String clickedPnrLoc = "";
	
	private Vector pnrList = null;
	//buttons
	private ImageButtonBean goBtn;
	private ImageButtonBean resetBtn;
	
	//current date
	private String currentDate=null;
	
		
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		// Reset field values here.

		goBtn = new ImageButtonBean();
		resetBtn = new ImageButtonBean();
		retrieve_message = null;
		pnrMemo = null;
		travelDte = null;
	}
	
	public void reset() {

			// Reset field values here.
			pnrLocator = null;
		}

	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		
		boolean locatorLookup = false;
		boolean nameLookup = false;
		boolean flightNumLookup = false;
		boolean flightDteLookup = false;
		
		if(getGoBtn().isSelected()){
			if (pnrLocator != null && pnrLocator.trim().length() != 0) 
			{
				locatorLookup = true;
			}
			if(pngrName != null && pngrName.trim().length() != 0)
			{
				nameLookup = true;
			}
			if(flightNbr != null && flightNbr.trim().length() != 0)
			{
				flightNumLookup = true;
			}
			if(travelDte != null && travelDte.trim().length() != 0)
			{
				flightDteLookup=true;
				try {
					DateHelper dh = new DateHelper();
					if (!dh.validateDate(travelDte,"DDMONYY"))
					{
						errors.add("flightDte", new org.apache.struts.action.ActionError("error.flightDte.invalid"));
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (!locatorLookup && !nameLookup && !flightNumLookup && !flightDteLookup)
			{
				errors.add("allFields", new org.apache.struts.action.ActionError("error.allFields.empty"));
			}
			else if (!locatorLookup && !nameLookup && !flightNumLookup && flightDteLookup)
			{
				errors.add("flightNum", new org.apache.struts.action.ActionError("error.flightNum.empty"));
			}
			else if (!locatorLookup && !nameLookup && flightNumLookup && !flightDteLookup)
			{
				errors.add("flightDte", new org.apache.struts.action.ActionError("error.flightDte.empty"));
			}
			
								
		}
		return errors;
		
	}
	/**
	 * @return
	 */
	public ImageButtonBean getGoBtn() {
		return goBtn;
	}

	/**
	 * @param bean
	 */
	public void setGoBtn(ImageButtonBean bean) {
		goBtn = bean;
	}

	public String getCurrentDate() {
		if (currentDate == null){
			currentDate = (new DateHelper().getCurrentDate());
		}
		return currentDate;
	}

	/**
	 * @param string
	 */
	public void setCurrentDate(String string) {
		currentDate = string;
	}

	

	/**
	 * @return
	 */
	public String getPnrLocator() {
		return pnrLocator;
	}

	/**
	 * @param string
	 */
	public void setPnrLocator(String string) {
		pnrLocator = string;
	}

	/**
	 * @return
	 */
	public String getPnrMemo() {
		return pnrMemo;
	}

	/**
	 * @param string
	 */
	public void setPnrMemo(String string) {
		pnrMemo = string;
	}

	/**
	 * @return
	 */
	public Vector getPnrLines() {
		if (pnrLines == null)
		return (new Vector());
	else
		return pnrLines;
	}

	/**
	 * @param vector
	 */
	public void setPnrLines(Vector vector) {
		pnrLines = vector;
	}

	/**
	 * @return
	 */
	public String getPngrName() {
		return pngrName;
	}

	/**
	 * @param string
	 */
	public void setPngrName(String string) {
		pngrName = string;
	}

	/**
	 * @return
	 */
	public Vector getPnrList() {
		if (pnrList == null)
		return (new Vector());
	else
		return pnrList;
	}

	/**
	 * @param vector
	 */
	public void setPnrList(Vector vector) {
		pnrList = vector;
	}

	/**
	 * @return
	 */
	public String getRetrieve_message() {
		return retrieve_message;
	}

	/**
	 * @param string
	 */
	public void setRetrieve_message(String string) {
		retrieve_message = string;
	}

	/**
	 * @return
	 */
	public String getFlightNbr() {
		return flightNbr;
	}

	/**
	 * @return
	 */
	public String getTravelDte() {
		return travelDte;
	}

	/**
	 * @param string
	 */
	public void setFlightNbr(String string) {
		flightNbr = string;
	}

	/**
	 * @param string
	 */
	public void setTravelDte(String string) {
		travelDte = string;
	}

	/**
	 * @return
	 */
	public String getClickedPnrLoc() {
		return clickedPnrLoc;
	}

	/**
	 * @param string
	 */
	public void setClickedPnrLoc(String string) {
		clickedPnrLoc = string;
	}

	/**
	 * @return
	 */
	public ImageButtonBean getResetBtn() {
		return resetBtn;
	}

	/**
	 * @param bean
	 */
	public void setResetBtn(ImageButtonBean bean) {
		resetBtn = bean;
	}

}
	