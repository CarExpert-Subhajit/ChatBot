function validateForm()
{
	let fname=document.forms["RegForm"]["firstname"];
	let lname=document.forms["RegForm"]["lastname"];
	let username=document.forms["RegForm"]["users"];
	let password=document.forms["RegForm"]["pass"];
	let address=document.forms["RegForm"]["address"];
	let contact=document.forms["RegForm"]["contact"];
	if(fname.value=="")
	{		
		alert("Please fill first name");
		fname.focus();
		
		return false;
	}
	if(lname.value=="")
	{
		alert("Please fill last name");
		lname.focus();
		return false;
	}
	if(username.value=="")
	{
		alert("Please fill user name");
		username.focus();
		return false;
	}
	if(password.value=="")
	{
		alert("Please fill password");
		password.focus();
		return false;
	}
	if(address.value=="")
	{
		alert("Please fill address");
		address.focus();
		return false;
	}
	if(contact.value=="")
	{
		alert("Please fill contact field");
		contact.focus();
		return false;
	}
	if(password.value.length<4)
	{
	alert("Password must be atleast 4 characters");	
	password.focus();
	return false;
	}
	if(contact.value.length!=10)
	{
		alert("Wrong phone number. Must be 10 digits");
		contact.focus();
		return false;
	}
	return true;
}