<!DOCTYPE html>
<!-- saved from url=(0053)file:///home/aaron/Downloads/manage_users_screen.html -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Manage Users</title>
        <style type="text/css">
        <!--
        .tab { margin-left: 40px; }
        -->
        </style>
    <style>
        body {
            background-color: #C5D1FF;
        }
    </style></head>
    
    <body>
        <h1>Manage Users
        </h1>
        <form action="file:///action_page.php">
			<h2>Add New User</h2>
			First name:<input type="text" name="FirstName" value=""><br>
            <br>
            Last name: <input type="text" name="LastName" value=""><br>
            <br>
            User ID: <input type="text" name="User ID" value=""><br>
            <br>
            Temporary Password: <input type="text" name="Password" value=""><br>
            <br>
            Email: <input type="text" name="Email" value=""><br>
            <br>
            Phone #: <input type="text" name="Phone #" value=""><br>
            <br>
			Credit Card #: <input type="text" name="Email" value=""><br>
            <input type="radio" name="radAnswer" value="Mastercard"> Mastercard<br>
            <input type="radio" name="radAnswer" value="Visa"> Visa<br>
            <br>
			<input type="submit" value="Submit">
            <input type="submit" value="Cancel">
        	<p>Click the "Submit" to create user or "Cancel" to go to previous screen </p>
			<br>
			<h2>Edit User</h2>
			Search user name to display below:<input type="text" name="user name" value=""><br>
            <br>
			<h4>Recently Viewed User Information</h4>

				<table style="width:100%">
				  <tbody><tr>
					<th>Firstname</th>
					<th>Lastname</th> 
					<th>User name</th>
					<th>Email Address</th>
					<th>Phone Number</th>
					<th>Credit Card</th>
				  </tr>
				  <tr>
					<td><input type="checkbox" name="name1" value="Jill"> Jill</td>
					<td>Smith</td>
					<td>singer101</td>
					<td>jills@aol.com</td>
					<td>770-345-8751</td>
					<td>Mastercard: 7473 9182 8463 7282</td>
				  </tr>
				  <tr>
					<td><input type="checkbox" name="name2" value="David"> David</td>
					<td>Hassleback</td>
					<td>hassdavid</td>
					<td>hass@aol.com</td>
					<td>770-857-2324</td>
					<td>Visa: 1234 1234 1234 1234</td>
				  </tr>
				  <tr>
					<td><input type="checkbox" name="name3" value="Eve"> Eve</td>
					<td>Jackson</td>
					<td>evej234</td>
					<td>evej@att.net</td>
					<td>678-297-0971</td>
					<td>Visa: 1235 1234 1234 1234</td>
				  </tr>
				  <tr>
					<td><input type="checkbox" name="name4" value="John"> John</td>
					<td>Doe</td>
					<td>jdoe123</td>
					<td>jdoe@gmail.com</td>
					<td>678-234-8762</td>
					<td>Mastercard: 2110 4762 2744 9176</td>
				  </tr>
				</tbody></table>
			<br><br>
			<input type="radio" name="radAnswer" value="Edit Information"> Edit Selected Users<br>
            <input type="radio" name="radAnswer" value="delete user"> Delete Selected Users<br>
            <br>
			<input type="submit" value="Submit">
            <input type="submit" value="Cancel">
		</form>
        <p>Click the "Submit" to proceed or "Cancel" to go to previous screen</p>
    



</body></html>