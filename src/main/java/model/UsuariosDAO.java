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

/**
 *
 * @author Guido
 */
public class UsuariosDAO {

    Connection conexion;

    public UsuariosDAO() {
        Conexion con = new Conexion();
        conexion = con.getConnection();
    }

    public Usuarios validar(String _email, String _password) {
        PreparedStatement ps;
        ResultSet rs;
        Usuarios usuario = null;

        try {
            ps = conexion.prepareStatement("SELECT * FROM usuarios WHERE email = ? AND password = ?");
            ps.setString(1, _email);
            ps.setString(2, _password);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");

                usuario = new Usuarios(id, nombre, apellido, email);
            }
            return usuario;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
