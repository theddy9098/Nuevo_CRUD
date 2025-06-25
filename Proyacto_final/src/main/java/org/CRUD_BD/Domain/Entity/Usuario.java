package org.CRUD_BD.Domain.Entity;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String cargo;
    private int telefono;
    private String direccion;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido, String cargo, int telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
