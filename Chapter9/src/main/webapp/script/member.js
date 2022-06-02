function loginCheck(){
	if (document.frm.userid.value.length ==0) {
		alert("id");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == ""){
		alert("pwd");
		frm.pwd.focus();
		return false;
	}
	return true;
}

function idCheck(){
	if(document.frm.userid.value == ""){
		alert("아이디를 입력하여 주십시오.");
		document.frm.userid.focus();
		return;
	}
	var url = "idCheck.do?userid=" + document.frm.userid.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizeable=no, width=450, height=200");
}