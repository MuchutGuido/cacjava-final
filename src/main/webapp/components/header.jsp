<%-- 
    Document   : header
    Created on : 4 ago. 2021, 22:21:01
    Author     : Guido
--%>

<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">${usuario.getNombre()} ${usuario.getApellido()}</a>
    <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <!--<input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">-->
    <div class="text-muted w-100 px-3"></div>
    <div class="navbar-nav">
        <div class="nav-item text-nowrap">
            <a href="InicioController?accion=salir" class="nav-link px-3">Cerrar sesión</a>
        </div>
    </div>
</header>
