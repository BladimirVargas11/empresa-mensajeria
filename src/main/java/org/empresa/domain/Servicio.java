package org.empresa.domain;

public abstract class Servicio {
    protected double valorBase = 5000;

    public abstract double calcularTarifa(double peso, double valorDeclarado);
}
