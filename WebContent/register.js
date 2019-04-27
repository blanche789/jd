// JavaScript Document
		function onLoad(){
			var registerDialog = document.getElementById("register_dialog");
			registerDialog.style.display = "block";
			var bgDiv = document.getElementById("bg_div");
			bgDiv.style.display = "block";
		}
		
		function cancelDialog(){
			window.location="login.html";
		}
		
		function agreeDialog(){ 
			var registerDialog = document.getElementById("register_dialog");
			registerDialog.style.display = "none";
			var bgDiv = document.getElementById("bg_div");
			bgDiv.style.display = "none";
			var userName = document.getElementById("userName");
			userName.focus();
		}

		function validate(){
			
			
			var userName = document.getElementById("userName");
			var userMsg = document.getElementById("userMsg");
			var userSuccess = document.getElementById("userSuccess");
			userSuccess.style.display = "none";
			if(/^$/.test(userName.value))
				{	
					userMsg.innerHTML = "<img src='common/images/icon8.png'/>用户名不能为空";
					userName.focus();
					
					return false;
					
				}else if(!/^.{4,20}$/.test(userName.value)){
					userMsg.innerHTML = "<img src='common/images/icon8.png'/>长度只能在4-20个字符之间";
					userName.focus();
					
					return false;
				}else if(/^\d+$/.test(userName.value)){
					userMsg.innerHTML = "<img src='common/images/icon8.png'/>用户名不能是纯数字，请重新输入！";
					userName.focus();
					
					return false;
				}else if(!/^[\u4e00-\u9fa5\w-]+$/.test(userName.value)){
					userMsg.innerHTML = "<img src='common/images/icon8.png'/>用户名仅支持汉字、字母、数字、-、_组合,请重新输入！";
					userName.focus();
					
					return false;
				}
				else{
					userSuccess.style.display = "inline";
					userMsg.innerHTML = "&nbsp";
					}
			
			var password = document.getElementById("password");
			var passwordMsg = document.getElementById("passwordMsg");
			var passwordSuccess = document.getElementById("passwordSuccess");
			passwordMsg.style.color = "#ff952b";
			passwordSuccess.style.display = "none";
			if(password.value == ""){
				passwordMsg.innerHTML = "<img src='common/images/icon8.png'/>密码不能为空";
				password.focus();
				
				return false;
			}else if(password.value.length<6 || password.value.length>20){
				passwordMsg.innerHTML = "<img src='common/images/icon8.png'/>密码长度为6-20位";
				password.focus();
				
				return false;
			}else if(/^(\d+|[a-zA-Z]+|[^0-9a-zA-Z]+)$/.test(password.value)){
				passwordMsg.innerHTML = "<img src='common/images/icon10.png'/>有被盗风险,建议使用字母、数字和符号两种及以上组合";
				
				passwordMsg.focus();
				return false;
			}else if(/^(?!\D+$)(?![^a-zA-Z]+$)(?![0-9a-zA-Z]+$)/.test(password.value)){
				passwordMsg.innerHTML = "<img src='common/images/icon11.png'/>你的密码很安全";
				passwordSuccess.style.display = "inline";
				passwordMsg.style.color = "#43c75a";
			}else if(/^(?!\d+$)(?![a-zA-Z]+$)(?![^0-9a-zA-Z]+$)/.test(password.value)){
				passwordMsg.innerHTML = "<img src='common/images/icon12.png'/>安全度适中，可以使用三种以上的组合来提高安全强度";
				passwordSuccess.style.display = "inline";
			}
			
			var repassword = document.getElementById("repassword");
			var repasswordMsg = document.getElementById("repasswordMsg");
			var repasswordSuccess = document.getElementById("repasswordSuccess");
			
			repasswordSuccess.style.display = "none";
			if(repassword.value == ""){
				repasswordMsg.innerHTML = "<img src='common/images/icon8.png'/>确认密码不能为空";
				repassword.focus();
				
				return false;
			}else if(repassword.value != password.value){
				repasswordMsg.innerHTML = "<img src='common/images/icon8.png'/>两次密码不一致";
				repassword.focus();
				
				return false;
			}else if(repassword.value != password.value){
				repasswordMsg.innerHTML = "<img src='common/images/icon8.png'/>两次密码不一致";
				repassword.focus();
			
				return false;
			}
			
			else{
				repasswordMsg.innerHTML = "&nbsp";
				repasswordSuccess.style.display = "inline";
			}
			
			var telephone = document.getElementById("telephone");
			var telephoneMsg = document.getElementById("telephoneMsg");
			var telephoneSuccess = document.getElementById("telephoneSuccess");
			telephoneSuccess.style.display = "none";
			if(telephone.value == "")
				{
					telephoneMsg.innerHTML = "<img src='common/images/icon8.png'/>手机不能为空";
					telephone.focus();
					
					return false;
				}else if(telephone.value.length != 11){
					telephoneMsg.innerHTML = "<img src='common/images/icon8.png'/>手机号必须为11位";
					telephone.focus();
					
					return false;
				}else if(isNaN(telephone.value)){
					
					telephoneMsg.innerHTML = "<img src='common/images/icon8.png'/>手机号必须由数字组成";
					telephone.focus();
					
					return false;
				}else if(!/^(1[38]\d{9}|15[012356789]\d{8}|14[57]\d{8}|17[678]\d{8})$/.test(telephone.value)){
					
					telephoneMsg.innerHTML = "<img src='common/images/icon8.png'/>手机号格式不正确";
					telephone.focus();
					
					return false;
				}
				else{
					telephoneMsg.innerHTML = "&nbsp";
					telephoneSuccess.style.display = "inline";
				}
			
			var validateCode = document.getElementById("validateCode");
			var validateCodeMsg = document.getElementById("validateCodeMsg");
			if(validateCode.value == "")
				{
					validateCodeMsg.innerHTML = "<img src='common/images/icon8.png'/>手机验证码不能为空";
					validateCode.focus();
					return false;
				}else if(validateCode.value.length != 6){
					validateCodeMsg.innerHTML = "<img src='common/images/icon8.png'/>手机号必须为6位";
					validateCode.focus();
					return false;
				}else if(isNaN(validateCode.value)){
					
					validateCodeMsg.innerHTML = "<img src='common/images/icon8.png'/>手机验证码必须由数字组成";
					validateCode.focus();
					return false;
				}
				else{
					validateCodeMsg.innerHTML = "<img src='common/images/icon9.png'/> 手机验证码格式正确";
					validateCodeMsg.style.color = "#28c247";
					
				}
			
			return true;
		}