<%-- 
    Document   : About
    Created on : Sep 26, 2022, 1:19:55 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

        <title>About Us</title>

        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

        <!-- Additional CSS Files -->
        <link rel="stylesheet" href="assets/css/fontawesome.css">
        <link rel="stylesheet" href="assets/css/templatemo-woox-travel.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>

        <!--Map-->
        <link href="https://api.mapbox.com/mapbox-gl-js/v2.10.0/mapbox-gl.css" rel="stylesheet" />
        <script src="https://api.mapbox.com/mapbox-gl-js/v2.10.0/mapbox-gl.js"></script>
    </head>

    <body>

        <!-- ***** Preloader Start ***** -->
        <div id="js-preloader" class="js-preloader">
            <div class="preloader-inner">
                <span class="dot"></span>
                <div class="dots">
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
            </div>
        </div>
        <!-- ***** Preloader End ***** -->

        <jsp:include page="HeaderNFooter/header.jsp"></jsp:include>

            <div class="second-page-heading">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <h4>Book Prefered Deal Here</h4>
                            <h2>Make Your Reservation</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt uttersi labore et dolore magna aliqua is ipsum suspendisse ultrices gravida</p>
                            <div class="main-button"><a href="about.html">Discover More</a></div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="more-info reservation-info">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 col-sm-6">
                            <div class="info-item">
                                <i class="fa fa-phone"></i>
                                <h4>Make a Phone Call</h4>
                                <a href="#">+123 456 789 (0)</a>
                            </div>
                        </div>
                        <div class="col-lg-4 col-sm-6">
                            <div class="info-item">
                                <i class="fa fa-envelope"></i>
                                <h4>Contact Us via Email</h4>
                                <a href="#">company@email.com</a>
                            </div>
                        </div>
                        <div class="col-lg-4 col-sm-6">
                            <div class="info-item">
                                <i class="fa fa-map-marker"></i>
                                <h4>Visit Our Offices</h4>
                                <a href="#">6969 FPT, VN</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="reservation-form">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">

                        </div>

                        <div id="map" style="width: 936px; height: 456px  "></div>

                        <div class="col-lg-12">
                            <form id="reservation-form" name="gs" method="submit" role="search" action="#">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <h4>Make Your <em>Fead</em> Through This <em>Form</em></h4>
                                    </div>
                                    <div class="col-lg-6">
                                        <fieldset>
                                            <label for="Name" class="form-label">Your Name</label>
                                            <input type="text" name="Name" class="Name" placeholder="Ex. John Smithee" autocomplete="on" required>
                                        </fieldset>
                                    </div>
                                    <div class="col-lg-6">
                                        <fieldset>
                                            <label for="Number" class="form-label">Your Phone Number</label>
                                            <input type="text" name="Number" class="Number" placeholder="Ex. +xxx xxx xxx" autocomplete="on" required>
                                        </fieldset>
                                    </div>
                                    <div class="col-lg-6">
                                        <fieldset>
                                            <label for="chooseGuests" class="form-label">Number Of Guests</label>
                                            <select name="Guests" class="form-select" aria-label="Default select example" id="chooseGuests" onChange="this.form.click()">
                                                <option selected>ex. 3 or 4 or 5</option>
                                                <option type="checkbox" name="option1" value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4+">4+</option>
                                            </select>
                                        </fieldset>
                                    </div>
                                    <div class="col-lg-6">
                                        <fieldset>
                                            <label for="Number" class="form-label">Check In Date</label>
                                            <input type="date" name="date" class="date" required>
                                        </fieldset>
                                    </div>
                                    <div class="col-lg-12">
                                        <fieldset>
                                            <label for="chooseDestination" class="form-label">Choose Your Destination</label>
                                            <select name="Destination" class="form-select" aria-label="Default select example" id="chooseCategory" onChange="this.form.click()">
                                                <option selected>ex. Switzerland, Lausanne</option>
                                                <option value="Italy, Roma">Italy, Roma</option>
                                                <option value="France, Paris">France, Paris</option>
                                                <option value="Engaland, London">Engaland, London</option>
                                                <option value="Switzerland, Lausanne">Switzerland, Lausanne</option>
                                            </select>
                                        </fieldset>
                                    </div>
                                    <div class="col-lg-12">                        
                                        <fieldset>
                                            <button class="main-button">Make Your Reservation Now</button>
                                        </fieldset>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!--Footer-->
        <jsp:include page="HeaderNFooter/footer.jsp"></jsp:include>


        <!-- Scripts -->
        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>

        <script src="assets/js/isotope.min.js"></script>
        <script src="assets/js/owl-carousel.js"></script>
        <script src="assets/js/wow.js"></script>
        <script src="assets/js/tabs.js"></script>
        <script src="assets/js/popup.js"></script>
        <script src="assets/js/custom.js"></script>
        <!-- Map -->
        <script src="JavaScript/mapAPI.js"></script>

        <script>
                                                $(".option").click(function () {
                                                    $(".option").removeClass("active");
                                                    $(this).addClass("active");
                                                });
        </script>

    </body>

</html>

