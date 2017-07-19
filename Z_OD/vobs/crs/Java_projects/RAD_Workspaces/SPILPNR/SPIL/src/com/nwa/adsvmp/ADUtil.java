package com.nwa.adsvmp;



import java.net.URL;



import org.apache.axis.message.MessageElement;

import org.w3c.dom.Element;

import com.delta.common.SPILPropertyManager;



public class ADUtil {

	public EmployeeInfo getEmployeeInfoFromAD(String empID) throws Exception {

		SearchADSoap searchAD;

		SearchADLocator serviceLoc = new SearchADLocator();
		
		/*String Url = SPILPropertyManager.getProperty("SEARCHADURL");
		searchAD = serviceLoc.getsearchADSoap12(new URL(Url));*/
		
//		searchAD = serviceLoc.getsearchADSoap12(new URL("http://searchad-int.delta.com/"));
		searchAD = serviceLoc.getsearchADSoap12(new URL("http://searchad.delta.com/"));
				//"http://searchad-int.delta.com/"));
///// code change for SearchAD Webservice Update
				
				


		
		//		"http://adsvmp.nwa.com/"));

//		FindByNwIdResponseFindByNwIdResult response = searchAD.findByNwId(
//		empID, "1", "");

		FindByIdResponseFindByIdResult response = searchAD.findById(empID, "1", "");
		
	///// code change ends for SearchAD Webservice Update

		MessageElement[] test = response.get_any();

		EmployeeInfo employee = new EmployeeInfo();

		for (int y = 0; y < test.length; y++) {

			if (test[y].getElementsByTagName("NewDataSet").getLength() > 0) {

				try {

					if (test[y].getElementsByTagName("LastName").item(0)

							.getChildNodes().getLength() > 0) {

						employee.setLastName(test[y].getElementsByTagName(

								"LastName").item(0).getChildNodes().item(0)

								.getNodeValue().trim());

					}

				} catch (Exception e) {



				}

				try {

					if (test[y].getElementsByTagName("FirstName").item(0)

							.getChildNodes().getLength() > 0) {

						employee.setFirstName(test[y].getElementsByTagName(

								"FirstName").item(0).getChildNodes().item(0)

								.getNodeValue().trim());

					}

				} catch (Exception e) {



				}

				try {

					if (test[y].getElementsByTagName("MiddleInitial").item(0)

							.getChildNodes().getLength() > 0) {

						employee.setMiddleInitial(test[y].getElementsByTagName(

								"MiddleInitial").item(0).getChildNodes()

								.item(0).getNodeValue().trim());

					}

				} catch (Exception e) {



				}

				try {

					if (test[y].getElementsByTagName("Department").item(0)

							.getChildNodes().getLength() > 0) {

						employee.setDepartment(test[y].getElementsByTagName(

								"Department").item(0).getChildNodes().item(0)

								.getNodeValue().trim());

					}

				} catch (Exception e) {



				}

				try {

					if (test[y].getElementsByTagName("Title").item(0)

							.getChildNodes().getLength() > 0) {

						employee.setTitle(test[y].getElementsByTagName("Title")

								.item(0).getChildNodes().item(0).getNodeValue()

								.trim());

					}

				} catch (Exception e) {



				}

				try {

					if (test[y].getElementsByTagName("DisplayName").item(0)

							.getChildNodes().getLength() > 0) {

						employee.setDisplayName(test[y].getElementsByTagName(

								"DisplayName").item(0).getChildNodes().item(0)

								.getNodeValue().trim());

					}

				} catch (Exception e) {



				}

				try {

					if (test[y].getElementsByTagName("PrimaryEmail").item(0)

							.getChildNodes().getLength() > 0) {

						employee.setEmailAddress(test[y].getElementsByTagName(

								"PrimaryEmail").item(0).getChildNodes().item(0)

								.getNodeValue().trim());

					}

				} catch (Exception e) {



				}

				try {

					if (test[y].getElementsByTagName("SamAccountName").item(0)

							.getChildNodes().getLength() > 0) {

						employee.setEmployeeID(test[y].getElementsByTagName(

								"SamAccountName").item(0).getChildNodes().item(

								0).getNodeValue().trim());

					}

				} catch (Exception e) {



				}

				try {

					if (test[y].getElementsByTagName("AccountStatus").item(0)

							.getChildNodes().getLength() > 0) {

						employee.setAccountStatus(test[y].getElementsByTagName(

								"AccountStatus").item(0).getChildNodes()

								.item(0).getNodeValue().trim());

					}

				} catch (Exception e) {



				}

				try {

					if (test[y].getElementsByTagName("Company").item(0)

							.getChildNodes().getLength() > 0) {

						employee.setCompany(test[y].getElementsByTagName(

								"Company").item(0).getChildNodes().item(0)

								.getNodeValue().trim());

					}

				} catch (Exception e) {



				}

				try {

					if (test[y].getElementsByTagName("TelephoneNumber").item(0)

							.getChildNodes().getLength() > 0) {

						employee.setOfficePhone(test[y].getElementsByTagName(

								"TelephoneNumber").item(0).getChildNodes()

								.item(0).getNodeValue().trim());

					}

				} catch (Exception e) {



				}

				try {

					if (test[y].getElementsByTagName("OfficeName").item(0)

							.getChildNodes().getLength() > 0) {

						employee.setOfficeLocation(test[y]

								.getElementsByTagName("OfficeName").item(0)

								.getChildNodes().item(0).getNodeValue().trim());

					}

				} catch (Exception e) {



				}

				try {

					if (test[y].getElementsByTagName("PersonId").item(0)

							.getChildNodes().getLength() > 0) {

						String empNum = test[y].getElementsByTagName("PersonId").item(0).getChildNodes().item(0).getNodeValue().trim();

						while (empNum.length() <6) {

							empNum = "0" + empNum;

						}

						employee.setEmployeeNumber(empNum);

					}

				} catch (Exception e) {



				}

				try {

					if (test[y].getElementsByTagName("nwaDLPprid").item(0)

							.getChildNodes().getLength() > 0) {

						employee.setPPRNumber(test[y].getElementsByTagName(

								"nwaDLPprid").item(0).getChildNodes().item(0)

								.getNodeValue().trim());

					}

				} catch (Exception e) {



				}

				try {

					if (test[y].getElementsByTagName("MemberOf").item(0)

							.getChildNodes().getLength() > 0) {

						employee.setMemberOf(test[y].getElementsByTagName(

								"MemberOf").item(0).getChildNodes().item(0)

								.getNodeValue().trim());

					}

				} catch (Exception e) {



				}

			}

		}

		return employee;

	}

}

