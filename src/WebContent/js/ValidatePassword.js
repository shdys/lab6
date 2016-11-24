(function(){
	var sub=document.getElementById("sub");
	//初始化移入移出时间
	if(sub.addEventListener){
		sub.addEventListener("click",test);
	}else if(sub.attachEvent){
		sub.attachEvent("onClick",test);
	}
})();

function test(){
	var password = document.getElementById("password");
	var repassword = document.getElementById("repassword");
	if(password.value != repassword.value)
	{
		alert("Sorry,the password and the retype password are not the same!");
	}
	else
	{
		document.forms[1].submit();
	}
}