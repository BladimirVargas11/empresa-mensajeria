package org.empresa.domain.Entities;

public class Sobre extends Servicio {


    public Sobre(int tipoPaquete) {
        super(tipoPaquete);
    }

    @Override
    public double calcularTarifa(double peso, double valorDeclarado) {
        return valorBase + peso * 100 + valorDeclarado * 0.1;
    }
}