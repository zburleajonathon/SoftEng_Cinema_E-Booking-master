<!DOCTYPE html>
<!-- saved from url=(0046)file:///home/aaron/Downloads/edit_profile.html -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
		<title>Edit Profile</title>
		<style type="text/css">
		<!--
		.tab { margin-left: 40px; }
		-->
		</style>
	<style>
		body {
			background-color: #C5D1FF;
		}
	</style>
	
	</head>
	
	<body>
		<h1>Edit Profile
		</h1>
		<form action="editProfile" method="get">
			First name:<input type="text" name="FirstName" value="${editFirst}" placeholder="First name"><br>
			<br>
			Last name: <input type="text" name="LastName" value="${editLast}" placeholder="Last name"><br>
			<br>
			New Password: <input type="text" name="Password" value="${editPass}" placeholder=""><br>
			<br>
			Email: <input type="text" name="Email" value="${editEmail}" placeholder="robbydaking@aol.com"><br>
			<br>
			Phone #: <input type="text" name="Phone" value="${editPhone}" placeholder="555-555-5555"><br>
			<br>
			Address: <input type="text" name="Address" value="${editAddress}" placeholder="1234 Main St."><br>
			<br>
			City: <input type="text" name="City" value="${editCity}" placeholder="City"><br>
			<br>
			State: <input type="text" name="State" value="${editState}" placeholder="Georgia"><br>
			<br>
			Zip: <input type="text" name="Zip" value="${editZip}" placeholder="12345"><br>
			<br>
			Name on Card: <input type="text" name="cc-name" value="${editCCName}" placeholder="**************"><br>
			<br>
			Credit Card Number <input type="text" name="CreditCard" value="${editCredit}" placeholder="**************"><br>
			<br>
			Expiration: <input type="text" name="cc-expiration" value="${editExp}" placeholder="****"><br>
			<br>
			CVV: <input type="text" name="cc-cvv" value="${editCVV}" placeholder="***"><br>
			<br>
			<input type="checkbox" name="subscribe" value="subscribe"> Subscribe my email to recieve promotions<br>
			<a href="orderHistory" class="button">Order History and Refund</a><br>
			<br>
			<input type="submit">

			<a href="home_LoggedIn" class="button">Cancel</a><br>
		</form>
		<p>Click the "Submit" button to save changes or "Cancel" button to 
			cancel.
		</p>
		<br>
		<p> <font size="6" color="red"> ${OUTPUT}</font></p>
	

</body></html>
