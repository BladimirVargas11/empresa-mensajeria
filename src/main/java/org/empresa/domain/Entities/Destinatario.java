package org.empresa.domain.Entities;

public class Destinatario extends BaseEntity<Integer> {
    private String nombreCompania;
    private String nombreContacto;
    private String direccion;

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    private String telefono;

    public Destinatario(String nombreCompania, String nombreContacto, String direccion, String telefono) {
        this.nombreCompania = nombreCompania;
        this.nombreContacto = nombreContacto;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    public Destinatario(){

    }
}
