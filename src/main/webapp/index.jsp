<%-- 
    Document   : index
    Created on : 5 ago. 2021, 18:58:58
    Author     : Guido
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% session = request.getSession(false);
    if(session.getAttribute("ok") != null) {
        response.sendRedirect("ClientesController");
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login | Muchut</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/dashboard/">
    <style type="text/css">
    <%@include file="css/index.css" %>
    </style>
    <link href="https://fonts.googleapis.com/css2?family=New+Tegomin&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
</head>
<body>
<div class="container col-lg-3 login">
    <h3 class="text-center text-primary mb-5">Login</h3>
    <% if (request.getAttribute("login") == "0") { %>
    <div class="alert alert-danger">Email y/o contraseña erronea</div>
    <% } %>
    <form action="InicioController?accion=validar" method="POST">
        <div class="mb-3">
            <label for="email" class="form-label mb-0">Email</label>
            <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label mb-0">Contraseña</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
         <!--col-6 mx-auto-->
        <div class="d-grid gap-2">
            <input type="submit" class="btn btn-info" value="Acceder">
        </div>
    </form>
</div>
</body>
</html>
