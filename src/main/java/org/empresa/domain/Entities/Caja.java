package org.empresa.domain.Entities;

public class Caja extends Servicio {

    public Caja(int tipoPaquete) {
        super(tipoPaquete);
    }

    @Override
    public double calcularTarifa(double peso, double valorDeclarado) {
        return valorBase + peso * 200 + valorDeclarado * 0.2;
    }
}