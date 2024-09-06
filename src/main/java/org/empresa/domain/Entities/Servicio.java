package org.empresa.domain.Entities;

public abstract class Servicio {
    protected static final double valorBase = 5000;
    public int TipoPaquete;
    

    public Servicio(int tipoPaquete) {
        TipoPaquete = tipoPaquete;
    }


    public int getTipoPaquete() {
        return TipoPaquete;
    }


    public void setTipoPaquete(int tipoPaquete) {
        TipoPaquete = tipoPaquete;
    }


    public abstract double calcularTarifa(double peso, double valorDeclarado);
}
