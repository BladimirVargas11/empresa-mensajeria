package org.empresa.domain.Entities;

public class Caja extends Servicio {
    @Override
    public double calcularTarifa(double peso, double valorDeclarado) {
        // Lógica específica para calcular la tarifa de una caja
        return valorBase + peso * 200 + valorDeclarado * 0.2;
    }
}