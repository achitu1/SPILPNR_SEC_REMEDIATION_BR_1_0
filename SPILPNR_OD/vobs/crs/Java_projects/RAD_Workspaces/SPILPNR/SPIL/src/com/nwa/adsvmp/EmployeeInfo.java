/*
 * Created on Mar 4, 2004
 *
 * Source for class com.nwa.common.ADLookup.data.EmployeeInfo
 */
package com.nwa.adsvmp;

import java.io.Serializable;

/**
 * @author c58745 Swaroop Kolachina
 *
 */
public class EmployeeInfo implements Serializable {

	String employeeNumber;
	String PIN;
	String lastName;
	String firstName;
	String middleInitial;
	String displayName;
	String title;
	String employeeID;
	String PPRNumber;
	public String getPPRNumber() {
		return PPRNumber;
	}

	public void setPPRNumber(String number) {
		PPRNumber = number;
	}

	String company;
	String department;
	String officePhone;
	String emailAddress;
	String level_1;
	String level_2;
	String officeLocation;
	String OVID;
	String accountStatus;
	String passwordUpdateDate;
	String passwordDaysBeforeExpiration;
	String memberOf;
	String position;
		
	/**
	 * @return
	 */
	public String getAccountStatus() {
		return accountStatus;
	}

	/**
	 * @return
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @return
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @return
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @return
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @return
	 */
	public String getEmployeeID() {
		return employeeID;
	}

	/**
	 * @return
	 */
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return
	 */
	public String getLevel_1() {
		return level_1;
	}

	/**
	 * @return
	 */
	public String getLevel_2() {
		return level_2;
	}

	/**
	 * @return
	 */
	public String getMiddleInitial() {
		return middleInitial;
	}

	/**
	 * @return
	 */
	public String getOfficeLocation() {
		return officeLocation;
	}

	/**
	 * @return
	 */
	public String getOfficePhone() {
		return officePhone;
	}

	/**
	 * @return
	 */
	public String getOVID() {
		return OVID;
	}

	/**
	 * @return
	 */
	public String getPasswordDaysBeforeExpiration() {
		return passwordDaysBeforeExpiration;
	}

	/**
	 * @return
	 */
	public String getPasswordUpdateDate() {
		return passwordUpdateDate;
	}

	/**
	 * @return
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param string
	 */
	public void setAccountStatus(String string) {
		accountStatus = string;
	}

	/**
	 * @param string
	 */
	public void setCompany(String string) {
		company = string;
	}

	/**
	 * @param string
	 */
	public void setDepartment(String string) {
		department = string;
	}

	/**
	 * @param string
	 */
	public void setDisplayName(String string) {
		displayName = string;
	}

	/**
	 * @param string
	 */
	public void setEmailAddress(String string) {
		emailAddress = string;
	}

	/**
	 * @param string
	 */
	public void setEmployeeID(String string) {
		employeeID = string;
	}

	/**
	 * @param string
	 */
	public void setEmployeeNumber(String string) {
		employeeNumber = string;
	}

	/**
	 * @param string
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 * @param string
	 */
	public void setLastName(String string) {
		lastName = string;
	}

	/**
	 * @param string
	 */
	public void setLevel_1(String string) {
		level_1 = string;
	}

	/**
	 * @param string
	 */
	public void setLevel_2(String string) {
		level_2 = string;
	}

	/**
	 * @param string
	 */
	public void setMiddleInitial(String string) {
		middleInitial = string;
	}

	/**
	 * @param string
	 */
	public void setOfficeLocation(String string) {
		officeLocation = string;
	}

	/**
	 * @param string
	 */
	public void setOfficePhone(String string) {
		officePhone = string;
	}

	/**
	 * @param string
	 */
	public void setOVID(String string) {
		OVID = string;
	}

	/**
	 * @param string
	 */
	public void setPasswordDaysBeforeExpiration(String string) {
		passwordDaysBeforeExpiration = string;
	}

	/**
	 * @param string
	 */
	public void setPasswordUpdateDate(String string) {
		passwordUpdateDate = string;
	}

	/**
	 * @param string
	 */
	public void setPosition(String string) {
		position = string;
	}

	/**
	 * @param string
	 */
	public void setTitle(String string) {
		title = string;
	}

	/**
	 * @return
	 */
	public String getMemberOf() {
		return memberOf;
	}

	/**
	 * @param string
	 */
	public void setMemberOf(String string) {
		memberOf = string;
	}

	/**
	 * @return
	 */
	public String getPIN() {
		return PIN;
	}

	/**
	 * @param string
	 */
	public void setPIN(String string) {
		PIN = string;
	}
}
