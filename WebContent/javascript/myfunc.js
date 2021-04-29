function validateForm(){
   if(ValidateEmployeeId()&&ValidateEmail()){
    	document.forms['Employeeform'].submit();
	}
}

function validateLogin(){
   if(validateEmployeeId()&&validatePassword()){
    	document.forms['Employeeform'].submit();
	}
}

function validateRegistration()
{
 if(validateEmployeeId()&&validateEmail()&&validateAlternateEmail()&&validatePhoneNo()&&validateAlternatePhoneNo()&&validateBankAccountNo()&&validateIFSC()&&validateName()&&calculatePremium())
	{
	document.forms['Employeeform'].submit();
	}
}

function validateEmployeeId()
{
	var employeeId=document.Employeeform.EmpId.value;
	var letters= /^[0-9]+$/; 
	if(!letters.test(employeeId)){
	alert("invalid format for Employeeid");
	document.Employeeform.EmpId.focus();
	return false;
	}
	else if(employeeId<=1000000 || employeeId>=2000000)
	{
		alert("please enter only numeric values start with 1 and must have 7 digit for EmployeeId");
		document.Employeeform.EmpId.focus();
		return false;	
	}
	else{
	return true;
	}
}


function validatePassword()   
{   
	var passward=document.Employeeform.password.value;
	var pass=/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
	if(!pass.test(passward))   
	{  
		alert("Password should contain atleast 1 uppercase, 1 lowercase, 1 special character and it should be 8 to 15 characters long"); 
		return false;  
	}  
	else  
	{  
	return true;  
	}  
}    

function validateEmail()
{
	var email=document.Employeeform.Email.value;
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(!mailformat.test(email))
	{
	alert("You have entered an invalid email address!");
	document.Employeeform.Email.focus();
	return false;
	}
	else
	{
	alert("correct email");
	return true;	
	}
}

function validateAlternateEmail()
{
	var email=document.Employeeform.alternateEmail.value;
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(!mailformat.test(email))
	{
	alert("You have entered an invalid email address!");
	document.Employeeform.alternateEmail.focus();
	return false;
	}
	else
	{
	alert("correct email");
	return true;	
	}
}


function validatePhoneNo()
{
	 var AlterPhNo=document.Employeeform.PhNo.value;
	
       if(isNaN(AlterPhNo)|| AlterPhNo.indexOf(" ")!=-1)
        {
		document.Employeeform.PhNo.focus();
            alert("Enter number only");
           return false; 
        }
    else if (AlterPhNo.length!=10)
    {
    	document.Employeeform.PhNo.focus();
    	alert("enter 10 digit number");
         return false;
    }
    else if ((AlterPhNo.charAt(0)!="9") && (AlterPhNo.charAt(0)!="8") && (AlterPhNo.charAt(0)!="7"))
    {
    	 document.Employeeform.PhNo.focus();
         alert("it should start with 9 or 8 or 7 ");
         return false;
    }
 }

function validateAlternatePhoneNo()
{
	var AlterPhNo=document.Employeeform.Alternate.value;
	
       if(isNaN(AlterPhNo)|| AlterPhNo.indexOf(" ")!=-1)
        {
		document.Employeeform.Alternate.focus();
            alert("Enter number only");
           return false; 
        }
    else if (AlterPhNo.length!=10)
    {
    	document.Employeeform.Alternate.focus();
    	alert("enter 10 digit number");
         return false;
    }
    else if ((AlterPhNo.charAt(0)!="9") && (AlterPhNo.charAt(0)!="8") && (AlterPhNo.charAt(0)!="7"))
    {
    	 document.Employeeform.Alternate.focus();
         alert("it should start with 9 or 8 or 7 ");
         return false;
    }
 }


function validatePolicyPeriod()
{
	var PolicyPeriod=document.Employeeform. PolicyPeriod.value;
	if(PolicyPeriod!=null)
	{
		document.Employeeform.Policyperiod.focus();
		alert("enter policy period");
		return false;
	}
	
	if(isNaN( PolicyPeriod)|| PolicyPeriod.indexOf(" ")!=-1)
    {
		document.Employeeform. PolicyPeriod.focus();
        alert("Enter number only");
        return false; 
    }
    if (PolicyPeriod>=1 && PolicyPeriod<=99)
    {
    	document.Employeeform.PhNo.focus();
    	alert("enter 10 digit number");
         return false;
    }
}
	
function validateBankAccountNo()
{
	var accountNo=document.Employeeform.accno.value;
	var letters= /^[0-9]+$/; 
	if(!letters.test(accountNo)){
		alert("Enter number only");
		document.Employeeform.accno.focus();
	}
	else if(accountNo.length<=9 || accountNo.length>=17)
	{
		alert("please enter bank account number  between 9 to 17  numeric digit");
		document.Employeeform.accno.focus();
		return false;
	}
	else
	{
		return true;
	}
}


function validateIFSC() {
    var ifscval = document.Employeeform.ifsc.value;
    var reg = /[A-Z|a-z]{4}[0][a-zA-Z0-9]{6}$/;

    if (reg.test(ifscval)) {
        return true;
    }
    else {
        alert("You Entered Wrong IFSC Code \n\n ------ or------ \n\n IFSC code should be count 11 \n\n-> Starting 4 should be only alphabets[A-Z] \n\n-> Remaining 7 should be accepting only alphanumeric");
        document.Employeeform.ifsc.focus();
        return false;
    }

}

function validateName()
{  
	var regexp = /^[a-zA-Z-' ]+$/;
	var emp=document.Employeeform.EmpName.value;
	if(!regexp.test(emp)){
	alert("Enter valid name");
	document.Employeeform.EmpName.focus();
	return false;
	}
    else{
	document.Employeeform.EmpName.value=emp.toUpperCase();
	return true;
	}
 }

function calculatePremium()
{
	var total=document.Employeeform.totalSum.value;
	var pre=total*2/100;
	document.Employeeform.premiumAmmount.value=pre;
}












