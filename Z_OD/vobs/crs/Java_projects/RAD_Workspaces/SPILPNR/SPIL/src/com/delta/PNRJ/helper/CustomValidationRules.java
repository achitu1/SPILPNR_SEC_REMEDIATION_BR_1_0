package com.delta.PNRJ.helper;



import javax.servlet.http.HttpServletRequest;



import org.apache.commons.validator.Field;

import org.apache.commons.validator.GenericTypeValidator;

import org.apache.commons.validator.GenericValidator;

import org.apache.commons.validator.ValidatorAction;

import org.apache.commons.validator.ValidatorUtil;

import org.apache.struts.action.ActionErrors;

import org.apache.struts.validator.Resources;



import com.nwa.PRA.logger.Logger;



public class CustomValidationRules {



	public static boolean validateDate(Object bean, ValidatorAction va,

			Field field, ActionErrors errors, HttpServletRequest request) {



		Object result = null;

		String value = null;

		String datePattern = "MM/dd/yyyy";

		value = ValidatorUtil.getValueAsString(bean, field.getProperty());



		if (GenericValidator.isBlankOrNull(value)) {

			return true;

		}



		if (value.indexOf("/") != -1) {

			datePattern = "MM/dd/yy";

		} else if (value.indexOf("-") != -1) {

			datePattern = "MM-dd-yy";

		}



		try {

			result = GenericTypeValidator.formatDate(value, datePattern, false);

		} catch (Exception e) {

			Logger.log(CustomValidationRules.class, Logger.LEVEL_ERROR, e

					.getMessage());

		}



		if (result == null) {

			errors.add(field.getKey(), Resources.getActionError(request, va,

					field));

			return false;

		} else {

			return true;

		}

	}



	/**

	 * Created for Issue 4885 On the Default Lookup screen there is a field

	 * called Employee No. This field will only be available if user is under a

	 * given AD group = PnrWebP1; otherwise this field will not be seen in the

	 * page so whoever is logged in can only look at their PNRs - unless of

	 * course this user is under the AD group that allows it.

	 * 

	 * @param String

	 *            empGroups

	 * 

	 * @return boolean isAllowedViewOtherPnr

	 * 

	 */
	////////On-demand begin
	public static String isAllowedViewOtherPnrOnDemand(String empGroups) {

		// String allowedAdGroup = "PraWebA1"; //created for testing purposes

		// only.

		// empGroups = "PnrWebP1, PraWebA1"; //created for testing purposes

		// only.

		String allowedAdGroup = "PnrWebP1";

		int idx = empGroups.indexOf(allowedAdGroup);

		if (idx >= 0) {

			return "true";

		} else {

			return "false";

		}

	}
	//////on-demand end

	public static String isAllowedViewOtherPnr(String empGroups) {

		// String allowedAdGroup = "PraWebA1"; //created for testing purposes

		// only.

		// empGroups = "PnrWebP1, PraWebA1"; //created for testing purposes

		// only.

		String allowedAdGroup = "PnrWebP1";

		int idx = empGroups.indexOf(allowedAdGroup);

		if (idx >= 0) {

			return "true";

		} else {

			return "false";

		}

	}



	public static boolean validateName(Object bean, ValidatorAction va,

			Field field, ActionErrors errors, HttpServletRequest request) {



		String value = null;

		value = ValidatorUtil.getValueAsString(bean, field.getProperty());

		String sProperty2 = field.getVarValue("checkBoxProperty");

	    String value2 = ValidatorUtil.getValueAsString(bean,sProperty2);





		if (GenericValidator.isBlankOrNull(value)) {

			return true;

		}

	    if ("true".equals(value2)){

	    	if (value.indexOf("/") > 0){

	    		if (value.indexOf("/") <= value.length() - 2){

	    			return true;

	    		}else{

	    			errors.add(field.getKey(), Resources.getActionError(request, va,

	    					field));

	    			return false;

	    		}

	    	} else {

				errors.add(field.getKey(), Resources.getActionError(request, va,

						field));

				return false;

	    	}

	    }else{

	    	return true;

	    }

	}

}

