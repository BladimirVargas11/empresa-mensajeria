package org.empresa.domain;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Guia> guias = new ArrayList<>();

    public void registrarGuia(Guia nuevaGuia) {
        guias.add(nuevaGuia);
    }

    public List<Guia> consultarGuiasPorEstado(Estado estado) {
        List<Guia> resultado = new ArrayList<>();
        for (Guia guia : guias) {
            if (guia.getEstado() == estado) {
                resultado.add(guia);
            }
        }
        return resultado;
    }

    public List<Guia> consultarGuiasPorDestinatario(String destinatario) {
        List<Guia> resultado = new ArrayList<>();
        for (Guia guia : guias) {
            if (guia.getDestinatario().getNombreCompania().equals(destinatario)) {
                resultado.add(guia);
            }
        }
        return resultado;
    }
}
