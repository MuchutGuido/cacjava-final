<%-- 
    Document   : nuevo
    Created on : 23 jul. 2021, 14:11:20
    Author     : Guido
--%>

<%@include file="../components/session.jsp" %>
<jsp:include page="../components/head.jsp" >
    <jsp:param  name="title" value="Nuevo Cliente"/>
</jsp:include>
<%@include file="../components/header.jsp" %>

<div class="container-fluid">
    <div class="row">
        <%@include file="../components/sidebar.jsp" %>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <h4 class="text-center my-3">Crear cliente</h4>
            <div class="row justify-content-md-center">
                <form style="max-width: 500px;" action="ClientesController?accion=crear" method="POST">
                    <div class="mb-3">
                        <label for="dni" class="form-label mb-0">DNI</label>
                        <input type="number" id="dni" name="dni" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="nombre" class="form-label mb-0">Nombre</label>
                        <input type="text" id="nombre" name="nombre" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="apellido" class="form-label mb-0">Apellido</label>
                        <input type="text" id="apellido" name="apellido" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="domicilio" class="form-label mb-0">Domicilio</label>
                        <input type="text" id="domicilio" name="domicilio" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="telefono" class="form-label mb-0">Teléfono</label>
                        <input type="number" id="telefono" name="telefono" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label mb-0">Email</label>
                        <input type="email" id="email" name="email" class="form-control" required>
                    </div>
                    <button type="submit" class="btn btn-primary">
                        <i class="fas fa-save mr-6"></i>Crear
                    </button>
                </form>
            </div>
        </main>
    </div>
</div>

<%@include file="../components/footer.jsp" %>
