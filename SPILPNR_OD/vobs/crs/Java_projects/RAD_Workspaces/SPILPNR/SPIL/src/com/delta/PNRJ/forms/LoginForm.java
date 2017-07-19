package com.delta.PNRJ.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.ImageButtonBean;

/**
 * Form bean for a Struts application.
 * Users may access 2 fields on this form:
 * <ul>
 * <li>password - [your comment here]
 * <li>userID - [your comment here]
 * </ul>
 * @version 	1.0
 * @author
 */
public class LoginForm extends ActionForm {

	private String userID = null;
	private String password = null;
	private String needeAdGroup = null;
	private ImageButtonBean goBtn = new ImageButtonBean();
	private ImageButtonBean resetBtn = new ImageButtonBean();

	/**
	 * Get userID
	 * @return String
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * Set userID
	 * @param <code>String</code>
	 */
	public void setUserID(String u) {
		this.userID = u;
	}

	/**
	 * Get password
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set password
	 * @param <code>String</code>
	 */
	public void setPassword(String p) {
		this.password = p;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		// Reset values are provided as samples only. Change as appropriate.

		userID = null;
		password = null;
		goBtn = new ImageButtonBean();
		resetBtn = new ImageButtonBean();

	}

	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		// Validate the fields in your form, adding
		// adding each error to this.errors as found, e.g.

		if ((userID == null) || (userID.length() == 0)) {
			errors.add("userID", new org.apache.struts.action.ActionError("error.userID.required"));
		}
		if ((password == null) || (password.length() == 0)) {
			errors.add("password", new org.apache.struts.action.ActionError("error.password.required"));		
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
	 * @return
	 */
	public ImageButtonBean getResetBtn() {
		return resetBtn;
	}

	/**
	 * @param bean
	 */
	public void setGoBtn(ImageButtonBean bean) {
		goBtn = bean;
	}

	/**
	 * @param bean
	 */
	public void setResetBtn(ImageButtonBean bean) {
		resetBtn = bean;
	}

	/**
	 * @return
	 */
	public String getNeedeAdGroup() {
		return needeAdGroup;
	}

	/**
	 * @param string
	 */
	public void setNeedeAdGroup(String string) {
		needeAdGroup = string;
	}

}
