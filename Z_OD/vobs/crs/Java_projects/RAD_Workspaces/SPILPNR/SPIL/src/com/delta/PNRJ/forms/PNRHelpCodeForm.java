
package com.delta.PNRJ.forms;


import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class PNRHelpCodeForm extends ActionForm {
	private ArrayList<PNRHelpCodeBean>  helpCodes = null;

	/**
	 * @return the helpCodes
	 */
	public ArrayList<PNRHelpCodeBean> getHelpCodes() {
		return helpCodes;
	}

	/**
	 * @param helpCodes the helpCodes to set
	 */
	public void setHelpCodes(ArrayList<PNRHelpCodeBean> helpCodes) {
		this.helpCodes = helpCodes;
	}
	
	
	
}
