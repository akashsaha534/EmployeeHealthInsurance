function validateName(){
	
	var Name=document.Employeeform.EmpName.value;
	
	// check for string
	var letters = /^[A-Za-z ]+[A-Za-z ]$/;
	
       if(!(Name.match(letters))){
    	   document.getElementById("nameerror").style.color="red";
    	   
    	   document.getElementById("nameerror").style.fontFamily ="Times New Roman";
    	   document.getElementById("nameerror").innerHTML="Please enter name(letters only).";
   		      		return false;
   		      		
   	}
   	
    document.getElementById("nameerror").innerHTML="";
    document.Employeeform.EmpName.value=Name.toUpperCase();
       return true;
	}

function validatedob()
{ 
   var today =new Date();
    var validdate= /([0-9]|0[1-9]|1[0-2])[- \/.]([0-9]|0[1-9]|[1][0-9]|[2][0-9]|3[0-1])[- \/.](19|20)[0-9][0-9]/;
    var inputDate =document.Employeeform.DOB.value;
    if (!inputDate.match(validdate) && new Date(inputDate)> today)
    {
    	document.getElementById("doberror").style.color="red";
		document.getElementById("doberror").style.fontFamily ="Times New Roman";
	   	document.getElementById("doberror").innerHTML="Please enter a vaild date of birth.";
    	return false;
    
   
    
    	}
   
    	document.getElementById("doberror").innerHTML="";
    	return inputDate;
   

}
function validatedobr()
{ 
   
    var validdate= /([0-9]|0[1-9]|1[0-2])[- \/.]([0-9]|0[1-9]|[1][0-9]|[2][0-9]|3[0-1])[- \/.](19|20)[0-9][0-9]/;
    var inputDate =document.Employeeform.DOB.value;
    if (!inputDate.match(validdate) && new Date(inputDate)>validatedob())
    {
    	if(validaterelation()=="father" || validaterelation()=="father-in-law" || validaterelation()=="mother" || validaterelation()=="mother-in-law")
    	document.getElementById("doberror").style.color="red";
		document.getElementById("doberror").style.fontFamily ="Times New Roman";
	   	document.getElementById("doberror").innerHTML="date of birth should be day after employee date of birth";
    	return false;
    
   
    
    	}
   
    	document.getElementById("doberror").innerHTML="";
    	return true;
   

}

function validateEmail()
{
	var email=document.getElementById("eId").value;
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(!email.match(mailformat))
	{
		document.getElementById("emailerror").style.color="red";
		document.getElementById("emailerror").style.fontFamily ="Times New Roman";
 	   	document.getElementById("emailerror").innerHTML="Please enter vaild email address.";
 	   	return false;
	}
	document.getElementById("emailerror").innerHTML="";
	return true;	
	
}

function validateAlternateEmail()
{
	var email=document.Employeeform.alternateEmail.value;
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(email.match(mailformat)) 
	{	
		document.getElementById("email2error").innerHTML="";
		return true;
	}
	else if(email==null || email=="")
		{
		document.getElementById("email2error").innerHTML="";
		return true;
		}
	else
		{
		
		document.getElementById("email2error").style.color="red";
		document.getElementById("email2error").style.fontFamily ="Times New Roman";
 	   	document.getElementById("email2error").innerHTML="Please enter vaild email address.";
 	   	return false;
		}
}

function validatePhoneNo()
{
	var phone_number=document.Employeeform.Phone.value;
	var regex = /^\d{10}$/;;

    if (phone_number.match(regex)) 
    {
    	document.getElementById("perror").innerHTML=""; 
		  return true; 
    	
    } else
    {
    	document.getElementById("perror").style.color="red";
  		document.getElementById("perror").style.fontFamily ="Times New Roman";
  		document.getElementById("perror").innerHTML="Please enter 10 digit phone no."; 
        
        return false;
    	 
    }
 }
function validateAlternatePhoneNo()
{
	var phone_number=document.getElementById("apno").value;
	  var phone = /^\d{10}$/;  
	  if(phone_number.match(phone))  
	     {
		   document.getElementById("aperror").innerHTML=""; 
		  return true; 
	     } 
	  else if(phone_number==null || phone_number=="")
			{
	 		document.getElementById("aperror").innerHTML="";
	 		return true;
	 		}
	  
	  		document.getElementById("aperror").style.color="red";
	  		document.getElementById("aperror").style.fontFamily ="Times New Roman";
	  		document.getElementById("aperror").innerHTML="Please enter 10 digit phone no."; 
	        
	        return false;
    
 }
