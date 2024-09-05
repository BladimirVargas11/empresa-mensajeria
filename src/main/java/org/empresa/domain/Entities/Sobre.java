package org.empresa.domain.Entities;

public class Sobre extends Servicio {
    @Override
    public double calcularTarifa(double peso, double valorDeclarado) {
        // Lógica específica para calcular la tarifa de un sobre
        return valorBase + peso * 100 + valorDeclarado * 0.1;
    }
}