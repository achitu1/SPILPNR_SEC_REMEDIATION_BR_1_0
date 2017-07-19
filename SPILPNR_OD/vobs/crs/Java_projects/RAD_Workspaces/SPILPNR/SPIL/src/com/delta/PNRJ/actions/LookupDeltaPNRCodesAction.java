/*
 * Created on Mar 20, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.delta.PNRJ.actions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.delta.PNRJ.forms.PNRHelpCodeBean;
import com.delta.PNRJ.forms.PNRHelpCodeForm;

/**
 * @author Hari Somagatta
 * 
 *         To change the template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LookupDeltaPNRCodesAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		PNRHelpCodeForm frm = (PNRHelpCodeForm) form;

		try {
			
			ArrayList<PNRHelpCodeBean> helpCodes = new ArrayList<PNRHelpCodeBean>();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/com/delta/PNRJ/actions/PnrHelpCodes.txt"))); 
			String strLine;
			// Read File Line By Line
			while ((strLine = reader.readLine()) != null) {
				if(strLine != null & strLine.trim().length()>0){
					PNRHelpCodeBean bean =  new PNRHelpCodeBean();
					
					if(strLine.contains(":")){
						bean.setCode(strLine);
						bean.setType("");
						bean.setDefinition("");
					}else{
					
						String[] codes = strLine.split("~");
						
						bean.setCode(codes[0]);
						bean.setType(codes.length > 1?codes[1]:"");
						bean.setDefinition(codes.length > 2? codes[2]:"");
					}
					helpCodes.add(bean);
				}
			}
			frm.setHelpCodes(helpCodes);
			// Close the input stream
			//in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

		return mapping.findForward("success");
	}
}
