package org.empresa.domain.Entities;

public class Paquete extends Servicio {


    public Paquete(int tipoPaquete) {
        super(tipoPaquete);
    }

    @Override
    public double calcularTarifa(double peso, double valorDeclarado) {
        return valorBase + peso * 300 + valorDeclarado * 0.3;
    }
}