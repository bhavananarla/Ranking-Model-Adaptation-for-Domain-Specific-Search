function check(){
	var id=document.form1.listid;
	var name1=document.form1.listname;
	var no=document.form1.num_of_emp;
	if(id.value==""){
		alert("please enter listId");
		id.focus();
		return false;
	} else if (isNaN(id.value)){
		alert("please enter numbers only");
		document.form1.listid.value=="";
		id.focus();
		return false;
	}
	else if(name1.value==""){
		alert("please enter listname");
		name1.focus();
		return false;
	}else if(!(isNaN(name1.value))){
		alert("please enter characters only");
		name1.focus();
		return false;
	}
	if(no.value==""){
		alert("please enter number of customers");
		no.focus();
		return false;
	} else if (isNaN(no.value)){
		alert("please enter numbers only");
		//document.form1.listid.value=="";
		no.focus();
		return false;
	}

}/*
function check2(){
	alert(document.from2.formid.value);
	var fromid=document.from2.formid;
	alert(formid.value);
	if(fromid.value==""){
		alert("please enter listId");
		fromid.focus();
		return false;
	} else if (isNaN(fromid.value)){
		alert("please enter numbers only");
		document.form2.formid.value=="";
		fromid.focus();
		return false;
	}
}
*/