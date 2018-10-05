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
		
		function myFBLogin(){
			// Get current status
			FB.getLoginStatus(function(response) {
			  if (response.status === 'connected') {
			    // The user is logged in and has authenticated your app, and response.authResponse supplies
			    // the user's ID, a valid access token, a signed request, and the time the access token 
			    // and signed request each expire.
			    uid = response.authResponse.userID;
			    accessToken = response.authResponse.accessToken;
			    
			    FB.api('/me', function(meResponse) {
				       	console.log('Good to see you, ' + meResponse.name + '.');
				       	fbUserName =  meResponse.name;
				       	document.getElementById('userName').value = fbUserName;
						document.getElementById('status').innerHTML = 'You are already logged in. Good to see you, ' + fbUserName+ '.';
						document.getElementById('proceedForm').style.visibility = 'visible'; //Will show
				});
			    
			  } else {
			    // The user isn't logged in to Facebook. You can launch a login dialog with a user gesture, but the user may have
			    // to log in to Facebook before authorizing your application.
			    
			    //Try to login. 
				  FB.login(function(loginResponse) {
					    if (loginResponse.authResponse) {
					     FB.api('/me', function(meResponse) {
					       	console.log('Good to see you, ' + meResponse.name + '.');
					       	fbUserName =  meResponse.name;
					       	document.getElementById('userName').value = fbUserName;
							document.getElementById('status').innerHTML = 'Good to see you, ' + fbUserName+ '.';
							document.getElementById('proceedForm').style.visibility = 'visible'; //Will show
					     });
					    } else {
					    	document.getElementById('status').innerHTML = 'Tried logging in. User cancelled login or did not fully authorize.';
							document.getElementById('proceedForm').style.visibility = 'hidden'; //Will hide
					    }
					}, {scope: 'public_profile'});
			  }
 			});			
		}
		
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
		}
		
		
		</script>
	
		<div style="text-align:left;font-family:Arial, Helvetica, sans-serif;">
		<h1>Punctual Panda</h1>
		Let our panda help you become more productive! 
		<br>
		<hr size="2">
		<br>
		<h4>Login</h4>		
		<input type="image" src="<c:url value='/images/LogInWithFaceBook.png'/>" onclick="myFBLogin();"/>
		<br><br>
		<button onclick="myFBLogout();">   Logout from Facebook   </button>
		<br><br><br><br>
		<div id="status"></div><br>
		<div id="proceedForm" style="visibility: hidden;">
			<form:form action="hello" method="POST" modelAttribute="todoTask">
				<input type="hidden" id="userName" name="userName" />
				<input type="submit" value="    Proceed to manage your tasks..   "/>
			</form:form>
		</div>
		<br><br>
		<hr size="2">
		
		</div>
	</body>
	
</html>
