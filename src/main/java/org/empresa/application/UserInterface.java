package org.empresa.application;

import static org.empresa.domain.Entities.Estado.DESPACHO;

import java.util.List;
import java.util.Scanner;

import org.empresa.application.interfaces.IUserInterface;
import org.empresa.domain.Entities.Destinatario;
import org.empresa.domain.Entities.Guia;
import org.empresa.domain.Entities.Remitente;
import org.empresa.domain.Entities.Servicio;

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
        Remitente remitente = crearRemitente();
        Destinatario destinatario = crearDestinatario();
        Guia guia = crearGuia(remitente, destinatario);
        return guia;
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

    @Override
    public void saveGuia(Guia guia) {

    }

    private static Guia crearGuia(Remitente remitente, Destinatario destinatario) {
        int numeroGuia = leerEntero("Ingrese el número de guía:");
        int peso = leerEntero("Ingrese el peso del paquete:");
        int valorEnvio = leerEntero("Ingrese el valor del envío:");
        int opcionPaquete = leerEntero("\n1.SOBRE \n2.CAJA \n3.PAQUETE \n Ingrese tipo: ");

        Servicio servicio = ServicioFactory.crearServicio(opcionPaquete);
 
        return new Guia(numeroGuia, peso, valorEnvio, DESPACHO, servicio, remitente, destinatario);
    }

    private static Destinatario crearDestinatario() {
        System.out.println("Ingrese el nombre de la compañia del destinatario:");
        String nombreCompania = leerLinea();
        System.out.println("Ingrese el nombre de contacto del destinatario:");
        String nombreContacto = leerLinea();
        System.out.println("Ingrese la dirección del destinatario:");
        String direccion = leerLinea();
        System.out.println("Ingrese el teléfono del destinatario:");
        String telefono = leerLinea();
        return new Destinatario(nombreCompania, nombreContacto, direccion, telefono);
    }

    private static Remitente crearRemitente() {
        leerLinea();
        System.out.println("Ingrese el nombre del remitente:");
        String nombre = leerLinea();
        System.out.println("Ingrese el departamento del remitente:");
        String departamento = leerLinea();
        System.out.println("Ingrese el teléfono del remitente:");
        String telefono = leerLinea();
        return new Remitente(nombre, departamento, telefono);
    }

    private static String leerLinea() {
        return scanner.nextLine();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.println(mensaje);
                return Integer.parseInt(leerLinea());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            }
        }
    }

    @Override
    public void showTotalValue(double total) {
        System.out.println("El valor de su envío es: " + total  );
    }

}
