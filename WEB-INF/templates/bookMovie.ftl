<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- PAGE settings -->
  <link rel="icon" href="https://templates.pingendo.com/assets/Pingendo_favicon.ico">
  <title>Checkout</title>
  <meta name="description" content="Wireframe design of a checkout form by Pingendo">
  <meta name="keywords" content="Pingendo bootstrap example template wireframe checkout form">
  <meta name="author" content="Pingendo">
  <!-- CSS dependencies -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="resources/css/wireframe.css">
</head>

<body class="bg-light" onload="getMovie()">
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="text-center col-md-7 mx-auto"> <i class="fa d-block fa-bullseye fa-5x mb-4 text-info"></i>
          <h2><b>Book Movie</b></h2>
        </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <ul class="list-inline" style="">&nbsp;Movie Title:&nbsp; ${movieName2}&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</ul>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6"><img class="card-img-top" src="resources/images/${movieName}.jpg" style=""></div>
      </div>
    </div>
  </div>
  <div class="" style="">
    <div class="container">
      <div class="row">
        <div class="col-md-8 order-md-1">
          <h4 class="mb-3"><b>Tickets</b></h4>
          <form class="needs-validation" novalidate="">
            <div class="row">
			  </div>
				<div class="row">
				  <div class="col-md-6 mb-3"> <label for="country">Choose Showtime</label> 
					<select class="custom-select d-block w-100" id="showtime" name="showtime" required="">
					  <option value="">Choose...</option>
					  ${showtimes}
					  <!-- adding showtimes dynamically now
					  <option value="11/28/18 7:00pm H1">11/28/18 7:00pm H1</option>
					  <option value="11/28/18 7:00pm H2">11/28/18 7:00pm H2</option>
					  <option value="11/29/18 5:00pm H1">11/29/18 5:00pm H1</option>
					  <option value="11/29/18 5:00pm H1">11/29/18 9:00pm H1</option>
					  <option value="11/29/18 9:00pm H2">11/29/18 9:00pm H2</option>
					  -->
				   </select>
                <div class="invalid-feedback"> Please select a valid country. </div>
              </div>
              <!-- <div class="col-md-6 mb-3"> <label for="firstName"># of Child tickets (ages 12 or younger)</label>
                <input type="number" min="0" class="form-control" id="childTickets" name="childTickets" placeholder="" value="" required="">
                <div class="invalid-feedback"> Valid number required. </div>
              </div>
			  <div class="col-md-6 mb-3"> <label for="firstName"># of Adult tickets (ages 13-60)</label>
                <input type="number" min="0" class="form-control" id="adultTickets" name="adultTickets" placeholder="" value="" required="">
                <div class="invalid-feedback"> Valid number required. </div>
			  </div>
			  <div class="col-md-6 mb-3"> <label for="firstName"># of Senior tickets (ages 60+)</label>
                <input type="number" min="0" class="form-control" id="seniorTickets" name="seniorTickets" placeholder="" value="" required="">
                <div class="invalid-feedback"> Valid number required. </div>
              </div> -->
					
	      	<input type="text" name="movieName" id="movieName" value="">
			<input type="submit" class="btn btn-primary btn-lg btn-block" value="Proceed to Seat Selection">
	
            <!--<button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>-->
				
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="py-5 text-muted text-center">
    <div class="container">
      <div class="row">
        <div class="col-md-12 my-4">
          <ul class="list-inline">
            <li class="list-inline-item">
            </li>
            <li class="list-inline-item">
            </li>
            <li class="list-inline-item">
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <!-- <script>
	function saveSeats() {
	  	var x = document.getElementById("childTickets").value;
	  	var y = document.getElementById("adultTickets").value;
	  	var z = document.getElementById("sseniorTickets").value;
		var numSeats = x + y + z;
	  	localStorage.setItem('totalSeats', numSeats);
	}
  </script> -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  <script src="assets/js/validation.js"></script>
	<script>
		function getMovie(){
			var urlParams = new URLSearchParams(window.location.search);
			var movieName = document.getElementById("movieName");
			movieName.value = urlParams.get("movieName");
			movieName.innerHTML = movieName.value;
		}
	</script>
</body>

</html>
