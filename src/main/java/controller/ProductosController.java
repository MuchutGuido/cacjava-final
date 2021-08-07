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
import model.Productos;
import model.ProductosDAO;

/**
 *
 * @author Guido
 */
@WebServlet(name = "ProductosController", urlPatterns = {"/ProductosController"})
public class ProductosController extends HttpServlet {

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
        ProductosDAO productosDAO = new ProductosDAO();
        String accion;
        RequestDispatcher dispatcher = null;
        accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            dispatcher = request.getRequestDispatcher("productos/productos.jsp");
        } else if (accion.equals("modificar")) {
            dispatcher = request.getRequestDispatcher("productos/modificar.jsp");
        } else if (accion.equals("actualizar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            int stock = Integer.parseInt(request.getParameter("stock"));
            double precio = Double.parseDouble(request.getParameter("precio"));

            Productos producto = new Productos(id, nombre, stock, precio);
            productosDAO.actualizarProducto(producto);

            dispatcher = request.getRequestDispatcher("productos/productos.jsp");
        } else if (accion.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            productosDAO.eliminarProducto(id);

            dispatcher = request.getRequestDispatcher("productos/productos.jsp");
        } else if (accion.equals("nuevo")) {
            dispatcher = request.getRequestDispatcher("productos/nuevo.jsp");
        } else if (accion.equals("crear")) {
            String nombre = request.getParameter("nombre");
            int stock = Integer.parseInt(request.getParameter("stock"));
            double precio = Double.parseDouble(request.getParameter("precio"));

            Productos producto = new Productos(0, nombre, stock, precio);
            productosDAO.insertarProducto(producto);

            dispatcher = request.getRequestDispatcher("productos/productos.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("productos/productos.jsp");
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
