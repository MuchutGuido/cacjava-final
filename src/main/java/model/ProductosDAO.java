/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guido
 */
public class ProductosDAO {
    Connection conexion;
    
    public ProductosDAO() {
        Conexion con = new Conexion();
        conexion = con.getConnection();
    }
    
    public List<Productos> listarProductos() {
        PreparedStatement ps;
        ResultSet rs;
        
        List<Productos> lista = new ArrayList<>();
        
        try {
            ps = conexion.prepareStatement("SELECT * FROM productos");
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                int id = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                int stock = rs.getInt("stock");
                double precio = rs.getDouble("precio");
                
                Productos producto = new Productos(id, nombre, stock, precio);
                lista.add(producto);
            }
            
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    public Productos mostrarProducto(int _id) {
        PreparedStatement ps;
        ResultSet rs;
        Productos producto = null;
        
        try {
            ps = conexion.prepareStatement("SELECT * FROM productos WHERE id_producto = ?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                int id = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                int stock = rs.getInt("stock");
                double precio = rs.getDouble("precio");
                
                producto = new Productos(id, nombre, stock, precio);
            }
            
            return producto;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    public boolean insertarProducto(Productos producto) {
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement("INSERT INTO productos(nombre, stock, precio) VALUE(?,?,?)");
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getStock());
            ps.setDouble(3, producto.getPrecio());
            
            return ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean actualizarProducto(Productos producto) {
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement("UPDATE productos SET nombre = ?, stock = ?, precio = ? WHERE id_producto = ?");
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getStock());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getId());
            
            return ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean eliminarProducto(int _id) {
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement("DELETE FROM productos WHERE id_producto = ?");
            ps.setInt(1, _id);
            
            return ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
