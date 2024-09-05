package org.empresa.application;

import java.util.List;
import java.util.Scanner;

import org.empresa.application.interfaces.IUserInterface;
import org.empresa.domain.Entities.Guia;
import org.empresa.domain.Services.EmpresaService;
import org.empresa.infraestructure.Extensions.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserInterface implements IUserInterface {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("1. Registrar guía");
        System.out.println("2. Consultar guías por estado");
        System.out.println("3. Consultar guías por empresa destinatario");
        System.out.println("4. Salir");
        System.out.println("===========================");
    }

    @Override
    public int getUserOption() {
        return scanner.nextInt();
    }

    @Override
    public Guia getGuiaFromUser() {
        System.err.println("Hola");
        return new Guia(getUserOption(), getUserOption(), getUserOption(), null, null, null, null);
    }

    @Override
    public String getEstadoFromUser() {
        System.out.println("Ingrese el estado (DESPACHO, FINALIZADA):");
        return scanner.next().toUpperCase();
    }

    @Override
    public String getEmpresaDestinatarioFromUser() {
        System.out.println("Ingrese el nombre de la empresa destinatario:");
        return scanner.next();
    }

    @Override
    public void displayGuias(List<Guia> guias) {
        for (Guia g : guias) {
            System.out.println("Guía: " + g.getNumeroGuia() + ", Estado: " + g.getEstado());
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
