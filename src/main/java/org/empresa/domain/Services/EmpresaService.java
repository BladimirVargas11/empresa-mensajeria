package org.empresa.domain.Services;

import java.util.List;
import java.util.Optional;

import org.empresa.domain.Entities.Empresa;
import org.empresa.domain.Entities.Estado;
import org.empresa.domain.Entities.Guia;
import org.empresa.domain.Ports.IRepositoryGeneric;
import org.empresa.domain.Ports.Services.IEmpresaService;

public class EmpresaService implements IEmpresaService {
 private final IRepositoryGeneric<Empresa> empresaRepository;

    public EmpresaService(IRepositoryGeneric<Empresa> empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public void createEmpresa(Empresa empresa) {
         empresaRepository.save(empresa);
    }

    @Override
    public Optional<Empresa> findEmpresaById(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public Empresa updateEmpresa(Empresa empresa) {
        if (empresaRepository.findById(empresa.getId()).isPresent()) {
             empresaRepository.update(empresa);
             return empresa;
        }
        throw new RuntimeException("Empresa not found");
    }

    @Override
    public void deleteEmpresaById(Long id) {
        empresaRepository.deleteById(id);
    }
    @Override
    public Iterable<Empresa> findAllEmpresas() {
        return empresaRepository.findAll();
    }

    public List<Guia> consultarGuiasPorEstado(Estado valueOf) {
        throw new UnsupportedOperationException("Unimplemented method 'consultarGuiasPorEstado'");
    }

    public List<Guia> consultarGuiasPorDestinatario(String destinatario) {
        throw new UnsupportedOperationException("Unimplemented method 'consultarGuiasPorDestinatario'");
    }
}
