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
public class ClientesDAO {
    Connection conexion;
    
    public ClientesDAO() {
        Conexion con = new Conexion();
        conexion = con.getConnection();
    }
    
    public List<Clientes> listarClientes() {
        PreparedStatement ps;
        ResultSet rs;
        
        List<Clientes> lista = new ArrayList<>();
        
        try {
            ps = conexion.prepareStatement("SELECT * FROM clientes");
            rs = ps.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id_cliente");
                int dni = rs.getInt("dni");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String domicilio = rs.getString("domicilio");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                
                Clientes cliente = new Clientes(id, dni, nombre, apellido, domicilio, telefono, email);
                lista.add(cliente);
            }
            return lista;
        } catch(SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    public Clientes mostrarCliente(int _id) {
        PreparedStatement ps;
        ResultSet rs;
        Clientes cliente = null;
        
        try {
            ps = conexion.prepareStatement("SELECT * FROM clientes WHERE id_cliente = ?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id_cliente");
                int dni = rs.getInt("dni");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String domicilio = rs.getString("domicilio");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                
                cliente = new Clientes(id, dni, nombre, apellido, domicilio, telefono, email);
            }
            return cliente;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    public boolean insertarCliente(Clientes cliente) {
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement("INSERT INTO clientes(dni, nombre, apellido, domicilio, telefono, email) VALUES(?,?,?,?,?,?)");
            ps.setInt(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setString(4, cliente.getDomicilio());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getEmail());
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean actualizarCliente (Clientes cliente) {
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement("UPDATE clientes SET dni = ?, nombre = ?, apellido = ?, domicilio = ?, telefono = ?, email = ? WHERE id_cliente = ?");
            ps.setInt(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setString(4, cliente.getDomicilio());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getEmail());
            ps.setInt(7, cliente.getId());
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean eliminarCliente(int _id) {
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement("DELETE FROM clientes WHERE id_cliente = ?");
            ps.setInt(1, _id);
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
