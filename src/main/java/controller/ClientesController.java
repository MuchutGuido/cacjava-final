/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Clientes;
import model.ClientesDAO;

/**
 *
 * @author Guido
 */
@WebServlet(name = "ClientesController", urlPatterns = {"/ClientesController"})
public class ClientesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                ClientesDAO clientesDAO = new ClientesDAO();
        String accion;
        RequestDispatcher dispatcher = null;
        accion = request.getParameter("accion");
        
        if (accion == null || accion.isEmpty()) {            
            dispatcher = request.getRequestDispatcher("clientes/clientes.jsp");
        } else if (accion.equals("modificar")) {
            dispatcher = request.getRequestDispatcher("clientes/modificar.jsp");
        } else if (accion.equals("actualizar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            int dni = Integer.parseInt(request.getParameter("dni"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String domicilio = request.getParameter("domicilio");
            String telefono = request.getParameter("telefono");
            String email = request.getParameter("email");
            
            Clientes cliente = new Clientes(id, dni, nombre, apellido, domicilio, telefono, email);
            clientesDAO.actualizarCliente(cliente);
            
            dispatcher = request.getRequestDispatcher("clientes/clientes.jsp");
        } else if (accion.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            clientesDAO.eliminarCliente(id);
            
            dispatcher = request.getRequestDispatcher("clientes/clientes.jsp");
        } else if (accion.equals("nuevo")) {
            dispatcher = request.getRequestDispatcher("clientes/nuevo.jsp");
        } else if (accion.equals("crear")) {
            int dni = Integer.parseInt(request.getParameter("dni"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String domicilio = request.getParameter("domicilio");
            String telefono = request.getParameter("telefono");
            String email = request.getParameter("email");
            
            Clientes cliente = new Clientes(0, dni, nombre, domicilio, telefono, apellido, email);
            clientesDAO.insertarCliente(cliente);
            
            dispatcher = request.getRequestDispatcher("clientes/clientes.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("clientes/clientes.jsp");
        }
        
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
