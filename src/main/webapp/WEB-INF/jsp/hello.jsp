<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<body leftmargin="50" topmargin="70">
	
	<script>				
		  window.fbAsyncInit = function() {
		    FB.init({
		      appId      : '1081586782006977',
		      cookie     : true,
		      xfbml      : true,
		      version    : 'v3.1'
		    });
		      
		    FB.AppEvents.logPageView();   
		      
		  };
		 
		  //Include the JavaScript SDK on your page once, ideally right after the opening body tag.
		  (function(d, s, id){
		     var js, fjs = d.getElementsByTagName(s)[0];
		     if (d.getElementById(id)) {return;}
		     js = d.createElement(s); js.id = id;
		     js.src = "https://connect.facebook.net/en_US/sdk.js";
		     fjs.parentNode.insertBefore(js, fjs);
		   }(document, 'script', 'facebook-jssdk'));

		document.getElementById('proceedForm').style.display = 'none';
		  
		var fbUserName = "";
		var fbUserName = "";
		var uid = "";
		var accessToken= "";

		function myFBLogout(){
			FB.getLoginStatus(function(response) {
				  if (response.status === 'connected') {
				    // The user is logged in and has authenticated your app, and response.authResponse supplies
				    // the user's ID, a valid access token, a signed request, and the time the access token 
				    // and signed request each expire.
				    FB.logout(function(response) {
						  // user is now logged out
						document.getElementById('status').innerHTML = 'You are now loggedd off. Goodbye.';
						document.getElementById('proceedForm').style.visibility = 'hidden'; //Will hide
						});
				  } else {
						document.getElementById('status').innerHTML = 'You are not logged in. Please login.';
				  }
			});
			window.location='login';
		}
		
		</script>
	
	
	
	<div style="text-align:left;font-family:Arial, Helvetica, sans-serif;">
	
		<h1>Punctual Panda</h1>
		Let our panda help you become more productive! 
		<br>
		<hr size="2">
		<br><br>
		Welcome <label>${empty todoTaskFromLogin.userName? loginUserName : todoTaskFromLogin.userName}</label>!<br>
		<button onclick="myFBLogout();">   Logout from Facebook   </button>
		<br><br>
		<h4>Add New Task</h4>
		<form:form action="addTask" method="POST" modelAttribute="todoTask">
			<form:hidden path="userName" value="${empty todoTaskFromLogin.userName? loginUserName : todoTaskFromLogin.userName}"/>
			Task Name: <form:input path="taskName" size="40"/><br><br>
			Due Date: <form:input type="date" path="dueDate" />
				<div style="font-family:    Arial, Helvetica, sans-serif;font-size:14px;" >
					To get the date picker please hover on the right side of the box.
				</div>
			<br><br>
			<input type="submit" value="   A d d   T a s k    "  style="width: 100px; "/>
		
		</form:form>
		<br>
		<hr size="2">
			<h4>Current Tasks</h4>
			<div style="font-family:    Arial, Helvetica, sans-serif;font-size:14px;" >
			Note: You can delete your tasks by clicking the X button.
			</div>
			<br>
			<c:forEach var='task' items="${alltasks}">	
				<form:form action="deleteTask" method="POST" modelAttribute="todoTask">
					<form:hidden path="userName" value="${empty todoTaskFromLogin.userName? loginUserName : todoTaskFromLogin.userName}"/>
					<form:input path="taskId" type="hidden" value="${task.taskId}"/>
					<input type="submit" value=" X "  style="width: 30px; "/> ${task.taskName}. <br>    
					<div style="font-family:    Arial, Helvetica, sans-serif;font-size:11px;" >
					<pre>      Due Date: ${task.dueDate}</pre>   
					</div>
				</form:form>
				<br>
			</c:forEach>
			
		 
		<hr size="2">
	</div>	
	</body>
	
</html>
