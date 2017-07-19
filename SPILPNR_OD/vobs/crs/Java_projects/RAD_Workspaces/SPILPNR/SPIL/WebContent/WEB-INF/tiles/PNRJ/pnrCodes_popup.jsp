<!--
	PNR Code Pop-up Prototype version 1.0 
	ICE 12-01-2004
	All data are mocked/static
	/images and /theme folders are needed by this file
-->
<html>
<!--Header-->
<head>
<title>DELTA PNR Codes</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/theme/PRAMaster.css" />
<LINK href="<html:rewrite page='<%=request.getContextPath()%>/theme/PRAMaster2.css'/>" rel="stylesheet" type="text/css">
<script type="text/javascript" language="JavaScript">
	function closeWin(){
		window.close();
		return true;
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginheight="0" marginwidth="0" rightmargin="0" bgcolor="#ffffff">
<!--main table start-->
<table width="600">
<tr>
	<td>
		<!-- This is the start of the image header -->
		<table width="600" align="center">
			<tr>
				<td width="40%">
					<!-- tiles:logo -->
					<table align="left">
					<tr>
						<td>
							<img src="<%=request.getContextPath()%>/images/topnav_bg1.gif" width="100" border="0" />
						</td>
					</tr>
					</table>
					<!-- end of tiles:logo -->
				</td>
			</tr>
		</table>
		<!-- This is the end of the image header -->
	</td>
</tr>

<!-- This is the start of the header -->
<tr>
	<td>
		<table width="600" align="left">
			<tr>
				<td>
				<table width="100%">
					<tr>
						<td align="left"><span id="headermessages"><font color="red">PNR Codes Look-up</font></span></td>
						<td align="right"><a href="#" onClick="closeWin();" ><img src="<%=request.getContextPath()%>/images/btn_close_window.gif" border="0" width="89" height="15" alt="Close Window"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
	</td>
</tr>
<tr>
	<td><hr width="600" size="1"/></td>
</tr>
<!-- This is the end of the header -->

<!-- Main Window Content Start -->
<tr>
	<td align="center">
		<table width="550" cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td>
					<table class="filter" border="0" cellpadding="0" cellspacing="0" width="550">
						<tr>
							<td><b>PNR codes</b><br />
							  <a href="#PNR$">$</a> 
							| <a href="#PNRA">A</a> | <a href="#PNRB">B</a> | <a href="#PNRC">C</a>
							| <a href="#PNRD">D</a> | <a href="#PNRE">E</a> | <a href="#PNRF">F</a>
							| <a href="#PNRG">G</a> | <a href="#PNRH">H</a> | <a href="#PNRI">I</a>
							| <a href="#PNRJ">J</a> | <a href="#PNRK">K</a> | <a href="#PNRL">L</a>
							| <a href="#PNRM">M</a> | <a href="#PNRN">N</a> | <a href="#PNRO">O</a>
							| <a href="#PNRP">P</a> | <a href="#PNRQ">Q</a> | <a href="#PNRR">R</a>
							| <a href="#PNRS">S</a> | <a href="#PNRT">T</a> | <a href="#PNRU">U</a>
							| <a href="#PNRV">V</a> | <a href="#PNRW">W</a> | <a href="#PNRX">X</a>
							| <a href="#PNRY">Y</a> | Z
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>
								<table class="filter" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td colspan="3"><b>Legend: </b><td>
									</tr>
									<tr>
										<td width="30">
											AAC <br/>
											FLT <br/>
											HIS <br/>
											OTH <br/>
											SCH <br/>
											SSR <br/>
											TAR <br/>
											TKT <br/>
											</td>
										<td width="20">
											- <br/>
											- <br/>
											- <br/>
											- <br/>
											- <br/>
											- <br/>
											- <br/>
											- <br/>
										</td>
										<td width="500">
											ACTION ADVICE CODES <br/>
											FLIGHT INFO <br/>
											HISTORY <br/>
											OTHER <br/>
											SCHEDULE CHANGE CODES <br/>
											SPECIAL SERVICE REQUEST <br/>
											TAR SALES CODE <br/>
											TICKETING CODES <br/>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		
			<tr>
				<td>&nbsp;</td>
			</tr>


			<!-- PNR Codes Start -->				
			<tr>
				<td>
					<table class="filter" border="0" cellpadding="0" cellspacing="0" width="550">
						<tr>
							<td colspan="3">PNR Codes<br/><hr size="1"/></td>
						</tr>
						<!--$ start-->
						<tr>
							<td width="70">
								<a name="PNR$">$</a><br/>
								<b>Code</b><br/>
								$C	<br/>
								$O	<br/>
								$R	<br/>
								$S	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								TAR	<br/>
								TAR	<br/>
								TAR	<br/>
								TAR	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								CASH FOR CUSTOMER'S PERSONAL CHECK	<br/>
								OVERAGE IN TAR	<br/>
								CASH REFUND FOR NW CHECK <br/>
								SHORTAGE IN TAR	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--$ end-->
						<!--A start-->
						<tr>
							<td width="70">
								<a name="PNRA">A</a><br/>
								<b>Code</b><br/>
								A	<br/>
								AB	<br/>
								AC	<br/>
								AC	<br/>
								ACFT SVCG <br/>
								ACK	<br/>
								AD	<br/>
								ADNO <br/>
								ADT	<br/>
								ADV	<br/>
								ADVR<br/>
								AG	<br/>
								AGT	<br/>
								AI	<br/>
								AJ	<br/>
								AK	<br/>
								AM	<br/>
								AN	<br/>
								AP	<br/>
								AP	<br/>
								AR	<br/>
								ARMD<br/>
								AS	<br/>
								ASAP<br/>
								ATA	<br/>
								ATC	<br/>
								ATD	<br/>
								ATX	<br/>
								AUTH<br/>
								AVIH<br/>
								AVML<br/>
								AZ	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								OTH	<br/>
								HIS	<br/>
								HIS	<br/>
								TAR	<br/>
								FLT	<br/>
								OTH	<br/>
								HIS	<br/>
								OTH	<br/>
								OTH	<br/>
								OTH	<br/>
								OTH	<br/>
								HIS	<br/>
								OTH	<br/>
								HIS	<br/>
								HIS	<br/>
								HIS	<br/>
								HIS	<br/>
								HIS	<br/>
								HIS	<br/>
								SSR	<br/>
								HIS	<br/>
								SSR	<br/>
								HIS	<br/>
								OTH	<br/>
								FLT	<br/>
								FLT	<br/>
								FLT	<br/>
								OTH	<br/>
								OTH	<br/>
								SSR	<br/>
								SSR	<br/>
								HIS	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								HOTEL PHONE NUMBER	<br/>
								PTA PNR - PURCHASER FIELD ADDITION	<br/>
								PTA PNR - ACTION FIELD ADDITION	<br/>
								ADD COLLECT FOR FARE DIFFERENCE	<br/>
								SERVICING OF AIRCRAFT SUCH AS EQUIPMENT/FUEL/MEALS AND IN-FLIGHT SERVICES	<br/>
								ACKNOWLEDGE, OR ACKNOWLEDGEMENT MESSAGE (FOR PTA MESSAGES ONLY)	<br/>
								ADDED DIRECT RESPONSE ACKNOWLEDGEMENT	<br/>
								ADVISE IF NOT OKAY	<br/>
								ADULT	<br/>
								ADVISE(D), (ING)	<br/>
								ADVISE RATE	<br/>
								ADDED SSR ITEM	<br/>
								TRAVEL AGENT	<br/>
								PTA PNR - SPECIAL REMARKS ADDITION	<br/>
								PTA PNR - PASSENGER CONTACT ADDITION	<br/>
								PTA PNR - MESSAGE FIELD ADDITION	<br/>
								PTA PNR - FARE FIELD ADDITION	<br/>
								ADDED NAME FIELD	<br/>
								PTA PNR - NUMBER ADDITION	<br/>
								BOARDING PASS ISSUED BY THE AIRPORT	<br/>
								PTA PNR - ROUTING ADDITION	<br/>
								ARMED GUARD/ARMED OFFICER	<br/>
								ADDED SEGMENT	<br/>
								AS SOON AS POSSIBLE	<br/>
								ACTUAL TIME OF ARRIVAL	<br/>
								AIR TRAFFIC CLEARANCE OR AIRPORT CONGESTION	<br/>
								ACTUAL TIME OF DEPARTURE	<br/>
								AIR TAXI	<br/>
								AUTHORITY, AUTHORIZE, AUTHORIZATION	<br/>
								ANIMAL IN HOLD	<br/>
								ASIAN VEGETARIAN MEAL/VEGETARIAN NON DAIRY/OAL	<br/>
								ADDED UNIQUE 5/Z REMARK	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--A end-->
						<!--B start-->
						<tr>
							<td width="70">
								<a name="PNRB">B</a><br/>
								<b>Code</b><br/>
								B	 <br/>
								BBML <br/>
								BBSL <br/>
								BC	 <br/>
								BIKE <br/>
								BLML <br/>
								BLND <br/>
								BP	 <br/>
								BREV <br/>
								BSCT <br/>
								BULK <br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								OTH	<br/>
								SSR	<br/>
								SSR	<br/>
								TAR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								BUSINESS PHONE <br/>
								BABY FOOD/INFANT	<br/>
								BABY SLEEPING BAG/KLM FLIGHTS ONLY	<br/>
								GUN CASE/FLIGHT BAGS/BIKE BOXES	<br/>
								BICYCLE	<br/>
								BLAND MEAL	<br/>
								BLIND PASSENGER/STATE IF WITH SEEING EYE DOG	<br/>
								BOARDING PASS ISSUED BY A WORLDSPAN AGENCY, CTO, OR TBM OFFICE	<br/>
								BEREAVEMENT CUSTOMER/NWA ONLY	<br/>
								BASSINET/BULKHEAD SEATING REQUIRED - INTERNATIONAL ONLY - GSPL BSCT	<br/>
								BULKY BAGGAGE	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--B end-->
						<!--C start-->
						<tr>
							<td width="70">
								<a name="PNRC">C</a><br/>
								<b>Code</b><br/>
								C(AGE)	<br/>
								CA	 <br/>
								CAR	 <br/>
								CARE <br/>
								CBBG <br/>
								CC	 <br/>
								CFY	 <br/>
								CHLD <br/>
								CHML <br/>
								CK	 <br/>
								CKIN <br/>
								CMP	 <br/>
								CN	 <br/>
								COMM RATE	<br/>
								CONN <br/>
								CORP <br/>
								COUR <br/>
								CP	 <br/>
								CR	 <br/>
								CREW <br/>
								CRUZ <br/>
									 <br/>
								CS	 <br/>
								CTC	 <br/>
								CTCA <br/>
								CTCB <br/>
								CTCH <br/>
								CTCO <br/>
								CTCT <br/>
								CX	<br/>
								CX	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								OTH	<br/>
								TAR	<br/>
								OTH	<br/>
								SSR	<br/>
								SSR	<br/>
								TAR	<br/>
								OTH	<br/>
								SSR	<br/>
								SSR	<br/>
								TAR	<br/>
								SSR	<br/>
								OTH	<br/>
								HIS	<br/>
								OTH	<br/>
								FLT	<br/>
								SSR	<br/>
								SSR	<br/>
								HIS	<br/>
								HIS	<br/>
								FLT	<br/>
								SSR	<br/>
									<br/>
								HIS	<br/>
								FLT	<br/>
								FLT	<br/>
								FLT	<br/>
								FLT	<br/>
								FLT	<br/>
								FLT	<br/>
								HIS	<br/>
								SSR	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								AGE OF CHILD BETWEEN 2 AND 11	<br/>
								CASH	<br/>
								CAR RENTAL	<br/>
								HUMAN REMAINS ESCORT / FUNERAL ATTENDEE - OAL	<br/>
								BLOCK SEAT BAGGAGE / REQUIRES BULKHEAD SEATS	<br/>
								CREDIT CARD	<br/>
								CLARIFY-YOUR MESSAGE IS NOT UNDERSTOOD	<br/>
								CHILD AGE 15-17 WHOSE PARENTS DECLINE UMNR SERVICE	<br/>
								CHILDS MEAL - NO LONGER ABLE TO SPECIFY CHOICE	<br/>
								CHECK	<br/>
								CHECK-IN INFO FOR AIRPORT USE FOR PSGR HANDLING	<br/>
								COMPANION	<br/>
								ADDED/CHANGED HOTEL/CAR CONFIRMATION NUMBER	<br/>
								COMMISSION RATE	<br/>
								WAITING FOR IN-BOUND CONNECTING FLIGHT	<br/>
								PASSENGER TRAVELING ON SPECIFIC TICKET DESIGNATOR	<br/>
								COMMERCIAL COURIER - IF KNOWN ADD NAME OF COMPANY ETC	<br/>
								PTA PNR - PTA NUMBER MODIFIED	<br/>
								DENOTES A CHANGED RECORD	<br/>
								INCOMPLETE CABIN ATTENDANT OR COCKPIT CREW	<br/>
								CRUISE CUSTOMER/NWA ONLY - ADD CRUISE COMPANY NAME/SHIPNAME/SAILING TIME/PORT SHIPS SAILS FROM IN SSR	<br/>
								CODESHARE SOLD NW/KLM	<br/>
								CONTACTED/CONTACTING	<br/>
								HOME OR HOTEL ADDRESS	<br/>
								BUSINESS PHONE	<br/>
								HOME PHONE	<br/>
								PHONE NATURE NOT KNOWN	<br/>
								TRAVEL AGENCY PHONE	<br/>
								CODESHARE FLIGHT CANCELLED	<br/>
								CONNECTION BOARDING PASS	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--C end-->

						<!--D start-->
						<tr>
							<td width="70">
								<a name="PNRD">D</a><br/>
								<b>Code</b><br/>
								DAPO <br/>
								DB	 <br/>
								DBML <br/>
								DEAF <br/>
								DEPA <br/>
								DEPU <br/>
								DI	 <br/>
								DIPB <br/>
								DITM <br/>
								DJ	 <br/>
								DL	 <br/>
								DLYD <br/>
								DO	 <br/>
								DS	 <br/>
								DX	 <br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								OTH	<br/>
								TAR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								TAR	<br/>
								SSR	<br/>
								FLT	<br/>
								HIS	<br/>
								AAC	<br/>
								FLT	<br/>
								HIS	<br/>
								AAC	<br/>
								HIS	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								DO ALL POSSIBLE	<br/>
								DOMESTIC DBC	<br/>
								DIABETIC MEAL	<br/>
								DEAF PASSENGER/STATE IF WITH HEARING GUIDE DOG	<br/>
								DEPORTEE ACCOMPANIED	<br/>
								DEPORTEE UNACCOMPANIED	<br/>
								INTERNATIONAL DBC	<br/>
								DIPLOMATIC BAGGAGE - OAL	<br/>
								DECISION TIME WHEN NEW DEPARTURE WILL BE KNOWN	<br/>
								DELETED/CANCELLED MARRIED SEGMENT	<br/>
								SEGMENT DEFERRED FROM KL STATUS	<br/>
								DELAYED	<br/>
								PTA PNR - DATE OF ISSUE	<br/>
								DESIRED SEGMENT - AFTER WAITLISTED SEGMENT	<br/>
								DOCUMENT INSTRUCTIONS	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--D end-->

						<!--E start-->
						<tr>
							<td width="70">
								<a name="PNRE">E</a><br/>
								<b>Code</b><br/>
								EE	 <br/>
								EJ	 <br/>
								EM	 <br/>
								EQPMT<br/>
								ET	 <br/>
								ETA	 <br/>
								ETD	 <br/>
								EXST <br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								TAR	<br/>
								HIS	<br/>
								TAR	<br/>
								FLT	<br/>
								TAR	<br/>
								FLT	<br/>
								FLT	<br/>
								SSR	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								EVEN EXCHANGE	<br/>
								EXISTING MARRIED SEGMENT	<br/>
								EXTRA MILESFARE - WORLDPERKS	<br/>
								AIRCRAFT NOT AVAILABLE DUE TO NON-ARRIVAL OR LATE ARRIVAL	<br/>
								EXPEDITED TICKET FEES - WORLDPERKS	<br/>
								ESTIMATED TIME OF ARRIVAL	<br/>
								ESTIMATED TIME OF DEPARTURE	<br/>
								EXTRA SEAT/PASSENGER COMFORT	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--E end-->					

						<!--F start-->
						<tr>
							<td width="70">
								<a name="PNRF">F</a><br/>
								<b>Code</b><br/>
								FFML	<br/>
								FLD CNDNS	<br/>
									 <br/>
								FN	 <br/>
								FPML <br/>
								FQTV <br/>
								FRAG <br/>
								FRAV <br/>
								FS	<br/>
								FX	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								SSR	<br/>
								FLT	<br/>
									<br/>
								AAC	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR/FLT	<br/>
								AAC	<br/>
								FLT	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								FREQUENT FLIER MEAL - OAL	<br/>
								CLOSING OR RESTRICTION OF RAMP OR FIELD DUE TO CONSTRUCTION/WEATHER OR DISABLE AIRCRAFT	<br/>
								CHECK FREE SALE AGREEMENT - THEN CHANGE SEGMENT STATUS TO A FS OR A NN	<br/>
								FRUIT PLATE MEAL	<br/>
								FREQUENT FLIER/USE MANUAL SSR FORMAT/SEE >HELP WOR	<br/>
								FRAGILE BAGGAGE	<br/>
								FIRST AVAILABLE	<br/>
								SELL THE SEGMENT UNDER THE TERMS OF A FREE SALE AGREEMENT	<br/>
								FLIGHT CANCELLED	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--F end-->					

						<!--G start-->
						<tr>
							<td width="70">
								<a name="PNRG">G</a><br/>
								<b>Code</b><br/>
								GA	<br/>
								GARD	<br/>
								GATE EQPMT	<br/>
								GC	<br/>
								GFML	<br/>
								GL	<br/>
								GN	<br/>
								GO	<br/>
								GPST	<br/>
								GR	<br/>
								GRPF	<br/>
								GRP	<br/>
								GRPS	<br/>
								GU	<br/>
								GVT	<br/>
								GX	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								AAC	<br/>
								SSR	<br/>
								FLT	<br/>
								AAC	<br/>
								SSR	<br/>
								AAC	<br/>
								AAC	<br/>
								AAC	<br/>
								SSR	<br/>
								TAR	<br/>
								SSR	<br/>
								OTH	<br/>
								SSR	<br/>
								AAC	<br/>
								OTH	<br/>
								AAC	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								REQUEST GROUP SPACE - PREFERRED CHOICE	<br/>
								GUARD - OAL	<br/>
								INOPERATIVE MALFUNCTIONING OR INSUFFICIENT GROUND EQUIPMENT	<br/>
								GROUP REQUEST UNABLE - CANNOT BE LISTED	<br/>
								GLUTEN FREE MEAL	<br/>
								GROUP IS WAITLISTED	<br/>
								REQUEST GROUP SPACE - ACCEPTABLE ALTERNATE	<br/>
								NO ACTION TAKEN ON GROUP REQUEST	<br/>
								GROUP SEAT/FOR NWA USE 4R/FOR OAL USE 3SSR	<br/>
								GTR	<br/>
								GROUP FARE CODE / USE 3SSR FORMAT	<br/>
								GROUP	<br/>
								GROUPS/USE 3SSR FORMAT	<br/>
								GROUP REQUEST UNABLE - CANNOT BE LISTED	<br/>
								GOVERNMENT	<br/>
								ACTION CODE / GA-GN-GU-GL / AFFECTED BY SCHEDULE CHANGE	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--G end-->					

						<!--H start-->
						<tr>
							<td width="70">
								<a name="PNRH">H</a><br/>
								<b>Code</b><br/>
								H	<br/>
								HFML	<br/>
								HG	<br/>
								HK	<br/>
								HL	<br/>
								HN	<br/>
								HNML	<br/>
								HTL	<br/>
								HX	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								OTH	<br/>
								SSR	<br/>
								HIS	<br/>
								AAC	<br/>
								AAC	<br/>
								AAC	<br/>
								SSR	<br/>
								OTH	<br/>
								AAC	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								HOME PHONE NUMBER	<br/>
								HIGH FIBER MEAL - OAL	<br/>
								DISPLAY SSR ITEMS OF HISTORY (HX GFAX)	<br/>
								PASSENGER HAS BEEN ADVISED THAT THE SEGMENT IS CONFIRMED	<br/>
								PASSENGER HAS BEEN WAITLISTED	<br/>
								SPACE HAS BEEN REQUESTED THROUGH AN OAL	<br/>
								HINDU MEAL	<br/>
								HOTEL ACCOMMODATION	<br/>
								HAVE CANCELLED SPACE	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--H end-->					

						<!--I start-->
						<tr>
							<td width="70">
								<a name="PNRI">I</a><br/>
								<b>Code</b><br/>
								IE	<br/>
								IFUN	<br/>
								IN	<br/>
								INAD	<br/>
								INFT	<br/>
								IS	<br/>
								IX	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								TAR	<br/>
								OTH	<br/>
								AAC	<br/>
								SSR	<br/>
								OTH	<br/>
								AAC	<br/>
								AAC	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								UNEVEN EXCHANGE	<br/>
								IF UNABLE	<br/>
								SEGMENT REQUEST - MAY HAVE BEEN PREVIOUSLY SENT - REPLY REQUIRED	<br/>
								INADMISSIBLE PASSENGER - OAL	<br/>
								INFANT -> GSPL INFANT	<br/>
								SEGMENT SELL - MAY HAVE BEEN PREVIOUSLY SENT	<br/>
								IF SEGMENT IS HELD - CANCEL IT	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--I end-->					

						<!--J start-->
						<tr>
							<td width="70">
								<a name="PNRJ">J</a><br/>
								<b>Code</b><br/>
								JO1	<br/>
								
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								HIS	<br/>
								
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								MARRIAGE INDICATOR	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--J end-->					

						<!--K start-->
						<tr>
							<td width="70">
								<a name="PNRK">K</a><br/>
								<b>Code</b><br/>
								KK	<br/>
								KL	<br/>
								KSML<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								AAC	<br/>
								AAC	<br/>
								SSR	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								CONFIRMATION OF SEGMENT REQUEST	<br/>
								CONFIRMATION OF A PREVIOUSLY LISTED SEGMENT	<br/>
								KOSHER MEAL	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--K end-->					

						<!--L start-->
						<tr>
							<td width="70">
								<a name="PNRL">L</a><br/>
								<b>Code</b><br/>
								L-	<br/>
								LANG	<br/>
								LC	<br/>
								LCML	<br/>
								LDG	<br/>
								LFF	<br/>
								LFML	<br/>
								LL	<br/>
								LND	<br/>
								LP	<br/>
								LPML	<br/>
								LSML	<br/>
								LX	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								HIS	<br/>
								SSR	<br/>
								TAR	<br/>
								SSR	<br/>
								FLT	<br/>
								FLT	<br/>
								SSR	<br/>
								AAC	<br/>
								FLT	<br/>
								TAR	<br/>
								SSR	<br/>
								SSR	<br/>
								FLT	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								RECORD LOCATOR (PNR CODE)	<br/>
								SPEAKS ONLY LANGUAGE SPECIFIED	<br/>
								LOST TICKET CHARGE	<br/>
								LOW CALORIE MEAL	<br/>
								LOADING OR REMOVAL OF CARGO OR PASSENGERS	<br/>
								UNSCHEDULED LANDING FOR FUEL	<br/>
								LOW CHOLESTEROL/LOW FAT MEAL	<br/>
								LIST THE SEGMENT - REPLY NOT REQUIRED	<br/>
								LANDED BUT NOT AT GATE	<br/>
								EXCESS LIABILITY/USE EXCESS BAG TKT	<br/>
								LOW PROTEIN MEAL - OAL	<br/>
								LOW SODIUM / LOW SALT	<br/>
								LANDING CANCELLED	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--L end-->					

						<!--M start-->
						<tr>
							<td width="70">
								<a name="PNRM">M</a><br/>
								<b>Code</b><br/>
								MAAS<br/>
									<br/>
								MAINT<br/>
								MCO	<br/>
								MECH<br/>
								MEDA<br/>
								MIL	<br/>
								MK	<br/>
									<br/>
								ML	<br/>
								MN	<br/>
								MOML<br/>
								MS	<br/>
									<br/>
								MSCN<br/>
								MW	<br/>
								MX	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								SSR	<br/>
									<br/>
								FLT	<br/>
								OTH	<br/>
								FLT	<br/>
								SSR	<br/>
								OTH	<br/>
								AAC	<br/>
									<br/>
								AAC	<br/>
								AAC	<br/>
								SSR	<br/>
								SCH/AAC	<br/>
									<br/>
								FLT	<br/>
								SCH/AAC	<br/>
								AAC	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								MEET AND ASSIST/18 YRS OF OLDER/SPECIFY ASSISTANCE - NOT FOR USE W/ UNACCOMPANIED MINOR	<br/>
								AIRCRAFT MAINTENANCE	<br/>
								MISCELLANEOUS CHARGES ORDER	<br/>
								MECHANICAL	<br/>
								MEDICAL APPROVAL/SPECIFY MEDICAL CONDITION	<br/>
								MILITARY	<br/>
								CORRESPONDING INVENTORY SEGMENT IS /HK/ OR IS BEING USED FOR INFANT PNR OR IS A MEMO SEGMENT	<br/>
								CORRESPONDING INVENTORY SEGMENT IS HL/HN/PN	<br/>
								SEGMENT /MK/ AFFECTED - EQUIVALENT TO /UN/ON INVENTORY SEGMENT	<br/>
								MOSLEM MEAL	<br/>
								REACCOMMODATION OF /MK/ SEGMENT - EQUIVALENT TO /SC/ ON INVENTORY SEGMENT	<br/>
								MISCONNECT	<br/>
								SEGMENT /ML/ AFFECTED - NO REACCOMMODATION	<br/>
								SEGMENT /MK/ AFFECTED - EQUIVALENT TO /WK/ ON INVENTORY SEGMENT	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--M end-->					

						<!--N start-->
						<tr>
							<td width="70">
								<a name="PNRN">N</a><br/>
								<b>Code</b><br/>
								N	<br/>
								NA	<br/>
								NA	<br/>
									<br/>
									<br/>
								NBR	<br/>
								NJ	<br/>
								NLML<br/>
								NN	<br/>
								NO	<br/>
								NOCN<br/>
								NOML<br/>
								NOOP<br/>
								NSSA<br/>
								NSSB<br/>
								NSST<br/>
								NSSW<br/>
								NX	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								OTH	<br/>
								HIS	<br/>
								AAC	<br/>
									<br/>
									<br/>
								OTH	<br/>
								HIS	<br/>
								SSR/AAC	<br/>
								AAC	<br/>
								AAC	<br/>
								OTH	<br/>
								SSR	<br/>
								FLT	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								HIS	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								NO CONTACT	<br/>
								TOUR PNR - NAME FIELD ADDITION	<br/>
								SEGMENT REQUIREMENT - FOLLOWED BY ACCEPTABLE ALTERNATES OVER SAME AIRLINE SEGMENT.  LAST SEGMENT IN SERIES MUST HAVE /NN/ ACTION CODE. /OAL-NO AVAILABILITY AGREEMENT.	<br/>
								NUMBER	<br/>
								NEW MARRIED SEGMENT	<br/>
								NON LACTOSE MEAL - OAL	<br/>
								SEGMENT REQUEST - REPLY REQUIRED	<br/>
								NO ACTION WAS TAKEN ON THE SEGMENT	<br/>
								NO CONNECTION	<br/>
								NO MEAL - NW ONLY	<br/>
								ON OPERATION	<br/>
								NO SMOKING AISLE SEAT - OAL	<br/>
								NO SMOKING BULKHEAD SEAT - OAL	<br/>
								NO SMOKING SEAT - OAL	<br/>
								NO SMOKING WINDOW SEAT - OAL	<br/>
								TOUR PNR - NAME FIELD DELETION	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--N end-->					

						<!--O start-->
						<tr>
							<td width="70">
								<a name="PNRO">O</a><br/>
								<b>Code</b><br/>
								OB	<br/>
								OB	<br/>
								ONO	<br/>
								OPNS<br/>
								ORML<br/>
								OTHS<br/>
								OVFL<br/>
								OVWX<br/>
								OW	<br/>
								OX	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								AAC	<br/>
								TAR	<br/>
								FLT	<br/>
								FLT	<br/>
								SSR	<br/>
								SSR	<br/>
								FLT	<br/>
								FLT	<br/>
								OTH	<br/>
								AAC	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								OVERBOOK	<br/>
								OXYGEN BOTTLE	<br/>
								DELAY OCCURRED BETWEEN LEAVING GATE AND TAKEOFF	<br/>
								REASON FOR DELAY WILL BE EXPLAINED BY CRC	<br/>
								ORIENTAL MEAL - OAL	<br/>
								OTHER/NO CODE EXISTS - DESCRIBE / USE MANUAL 3SSR FORMAT	<br/>
								OVER FLYING A STATION	<br/>
								OVER FLYING A STATION DUE TO WEATHER	<br/>
								ONE WAY	<br/>
								CANCEL ONLY IF THE REQUESTED SEGMENT IS AVAILABLE	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--O end-->					

						<!--P start-->
						<tr>
							<td width="70">
								<a name="PNRP">P</a><br/>
								<b>Code</b><br/>
								PA	<br/>
								PA	<br/>
								PADV	<br/>
								PB	<br/>
								PB	<br/>
								PC	<br/>
								PC	<br/>
								PD	<br/>
								PD	<br/>
								PETC	<br/>
								PK	<br/>
								PN	<br/>
									<br/>
								PNADV	<br/>
								PNR	<br/>
								PREM	<br/>
								PRG DATE	<br/>
								PRIS	<br/>
								PRML	<br/>
								PROT	<br/>
								PS	<br/>
								PSPT	<br/>
								PT	<br/>
								PTA	<br/>
								PWCT	<br/>
								PX	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								AAC	<br/>
								TAR	<br/>
								FLT	<br/>
								AAC	<br/>
								TAR	<br/>
								AAC	<br/>
								TAR	<br/>
								AAC	<br/>
								TAR	<br/>
								SSR	<br/>
								TAR	<br/>
								AAC	<br/>
									<br/>
								FLT	<br/>
								OTH	<br/>
								SSR	<br/>
								HIS	<br/>
								SSR	<br/>
								SSR	<br/>
								FLT	<br/>
								AAC	<br/>
								SSR	<br/>
								TAR	<br/>
								TAR	<br/>
								OTH	<br/>
								HIS	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								WAITLIST CODE FOR VIP/HARDSHIP	<br/>
								SERVICE RECOVERY / $25 OR 1000 WP MILES	<br/>
								PASSENGER ADVISED	<br/>
								WAITLIST CODE FOR PARS SUBSCRIBER/COMMERCIAL ACCOUNT	<br/>
								SERVICE RECOVERY / $50 OR 2500 WP MILES	<br/>
								WAITLIST CODE FOR THRU REQUESTS	<br/>
								SERVICE RECOVERY / $75 OR 3500 WP MILES	<br/>
								WAITLIST CODE FOR NONAUTOMATED AGENCY / OAL AGENCY	<br/>
								SERVICE RECOVERY / $100 OR 5000 WP MILES	<br/>
								PET IN CABIN	<br/>
								PET KENNEL	<br/>
								SPACE HAS BEEN REQUESTED THROUGH PARS - A REPLY IS REQUIRED AND HAS NOT BEEN RECEIVED	<br/>
								PASSENGER NOT ADVISED	<br/>
								PASSENGER NAME RECORD	<br/>
								PASSENGER TRAVELING ON FULL FARE	<br/>
								PTA PNR - PURGE DATE	<br/>
								PRISONER	<br/>
								LOW PURIN MEAL - OAL	<br/>
								PROTECT	<br/>
								OPEN SEGMENT ACTION CODE	<br/>
								PASSPORT INFORMATION - VALID NW/TW ONLY	<br/>
								PTA--PREPAID TICKET ADVICE	<br/>
								PTA	<br/>
								PASSENGER WILL CONTACT	<br/>
								PRICING INSTRUCTIONS	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--P end-->					

						<!--Q start-->
						<tr>
							<td width="70">
								<a name="PNRQ">Q</a><br/>
								<b>Code</b><br/>
								QP	<br/>
								QR	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								HIS	<br/>
								HIS	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								QUEUE PLACEMENT	<br/>
								QUEUE REMOVE	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--Q end-->					

						<!--R start-->
						<tr>
							<td width="70">
								<a name="PNRR">R</a><br/>
								<b>Code</b><br/>
								R-	<br/>
								RA	<br/>
								RAM	<br/>
								RB	<br/>
								RC	<br/>
								RD	<br/>
								RG	<br/>
								RON	<br/>
								RQST	<br/>
								RR	<br/>
								RS	<br/>
								RT	<br/>
								RU	<br/>
								RVML	<br/>
								RV	<br/>
								RX	<br/>
								RZ	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								HIS	<br/>
								TAR	<br/>
								FLT	<br/>
								SSR	<br/>
								SSR	<br/>
								TAR	<br/>
								SSR	<br/>
								FLT	<br/>
								SSR	<br/>
								AAC	<br/>
								SSR	<br/>
								OTH	<br/>
								TAR	<br/>
								SSR	<br/>
								TAR	<br/>
								HIS	<br/>
								SSR	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								RECEIVED FROM FIELD (AN ACTION IS BEING TAKEN)	<br/>
								REFUND ADJUSTED - FROM MASK	<br/>
								RETURN ACCOUNT MECHANICAL	<br/>
								OAL BOARDING PASS	<br/>
								RESERVED SEAT - CHANGE OF GAUGE	<br/>
								REDEPOSIT FEES - WORLD PERKS	<br/>
								OAL BOARDING PASS--CHANGE OF GAUGE	<br/>
								REMAIN OVERNIGHT	<br/>
								SEAT REQUEST - OAL	<br/>
								PASSENGER RECONFIRMED.  FOR INTERNATIONAL USE ONLY	<br/>
								RESERVED SEAT	<br/>
								ROUND TRIP	<br/>
								REFUND UNUSED - FROM MASK	<br/>
								RAW VEGETARIAN MEAL - OAL	<br/>
								REFUND VOLUNTARY - FROM MASK	<br/>
								TICKETING RECORDS	<br/>
								BOARDING PASS INHIBITED/USED BY KLM TO ADVISE OFFLINE	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--R end-->					

						<!--S start-->
						<tr>
							<td width="70">
								<a name="PNRS">S</a><br/>
								<b>Code</b><br/>
								SA	<br/>
								SC	<br/>
								SC	<br/>
								SEAT	<br/>
								SECURITY	<br/>
								SEMN	<br/>
								SFQ	<br/>
								SK	<br/>
								SLPR	<br/>
								SMSA	<br/>
								SMSB	<br/>
								SMST	<br/>
								SMSW	<br/>
								SPEQ	<br/>
								SPML	<br/>
								SRC	<br/>
								SS	<br/>
								STCR	<br/>
								SUR	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								AAC	<br/>
								HIS	<br/>
								SCH/AAC	<br/>
								SSR	<br/>
								FLT	<br/>
								SSR	<br/>
								OTH	<br/>
								HIS/SCH	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								OTH	<br/>
								AAC	<br/>
								SSR	<br/>
								OTH	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								SPACE AVAILABLE - NON REVENUE STANDBY	<br/>
								SEGMENT WITH STATUS/ACTION ADVICE CODE/CHANGE	<br/>
								ALTERNATE CONFIRMED SEGMENT	<br/>
								SEAT ITEM - PARS GENERATED	<br/>
								GENERAL SECURITY CHECKS	<br/>
								SEAMAN/SHIPS CREW	<br/>
								STORE FARE QUOTE	<br/>
								SCHEDULE CHANGE SEGMENT (INVOLUNTARY)	<br/>
								SLEEPER BED - OAL	<br/>
								SMOKING AISLE SEAT - OAL	<br/>
								SMOKING BULKHEAD SEAT - OAL	<br/>
								SMOKING SEAT - OAL	<br/>
								SMOKING WINDOW SEAT - OAL	<br/>
								SPORTS EQUIPMENT - REQUIRED FOR KL FLIGHTS	<br/>
								SPECIAL MEAL *SPECIFY SOFT/SULFITE FREE ETC.	<br/>
								SENIOR CITIZEN	<br/>
								SELL THE SEGMENT - AVAILABILITY HAS ALREADY BEEN DETERMINED	<br/>
								STRETCHER REQUEST/MUST BE MADE 48 HOURS PRIOR SEE >GLPL STCR	<br/>
								SURFACE (SHIP, RAIL, BUS, ETC)	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--S end-->					

						<!--T start-->
						<tr>
							<td width="70">
								<a name="PNRT">T</a><br/>
								<b>Code</b><br/>
								T	<br/>
								T	<br/>
								TAC	<br/>
								TAD	<br/>
								TAE	<br/>
								TAM	<br/>
								TAP	<br/>
								TAS	<br/>
								TAT	<br/>
								TAW	<br/>
								TAX	<br/>
								TCP4	<br/>
								TD	<br/>
								TF	<br/>
								TFC DEC	<br/>
								TIME GAINED	<br/>
								TK	<br/>
								TKNA	<br/>
								TKNE	<br/>
								TKNM	<br/>
								TKTD	<br/>
								TKTL	<br/>
								TL	<br/>
								TL	<br/>
									<br/>
								TN	<br/>
								TOTL	<br/>
								TRH	<br/>
									<br/>
								TUR	<br/>
								TW	<br/>
								TWOV	<br/>
								TX	<br/>
								TY	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								OTH	<br/>
								TKT	<br/>
								TKT	<br/>
								TKT	<br/>
								TKT	<br/>
								TKT	<br/>
								TKT	<br/>
								TKT	<br/>
								TKT	<br/>
								TKT	<br/>
								TKT	<br/>
								OTH	<br/>
								TAR	<br/>
								TAR	<br/>
								FLT	<br/>
								FLT	<br/>
								AAC	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								OTH	<br/>
								SSR	<br/>
								AAC	<br/>
								TKT	<br/>
									<br/>
								AAC	<br/>
								OTH	<br/>
								TKT	<br/>
									<br/>
								OTH	<br/>
								TAR	<br/>
								SSR	<br/>
								TAR	<br/>
								TAR	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								TRAVEL AGENT PHONE NUMBER	<br/>
								TICKETED	<br/>
								LOCAL TICKET BY MAIL	<br/>
								TICKET BY MAIL FOLLOW-UP	<br/>
								E-TKT	<br/>
								CENTRAL TICKET BY MAIL	<br/>
								TELEPHONE PREPAIDS	<br/>
								WILL CALL NON-BURST	<br/>
								TELETICKETING	<br/>
								WILL CALL	<br/>
								OPTION DATE	<br/>
								TO COMPLETE PARTY OF 4	<br/>
								MISCELLANEOUS UNKNOWNS	<br/>
								INTL DBC/FREE TICKET	<br/>
								FLIGHT DELAYED OR CANCELLED AT THE REQUEST OF MARKETING DIVISION	<br/>
								MAKEUP OF LOST TIME WHILE AIRCRAFT ON GROUND	<br/>
								CONFIRMING/HOLDS CONFIRMED. ADVISE PASSENGER OF NEW SCHEDULED TIMES	<br/>
								SYSTEM GENERATED TKT - TAT/ATB/ETKT	<br/>
								SYSTEM GENERATED ETKT	<br/>
								MNAUALLY ENTERED HANDWRITTEN TKT	<br/>
								TICKETED	<br/>
								TICKETING TIME LIMIT - DOWNLINE	<br/>
								IS ON WAITING LIST. ADVISE PASSENGER OF NEW SCHEDULED TIMES	<br/>
								TIME LIMIT (NOT A GUARANTEED FARE--FOLLOWED BY A DATE AND TIME. IF NOT CONFIRMED BY THAT TIME ITEM WILL BE XLD)	<br/>
								IS ON REQUEST/HOLDS.  ADVISE PASSENGER OF NEW SCHEDULED TIMES	<br/>
								TOTAL	<br/>
								ALLOW FOR BURST TKTING FOR PYMT BY CHECK AND SPLIT FOP - USED WHEN PXGR IS SENDING MCO, ETC.	<br/>
								TOUR / SIGHTSEEING, ETC.	<br/>
								TRANSIT WITHOUT VISA	<br/>
								TRANSIT/TRANSFER WITHOUT VISA	<br/>
								ADDITIONAL TAX COLLECTION	<br/>
								DOMESTIC DBC/FREE TICKET	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--T end-->					

						<!--U start-->
						<tr>
							<td width="70">
								<a name="PNRU">U</a><br/>
								<b>Code</b><br/>
								UADT	<br/>
								UC	<br/>
								UM	<br/>
								UN	<br/>
									<br/>
									<br/>
								UNCLASSIFIED<br/>
									<br/>
								UNMR<br/>
								UP	<br/>
								US	<br/>
									<br/>
								UU	<br/>
								UX	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								SSR	<br/>
								AAC	<br/>
								TAR	<br/>
								SCH/AAC	<br/>
									<br/>
									<br/>
								FLT	<br/>
									<br/>
								SSR	<br/>
								TAR	<br/>
								AAC	<br/>
									<br/>
								AAC	<br/>
								AAC	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								UNACCOMPANIED ADULT ASSIST ENROLLEE >GSPL UADT	<br/>
								SEGMENT NOT AVAILABLE AND WAITLIST CLOSED	<br/>
								UNACCOMPANIED MINOR (MANDATORY FOR AGE 5-14/OPTIONAL FOR AGE 15-17)	<br/>
								PREVIOUSLY CONFIRMED SEGMENT AFFECTED BY A MINOR CHANGE WHICH REQUIRES NO NOTIFICATION WHEN FOLLOWED BY /HK/ ON THE SAME FLT. WHEN MANUALLY ENTERED BY CRC--NOTIFICATION REQUIRED.	<br/>
								NO SPECIFIC DELAY CODE, CRC WILL ENTER REASON WHICH WILL SHOW BELOW DISPLAY	<br/>
								UNACCOMPANIED MINOR/MANDATORY AGE 5-14/OPTIONAL 15-17 >GSPL UMNR	<br/>
								UPGRADES	<br/>
								UNABLE TO ACCEPT SALE. SPACE IS NOT AVAILABLE - PASSENGER HAS BEEN WAITLISTED	<br/>
								SEGMENT NOT AVAILABLE - PASSENGER HAS BEEN WAITLISTED	<br/>
								TOUR SEGMENT CANCELLED DUE TO LACK OF REQUIRED NUMBER OF PASSENGERS	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--U end-->					

						<!--V start-->
						<tr>
							<td width="70">
								<a name="PNRV">V</a><br/>
								<b>Code</b><br/>
								VGML	<br/>
								VLML	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								SSR	<br/>
								SSR	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								VEGETARIAN - NON DAIRY	<br/>
								BEGETARIAN MEAL LACTO - OVO	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--V end-->					

						<!--W start-->
						<tr>
							<td width="70">
								<a name="PNRW">W</a><br/>
								<b>Code</b><br/>
								WAAG<br/>
								WC	<br/>
								WCBD<br/>
								WCWB<br/>
								WCHC<br/>
								WCHR<br/>
								WCHS<br/>
								WCMP<br/>
								WCOB<br/>
								WCWB<br/>
								WK	<br/>
									<br/>
								WL	<br/>
									<br/>
								WN	<br/>
									<br/>
								WX	<br/>
								WX/EQPMT	<br/>
								WZ	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								SSR	<br/>
								TAR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								SSR	<br/>
								OSSR<br/>
								SCH/AAC	<br/>
									<br/>
								SCH/AAC	<br/>
									<br/>
								SCH/AAC	<br/>
									<br/>
								FLT	<br/>
								FLT	<br/>
								SSR	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								ANNIVERSARY GIFT - KL/NW DESIGNATED KL FLIGHTS ONLY SEE >GIFS WAAG	<br/>
								WORLDCLUB FEE - WC USE ONLY	<br/>
								WHEELCHAIR TYPE - DRY PACK	<br/>
								WHEELCHAIR TYPE - WET/GELL PACK	<br/>
								WHEELCHAIR - C FOR CABIN SEAT PSGR IMMOBILE	<br/>
								WHEELCHAIR - R FOR RAMP CAN ASCEND DESCEND STEPS	<br/>
								WHEELCHAIR - S FOR STEPS CANNOT ASCEND DESCEND STEPS	<br/>
								WHEELCHAIR TYPE - MANUALLY POWERED	<br/>
								WHEELCHAIR TYPE - ON BOARD WHEELCHAIR - PROVIDED BY AIRLINE	<br/>
								WHEELCHAIR--ON BOARD WHEELCHAIR	<br/>
								PRECIOUSLY CONFIRMED SEGMENT WHICH HAS BEEN CHANGED OR NO LONGER OPERATES (INVOL)	<br/>
								PREVIOUSLY WAITLISTED SEGMENT WHICH HAS BEEN CHANGE OR NO LONGER OPERATES	<br/>
								PRECVIOUSLY CONFIRMED SEGMENT - PENDING PASSENGER NOTIFICATION - CHANGED OR NO LONGER OPERATES	<br/>
								WEATHER CONDITION AT AIRPORT OR ENROUTE	<br/>
								EQUIPMENT NOT AVAILABLE DUE TO WEATHER AT ANOTHER AIRPORT	<br/>
								WAS HOLDING	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--W end-->					

						<!--X start-->
						<tr>
							<td width="70">
								<a name="PNRX">X</a><br/>
								<b>Code</b><br/>
								XB	<br/>
								XB	<br/>
								XC	<br/>
								XD	<br/>
								XE	<br/>
								XF	<br/>
								XG	<br/>
								XI	<br/>
								XJ	<br/>
								XK	<br/>
								XK	<br/>
								XL	<br/>
								XL	<br/>
								XLD	<br/>
								XM	<br/>
								XM	<br/>
								XN	<br/>
								XN	<br/>
								XO	<br/>
								XP	<br/>
								XQ	<br/>
								XR	<br/>
								XR	<br/>
								XS	<br/>
								XSEC<br/>
								XT	<br/>
								XX	<br/>
								XX	<br/>
								XZ	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								HIS	<br/>
								TAR	<br/>
								HIS	<br/>
								HIS	<br/>
								HIS	<br/>
								HIS	<br/>
								HIS	<br/>
								HIS	<br/>
								HIS	<br/>
								AAC	<br/>
								HIS	<br/>
								AAC	<br/>
								HIS	<br/>
								FLT	<br/>
								AAC	<br/>
								HIS	<br/>
								AAC	<br/>
								HIS	<br/>
								HIS	<br/>
								HIS	<br/>
								HIS	<br/>
								AAC	<br/>
								HIS	<br/>
								HIS	<br/>
								HIS	<br/>
								HIS	<br/>
								AAC	<br/>
								TAR	<br/>
								HIS	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								PTA PNR - PURCHASER CHANGE	<br/>
								EXCESS BAGGAGE/PET CHARGE/USE EXCESS BAGGAGE TICKET	<br/>
								PTA PNR - ACTION FIELD CHANGE	<br/>
								CANCELLED DIRECT RESPONSE ACKNOWLEDGEMENT	<br/>
								ELECTRONIC TICKET ACKNOWLEDGEMENT REMOVED FROM PNR	<br/>
								PHONE FIELD CHANGE/DELETION	<br/>
								CANCELLED/CHANGE SSR ITEMS	<br/>
								PTA PNR - SPECIAL REMARKS CHANGE/DELETION	<br/>
								PTA PNR - PASSENGER CONTACT CHANGE	<br/>
								SEGMENT HAS BEEN CANCELLED - NO TELETYPE MESSAGE SENT FOR THIS SEGMENT	<br/>
								PTA PNR - MESSAGE FIELD CHANGE	<br/>
								CANCEL WAITLIST SEGMENT	<br/>
								RECORD LOCATOR CHANGE	<br/>
								CANCELLED	<br/>
								USED BY AIRPORTS TO CANCEL DUE TO MISCONNECT	<br/>
								PTA PNR - FARE CHANGE	<br/>
								ITINERARY CANCELLED DUE TO POSSIBLE NO SHOW ON OUTBOUND	<br/>
								CANCELLED/DELETED NAME FIELD	<br/>
								CANCELLED OTHER DATA	<br/>
								PTA PNR - ROUTING FIELD CHANGE	<br/>
								STORED FARE QUOTE CHANGE/DELETION	<br/>
								CANCELLATION RECOMMENDED	<br/>
								PTA PNR - ROUTING FIELD CHANGE	<br/>
								CANCELLED SEGMENT	<br/>
								OTHER SECTION/FLIGHT	<br/>
								TICKETING FIELD CHANGE	<br/>
								CANCEL CONFIRMED SEGMENT	<br/>
								ACCOUNTING REVIEW	<br/>
								CHANGE/DELETED UNIQUE 5/Z REMARK	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr>
						<!--X end-->					

						<!--Y start-->
						<tr>
							<td width="70">
								<a name="PNRY">Y</a><br/>
								<b>Code</b><br/>
								YQ	<br/>
								YR	<br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
								TAR	<br/>
								TAR	<br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
								DOMESTIC ADMINISTRATIVE/PENALTY FEES/FOR DOMESTIC TRAVEL ONLY	<br/>
								PENALTY FEE FOR INTERNATIONAL TRAVEL. ANY SEGMENT IN CONJUNCTION WITH INTERNATIONAL ITINERARIES	<br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/></td>
						</tr>
						<!--Y end-->					

						<!--# start-->
						<!--tr>
							<td width="70">
								<a name="PNR#">#</a><br/>
								<b>Code</b><br/>
							</td>
							<td width="50" align="left">
								<br/>
								<b>Type</b><br/>
							</td>
							<td width="430" align="left">
								<br/>
								<b>Description</b><br/>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="right"><small><a href="#">return to top</a></small><br/><hr size="1"/></td>
						</tr-->
						<!--# end-->					
					</table>
				</td>
			</tr>
			<!-- PNR Codes End -->				
		</table>
	</td>
</tr>
<!-- Main Window Content End -->

<!-- This is the start of the footer -->
<tr>
	<td><hr width="600" size="1"/></td>
</tr>
<!-- This is the end of the footer -->
</table>
<!-- main table end -->
</body>
</html>
