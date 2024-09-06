package org.empresa.application.interfaces;

import java.util.List;

import org.empresa.domain.Entities.Guia;

public interface IUserInterface {
    void displayMenu();
    int getUserOption();
    Guia getGuiaFromUser();
    String getEstadoFromUser();
    String getEmpresaDestinatarioFromUser();
    void saveGuia(Guia guia);
    void displayGuias(List<Guia> guias);
    void exit();
}
