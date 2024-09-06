package org.empresa.application;

import org.empresa.domain.Entities.Caja;
import org.empresa.domain.Entities.Paquete;
import org.empresa.domain.Entities.Servicio;
import org.empresa.domain.Entities.Sobre;

public interface ServicioFactory {
    public static Servicio crearServicio(int opcionPaquete) {
        try {
            switch (opcionPaquete) {
                case 1:
                    return new Sobre();
                case 2:
                    return new Caja();
                case 3:
                    return new Paquete();
                default:
                    throw new IllegalArgumentException("Opción inválida: " + opcionPaquete);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear el servicio: " + e.getMessage());
            return new Sobre(); 
        }
    }
}
