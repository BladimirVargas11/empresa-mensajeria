package org.empresa.domain.Ports.Services;

import java.util.Optional;

import org.empresa.domain.Entities.Empresa;

public interface IEmpresaService {
    void createEmpresa(Empresa empresa);

    Optional<Empresa> findEmpresaById(Long id);

    Empresa updateEmpresa(Empresa empresa);

    void deleteEmpresaById(Long id);

    Iterable<Empresa> findAllEmpresas();
}
