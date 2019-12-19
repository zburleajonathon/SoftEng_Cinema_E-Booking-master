<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- PAGE settings -->
  <link rel="icon" href="https://templates.pingendo.com/assets/Pingendo_favicon.ico">
  <title>Registration</title>
  <meta name="description" content="Wireframe design of a checkout form by Pingendo">
  <meta name="keywords" content="Pingendo bootstrap example template wireframe checkout form">
  <meta name="author" content="Pingendo">
  <!-- CSS dependencies -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="resources/css/wireframe.css">
</head>

<body class="bg-light">
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="text-center col-md-7 mx-auto"> <i class="fa d-block fa-bullseye fa-5x mb-4 text-info"></i>
          <h2><b>Registration</b><br></h2>
        </div>
      </div>
    </div>
  </div>
	<p><font size="4" color="red"> ${regOUTPUT} </font></p>
  <div class="">
    <div class="container">
      <div class="row">
        <div class="col-md-12 order-md-1">
          <h4 class="mb-3">Required Information *</h4>
          <form class="needs-validation" id="frm1" action="" method="get">
			<fieldset>
            <div class="row">
              <div class="col-md-6 mb-3"> <label for="firstName">First name *</label>
                <input type="text" class="form-control" name="firstName" id="firstName" placeholder="" value="" required="">
                <div class="invalid-feedback"> First name is required. </div>
              </div>
              <div class="col-md-6 mb-3"> <label for="lastName">Last name *</label>
                <input type="text" class="form-control" name="lastName" id="lastName" placeholder="" value="" required="">
                <div class="invalid-feedback"> Last name is required. </div>
              </div>
            </div>
            <div class="mb-3"> <label for="email">Email *</label>
              <div class="input-group">
                <input type="text" class="form-control" name="email" id="email" placeholder="" required="">
                <div class="invalid-feedback" style="width: 100%;"> Please enter a valid email address </div>
              </div><br>
			  <div class="input-group">
			  <div class="mb-3"> <label for="email">Phone Number *</label>
                <input type="text" class="form-control" name="phone" id="phone" placeholder="" required="">
                <div class="invalid-feedback" style="width: 100%;"> Please enter a valid Phone Number</div>
              </div></div>
	      <input type="checkbox" name="subscribe" value="subscribe"> Subscribe to email promotions<br>
            </div>
            <div class="mb-3"> <label for="password">Password *<span class="text-muted"></span></label>
              <input type="password" class="form-control" name="password" id="password" placeholder="" required="">
              <div class="invalid-feedback"> Please provide a password </div>
            </div>
            <div class="mb-3"> <label for="password2">Confirm Password *</label>
              <input type="password" class="form-control" name="password2" id="password2" placeholder="" required="">
              <div class="invalid-feedback"> Passwords do not match </div>
            </div>
            <div class="mb-3"> <label for="address">Address</label>
              <input type="text" class="form-control" name="address" id="address" placeholder="1234 Main St">
	      <div class="invalid-feedback"> Please enter your billing address. </div>
            </div>
			<div class="mb-3"> <label for="city">City</label>
                <input type="text" class="form-control" id="city" name="city" placeholder="">
                <div class="invalid-feedback"> City is Required </div>
              </div>
            <div class="row">
              <div class="col-md-6 mb-3"> <label for="state">State</label> <select class="custom-select d-block w-100" name="state" id="state">
                  <option value="">Choose a State</option>
                  <option value="California">Georgia</option>
                </select>
                <div class="invalid-feedback"> Please provide a valid state. </div>
              </div>
              <div class="col-md-6 mb-3"> <label for="zip">Zip</label>
                <input type="text" class="form-control" name="zip" id="zip" placeholder="">
                <div class="invalid-feedback"> Zip code required. </div>
              </div>
            </div>
            <hr class="mb-4">
            <div class="custom-control custom-checkbox">
              <input type="checkbox" class="custom-control-input" id="same-address" value="on"> </div>
            <div class="custom-control custom-checkbox">
              <input type="checkbox" class="custom-control-input" id="save-info" value="on"> </div>
				
            <!--<hr class="mb-4">
            <h4 class="mb-3"><b>Payment</b></h4>
            <div class="d-block my-3">
              <div class="custom-control custom-radio">
                <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked="" value="on"> <label class="custom-control-label" for="credit">Credit card</label> </div>
	      <div class="custom-control custom-radio">
                <input id="debit" name="paymentMethod" type="radio" class="custom-control-input" value="on"> <label class="custom-control-label" for="debit">Debit card</label> </div>
              <div class="custom-control custom-radio">
                <input id="paypal" name="paymentMethod" type="radio" class="custom-control-input" value="on"> </div>
            </div>
            <div class="row">
              <div class="col-md-6 mb-3"> <label for="cc-name">Name on card</label>
                <input type="text" class="form-control" name="cc-name" id="cc-name" placeholder=""> <small class="text-muted">Full name as displayed on card</small>
                <div class="invalid-feedback"> Name on card is required </div>
              </div>
              <div class="col-md-6 mb-3"> <label for="cc-number">Credit card number</label>
                <input type="number" class="form-control" name="cc-number" id="cc-number" placeholder="">
                <div class="invalid-feedback"> Credit card number is required </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-3 mb-3"> <label for="cc-expiration">Expiration</label>
                <input type="number" class="form-control" name="cc-expiration" id="cc-expiration" placeholder="">
                <div class="invalid-feedback"> Expiration date required </div>
              </div>
              <div class="col-md-3 mb-3"> <label for="cc-expiration">CVV</label>
                <input type="number" class="form-control" name="cc-cvv" id="cc-cvv" placeholder="">
                <div class="invalid-feedback"> Security code required </div>
              </div>
	    </div>-->
				
            <hr class="mb-4">
	    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Sign Up">
	    <!--<button onclick="window.location.href='http://www.google'">Sign Up</button>-->
			  </fieldset>
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="py-5 text-muted text-center">
    <div class="container">
      <div class="row">
        <div class="col-md-12 my-4">
          <p class="mb-1">© 2017-2018 Company Name</p>
          <ul class="list-inline">
            <li class="list-inline-item">
              <a href="#">Privacy</a>
            </li>
            <li class="list-inline-item">
              <a href="#">Terms</a>
            </li>
            <li class="list-inline-item">
              <a href="#">Support</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  <script src="assets/js/validation.js"></script>
<script>
function haha() {
	var email = document.getElementById("email");
	var passwd = document.getElementById("password");
	var passwd2 = document.getElementById("valpassword");
	var firstName = document.getElementById("firstName");
	var lastName = document.getElementById("lastName");
	var address = document.getElementById("address");
	var state = document.getElementById("state");
	var zip = document.getElementById("zip");
	var credit = document.getElementById("credit");
	var debit = document.getElementById("debit");
	var paypal = document.getElementById("paypal");
	var ccName = document.getElementById("cc-name");
	var ccNum = document.getElementById("cc-number");
	var ccExp = document.getElementById("cc-expiration");	
	var ccCVV = document.getElementById("cc-cvv");
	document.write("Your name is  ");
	document.write(firstName.value);
	document.write(" ");
	document.write(lastName.value);
	document.write("     and your email is:  ");
	document.write(email.value);
}
</script>
</body>
</html>
