/**
 * 
 */
package com.delta.PNRJ.helper;

/**
 * @author f77219
 *
 */
public class DeltaAssert {
	
	public static void isNotNull(Object o, String errMsg) {
		if (o == null) {
			throw new IllegalArgumentException(errMsg);
		}
	}
	/*
	 * This method is useful when there is a check for not null, 
	 * no blank and length is greater than 0
	 */
	public static void isNotNullNotBlank(String o, String errMsg) {
		isNotNull(o,errMsg);
		if(o.trim().length() <= 0){
			throw new IllegalArgumentException(errMsg);
		}
	}

}
