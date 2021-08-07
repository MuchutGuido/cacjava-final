<%-- 
    Document   : nuevo
    Created on : 7 ago. 2021, 17:30:23
    Author     : Guido
--%>

<%@include file="../components/session.jsp" %>
<jsp:include page="../components/head.jsp" >
    <jsp:param  name="title" value="Nuevo Producto"/>
</jsp:include>
<%@include file="../components/header.jsp" %>

<div class="container-fluid">
    <div class="row">
        <%@include file="../components/sidebar.jsp" %>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <h4 class="text-center my-3">Crear producto</h4>
            <div class="row justify-content-md-center">
                <form style="max-width: 500px;" action="ProductosController?accion=crear" method="POST">
                    <div class="mb-3">
                        <label for="nombre" class="form-label mb-0">Producto</label>
                        <input type="text" id="nombre" name="nombre" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="stock" class="form-label mb-0">Stock</label>
                        <input type="number" id="stock" name="stock" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="precio" class="form-label mb-0">Precio</label>
                        <input type="number" step="0.01" id="precio" name="precio" class="form-control" required>
                    </div>
                    <button type="submit" class="btn btn-primary">
                        <i class="fas fa-save fa-fw mr-6"></i>Crear
                    </button>
                </form>
            </div>
        </main>
    </div>
</div>

<%@include file="../components/footer.jsp" %>
