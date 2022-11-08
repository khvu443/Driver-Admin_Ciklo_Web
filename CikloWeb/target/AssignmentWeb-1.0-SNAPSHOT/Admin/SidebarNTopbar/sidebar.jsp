

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
        <a class="nav-link" href="http://localhost:8080/CikloWeb/AdminServlet">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Route       
    </div>

    <!-- Nav Item - Utilities Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link" href="http://localhost:8080/CikloWeb/Admin/Route.jsp">
            <i class="fas fa-fw fa-wrench"></i>
            <span>Route Manage</span>
        </a>
    </li>


    <!-- Divider -->
    <hr class="sidebar-divider">
    <!-- Heading -->
    <div class="sidebar-heading">
        Account Manage
    </div>

    <!-- Nav Item - Driver -->
    <li class="nav-item">
        <!--                <a class="nav-link" href="tables.html">
                            <i class="fas fa-solid fa-plus"></i>
                            <span>Create Driver Account</span></a>-->
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
            <i class="fas fa-solid fa-id-badge"></i>
            <span>Driver</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Driver Manage:</h6>
                <a class="collapse-item" href="http://localhost:8080/CikloWeb/AdminDriverAccount">Driver Detail</a>
                <a class="collapse-item" href="http://localhost:8080/CikloWeb/AdminAddNewDriver">Create Driver Account</a>
            </div>
        </div>
    </li>

    <!-- Nav Item - Customer -->
    <li class="nav-item">
        <a class="nav-link" href="http://localhost:8080/CikloWeb/Admin/Customer.jsp">
            <i class="fas fa-fw fa-table"></i>
            <span>Customer</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">
    <!-- Nav Item - Customer -->
    <li class="nav-item">
        <a class="nav-link" href="http://localhost:8080/CikloWeb/HomeSevlet">
            <i class="fa fa-house-user"></i>
            <span>Home Page</span></a>
    </li>

    <hr class="sidebar-divider d-none d-md-block">
    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

</ul>


