package org.empresa.infraestructure;
import java.util.List;

import org.empresa.domain.Entities.Empresa;
import org.empresa.domain.Entities.Estado;
import org.empresa.domain.Entities.Guia;

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
