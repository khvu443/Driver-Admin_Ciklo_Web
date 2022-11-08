<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    /* Nút Dropdown*/
    .nut_dropdown {
        background-color: rgba(255,255,255,0);
        background-color: Transparent;
        background-repeat:no-repeat;
        border: none;
        color: #FFF;
        padding: 16px;
        font-size: 13px;
        border: none;
    }

    .nut_dropdown:hover {
        background-color: rgba(255,255,255,0);
        background-color: Transparent;
        background-repeat:no-repeat;
        border: none;
        color: #D10024;
        padding: 16px;
        font-size: 13px;
        border: none;
    }
    /* Thiết lập vị trí cho thẻ div với class dropdown*/
    .dropdown {
        position: relative;
        display: inline-block;
    }
    /* Nội dung Dropdown */
    .noidung_dropdown {
        /*Ẩn nội dụng các đường dẫn*/
        margin-top:30px;
        border-radius: 8px;
        display: none;
        position: absolute;
        background: rgb(34,179,193);
        background: linear-gradient(0deg, rgba(34,179,193,0.6982143199076505) 0%, rgba(0,0,0,0.40129555240064774) 100%);
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
    }
    /* Thiết kế style cho các đường dẫn tronng Dropdown */
    .noidung_dropdown a {
        color: #D10024;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }
    .hienThi{
        display:block;
    }
</style>

<!-- ***** Header Area Start ***** -->
<header class="header-area header-sticky">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <nav class="main-nav">
                    <!-- ***** Logo Start ***** -->
                    <a href="index.html" class="logo">
                        <img src="assets/images/logo.png" alt="">
                    </a>
                    <!-- ***** Logo End ***** -->
                    <!-- ***** Menu Start ***** -->
                    <ul class="nav">
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="DetailRoute.jsp">Detail ${route}</a></li>
                        <li><a href="About.jsp">About Us</a></li>
                        <li>
                            <form class="d-flex" role="search" id="searchBtn">
                                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                                <button class="btn btn-outline-white" type="submit">Search</button>
                            </form>
                        </li>
                        <li>    
                            <c:if test="${not empty User}">
                                <div class="d-flex">                            
                                    <c:set var = "ID" value = "${ID}"></c:set>
                                    <c:if test = "${ID eq 'D'}">
                                        <div class="dropdown">
                                            <a onclick="hamDropdown()" class="nut_dropdown" >
                                                Hello ${User.driverUserName}
                                            </a>
                                        </div>
                                        <div class="noidung_dropdown">
                                            <a id="dropItem" href="UpdateAccountServlet?id=${User.driverID}" style="font-size: 14px" >Manager Account</a>
                                            <hr class="solid" style="border-top: 1px solid #D9D9D9;">
                                            <a id="dropItem" href="LogoutServlet" style="margin-top: -20px; font-size: 14px">Logout</a>
                                        </div>

                                    </c:if>

                                    <c:if test = "${fn:contains(ID, 'KH')}">
                                        <div class="dropdown">
                                            <a onclick="hamDropdown()" class="nut_dropdown">
                                                Hello ${User.cusUserName}
                                            </a>
                                        </div>

                                        <div class="noidung_dropdown">
                                            <a id="dropItem" href="UpdateAccountServlet?id=${User.cusID}" style="font-size: 14px" >Manager Account</a>
                                            <a id="dropItem" href="" style="margin-bottom:-20px;font-size: 14px">View Bill</a>
                                            <hr class="solid" style="border-top: 1px solid #D9D9D9;">
                                            <a id="dropItem" href="LogoutServlet" style="margin-top: -20px; font-size: 14px">Logout</a>
                                        </div>
                                    </c:if>

                                    <c:if test = "${ID eq 'AD'}">
                                        <div class="dropdown">
                                            <a onclick="hamDropdown()" class="nut_dropdown">
                                                Hello ${User.adUserName}
                                            </a>
                                        </div>

                                        <div class="noidung_dropdown">
                                            <a id="dropItem" href="UpdateAccountServlet?id=${User.adID}" style="font-size: 12px" >Manager Account</a>
                                            <hr class="solid" style="border-top: 1px solid #D9D9D9;">
                                            <a id="dropItem" href="AdminServlet" style="margin-top: -20px; font-size: 14px">Admin Home</a>
                                            <hr class="solid" style="border-top: 1px solid #D9D9D9;">

                                            <a id="dropItem" href="LogoutServlet" style="margin-top: -20px; font-size: 14px">Logout</a>
                                        </div>
                                    </c:if>
                                </div>
                            </c:if>
                            <c:if test="${empty User}">
                                <a href="Login.jsp"><i class=""></i> Login</ <aa>
                                    </c:if>


                                    </li>
                                    </ul>   
                                    <a class='menu-trigger'>
                                        <span>Menu</span>
                                    </a>
                                    <!-- ***** Menu End ***** -->
                                    </nav>
                                    </div>
                                    </div>
                                    </div>
                                    </header>
                                    <!-- ***** Header Area End ***** -->

                                    <script>
                                        function hamDropdown() {
                                            document.querySelector(".noidung_dropdown").classList.toggle("hienThi");
                                        }
                                    </script>                                  

