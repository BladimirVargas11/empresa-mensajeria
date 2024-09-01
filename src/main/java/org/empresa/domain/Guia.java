package org.empresa.domain;

public class Guia {
    private int numeroGuia;
    private double peso;
    private double valorDeclarado;
    private Estado estado;
    private Servicio servicio;
    private Remitente remitente;
    private Destinatario destinatario;

    public double calcularValor() {
        return servicio.calcularTarifa(peso, valorDeclarado);
    }

    public void cambiarEstado(Estado nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public int getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(int numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getValorDeclarado() {
        return valorDeclarado;
    }

    public void setValorDeclarado(double valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Remitente getRemitente() {
        return remitente;
    }

    public void setRemitente(Remitente remitente) {
        this.remitente = remitente;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    public Guia(int numeroGuia, double peso, double valorDeclarado, Estado estado, Servicio servicio, Remitente remitente, Destinatario destinatario) {
        this.numeroGuia = numeroGuia;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
        this.estado = estado;
        this.servicio = servicio;
        this.remitente = remitente;
        this.destinatario = destinatario;
    }
}
