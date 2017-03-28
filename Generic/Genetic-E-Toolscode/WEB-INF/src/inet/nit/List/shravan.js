<script language="JavaScript">
  function validateDOB(thisDate)
{
	var checkstr = "0123456789";
	var DateField = thisDate;

	var DateValue = thisDate;
	var DateTemp = "";

	var seperator = "-";
	var day;
	var month;
	var year;
	var leap = 0;
	var err = 0;
	var i;
	

	if(thisDate == "") err = 10;
	else 
	{
		
		if (DateValue.length != 9) err = 19;

		day = DateValue.substr(0,2);
		if (day < 1) err = 22;

		month = DateValue.substr(3,3);
		if(!isNaN(month)) err=13;
		var mon = month;
		mon = mon.toUpperCase();

		if ((mon != "JAN")  && (mon != "FEB") && (mon != "MAR") && (mon != "APR") && (mon != "MAY") && (mon != "JUN") && (mon != "JUL") && (mon != "AUG") && (mon != "SEP") && (mon != "OCT") && (mon != "NOV") && (mon != "DEC")) err = 21;

		year = DateValue.substr(7,2);
		if(year >= 0 && year <=8) yr = 20 + year;
		else yr=19+year;

		if ((yr % 4 == 0) || (yr % 100 == 0) || (yr % 400 == 0)) leap = 1;
		if ((mon == "FEB") && (leap == 1) && (day > 29)) err = 23;
		if ((mon == "FEB") && (leap != 1) && (day > 28)) err = 24;


		if ((day > 31) && ((mon == "JAN") || (mon == "MAR") || (mon == "MAY") || (mon == "JUL") || (mon == "AUG") || (mon == "OCT") || (mon == "DEC"))) err = 25;
		if ((day > 30) && ((mon == "APR") || (mon == "JUN") || (mon == "SEP") || (month == "NOV"))) err = 26;
		if ((day == 0) && (month == "") && (year == 00)) {err = 0; day = ""; month = ""; year = ""; seperator = "";}

		DateValue = day + seperator + month + seperator + year;
		if(DateField != DateValue) err = 12;

		
		
		
	}
	//alert("DateTemp: " + DateTemp);
	if (err != 0) return false;
	else return true;
}


  function pv(ThisForm)
  {
     if (ThisForm.fname.value == "")
    {
      alert("Please Enter Your \"FIRSTNAME\".");
      ThisForm.fname.focus();
      return(false);
    }
	if (ThisForm.lname.value == "")
    {
      alert("Please Enter Your \"LASTNAME\".");
      ThisForm.lname.focus();
      return(false);
    }
	  db = cf.dob.value;
	if(!validateDOB(db))
	  {
		alert("please enter valid date(dd-mon-yy");
             cf.dob.focus();
      return(false);
      }

    if (ThisForm.cellno.value == "")
    {
      alert("Please Enter Your \"cellno\".");
      ThisForm.cellno.focus();
      return(false);
    }

    if (ThisForm.sex.value == "")
    {
      alert("Please Enter Your \"sex\".");
      ThisForm.sex.focus();
      return(false);
    }

    if (ThisForm.passportno.value == "")
    {
      alert("Please Enter Your \"passportno\".");
      ThisForm.passportno.focus();
      return(false);
    }
      if (ThisForm.email.value == "")
    {
      alert("Please Enter Your \"email\".");
      ThisForm.email.focus();
      return(false);
    }
	if (!((/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(cf.email.value)))){
		alert("Invalid E-mail Address! Please re-enter.");
		cf.email.value="";
		cf.email.focus();
		return (false)
	}
    if (ThisForm.hobbies.value == "")
    {
      alert("Please CONFIRM Your \"hobbies\".");
      ThisForm.hobbies.focus();
      return(false);
    }

    if (ThisForm.p_streetname.value == "")
    {
      alert("Please Enter Your \"streetname\".");
      ThisForm.p_streetname.focus();
      return(false);
    }
	 if (ThisForm.c_streetname.value == "")
    {
      alert("Please Enter Your \"streetname\".");
      ThisForm.c_streetname.focus();
      return(false);
    }

    if (ThisForm.p_area.value == "")
    {
      alert("Please Enter Your \"AREA\".");
      ThisForm.p_area.focus();
      return(false);
    }

    if (ThisForm.c_area.value == "")
    {
      alert("Please Enter Your \"AREA\".");
      ThisForm.c_area.focus();
      return(false);
    }

    if (ThisForm.p_city.value == "")
    {
      alert("Please Enter Your \"city\".");
      ThisForm.p_city.focus();
      return(false);
    }   

    if (ThisForm.c_city.value == "")
    {
      alert("Please Enter Your \"CITY\".");
      ThisForm.c_city.focus();
      return(false);
    }

   
    if(cf.phno.value=="" ||(isNaN(cf.phno.value)) ||(cf.phno.value.length < 6))
   {
		
			alert('enter valid zip code min of 6 digits');
			
			cf.phno.focus();
			return false;
	}
	 if (ThisForm.qualification.value == "")
    {
      alert("Please Enter Your \"qualification\".");
      ThisForm.qualification.focus();
      return(false);
    }    
	if (ThisForm.branch.value == "")
    {
      alert("Please Enter Your \"branch\".");
      ThisForm.branch.focus();
      return(false);
    }   
  if (ThisForm.skills.value == "")
    {
      alert("Please Enter Your \"skills\".");
      ThisForm.skills.focus();
      return(false);
    }   
  if (ThisForm.o_qualifications.value == "")
    {
      alert("Please Enter Your \"qualification\".");
      ThisForm.o_qualifications.focus();
      return(false);
    }
	if (ThisForm.experience.value == "")
    {
      alert("Please Enter Your \"experience\".");
      ThisForm.experience.focus();
      return(false);
    }   
  if (ThisForm.quali.value == "")
    {
      alert("Please Enter Your \"qualification\".");
      ThisForm.quali.focus();
      return(false);
    }   
   if (ThisForm.m_board.value == "")
    {
      alert("Please Enter Your \"UNIVERSITY\".");
      ThisForm.m_board.focus();
      return(false);
    }   
	 if (ThisForm.m_year.value == "")
    {
      alert("Please Enter Your \"year\".");
      ThisForm.m_year.focus();
      return(false);
    }   
	 if (ThisForm.m_per.value == "")
    {
      alert("Please Enter Your \"PERCENTAGE\".");
      ThisForm.m_per.focus();
      return(false);
    }  
	if (ThisForm.degree.value == "")
    {
      alert("Please Enter Your \"degree\".");
      ThisForm.degree.focus();
      return(false);
    }
	 if (ThisForm.i_board.value == "")
    {
      alert("Please Enter Your \"university\".");
      ThisForm.i_board.focus();
      return(false);
    } 
	 if (ThisForm.i_year.value == "")
    {
      alert("Please Enter Your \"year\".");
      ThisForm.i_year.focus();
      return(false);
    }   
   if (ThisForm.i_per.value == "")
    {
      alert("Please Enter Your \"percentage\".");
      ThisForm.i_per.focus();
      return(false);
    } 
	if (ThisForm.higher.value == "")
    {
      alert("Please Enter Your \"higher\".");
      ThisForm.higher();
      return(false);
    }   
	 if (ThisForm.u_university.value == "")
    {
      alert("Please Enter Your \"university\".");
      ThisForm.u_university.focus();
      return(false);
    }   
	 if (ThisForm.u_year.value == "")
    {
      alert("Please Enter Your \"year\".");
      ThisForm.u_year.focus();
      return(false);
    } 
	 if (ThisForm.u_per.value == "")
    {
      alert("Please Enter Your \"percentage\".");
      ThisForm.u_per.focus();
      return(false);
    }   
	 if (ThisForm.ssc.value == "")
    {
      alert("Please Enter Your \"ssc\".");
      ThisForm.ssc.focus();
      return(false);
    }   
	 if (ThisForm.p_university.value == "")
    {
      alert("Please Enter Your \"university\".");
      ThisForm.p_university.focus();
      return(false);
    } 
	 if (ThisForm.p_year.value == "")
    {
      alert("Please Enter Your \"year\".");
      ThisForm.p_year.focus();
      return(false);
    }   
	 if (ThisForm.p_per.value == "")
    {
      alert("Please Enter Your \"percentage\".");
      ThisForm.p_per.focus();
      return(false);
    }   
	 if (ThisForm.passwd.value == "")
    {
      alert("Please Enter Your \"passwd\".");
      ThisForm.passwd.focus();
      return(false);
    }
	 if (ThisForm.retypepassword.value != ThisForm.passwd.value)
    {
      alert("Please Enter Your \"retypepassword\".");
      ThisForm.retypepassword.focus();
      return(false);
    } 
	 if (ThisForm.question.value == "")
    {
      alert("Please Enter Your \"question\".");
      ThisForm.question.focus();
      return(false);
    }   
   if (ThisForm.answer.value == "")
    {
      alert("Please Enter Your \" answer\".");
      ThisForm.answer.focus();
      return(false);
    }   
  }

   
  function cblur(ThisField)
  {
    cnt=0
    var val=ThisField.value
    len=val.length
    if(len !=0)
    {
      for(i=0;i<len;i++)
      {
        c=val.substr(i,1)
        if(c==" ") cnt++
      }
      if(cnt==len)
      {
        ThisField.value=""
        alert("Your Input Contains Only Space")
        ThisField.focus();
        return(false);
      }
    }
  r=0
  if((ThisField.name=="fname") ||(ThisField.name=="lname") ||(ThisField.name=="sex")||(ThisField.name=="hobbies")||(ThisField.name=="p_streetname")||(ThisField.name=="c_streetname")||(ThisField.name=="p_area")||(ThisField.name=="c_area")||(ThisField.name=="p_city")||(ThisField.name=="c_city")||(ThisField.name=="higher")||(ThisField.name=="skills")||(ThisField.name=="o_qualification")||(ThisField.name=="quali")||(ThisField.name=="m_board")|(ThisField.name=="degree")||(ThisField.name=="i_board")||(ThisField.name=="u_university")||(ThisField.name=="ssc")||(ThisField.name=="p_university")||(ThisField.name=="passwd")||(ThisField.name=="retypepassword")||(ThisField.name=="higher"))
  {
    for(i=0;i<len;i++)
    {
      c=val.substr(i,1)
      if((c<"a"||c>"z")&&(c<"A"||c>"z")&&(c!=" ")&&(c!="."))
      {
        r=r+1
      }
    }
    if(r>0)
    {
      alert("Please Enter Only \"ALPHABETS\".")
      ThisField.value="";
      ThisField.focus();
      return(false);
    }
    /*else
    {
      window.cf.CId.focus();
    } */
  }
  //*******************************
  if((ThisField.name=="passportno") || (ThisField.name=="experience") || (ThisField.name=="m_year") || (ThisField.name=="m_per") || (ThisField.name=="i_year")|| (ThisField.name=="i_per")|| (ThisField.name=="u_year")|| (ThisField.name=="u_per")|| (ThisField.name=="p_year")|| (ThisField.name=="p_per") )
  {
    for(i=0;i<len;i++)
    {
      c=val.substr(i,1)
      if((c<"0" ||c>"9") && (c!="-"))
      {
        r=r+1
      }
    }
    if(r>0)
    {
      alert("Enter Only \"NUMBERS\"!")
      ThisField.value= "";
      ThisField.focus();
      return(false);
    }
  }
  if((ThisField.name=="cellno")||(ThisField.name=="phno") )
	     for(i=0;i<len;i++)
    {
      c=val.substr(i,1)
      if((c<"0")||(c>"9") && (c!="-"))
      {
        r=r+1
      }
    }
    if(r>0)
    {
      alert("Enter Only \"NUMBERS\"!")
      ThisField.value= "";
      ThisField.focus();
      return(false);
    }
 
  //************Mail Id*******************
  
  
  //****************End Of mail Id Checking*******************************

  //****************ExpDate Checking**************************************

  //***************end expdate************************
}
   
function foc()
 {
  document.cf.fname.focus();
 }
</script>
