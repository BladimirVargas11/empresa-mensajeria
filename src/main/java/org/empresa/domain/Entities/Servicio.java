package org.empresa.domain.Entities;

public abstract class Servicio extends BaseEntity<Integer> {
    protected double valorBase = 5000;

    public abstract double calcularTarifa(double peso, double valorDeclarado);
}
