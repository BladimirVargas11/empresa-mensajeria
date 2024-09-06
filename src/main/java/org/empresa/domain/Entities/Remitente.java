package org.empresa.domain.Entities;

public class Remitente {
    private String nombre;
    private String departamento;
    private String telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Remitente(String nombre, String departamento, String telefono) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.telefono = telefono;
    }

}

