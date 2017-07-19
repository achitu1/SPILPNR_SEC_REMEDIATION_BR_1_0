/**
 * 
 */
package com.delta.jobs;

/**
 * @author f77219
 *
 */
public class CreditCard {
	
	private String pnr;
	private String pnrCrtnDt;
	private String ccCode;
	private String ccNum;
	private String tknCCNum;
	
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getPnrCrtnDt() {
		return pnrCrtnDt;
	}
	public void setPnrCrtnDt(String pnrCrtnDt) {
		this.pnrCrtnDt = pnrCrtnDt;
	}
	public String getCcCode() {
		return ccCode;
	}
	public void setCcCode(String ccCode) {
		this.ccCode = ccCode;
	}
	public String getCcNum() {
		return ccNum;
	}
	public void setCcNum(String ccNum) {
		this.ccNum = ccNum;
	}
	public String getTknCCNum() {
		return tknCCNum;
	}
	public void setTknCCNum(String tknCCNum) {
		this.tknCCNum = tknCCNum;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public String toString() {
		String mystring = pnr+"|"+pnrCrtnDt+"|"+ccCode+"|"+tknCCNum;
		return mystring;
	}
	
	
	

}
