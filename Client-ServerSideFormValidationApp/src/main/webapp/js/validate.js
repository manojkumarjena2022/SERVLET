/**
 * Form data input validation logic for corona_vaccine.html
 */
function validate(frm){
	//empty the form validation message
	document.getElementById("errName").innerHTML="";
	document.getElementById("errAddress").innerHTML="";
	document.getElementById("errAge").innerHTML="";
	//fetch form input data
	let name=frm.name.value;
	let address=frm.address.value;
	let age=frm.age.value;
	//write form validation logic
	let flag=true;
	if(name=="")
	{
		document.getElementById("errName").innerHTML="Name field is required";
		frm.name.focus();
		flag=false;
	}
	if(address=="")
	{
		document.getElementById("errAddress").innerHTML="Address field is required";
		frm.address.focus();
		flag=false;
	}
	else if(address.length<10)
	{
		document.getElementById("errAddress").innerHTML="Address field must have min 10 characters";
		frm.address.focus();
		flag=false;
	}
	if(age=="")
	{
		document.getElementById("errAge").innerHTML="Age field is required";
		frm.age.focus();
		flag=false;
	}
	else if(isNaN(age))
	{
		document.getElementById("errAge").innerHTML="Age must be a numeric value";
		frm.age.focus();
		flag=false;
	}
	else if(age<0 || age>125)
	{
		document.getElementById("errAge").innerHTML="Age must be in range between 1 to 125";
		frm.age.focus();
		flag=false;
	}
	frm.vflag.value="yes";
	return flag;
	
}