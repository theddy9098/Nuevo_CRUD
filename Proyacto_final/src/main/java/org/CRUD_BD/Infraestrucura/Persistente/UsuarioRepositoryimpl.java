package org.CRUD_BD.Infraestrucura.Persistente;

import org.CRUD_BD.Domain.Entity.Usuario;
import org.CRUD_BD.Infraestrucura.Confi_BD.Conexion_BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRepositoryimpl implements UsuarioRepository {

    @Override
    public void save(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, apellido, cargo, telefono, direccion) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion_BD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getCargo());
            stmt.setInt(4, usuario.getTelefono());
            stmt.setString(5, usuario.getDireccion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al guardar el usuario: " + e.getMessage());
        }
    }

    @Override
    public Usuario findById(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = Conexion_BD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setTelefono(rs.getInt("telefono"));
                usuario.setDireccion(rs.getString("direccion"));
                return usuario;
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar el usuario: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void update(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, cargo = ?, telefono = ?, direccion = ? WHERE id = ?";
        try (Connection conn = Conexion_BD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getCargo());
            stmt.setInt(4, usuario.getTelefono());
            stmt.setString(5, usuario.getDireccion());
            stmt.setInt(6, usuario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el usuario: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = Conexion_BD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }
}