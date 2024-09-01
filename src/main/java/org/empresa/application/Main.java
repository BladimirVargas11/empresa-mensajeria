package org.empresa.application;


import org.empresa.domain.*;
import org.empresa.infraestructure.EmpresaDAO;
import org.empresa.infraestructure.GuiaDAO;

import java.util.List;
import java.util.Scanner;

import static org.empresa.domain.Estado.DESPACHO;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        EmpresaDAO empresaDAO = new EmpresaDAO(empresa);
        GuiaDAO guiaDAO = new GuiaDAO();



        // Ejemplo de uso
        while (true) {
            System.out.println("1. Registrar guía");
            System.out.println("2. Consultar guías por estado");
            System.out.println("3. Consultar guías por empresa destinatario");
            System.out.println("4. Salir");
            System.out.println("===========================");
            System.out.println("Seleccione Su Opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    empresa.registrarGuia(saveGuia());
                    break;
                case 2:
                    System.out.println("Ingrese el estado (DESPACHO, FINALIZADA):");
                    String estado = scanner.next().toUpperCase();
                    List<Guia> guiasPorEstado = empresa.consultarGuiasPorEstado(Estado.valueOf(estado));
                    for (Guia g : guiasPorEstado) {
                        System.out.println("Guía: " + g.getNumeroGuia() + ", Estado: " + g.getEstado());
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nombre de la empresa destinatario:");
                    String destinatario = scanner.next();
                    List<Guia> guiasPorDestinatario = empresa.consultarGuiasPorDestinatario(destinatario);
                    for (Guia g : guiasPorDestinatario) {
                        System.out.println("Guía: " + g.getNumeroGuia() + ", Destinatario: " + g.getDestinatario().getNombreCompania());
                    }
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    public static Guia saveGuia() {
        Remitente remitente = crearRemitente();
        Destinatario destinatario = crearDestinatario();
        Guia guia = crearGuia(remitente, destinatario);

        System.out.println("El valor de su envío es: " + guia.calcularValor());
        return guia;
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

    private static Guia crearGuia(Remitente remitente, Destinatario destinatario) {
        int numeroGuia = leerEntero("Ingrese el número de guía:");
        int peso = leerEntero("Ingrese el peso del paquete:");
        int valorEnvio = leerEntero("Ingrese el valor del envío:");
        int opcionPaquete = leerEntero("\n1.SOBRE \n2.CAJA \n3.PAQUETE \n Ingrese tipo: ");

        Servicio servicio;
        switch (opcionPaquete) {
            case 1:
                servicio = new Sobre();
                break;
            case 2:
                servicio = new Caja(); // Asume que tienes una clase Caja
                break;
            case 3:
                servicio = new Paquete(); // Asume que tienes una clase Paquete
                break;
            default:
                System.out.println("Opción inválida. Se utilizará un Sobre por defecto.");
                servicio = new Sobre();
                break;
        }

        return new Guia(numeroGuia, peso, valorEnvio, DESPACHO, servicio, remitente, destinatario);
    }

    private static String leerLinea() {
        return scanner.nextLine();
    }

    private static  int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.println(mensaje);
                return Integer.parseInt(leerLinea());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            }
        }
    }
}