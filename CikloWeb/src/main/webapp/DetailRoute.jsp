<%-- 
    Document   : DetailRoute
    Created on : Sep 21, 2022, 3:50:24 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

        <title>Route</title>

        <!-- Bootstrap core CSS -->
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

        <!-- ***** Header Area Start ***** -->
        <jsp:include page="HeaderNFooter/header.jsp"></jsp:include>
        <!-- ***** Header Area End ***** -->

        <!-- ***** Main Banner Area Start ***** -->
        <div class="about-main-content">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="content">
                            <div class="blur-bg"></div>
                            <h4>EXPLORE OUR ROUTE</h4>
                            <div class="line-dec"></div>
                            <h2>Welcome To HOI AN</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt uttersi labore et dolore magna aliqua is ipsum suspendisse ultrices gravida</p>
                            <div class="main-button">
                                <a href="reservation.html">Discover More</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- ***** Main Banner Area End ***** -->

        <div class="cities-town">
            <div class="container">
                <div class="row">
                    <div class="slider-content">
                        <div class="row">
                            <div class="col-lg-12">
                                <h2>Caribbean’s <em>Cities &amp; Towns</em></h2>
                            </div>
                            <div class="col-lg-12">
                                <div class="owl-cites-town owl-carousel">
                                    <div class="item">
                                        <div class="thumb">
                                            <img src="assets/images/cities-01.jpg" alt="">
                                            <h4>EXAMPLE</h4>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="thumb">
                                            <img src="assets/images/cities-02.jpg" alt="">
                                            <h4>EXAMPLE</h4>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="thumb">
                                            <img src="assets/images/cities-03.jpg" alt="">
                                            <h4>EXAMPLE</h4>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="thumb">
                                            <img src="assets/images/cities-04.jpg" alt="">
                                            <h4>EXAMPLE</h4>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="thumb">
                                            <img src="assets/images/cities-01.jpg" alt="">
                                            <h4>EXAMPLE</h4>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="thumb">
                                            <img src="assets/images/cities-02.jpg" alt="">
                                            <h4>EXAMPLE</h4>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="thumb">
                                            <img src="assets/images/cities-03.jpg" alt="">
                                            <h4>EXAMPLE</h4>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="thumb">
                                            <img src="assets/images/cities-04.jpg" alt="">
                                            <h4>EXAMPLE</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="weekly-offers">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 offset-lg-3">
                        <div class="section-heading text-center">
                            <h2 class="text-info">Best Place</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="owl-weekly-offers owl-carousel">
                            <div class="item">
                                <div class="thumb">
                                    <img src="assets/images/offers-01.jpg" alt="">
                                    <div class="text">
                                        <h4>Name Place</h4><br>
                                        <h6>$420<span>/person</span></h6>
                                        <div class="line-dec"></div>
                                        <ul>
                                            <li>Deal Includes:</li>
                                            <li><i class="fa fa-taxi"></i> 5 Days Trip > Hotel Included</li>
                                            <li><i class="fa fa-plane"></i> Airplane Bill Included</li>
                                            <li><i class="fa fa-building"></i> Daily Places Visit</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="thumb">
                                    <img src="assets/images/offers-02.jpg" alt="">
                                    <div class="text">
                                        <h4>Name Place</h4><br>
                                        <h6>$420<span>/person</span></h6>
                                        <div class="line-dec"></div>
                                        <ul>
                                            <li>Deal Includes:</li>
                                            <li><i class="fa fa-taxi"></i> 5 Days Trip > Hotel Included</li>
                                            <li><i class="fa fa-plane"></i> Airplane Bill Included</li>
                                            <li><i class="fa fa-building"></i> Daily Places Visit</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="thumb">
                                    <img src="assets/images/offers-03.jpg" alt="">
                                    <div class="text">
                                        <h4>Name Place</h4><br>
                                        <h6>$420<span>/person</span></h6>
                                        <div class="line-dec"></div>
                                        <ul>
                                            <li>Deal Includes:</li>
                                            <li><i class="fa fa-taxi"></i> 5 Days Trip > Hotel Included</li>
                                            <li><i class="fa fa-plane"></i> Airplane Bill Included</li>
                                            <li><i class="fa fa-building"></i> Daily Places Visit</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="thumb">
                                    <img src="assets/images/offers-01.jpg" alt="">
                                    <div class="text">
                                        <h4>Name Place</h4><br>
                                        <h6>$420<span>/person</span></h6>
                                        <div class="line-dec"></div>
                                        <ul>
                                            <li>Deal Includes:</li>
                                            <li><i class="fa fa-taxi"></i> 5 Days Trip > Hotel Included</li>
                                            <li><i class="fa fa-plane"></i> Airplane Bill Included</li>
                                            <li><i class="fa fa-building"></i> Daily Places Visit</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="thumb">
                                    <img src="assets/images/offers-02.jpg" alt="">
                                    <div class="text">
                                        <h4>Name Place</h4><br>
                                        <h6>$420<span>/person</span></h6>
                                        <div class="line-dec"></div>
                                        <ul>
                                            <li>Deal Includes:</li>
                                            <li><i class="fa fa-taxi"></i> 5 Days Trip > Hotel Included</li>
                                            <li><i class="fa fa-plane"></i> Airplane Bill Included</li>
                                            <li><i class="fa fa-building"></i> Daily Places Visit</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="thumb">
                                    <img src="assets/images/offers-03.jpg" alt="">
                                    <div class="text">
                                        <h4>Name Place</h4><br>
                                        <h6>$420<span>/person</span></h6>
                                        <div class="line-dec"></div>
                                        <ul>
                                            <li>Deal Includes:</li>
                                            <li><i class="fa fa-taxi"></i> 5 Days Trip > Hotel Included</li>
                                            <li><i class="fa fa-plane"></i> Airplane Bill Included</li>
                                            <li><i class="fa fa-building"></i> Daily Places Visit</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright © 2036 <a href="#">WoOx Travel</a> Company. All rights reserved. 
                            <br>Design: <a href="https://templatemo.com" target="_blank" title="free CSS templates">TemplateMo</a></p>
                    </div>
                </div>
            </div>
        </footer>


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

        <script src="JavaScript/mapAPI.js"></script>

        <script>
            $(".option").click(function () {
                $(".option").removeClass("active");
                $(this).addClass("active");
            });
        </script>

    </body>

</html>

