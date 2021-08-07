<%-- 
    Document   : session
    Created on : 7 ago. 2021, 15:41:56
    Author     : Guido
--%>

<% session = request.getSession(true);
    if(session.getAttribute("ok") == null) {
        response.sendRedirect("index.jsp");
    }
%>
