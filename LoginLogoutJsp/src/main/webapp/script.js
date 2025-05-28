function check()
 {
	if(document.getElementById("em").value=="")
	{
		alert("Email field is empty");
		return false;
	}
	
	if(document.getElementById("pass").value=="")
	{
		alert("Password field is empty");
		return false;
	}
	
	if(document.getElementById("cpass").value=="")
	{
		alert("Confirm Password field is empty");
		return false;
	}
	
	var a=document.getElementById("pass").value;
	var b=document.getElementById("cpass").value;
	
	if(a!=b)
	{
		alert("Password mismatch");
		return false;
	}
}