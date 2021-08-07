<%-- 
    Document   : modificar
    Created on : 7 ago. 2021, 18:25:59
    Author     : Guido
--%>

<%@page import="model.ProductosDAO"%>
<%@page import="model.Productos"%>

<%@include file="../components/session.jsp" %>
<jsp:include page="../components/head.jsp" >
    <jsp:param  name="title" value="Modificar Producto"/>
</jsp:include>
<%@include file="../components/header.jsp" %>
<%
    String id = request.getParameter("id"); // Use request para obtener 
    int _id = Integer.parseInt(id);
    Productos resultado = null;
    ProductosDAO productoDAO = new ProductosDAO();
    resultado = productoDAO.mostrarProducto(_id);
%>
<div class="container-fluid">
    <div class="row">
        <%@include file="../components/sidebar.jsp" %>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <h2 class="text-center my-3">Actualizar producto</h2>
            <div class="row justify-content-md-center">
                <form style="max-width: 500px;" action="ProductosController?accion=actualizar" method="POST">
                    <input type="hidden" name="id" value="<%=resultado.getId()%>">
                    <div class="mb-3">
                        <label for="nombre" class="form-label mb-0">Nombre</label>
                        <input type="text" id="nombre" name="nombre" class="form-control" value="<%=resultado.getNombre()%>" required>
                    </div>
                    <div class="mb-3">
                        <label for="stock" class="form-label mb-0">Stock</label>
                        <input type="number" id="stock" name="stock" class="form-control" value="<%=resultado.getStock()%>" required>
                    </div>
                    <div class="mb-3">
                        <label for="precio" class="form-label mb-0">Precio</label>
                        <input type="number" step="0.01" id="precio" name="precio" class="form-control" value="<%=resultado.getPrecio()%>" required>
                    </div>
                    <button type="submit" class="btn btn-primary">
                        <i class="fas fa-edit mr-6"></i> Actualizar
                    </button>
                </form>
            </div>
        </main>
    </div>
</div>

<%@include file="../components/footer.jsp" %>