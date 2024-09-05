package org.empresa.infraestructure;
import java.util.ArrayList;
import java.util.List;

import org.empresa.domain.Entities.Estado;
import org.empresa.domain.Entities.Guia;

public class GuiaDAO {
    private List<Guia> guias = new ArrayList<>();

    public void guardarGuia(Guia guia) {
        guias.add(guia);
    }

    public List<Guia> obtenerGuias() {
        return guias;
    }

    public List<Guia> obtenerGuiasPorEstado(Estado estado) {
        List<Guia> resultado = new ArrayList<>();
        for (Guia guia : guias) {
            if (guia.getEstado().equals(estado)) {
                resultado.add(guia);
            }
        }
        return resultado;
    }

    public List<Guia> obtenerGuiasPorDestinatario(String destinatario) {
        List<Guia> resultado = new ArrayList<>();
        for (Guia guia : guias) {
            if (guia.getDestinatario().getNombreCompania().equals(destinatario)) {
                resultado.add(guia);
            }
        }
        return resultado;
    }
}
