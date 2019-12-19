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
</head>

<body>
  <div class="collapse bg-dark" id="navbarHeader" style="">
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
        </a>
        <ul class="navbar-nav mx-auto">
          <li class="nav-item"> <a class="nav-link" href="browse_loggedIn">Movies<br></a> </li>
        </ul>
        <ul class="navbar-nav">
          <li class="nav-item"> <a class="nav-link" href="logout">Logout<br></a> </li>
          <li class="nav-item"> <a class="nav-link text-primary" href="editProfile">Profile</a> </li>
        </ul>
      </div>
    </div>
  </nav>
  <nav class="navbar navbar-expand-md navbar-dark bg-info" style="">
    <div class="container">
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent" aria-controls="navbar2SupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span> </button>
      <div class="collapse navbar-collapse text-center justify-content-between" id="navbar2SupportedContent">
        <p class="lead">Search by title</p>
        <form class="form-inline my-2 my-lg-0"> 
			<input class="form-control mr-sm-2" type="text" name="searchName" id="search" placeholder="Search" value=""> 
			<!--<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button> -->
			<input type="submit" class="btn btn-primary btn-lg btn-block" value="Search">
	   </form>
      </div>
    </div>
  </nav>
  <nav class="navbar navbar-expand-md navbar-dark bg-info" style="">
    <div class="container">
      <!--<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent" aria-controls="navbar2SupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span> </button>-->
      <div class="collapse navbar-collapse text-center justify-content-between" id="navbar2SupportedContent">
        <p class="lead">Filter by category</p>
        <form class="form-inline my-2 my-lg-0"> 
			<input class="form-control mr-sm-2" type="text" name="searchGenre" placeholder="Search"> 
			<!--<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Apply</button> -->
			<input type="submit" class="btn btn-primary btn-lg btn-block" value="Apply">
		</form>
      </div>
    </div>
  </nav>
  <nav class="navbar navbar-expand-md navbar-dark bg-info" style="">
    <div class="container">
      <!--<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent" aria-controls="navbar2SupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span> </button>-->
      <div class="collapse navbar-collapse text-center justify-content-between" id="navbar2SupportedContent">
        <p class="lead">Filter by showtime: time range, date</p>
        <form class="form-inline my-lg-0">
          <input class="form-control" type="time">
        </form>
        <form class="form-inline my-2 my-lg-0"> <input class="form-control mr-sm-2" type="time" placeholder="Search"> </form>
        <form class="form-inline my-2 my-lg-0"> <input class="form-control mr-sm-2" type="date" placeholder="Search"> <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Apply</button> </form>
      </div>
    </div>
  </nav>
  <div class="py-4 bg-light">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="" contenteditable="true">Now Playing</h1>
        </div>
      </div>
    </div>
	${nowPlaying}
	<!-- we start crazy shit here
    <div class="container">
      <div class="row">
        <div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="resources/images/venom_movie.jpg">
            <div class="card-body">
		    <p class="card-text" id="Venom" value="Venom">Venom</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="viewMovie1()" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="getMovie1()" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">140 mins</small>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="resources/images/CreedII.jpg" style="">
            <div class="card-body">
              <p class="card-text">Creed II</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="viewMovie2()" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="getMovie2()" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">130 mins</small>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="resources/images/Widows.jpeg">
            <div class="card-body">
              <p class="card-text">Widows</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="viewMovie3()" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="getMovie3()" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">130 mins</small>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="resources/images/TheGrinch.jpg">
            <div class="card-body">
              <p class="card-text">Dr Seuss The Grinch</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="viewMovie4()" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="getMovie4()" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">105 mins</small>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="resources/images/RalphBreaksTheInternet.jpg">
            <div class="card-body">
              <p class="card-text">Ralph Breaks the Internet</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="viewMovie5()" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="getMovie5()" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">116 mins</small>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="resources/images/Tyrel.jpg">
            <div class="card-body">
              <p class="card-text">Tyrel</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="viewMovie6()" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="getMovie6()" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">86 mins</small>
              </div>
            </div>
          </div>
        </div>
		-->
        <!--<div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="https://pingendo.com/assets/photos/wireframe/photo-1.jpg">
            <div class="card-body">
              <p class="card-text">Ben is Back</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="location.href='movieInfo'" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="location.href='bookMovie'" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">9 mins</small>
              </div>
            </div>
          </div>
	</div>-->
        <!--<div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="https://pingendo.com/assets/photos/wireframe/photo-1.jpg">
            <div class="card-body">
              <p class="card-text">Mortal Engines</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="location.href='movieInfo'" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="location.href='bookMovie'" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">9 mins</small>
              </div>
            </div>
          </div>
	</div>-->
        <!--<div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="https://pingendo.com/assets/photos/wireframe/photo-1.jpg">
            <div class="card-body">
              <p class="card-text">Once Upon a Deadpool</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="location.href='movieInfo'" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="location.href='bookMovie'" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">9 mins</small>
              </div>
            </div>
          </div>
	   </div>
      </div>
    </div>
  </div> -->
  <div class="py-4 bg-light" style="">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="">Coming Soon</h1>
        </div>
      </div>
    </div>
	<!-- start script here -->
	 ${comingSoon}
    <!-- <div class="container">
      <div class="row">
        <div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="resources/images/OnceUponADeadpool.jpg">
            <div class="card-body">
              <p class="card-text">Once Upon a Deadpool</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="viewMovie7()" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="getMovie7()" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">116 mins</small>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="resources/images/MortalEngines.jpg" style="">
            <div class="card-body">
              <p class="card-text">Mortal Engines</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="viewMovie8()" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="getMovie8()" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">91 mins</small>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="resources/images/BenIsBack.jpg">
            <div class="card-body">
              <p class="card-text">Ben is Back</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="viewMovie9()" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="getMovie9()" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">103 mins</small>
              </div>
            </div>
          </div>
        </div> -->
	<p type="text" name="movieName" id="movieName" value=""></p>
        <!--<div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="https://pingendo.com/assets/photos/wireframe/photo-1.jpg">
            <div class="card-body">
	    <form ... form stuff>
	    <input class="text" name="moviename" value="venom" placeholder="venom" readonly>
	    <input type="submit" ...>
	    <\form>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="location.href='movieInfo'" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="location.href='bookMovie'" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">9 mins</small>
              </div>
            </div>
          </div>
	</div>-->
        <!--<div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="https://pingendo.com/assets/photos/wireframe/photo-1.jpg">
            <div class="card-body">
              <p class="card-text">Movie info</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="location.href='movieInfo'" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="location.href='bookMovie'" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">9 mins</small>
              </div>
            </div>
          </div>
        </div>
	<!--<div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="https://pingendo.com/assets/photos/wireframe/photo-1.jpg">
            <div class="card-body">
              <p class="card-text">Movie info</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="location.href='movieInfo'" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="location.href='bookMovie'" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">9 mins</small>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="https://pingendo.com/assets/photos/wireframe/photo-1.jpg">
            <div class="card-body">
              <p class="card-text">Movie Info</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="location.href='movieInfo'" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="location.href='bookMovie'" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">9 mins</small>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="https://pingendo.com/assets/photos/wireframe/photo-1.jpg">
            <div class="card-body">
              <p class="card-text">Movie Info</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="location.href='movieInfo'" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="location.href='bookMovie'" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">9 mins</small>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4 p-3">
          <div class="card box-shadow">
            <img class="card-img-top" src="https://pingendo.com/assets/photos/wireframe/photo-1.jpg">
            <div class="card-body">
              <p class="card-text">Movie Info</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button onclick="location.href='movieInfo'" type="button" class="btn btn-sm btn-outline-secondary">View</button>
		  <button onclick="location.href='bookMovie'" type="button" class="btn btn-sm btn-outline-secondary">Book Ticket</button>
                </div> <small class="text-muted">9 mins</small>
              </div>
            </div>
          </div>
	</div>-->
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  
  <script>
	
	function searchByName(){
            var urlParams = new URLSearchParams(window.location.search);
            var movieName = document.getElementById("search");
            movieName.value = urlParams.get("search");
	    window.location.href = "browse_loggedIn?movieName=" + movieName.value();
	}

	${addMovie}
	
	/*for venom booking
	function getMovie1(){
	    var movie = document.getElementById("movieName");
	    movie.value = "Venom";
	    movie.innerHTML = movie.value;
	    window.location.href = "bookMovie?movieName=Venom";
	}
	function viewMovie1(){
            var movie = document.getElementById("movieName");
            movie.value = "Venom";
            movie.innerHTML = movie.value;
            window.location.href = "movieInfo?movieName=Venom";
	}

	//for creed 2 booking
        function getMovie2(){
            var movie = document.getElementById("movieName");
            movie.value = "CreedII";
            movie.innerHTML = movie.value;
            window.location.href = "bookMovie?movieName=CreedII";
        }

        //for creed 2 info
        function viewMovie2(){
            var movie = document.getElementById("movieName");
            movie.value = "CreedII";
            movie.innerHTML = movie.value;
            window.location.href = "movieInfo?movieName=CreedII";
        }

	//for widows booking
        function getMovie3(){
            var movie = document.getElementById("movieName");
            movie.value = "Widows";
            movie.innerHTML = movie.value;
            window.location.href = "bookMovie?movieName=Widows";
        }

        //for widows info
        function viewMovie3(){
            var movie = document.getElementById("movieName");
            movie.value = "Widows";
            movie.innerHTML = movie.value;
            window.location.href = "movieInfo?movieName=Widows";
        }

	//for the grinch booking
        function getMovie4(){
            var movie = document.getElementById("movieName");
            movie.value = "TheGrinch";
            movie.innerHTML = movie.value;
            window.location.href = "bookMovie?movieName=TheGrinch";
        }

        //for widows info
        function viewMovie4(){
            var movie = document.getElementById("movieName");
            movie.value = "TheGrinch";
            movie.innerHTML = movie.value;
            window.location.href = "movieInfo?movieName=TheGrinch";
        }

	//for widows booking
        function getMovie5(){
            var movie = document.getElementById("movieName");
            movie.value = "RalphBreaksTheInternet";
            movie.innerHTML = movie.value;
            window.location.href = "bookMovie?movieName=RalphBreaksTheInternet";
        }

        //for widows info
        function viewMovie5(){
            var movie = document.getElementById("movieName");
            movie.value = "RalphBreaksTheInternet";
            movie.innerHTML = movie.value;
            window.location.href = "movieInfo?movieName=RalphBreaksTheInternet";
        }

	//for widows booking
        function getMovie6(){
            var movie = document.getElementById("movieName");
            movie.value = "Tyrel";
            movie.innerHTML = movie.value;
            window.location.href = "bookMovie?movieName=Tyrel";
        }

        //for widows info
        function viewMovie6(){
            var movie = document.getElementById("movieName");
            movie.value = "Tyrel";
            movie.innerHTML = movie.value;
            window.location.href = "movieInfo?movieName=Tyrel";
        }

	//for widows booking
        function getMovie7(){
            var movie = document.getElementById("movieName");
            movie.value = "OnceUponADeadpool";
            movie.innerHTML = movie.value;
            window.location.href = "bookMovie?movieName=OnceUponADeadpool";
        }

        //for widows info
        function viewMovie7(){
            var movie = document.getElementById("movieName");
            movie.value = "OnceUponADeadpool";
            movie.innerHTML = movie.value;
            window.location.href = "movieInfo?movieName=OnceUponADeadpool";
        }

	//for widows booking
        function getMovie8(){
            var movie = document.getElementById("movieName");
            movie.value = "MortalEngines";
            movie.innerHTML = movie.value;
            window.location.href = "bookMovie?movieName=MortalEngines";
        }

        //for widows info
        function viewMovie8(){
            var movie = document.getElementById("movieName");
            movie.value = "MortalEngines";
            movie.innerHTML = movie.value;
            window.location.href = "movieInfo?movieName=MortalEngines";
        }

	//for widows booking
        function getMovie9(){
            var movie = document.getElementById("movieName");
            movie.value = "BenIsBack";
            movie.innerHTML = movie.value;
            window.location.href = "bookMovie?movieName=BenIsBack";
        }

        //for widows info
        function viewMovie9(){
            var movie = document.getElementById("movieName");
            movie.value = "BenIsBack";
            movie.innerHTML = movie.value;
            window.location.href = "movieInfo?movieName=BenIsBack";
        }
	  */
    </script>
</body>

</html>