function validatePolicyPeriod()
{
	var PolicyPeriod=document.Employeeform.policyPeriod.value;

	 
	if(PolicyPeriod==null || PolicyPeriod=="" || PolicyPeriod=="0")
	{
		document.getElementById("pperror").style.color="red";
  		document.getElementById("pperror").style.fontFamily ="Times New Roman";
  		document.getElementById("pperror").innerHTML="Please enter policy period.";
		return false;
	}
	
	else if(isNaN( PolicyPeriod)|| PolicyPeriod.indexOf(" ")!=-1)
    {
		document.getElementById("pperror").style.color="red";
  		document.getElementById("pperror").style.fontFamily ="Times New Roman";
  		document.getElementById("pperror").innerHTML="Please enter only digit.";
        return false; 
    }
	else if (PolicyPeriod.length>2)
    {
    	document.getElementById("pperror").style.color="red";
  		document.getElementById("pperror").style.fontFamily ="Times New Roman";
  		document.getElementById("pperror").innerHTML="Policy period can de 2 digits only.";
         return false;
    }
	else{
		document.getElementById("pperror").innerHTML="";
		return true;
	}
    
}

function calculatePremium()
{	
	var total=document.Employeeform.totalSum.value;
	
	if(total==null || total=="")
	{
		document.getElementById("terror").style.color="red";
  		document.getElementById("terror").style.fontFamily ="Times New Roman";
  		document.getElementById("terror").innerHTML="Please enter total sum.";
  		document.Employeeform.premiumAmmount.value=0;
		return false;
	}
	else if(isNaN(total)|| total.indexOf(" ")!=-1)
    {
		document.getElementById("terror").style.color="red";
  		document.getElementById("terror").style.fontFamily ="Times New Roman";
  		document.getElementById("terror").innerHTML="Total sum can be only digits.";
  		document.Employeeform.premiumAmmount.value=0;
        return false; 
    }
	else{
		
	var pre=total*2/100;
	document.getElementById("terror").innerHTML="";
	document.Employeeform.premiumAmmount.value=pre;
	return true;
	}
}
function validateBankAccountNo()
{
	var accountNo=document.Employeeform.accno.value;
	var letters= /^[0-9]+$/; 
	if(accountNo==null || accountNo=="")
	{
		document.getElementById("anoerror").style.color="red";
  		document.getElementById("anoerror").style.fontFamily ="Times New Roman";
  		document.getElementById("anoerror").innerHTML="Please enter bank account no.";
		return false;
	}
	else if(!letters.test(accountNo)){
		document.getElementById("anoerror").style.color="red";
  		document.getElementById("anoerror").style.fontFamily ="Times New Roman";
  		document.getElementById("anoerror").innerHTML="Bank account no. can be only digits.";
        return false; 
		
	}
	else if(accountNo.length<=8 || accountNo.length>=18)
	{
		document.getElementById("anoerror").style.color="red";
  		document.getElementById("anoerror").style.fontFamily ="Times New Roman";
  		document.getElementById("anoerror").innerHTML="Please enter bank account number between 9 to 17 numeric digits.";
        return false; 
	}
	else
	{
		document.getElementById("anoerror").innerHTML="";
		return true;
	}
}
function validateBank()
{	
	var total=document.Employeeform.nameOfBank.value;
	var check= /^[A-Za-z ]+[A-Za-z ]$/;
	if(total.match(check))
		{
		document.Employeeform.nameOfBank.value=total.toUpperCase();
		document.getElementById("berror").innerHTML="";
			return true;
		}
	else if(total==null || total=="")
	{
		document.getElementById("berror").style.color="red";
  		document.getElementById("berror").style.fontFamily ="Times New Roman";
  		document.getElementById("berror").innerHTML="Please enter bank name.";
		return false;
	}else
		{
		document.getElementById("berror").style.color="red";
  		document.getElementById("berror").style.fontFamily ="Times New Roman";
  		document.getElementById("berror").innerHTML="Please enter bank name.";
		return false;
		
		}
}
function validateIFSC() {
    var ifscval = document.Employeeform.ifsc.value;
    var reg = /^[A-Z|a-z]{4}[0][0-9]{6}$/;
    if(ifscval.match(reg))
    {
		document.Employeeform.ifsc.value=ifscval.toUpperCase();
		document.getElementById("cerror").innerHTML="";
        return true;
    }
    else {
    	document.getElementById("cerror").style.color="red";
  		document.getElementById("cerror").style.fontFamily ="Times New Roman";
  		document.getElementById("cerror").innerHTML="You Entered Wrong IFSC Code. IFSC code should be count 11, Starting 4 should be only alphabets[A-Z], 5th should be zero(0), Remaining 6 should be accepting only alphanumeric.";
		return false;
    }

}
function validatepolicydate()
{ 
   var today =new Date();
    var validdate= /([0-9]|0[1-9]|1[0-2])[- \/.]([0-9]|0[1-9]|[1][0-9]|[2][0-9]|3[0-1])[- \/.](19|20)[0-9][0-9]/;
    var inputDate =document.Employeeform.policydate.value;
    if (!inputDate.match(validdate) && new Date(inputDate)< today)
    {
    	document.getElementById("pderror").style.color="red";
		document.getElementById("pderror").style.fontFamily ="Times New Roman";
	   	document.getElementById("pderror").innerHTML="Policy start date must day after current date.";
    	return false;
    
   
    
    	}
   
    	document.getElementById("pderror").innerHTML="";
    	return true;
   

}
function validatecheckbox()
{
if(!this.document.Employeeform.checkbox.checked)
{
    alert('You must agree to our terms and policy.');
    return false;
}
else
	return true;
}

