<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- PAGE settings -->
  <link rel="icon" href="https://templates.pingendo.com/assets/Pingendo_favicon.ico">
  <title>Album</title>
  <meta name="description" content="Wireframe design of an album page by Pingendo">
  <meta name="keywords" content="Pingendo bootstrap example template wireframe album ">
  <meta name="author" content="Pingendo">
  <!-- CSS dependencies -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="resources/css/wireframe.css">
	<script>
	function getMovie(){
                        var urlParams = new URLSearchParams(window.location.search);
                        var movieName = document.getElementById("movieName");
                        movieName.value = urlParams.get("movieName");
                        movieName.innerHTML = movieName.value;
                }
	</script>
</head>

<body onload="getMovie()">
  <!--<div class="collapse bg-dark" id="navbarHeader" style="">
    <div class="container">
      <div class="row">
        <div class="col-md-7 py-4">
          <h4>About</h4>
          <p class="text-info">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        </div>
        <div class="col-md-3 offset-md-1 py-4">
          <h4>Contact</h4>
          <ul class="list-unstyled">
            <li>
              <a href="#" class="text-secondary">Follow on Twitter</a>
            </li>
            <li>
              <a href="#" class="text-secondary">Like on Facebook</a>
            </li>
            <li>
              <a href="#" class="text-secondary">Email me</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
          <nav class="navbar navbar-expand-md navbar-dark bg-dark">
<div class="container"> <button class="navbar-toggler navbar-toggler-right border-0" type="button" data-toggle="collapse" data-target="#navbar12">
<span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse" id="navbar12"> <a class="navbar-brand d-none d-md-block" href="#">
  	  <i class="fa d-inline fa-lg fa-circle"></i>
          <b> BRAND</b>
        </a>
      </div>
    </div>
	  </nav>-->
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="display-1">${name_of_movie}</h1>
        </div>
      </div>
    </div>
  </div>
  <div class="py-5" style="">
    <div class="container">
      <div class="row">
        <div class="col-md-12 p-3">
          <div class="card box-shadow p-0 m-0">
            <img class="card-img-top" src="resources/images/venom_movie.jpg" style="	transform:  scale(.8);">
            <div class="card-body">
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="location.href='${trailer}'" type="button" class="btn btn-sm btn-outline-secondary" contenteditable="true">Play Trailer<br></button>
		  <button onclick="location.href='bookMovie'" type="button" class="btn btn-sm btn-outline-secondary">Book Tickets<br></button>
			  </div> <small class="text-muted">140 mins</small>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
			<input class="text" name="movieName" id="movieName" value="" ${readonly}>  <br>
		    <!--  the following <p> is what I want to do dynamically
			<p class="lead">Runtime: 140 min<br>
				Rating: PG-13<br>
				Genre: Action and Adventure<br>
				Director: Ruben Fleisher<br>
				Producer: Marvel<br>
				Cast:  Tom Hardy, Michelle Williams, Riz Ahmed
				<br>Synopsis:  When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego "Venom" to save his life.<br>
				<br>
				<button onclick="location.href='https://www.imdb.com/title/tt1270797/externalreviews?ref_=tt_ov_rt'" type="button" class="btn btn-sm btn-outline-secondary">Reviews</button>
			</p>
				-->
			<p class="lead">Runtime: ${runtime} min<br>
				Rating: ${rating}<br>
				Genre: ${genre}<br>
				Cast:  ${cast}<br>
				<br>Synopsis:  When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego "Venom" to save his life.<br>
				<br>
				Review: ${review}<br>
			</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <footer class="text-muted py-5">
    <div class="container">
      <p class="float-right">
        <a href="#">Back to top</a>
      </p>
      <p>Album template is based on Bootstrap © examples.&nbsp; <br>New to Bootstrap? <a href="#">Visit the homepage</a> or read our <a href="#">getting started guide</a>.</p>
    </div>
  </footer>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>

</html>
