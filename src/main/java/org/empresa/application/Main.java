package org.empresa.application;

import org.empresa.domain.Entities.Guia;
import org.empresa.domain.Services.GuiaService;
import org.empresa.infraestructure.Extensions.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        GuiaService guiaService = context.getBean(GuiaService.class);

        UserInterface userInterface = new UserInterface();

        while (true) {
            userInterface.displayMenu();
            int opcion = userInterface.getUserOption();

            switch (opcion) {
                case 1:
                    Guia guia = userInterface.getGuiaFromUser();
                    guiaService.crearGuia(guia);
                    break;
                case 2:
                    String estado = userInterface.getEstadoFromUser();
                    List<Guia> guiasPorEstado = guiaService.obtenerGuiasPorEstado(estado);
                    userInterface.displayGuias(guiasPorEstado);
                    break;
                case 3:
                    String destinatario = userInterface.getEmpresaDestinatarioFromUser();
                    List<Guia> guiasPorDestinatario = guiaService.obtenerGuiasPorNombreDestinatario(destinatario);
                    userInterface.displayGuias(guiasPorDestinatario);
                    break;
                case 4:
                    userInterface.exit();
                    break;
            }
        }

    }
}