function validategender()
{

	var inputprefix= document.Employeeform.prefix.value;
	var inputrelation=document.Employeeform.relation.value;
	if((inputprefix=="Mr." && inputrelation=="Father") || (inputprefix=="Mr." && inputrelation=="Father-in-law") || (inputprefix=="Mr." && inputrelation=="Brother"))
		{
		document.getElementById("rerror").innerHTML="";
			document.getElementById("male").checked = true;
			return inputrelation;
		}
	else if((inputrelation=="Mother" && inputprefix=="Mrs.")   ||( inputrelation=="Mother-in-law" && inputprefix=="Mrs.") || (inputrelation=="Sister" && inputprefix=="Mrs.") || (inputrelation=="Sister" && inputprefix=="Miss."))
		{
		document.getElementById("rerror").innerHTML="";
		document.getElementById("female").checked = true;
		return relationrelation;
		}
	else
		{
		document.getElementById("rerror").style.color="red";
  		document.getElementById("rerror").style.fontFamily ="Times New Roman";
  		document.getElementById("rerror").innerHTML="prefix and relation does not match.";
		return false;
		}
}
function validategenderemp()
{

	var inputprefix= document.Employeeform.prefix.value;
	if(inputprefix=="Mr.")
		{
		document.getElementById("gerror").innerHTML="";
			document.getElementById("male").checked = true;
			return true;
		}
	else if(inputprefix=="Mrs." || inputprefix=="Miss.")
		{
		document.getElementById("gerror").innerHTML="";
		document.getElementById("female").checked = true;
		return true;
		}
	else
		{
		document.getElementById("rerror").style.color="red";
  		document.getElementById("rerror").style.fontFamily ="Times New Roman";
  		document.getElementById("rerror").innerHTML="prefix and relation does not match.";
		return false;
		}
}

/*function validaterelation()
{
    var inputrelation=document.Employeeform.relation.value;
    if(inputrelation=="father" || inputrelation=="father-in-law" || inputrelation=="brother")
	{
		document.getElementById("male").checked = true;
	}
else if(inputrelation=="mother" || inputrelation=="mother-in-law" || inputrelation=="sister")
	{
	document.getElementById("female").checked = true;
	}
else
	{
	return false;
	}
}*/
function validationform(){
	 if(validateBank() && validateBankAccountNo() && calculatePremium() && validatePolicyPeriod() && validateAlternatePhoneNo() && validatePhoneNo() && validateEmail() && validateAlternateEmail() && validatedob() && validateName() && validatecheckbox() && validategenderemp()){ 
		 return true;
	 }
	 else{
		 alert("please enter all mandatory fields");
		 return false;
		 
	 }
}
function validationformdep(){
	 if(validateName() && validatedobr() && validatepolicydate() && validatePolicyPeriod() && calculatePremium() && validatecheckbox() && validategender()){ 
		 return true;
	 }
	 else{
		 alert("please enter all mandatory fields");
		 return false;
		 
	 }
}