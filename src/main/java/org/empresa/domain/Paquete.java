package org.empresa.domain;

public class Paquete extends Servicio {
    @Override
    public double calcularTarifa(double peso, double valorDeclarado) {
        // Lógica específica para calcular la tarifa de un paquete
        return valorBase + peso * 300 + valorDeclarado * 0.3;
    }
}