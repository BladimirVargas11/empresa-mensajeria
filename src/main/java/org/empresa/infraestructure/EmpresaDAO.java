package org.empresa.infraestructure;
import org.empresa.domain.Empresa;
import org.empresa.domain.Estado;
import org.empresa.domain.Guia;

import java.util.List;

public class EmpresaDAO {
    private Empresa empresa;

    public EmpresaDAO(Empresa empresa) {
        this.empresa = empresa;
    }

    public void registrarGuia(Guia guia) {
        empresa.registrarGuia(guia);
    }

    public List<Guia> consultarGuiasPorEstado(Estado estado) {
        return empresa.consultarGuiasPorEstado(estado);
    }

    public List<Guia> consultarGuiasPorDestinatario(String destinatario) {
        return empresa.consultarGuiasPorDestinatario(destinatario);
    }
}
