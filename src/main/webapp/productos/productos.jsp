<%-- 
    Document   : productos
    Created on : 7 ago. 2021, 16:43:20
    Author     : Guido
--%>

<%@page import="model.ProductosDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Productos"%>

<%@include file="../components/session.jsp" %>
<jsp:include page="../components/head.jsp" >
    <jsp:param  name="title" value="Productos"/>
</jsp:include>
<%@include file="../components/header.jsp" %>

<div class="container-fluid">
    <div class="row">
        <%@include file="../components/sidebar.jsp" %>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <h3 class="text-center my-3">Listado de productos!</h3>
            <a href="ProductosController?accion=nuevo" class="btn btn-primary mb-2">
                <i class="fas fa-plus fa-fw mr-2"></i>Nuevo
            </a>
            <div class="table-responsive">
                <table class="table table-hover table-stripped table-sm">
                    <thead>
                    <th scope="col">Producto</th>
                    <th scope="col">Stock</th>
                    <th scope="col">Precio</th>
                    <th scope="col">Acciones</th>
                    </thead>
                    <tbody>
                        <%
                            List<Productos> resultado = null;
                            ProductosDAO productos = new ProductosDAO();
                            resultado = productos.listarProductos();

                            for (int i = 0; i < resultado.size(); i++) {
                                Productos get = resultado.get(i);
                        %>
                        <tr>
                            <td><%=get.getNombre()%></td>
                            <td><%=get.getStock()%></td>
                            <td><%=get.getPrecio()%></td>
                            <td>
                                <div class="btn-group btn-group-sm" role="group" aria-label="Basic example">
                                    <a href="ProductosController?accion=modificar&id=<%=get.getId()%>" class="btn btn-warning" title="Modificar producto">
                                        <i class="fas fa-edit fa-fw"></i>
                                    </a>
                                    <a href="ProductosController?accion=eliminar&id=<%=get.getId()%>" class="btn btn-danger" title="Eliminar producto">
                                        <i class="fas fa-trash fa-fw"></i>
                                    </a>
                                </div>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</div>

<%@include file="../components/footer.jsp" %>