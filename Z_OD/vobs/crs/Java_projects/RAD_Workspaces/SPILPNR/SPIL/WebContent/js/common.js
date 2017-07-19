function openURLSPIL(url) {
	if (url == "FlightInquiry.do"){
		url = url + "?";
		if (typeof document.forms[0].airlineCode != "undefined"){
			url = url + "alCde=" + document.forms[0].airlineCode.value + "&";
		}
		if (typeof document.forms[0].flightNumber != "undefined"){
			url = url + "fltNum=" + document.forms[0].flightNumber.value + "&";
		}
		if (typeof document.forms[0].localDepartureDate != "undefined"){
			url = url + "lclDepDte=" + document.forms[0].localDepartureDate.value+ "&";
		}
	} else if (url == "PassengerInquiry.do"){
		url = url + "?";
		if (typeof document.forms[0].passengerName != "undefined"){
			url = url + "paxNme=" + document.forms[0].passengerName.value + "&";
		}
		if (typeof document.forms[0].localDepartureDate != "undefined"){
			url = url + "lclDepDte=" + document.forms[0].localDepartureDate.value+ "&";
		}
	} else if (url == "OtherInquiry.do"){
		url = url + "?";
		if (typeof document.forms[0].pnrLocator != "undefined"){
			url = url + "pnrLoc=" + document.forms[0].pnrLocator.value + "&";
		}
	} else if (url == "FrequentFlierInquiry.do"){
		url = url + "?";
		if (typeof document.forms[0].airlineCode != "undefined"){
			url = url + "alCde=" + document.forms[0].airlineCode.value + "&";
		}
	} else if (url == "WaitlistInquiry.do"){
		url = url + "?";
		if (typeof document.forms[0].airlineCode != "undefined"){
			url = url + "alCde=" + document.forms[0].airlineCode.value + "&";
		}
		if (typeof document.forms[0].flightNumber != "undefined"){
			url = url + "fltNum=" + document.forms[0].flightNumber.value + "&";
		}
		if (typeof document.forms[0].localDepartureDate != "undefined"){
			url = url + "lclDepDte=" + document.forms[0].localDepartureDate.value + "&";
		}
		if (typeof document.forms[0].passengerName != "undefined"){
			url = url + "paxNme=" + document.forms[0].passengerName.value + "&";
		}
		if (typeof document.forms[0].pnrLocator != "undefined"){
			url = url + "pnrLoc=" + document.forms[0].pnrLocator.value + "&";
		}
	}else if (url == "SsrInquiry.do"){
		url = url + "?";
		if (typeof document.forms[0].airlineCode != "undefined"){
			url = url + "alCde=" + document.forms[0].airlineCode.value + "&";
		}
		if (typeof document.forms[0].flightNumber != "undefined"){
			url = url + "fltNum=" + document.forms[0].flightNumber.value + "&";
		}
		if (typeof document.forms[0].localDepartureDate != "undefined"){
			url = url + "lclDepDte=" + document.forms[0].localDepartureDate.value+ "&";
		}
	} 		else if (url == "OnDemandPassengerInquiry.do"){		url = url + "?";		if (typeof document.forms[0].passengerName != "undefined"){			url = url + "paxNme=" + document.forms[0].passengerName.value + "&";		}		if (typeof document.forms[0].localDepartureDate != "undefined"){			url = url + "lclDepDte=" + document.forms[0].localDepartureDate.value+ "&";		}
	
}	location.href = url;}
function openURLPNR(url) {
	if (url == "LookupPassenger.do"){
		url = url + "?";
		if (typeof document.forms[0].passengerName != "undefined"){
			url = url + "paxNme=" + document.forms[0].passengerName.value + "&";
		}
		if (typeof document.forms[0].travelDate != "undefined"){
			url = url + "trvlDte=" + document.forms[0].travelDate.value+ "&";
		}
		if (typeof document.forms[0].flightNumber != "undefined"){
			url = url + "fltNum=" + document.forms[0].flightNumber.value + "&";
		}
		if (typeof document.forms[0].airlineCode != "undefined"){
			url = url + "alCde=" + document.forms[0].airlineCode.value + "&";
		}
		if (typeof document.forms[0].origin != "undefined"){
			url = url + "orig=" + document.forms[0].origin.value + "&";
		}
		if (typeof document.forms[0].destination != "undefined"){
			url = url + "dest=" + document.forms[0].destination.value + "&";
		}
	} else if (url == "LookupFlight.do"){
		url = url + "?";
		if (typeof document.forms[0].passengerName != "undefined"){
			url = url + "paxNme=" + document.forms[0].passengerName.value + "&";
		}
		if (typeof document.forms[0].travelDate != "undefined"){
			url = url + "trvlDte=" + document.forms[0].travelDate.value+ "&";
		}
		if (typeof document.forms[0].flightNumber != "undefined"){
			url = url + "fltNum=" + document.forms[0].flightNumber.value + "&";
		}
		if (typeof document.forms[0].airlineCode != "undefined"){
			url = url + "alCde=" + document.forms[0].airlineCode.value + "&";
		}
		if (typeof document.forms[0].origin != "undefined"){
			url = url + "orig=" + document.forms[0].origin.value + "&";
		}
		if (typeof document.forms[0].destination != "undefined"){
			url = url + "dest=" + document.forms[0].destination.value + "&";
		}
	} else if (url == "LookupOrigDest.do"){
		url = url + "?";
		if (typeof document.forms[0].passengerName != "undefined"){
			url = url + "paxNme=" + document.forms[0].passengerName.value + "&";
		}
		if (typeof document.forms[0].travelDate != "undefined"){
			url = url + "trvlDte=" + document.forms[0].travelDate.value+ "&";
		}
		if (typeof document.forms[0].flightNumber != "undefined"){
			url = url + "fltNum=" + document.forms[0].flightNumber.value + "&";
		}
		if (typeof document.forms[0].airlineCode != "undefined"){
			url = url + "alCde=" + document.forms[0].airlineCode.value + "&";
		}
		if (typeof document.forms[0].origin != "undefined"){
			url = url + "orig=" + document.forms[0].origin.value + "&";
		}
		if (typeof document.forms[0].destination != "undefined"){
			url = url + "dest=" + document.forms[0].destination.value + "&";
		}
	}
	location.href = url;
}