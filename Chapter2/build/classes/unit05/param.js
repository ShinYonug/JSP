function check(){
	if(documet.frm.id.value == ""){
		alert("아이디를 입력해주세요.");
		document.frm.id.focus();
		return false;
	}else if (document.frm.age.value == ""){
		alert("나이를 입력해주세요.");
		document.frm.age.focus();
		return.false;
	}else if (isNaN(document.frm.age.value)){
		alert("숫자로 입력해주세요");
		document.frm.age.focus();
		return false;
	}else{
		return true;
	}
}



//교재 101 페이지 유효성 테스트 