package org.empresa.domain.Ports.Services;
import java.util.List;

import org.empresa.domain.Entities.Guia;

public interface IGuiaService {
    Guia crearGuia(Guia guia);
    Guia obtenerGuiaPorNumero(int numeroGuia);
    List<Guia> obtenerTodasLasGuias();
    Guia actualizarGuia(Guia guia);
    boolean eliminarGuia(int numeroGuia);
    double calcularValorGuia(Guia guia);
    void cambiarEstadoGuia(int numeroGuia, String nuevoEstado);
    List<Guia> obtenerGuiasPorEstado(String estado);
    List<Guia> obtenerGuiasPorNombreDestinatario(String nombreDestinatario);
}
