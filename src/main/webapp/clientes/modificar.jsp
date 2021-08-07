<%-- Document : modificar Created on : 23 jul. 2021, 15:10:37 Author : Guido --%>

<%@page import="model.Clientes"%>
<%@page import="model.ClientesDAO"%>

<%@include file="../components/session.jsp" %>
<jsp:include page="../components/head.jsp" >
    <jsp:param  name="title" value="Modificar Cliente"/>
</jsp:include>
<%@include file="../components/header.jsp" %>
<%
    String id = request.getParameter("id"); // Use request para obtener 
    int _id = Integer.parseInt(id);
    Clientes resultado = null;
    ClientesDAO clienteDAO = new ClientesDAO();
    resultado = clienteDAO.mostrarCliente(_id);
%>
<div class="container-fluid">
    <div class="row">
        <%@include file="../components/sidebar.jsp" %>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <h2 class="text-center my-3">Actualizar cliente</h2>
            <div class="row justify-content-md-center">
                <form style="max-width: 500px;" action="ClientesController?accion=actualizar" method="POST">
                    <input type="hidden" name="id" value="<%=resultado.getId()%>">
                    <div class="mb-3">
                        <label for="dni" class="form-label mb-0">DNI</label>
                        <input type="number" id="dni" name="dni" class="form-control" value="<%=resultado.getDni()%>" required>
                    </div>
                    <div class="mb-3">
                        <label for="nombre" class="form-label mb-0">Nombre</label>
                        <input type="text" id="nombre" name="nombre" class="form-control" value="<%=resultado.getNombre()%>" required>
                    </div>
                    <div class="mb-3">
                        <label for="apellido" class="form-label mb-0">Apellido</label>
                        <input type="text" id="apellido" name="apellido" class="form-control" value="<%=resultado.getApellido()%>" required>
                    </div>
                    <div class="mb-3">
                        <label for="domicilio" class="form-label mb-0">Domicilio</label>
                        <input type="text" id="domicilio" name="domicilio" class="form-control" value="<%=resultado.getDomicilio()%>">
                    </div>
                    <div class="mb-3">
                        <label for="telefono" class="form-label mb-0">Teléfono</label>
                        <input type="number" id="telefono" name="telefono" class="form-control" value="<%=resultado.getTelefono()%>">
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label mb-0">Email</label>
                        <input type="email" id="email" name="email" class="form-control" value="<%=resultado.getEmail()%>" required>
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