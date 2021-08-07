<%-- 
Document : clientes 
Created on : 23 jul. 2021, 14:11:09 
Author : Guido 
--%>

<%@page import="model.ClientesDAO" %>
<%@page import="java.util.List" %>
<%@page import="model.Clientes" %>

<%@include file="../components/session.jsp" %>
<jsp:include page="../components/head.jsp" >
    <jsp:param  name="title" value="Clientes"/>
</jsp:include>
<%@include file="../components/header.jsp" %>

<div class="container-fluid">
    <div class="row">
        <%@include file="../components/sidebar.jsp" %>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <h3 class="text-center my-3">Listado de clientes!</h3>
            <a href="ClientesController?accion=nuevo" class="btn btn-primary mb-2">
                <i class="fas fa-plus fa-fw mr-2"></i>Nuevo
            </a>
            <div class="table-responsive">
                <table class="table table-hover table-stripped table-sm">
                    <thead>
                    <th scope="col">DNI</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">Domicilio</th>
                    <th scope="col">Teléfono</th>
                    <th scope="col">E-mail</th>
                    <th scope="col">Acciones</th>
                    </thead>
                    <tbody>
                        <%
                            List<Clientes> resultado = null;
                            ClientesDAO clientes = new ClientesDAO();
                            resultado = clientes.listarClientes();

                            for (int i = 0; i < resultado.size(); i++) {
                                Clientes get = resultado.get(i);
                        %>
                        <tr>
                            <td><%=get.getDni()%></td>
                            <td><%=get.getNombre()%></td>
                            <td><%=get.getApellido()%></td>
                            <td><%=get.getDomicilio()%></td>
                            <td><%=get.getTelefono()%></td>
                            <td><%=get.getEmail()%></td>
                            <td>
                                <div class="btn-group btn-group-sm" role="group" aria-label="Basic example">
                                    <a href="ClientesController?accion=modificar&id=<%=get.getId()%>" class="btn btn-warning" title="Modificar cliente">
                                        <i class="fas fa-edit fa-fw"></i>
                                    </a>
                                    <a href="ClientesController?accion=eliminar&id=<%=get.getId()%>" class="btn btn-danger" title="Eliminar cliente">
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