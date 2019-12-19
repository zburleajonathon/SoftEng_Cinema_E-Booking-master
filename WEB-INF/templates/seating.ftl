<!--
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="zxx">

<head>
    <title>Movie Seat Selection Flat Responsive Widget Template :: w3layouts</title>
    <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="keywords" content="Movie Seat Selection a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- //Meta-Tags -->
    <!-- Index-Page-CSS -->
    <link rel="stylesheet" href="resources/css/style.css" type="text/css" media="all">
    <!-- //Custom-Stylesheet-Links -->
    <!--fonts -->
    <link href="//fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i" rel="stylesheet">
    <!-- //fonts -->
</head>

<body onload="onLoaderFunc()">
    <h1>Movie Seat Selection</h1>
    <div class="container">

        <div class="w3ls-reg">
            <!-- input fields -->
            <div class="inputForm">
					<h2>fill the required details below and select your seats</h2>
					
					<div class="mr_agilemain">
						<div class="agileits-left">
							<label> Name
								<span>*</span>
							</label>
							<input type="text" id="Username">
						</div>
						<div class="agileits-right">
							<label> Child Seats
								<span>*</span>
							</label>
							<input type="number" id="childSeats" name="childSeats" min="0">
						</div>
					</div>
					
					<div class="mr_agilemain">
						<div class="agileits-left">
							<label> Adult Seats
								<span>*</span>
							</label>
							<input type="number" id="adultSeats" name="adultSeats" min="0">
						</div>
						<div class="agileits-right">
							<label> Senior Seats
								<span>*</span>
							</label>
							<input type="number" id="seniorSeats" name="seniorSeats" min="0">
						</div>
					</div>
					
					<div class="mr_agilemain">
						<label> Total Seats
							<span></span>
						</label>
						<input type="number" id="Numseats" name="Numseats" min="1">
					</div>
					<p></p>
					
					
					<!-- <button onclick="takeData()">Start Selecting</button> -->
					<input type="submit" class="btn btn-primary btn-lg btn-block" value="Start Selecting" onclick="takeData()">
            </div>
            <!-- //input fields -->
            <!-- seat availabilty list -->
            <ul class="seat_w3ls">
                <li class="smallBox greenBox">Selected Seat</li>

                <li class="smallBox redBox">Reserved Seat</li>

                <li class="smallBox emptyBox">Empty Seat</li>
            </ul>
            <!-- seat availabilty list -->
            <!-- seat layout -->
			
			<form class="needs-validation" id="frm1" action="" method="get">
			
            <div class="seatStructure txt-center" style="overflow-x:auto;">
                <table id="seatsBlock">
                    <p id="notification"></p>
                    <tr>
                        <td></td>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                        <td>4</td>
                        <td>5</td>
                        <td></td>
                        <td>6</td>
                        <td>7</td>
                        <td>8</td>
                        <td>9</td>
                        <td>10</td>
                        <td>11</td>
                        <td>12</td>
                    </tr>
                    <tr>
                        <td>A</td>
                        <td>
                            <input type="checkbox" class="seats" value="A1" name="seat1">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="A2" name="seat2">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="A3" name="seat3">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="A4" name="seat4">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="A5" name="seat5">
                        </td>
                        <td class="seatGap"></td>
                        <td>
                            <input type="checkbox" class="seats" value="A6" name="seat6">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="A7" name="seat7">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="A8" name="seat8">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="A9" name="seat9">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="A10" name="seat10">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="A11" name="seat11">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="A12" name="seat12">
                        </td>
                    </tr>

                    <tr>
                        <td>B</td>
                        <td>
                            <input type="checkbox" class="seats" value="B1" name="seat13">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="B2" name="seat14">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="B3" name="seat15">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="B4" name="seat16">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="B5" name="seat17">
                        </td>
                        <td></td>
                        <td>
                            <input type="checkbox" class="seats" value="B6" name="seat18">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="B7" name="seat19">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="B8" name="seat20">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="B9" name="seat21">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="B10" name="seat22">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="B11" name="seat23">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="B12" name="seat24">
                        </td>
                    </tr>

                    <tr>
                        <td>C</td>
                        <td>
                            <input type="checkbox" class="seats" value="C1" name="seat25">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="C2" name="seat26">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="C3" name="seat27">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="C4" name="seat28">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="C5" name="seat29">
                        </td>
                        <td></td>
                        <td>
                            <input type="checkbox" class="seats" value="C6" name="seat30">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="C7" name="seat31">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="C8" name="seat32">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="C9" name="seat33">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="C10" name="seat34">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="C11" name="seat35">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="C12" name="seat36">
                        </td>
                    </tr>

                    <tr>
                        <td>D</td>
                        <td>
                            <input type="checkbox" class="seats" value="D1" name="seat37">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="D2" name="seat38">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="D3" name="seat39">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="D4" name="seat40">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="D5" name="seat41">
                        </td>
                        <td></td>
                        <td>
                            <input type="checkbox" class="seats" value="D6" name="seat42">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="D7" name="seat43">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="D8" name="seat44">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="D9" name="seat45">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="D10" name="seat46">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="D11" name="seat47">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="D12" name="seat48">
                        </td>
                    </tr>

                    <tr>
                        <td>E</td>
                        <td>
                            <input type="checkbox" class="seats" value="E1" name="seat49">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="E2" name="seat50">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="E3" name="seat51">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="E4" name="seat52">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="E5" name="seat53">
                        </td>
                        <td></td>
                        <td>
                            <input type="checkbox" class="seats" value="E6" name="seat54">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="E7" name="seat55">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="E8" name="seat56">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="E9" name="seat57">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="E10" name="seat58">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="E11" name="seat59">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="E12" name="seat60">
                        </td>
                    </tr>

                    <tr class="seatVGap"></tr>

                    <tr>
                        <td>F</td>
                        <td>
                            <input type="checkbox" class="seats" value="F1" name="seat61">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="F2" name="seat62">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="F3" name="seat63">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="F4" name="seat64">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="F5" name="seat65">
                        </td>
                        <td></td>
                        <td>
                            <input type="checkbox" class="seats" value="F6" name="seat66">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="F7" name="seat67">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="F8" name="seat68">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="F9" name="seat69">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="F10" name="seat70">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="F11" name="seat71">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="F12" name="seat72">
                        </td>
                    </tr>

                    <tr>
                        <td>G</td>
                        <td>
                            <input type="checkbox" class="seats" value="G1" name="seat73">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="G2" name="seat74">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="G3" name="seat75">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="G4" name="seat76">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="G5" name="seat77">
                        </td>
                        <td></td>
                        <td>
                            <input type="checkbox" class="seats" value="G6" name="seat78">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="G7" name="seat79">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="G8" name="seat80">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="G9" name="seat81">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="G10" name="seat82">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="G11" name="seat83">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="G12" name="seat84">
                        </td>
                    </tr>

                    <tr>
                        <td>H</td>
                        <td>
                            <input type="checkbox" class="seats" value="H1" name="seat85">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="H2" name="seat86">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="H3" name="seat87">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="H4" name="seat88">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="H5" name="seat89">
                        </td>
                        <td></td>
                        <td>
                            <input type="checkbox" class="seats" value="H6" name="seat90">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="H7" name="seat91">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="H8" name="seat92">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="H9" name="seat93">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="H10" name="seat94">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="H11" name="seat95">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="H12" name="seat96">
                        </td>
                    </tr>

                    <tr>
                        <td>I</td>
                        <td>
                            <input type="checkbox" class="seats" value="I1" name="seat97">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="I2" name="seat98">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="I3" name="seat99">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="I4" name="seat100">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="I5" name="seat101">
                        </td>
                        <td></td>
                        <td>
                            <input type="checkbox" class="seats" value="I6" name="seat102">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="I7" name="seat103">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="I8" name="seat104">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="I9" name="seat105">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="I10" name="seat106">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="I11" name="seat107">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="I12" name="seat108">
                        </td>
                    </tr>

                    <tr>
                        <td>J</td>
                        <td>
                            <input type="checkbox" class="seats" value="J1" name="seat109">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="J2" name="seat110">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="J3" name="seat111">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="J4" name="seat112">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="J5" name="seat113">
                        </td>
                        <td></td>
                        <td>
                            <input type="checkbox" class="seats" value="J6" name="seat114">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="J7" name="seat115">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="J8" name="seat116">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="J9" name="seat117">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="J10" name="seat118">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="J11" name="seat119">
                        </td>
                        <td>
                            <input type="checkbox" class="seats" value="J12" name="seat120">
                        </td>
                    </tr>
                </table>
				
                <div class="screen">
                    <h2 class="wthree">Screen this way</h2>
                </div>
				
				<div class="mr_agilemain">
					<div class="agileits-left">
						<label> Child Tickets
							<span></span>
						</label>
						<input type="text" name="childs" id="childs" >
					</div>
					<div class="agileits-right">
						<label> Adult Tickets
							<span></span>
						</label>
						<input type="text" name="adults" id="adults" >
					</div>
				</div>
					
				<div class="mr_agilemain">
					<div class="agileits-left">
						<label> Senior Tickets
							<span></span>
						</label>
						<input type="text" name="seniors" id="seniors" >
					</div>
					<div class="agileits-right">
						<label> Total Tickets
							<span></span>
						</label>
						<input type="text" name="numSeats" id="numSeats" min="1" >
					</div>
				</div>
				
               <!-- <button onclick="updateTextArea()">Confirm Selection</button> -->
				<input type="submit" class="btn btn-primary btn-lg btn-block" value="Continue to Checkout">
								
				</form>
				
            </div>
            <!-- //seat layout -->
            <!-- details after booking displayed here -->
            <div class="displayerBoxes txt-center" style="overflow-x:auto;">
                <table class="Displaytable w3ls-table" width="100%">
                    <tr>
                        <th>Name</th>
                        <th>Number of Seats</th>
                        <th>Seats</th>
                    </tr>
                    <tr>
                        <td>
                            <textarea id="nameDisplay"></textarea>
                        </td>
                        <td>
                            <textarea id="NumberDisplay"></textarea>
                        </td>
                        <td>
                            <textarea id="seatsDisplay"></textarea>
                        </td>
                    </tr>
                </table>
            </div>
			
		
			<!--
			<form class="needs-validation" id="frm1" action="" method="get">
				<div class="mr_agilemain">
					<div class="agileits-left">
						<label> Child Tickets
							<span></span>
						</label>
						<input type="text" name="childs" id="childs" >
					</div>
					<div class="agileits-right">
						<label> Adult Tickets
							<span></span>
						</label>
						<input type="text" name="adults" id="adults" >
					</div>
				</div>
					
				<div class="mr_agilemain">
					<div class="agileits-left">
						<label> Senior Tickets
							<span></span>
						</label>
						<input type="text" name="seniors" id="seniors" >
					</div>
					<div class="agileits-right">
						<label> Total Tickets
							<span></span>
						</label>
						<input type="text" name="numSeats" id="numSeats" min="1" >
					</div>
				</div>
				
				<input type="submit" class="btn btn-primary btn-lg btn-block" value="Continue to Checkout">
			</form>
			-->
			
            <!-- //details after booking displayed here -->
        </div>
    </div>
	
    <div class="copy-wthree">
        <p>© 2018 Movie Seat Selection . All Rights Reserved | Design by
            <a href="http://w3layouts.com/" target="_blank">W3layouts</a>
        </p>
    </div>
    <!-- js -->
    <script src="resources/js/jquery-2.2.3.min.js"></script>
    <!-- //js -->
    <!-- script for seat selection -->
	
    <script>
        function onLoaderFunc() {
            $(".seatStructure *").prop("disabled", true);
            $(".displayerBoxes *").prop("disabled", true);
        }

        function takeData() {
			var child = document.getElementById("childSeats").value;
			var adult = document.getElementById("adultSeats").value;
			var senior = document.getElementById("seniorSeats").value;
			child.readOnly = true;
			adult.readOnly = true;
			senior.readOnly = true;
			document.getElementById("Numseats").value = Number(child) + Number(adult) + Number(senior);
            if (($("#Username").val().length == 0) || ($("#Numseats").val().length == 0)) {
                alert("Please Enter your Name and Number of Seats");
            } else {
                $(".inputForm *").prop("disabled", true);
                $(".seatStructure *").prop("disabled", false);
                document.getElementById("notification").innerHTML =
                    "<b style='margin-bottom:0px;background:#ff9800;letter-spacing:1px;'>Please Select your Seats NOW!</b>";
            }
			document.getElementById("Numseats").readOnly = true;
			
			document.getElementById("childSeats");
			document.getElementById("adultSeats");
			document.getElementById("seniorSeats");
			document.getElementById("Numseats");
			document.getElementById("childs");
			document.getElementById("adults");
			document.getElementById("seniors");
			document.getElementById("numSeats");
			
			childs.value = childSeats.value;
			adults.value = adultSeats.value;
			seniors.value = seniorSeats.value;
			numSeats.value = Numseats.value;
			
			childs.readOnly = true;
			adults.readOnly = true;
			seniors.readOnly = true;
			numSeats.readOnly = true;
        }


        function updateTextArea() {

            if ($("input:checked").length == ($("#Numseats").val())) {
               	
			   	$(".seatStructure *").prop("disabled", true);
				
                var allNameVals = [];
                var allNumberVals = [];
                var allSeatsVals = [];

                //Storing in Array
                allNameVals.push($("#Username").val());
                allNumberVals.push($("#Numseats").val());
				
                $('#seatsBlock :checked').each(function () {
                    allSeatsVals.push($(this).val());
                });
				

                //Displaying 
                $('#nameDisplay').val(allNameVals);
                $('#NumberDisplay').val(allNumberVals);
                $('#seatsDisplay').val(allSeatsVals);
            } else {
                alert("Please select " + ($("#Numseats").val()) + " seats")
            }
			
			
			
        }


        function myFunction() {
            alert($("input:checked").length);
        }

        /*
        function getCookie(cname) {
            var name = cname + "=";
            var ca = document.cookie.split(';');
            for(var i = 0; i < ca.length; i++) {
                var c = ca[i];
                while (c.charAt(0) == ' ') {
                    c = c.substring(1);
                }
                if (c.indexOf(name) == 0) {
                    return c.substring(name.length, c.length);
                }
            }
            return "";
        }
        */

		
        $(":checkbox").click(function () {
        
			if ($("input:checked").length == ($("#Numseats").val())) {
                $(":checkbox").prop('disabled', true);
                $(':checked').prop('disabled', false);
            } else {
                $(":checkbox").prop('disabled', false);
            }
		
        });
    </script>
    <!-- //script for seat selection -->

	<script>
	function getSeats() {
	  	document.getElementById("Numseats").value = localStorage.getItem('totalSeats', numSeats);
	}
  	</script>

</body>

</html>
