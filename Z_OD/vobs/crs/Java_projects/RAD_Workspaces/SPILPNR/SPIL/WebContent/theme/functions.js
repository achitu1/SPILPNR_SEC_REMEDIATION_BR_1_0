function printData() {
    window.onbeforeprint = hideDivs;
    window.onafterprint = showDivs;
    window.print();
  }
  
function changeToUpper(obj){
	var val= obj.value;
	obj.value=val.toUpperCase();

}
function hideDivs () {
    tmp = document.getElementById('printArea');
    tmp.style.display = 'list-item';	

    tmp2 = document.getElementById('header');
    tmp2.style.display = 'none';

//    tmp3 = document.getElementById('logo');
//    tmp3.style.display = 'none';

    tmp4 = document.getElementById('main');
    tmp4.style.display = 'none';	

    tmp5 = document.getElementById('nav');
    tmp5.style.display = 'none';

    tmp6 = document.getElementById('footer');
    tmp6.style.display = 'none';
}
function showDivs () {
    tmp = document.getElementById('printArea');
    tmp.style.display = 'none';	

    tmp2 = document.getElementById('header');
    tmp2.style.display = 'block';

//    tmp3 = document.getElementById('logo');
//    tmp3.style.display = 'block';

    tmp4 = document.getElementById('main');
    tmp4.style.display = 'block';	

    tmp5 = document.getElementById('nav');
    tmp5.style.display = 'block';

    tmp6 = document.getElementById('footer');
    tmp6.style.display = 'block';
}


function paintMouseEvents(tableId) {
	  if (document.getElementById(tableId) != null){
	    var table = document.getElementById(tableId);
	    var tbody = table.getElementsByTagName("tbody")[0];
	    var rows  = tbody.getElementsByTagName("tr");

	    for (i=0; i < rows.length; i++) {
	        rows[i].onmouseover = function() { 
	                this.style.cursor="hand";
	                if(this.style.backgroundColor == "#6495ed"){
						this.style.backgroundColor = "#6495ed";
	                }else{
	                	this.style.backgroundColor = "#FFFFCC";	                
	                }
	          };
	          
	        rows[i].onmouseout = function() {
	                this.style.cursor='';
	                if(this.style.backgroundColor == "#6495ed"){
						this.style.backgroundColor = "#6495ed";
	                }else{
		                this.style.backgroundColor = "#E5E6EF";
	                }
	                
	          };
			rows[i].onmousedown = function(){
				for (i=0; i < rows.length; i++) {
					rows[i].style.backgroundColor = "#E5E6EF";	
				}
			
			};

	        rows[i].onclick = function(i) {
	                this.style.cursor="hand";
	                this.style.backgroundColor = "#6495ED";
	                document.forms[0].selPnrLoctrNum.value = this.getElementsByTagName("td")[0].innerText;
    	            document.forms[0].selPnrCrtnDate.value = this.getElementsByTagName("td")[1].innerText;
    	            document.forms[0].selPassenger.value = this.getElementsByTagName("td")[7].innerText;
    	            document.forms[0].selFlightNumber.value = this.getElementsByTagName("td")[4].innerText;
				
				document.forms[0].action='<%=contextPath%>/LookupDefaultDetailShow.do';
				document.forms[0].submit();

	          };

	    }
	  }
}

function clearSelected(){
	form = document.forms[0];
	form.selPnrLoctrNum.value = "";
	form.selPnrCrtnDate.value = "";
	form.selPassenger.value = "";
	form.selFlightNumber.value = "";
}