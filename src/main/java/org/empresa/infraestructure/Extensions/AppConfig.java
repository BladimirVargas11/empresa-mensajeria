package org.empresa.infraestructure.Extensions;

import org.empresa.domain.Entities.Empresa;
import org.empresa.domain.Ports.IRepositoryGeneric;
import org.empresa.domain.Services.EmpresaService;
import org.empresa.infraestructure.Adapters.RepositoryGeneric;
import org.springframework.context.annotation.Bean;

public class AppConfig {
    @Bean
    public IRepositoryGeneric<Empresa> empresaRepository() {
        return new RepositoryGeneric<>(Empresa.class);
    }

    @Bean
    public EmpresaService empresaService(IRepositoryGeneric<Empresa> empresaRepository) {
        return new EmpresaService(empresaRepository);
    }
}
