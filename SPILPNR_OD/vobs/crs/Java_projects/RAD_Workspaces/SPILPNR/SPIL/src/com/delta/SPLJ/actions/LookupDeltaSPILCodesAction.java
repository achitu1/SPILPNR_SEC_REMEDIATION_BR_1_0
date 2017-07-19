/*
 * Created on Dec 20, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.delta.SPLJ.actions;

import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import org.apache.struts.action.Action;import org.apache.struts.action.ActionForm;import org.apache.struts.action.ActionForward;import org.apache.struts.action.ActionMapping;


/**
 * @author Gerard Lee
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LookupDeltaSPILCodesAction extends Action {
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

//		SPILHelpCodeForm frm = (SPILHelpCodeForm) form;
//		
//		EJBLookup ejbLookup = new EJBLookup();
//		SPLJ spl = null;
		
		try {
			//Do nothing
//			spl = ejbLookup.lookupEjb();
//			
//			frm.setQueryJ( spl.call_query_j() );
//			frm.setQueryK( spl.call_query_k() );
//			frm.setQueryL( spl.call_query_l() );
//			frm.setQueryM( spl.call_query_m() );
//			frm.setQueryN( spl.call_query_n() );
//			frm.setQueryO( spl.call_query_o() );
//			frm.setQueryP( spl.call_query_p() );	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward("success");
	}
}
