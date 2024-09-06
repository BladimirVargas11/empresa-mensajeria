package org.empresa.infraestructure.Extensions;


import org.empresa.domain.Entities.Guia;
import org.empresa.domain.Ports.IRepositoryGeneric;
import org.empresa.domain.Services.GuiaService;
import org.empresa.infraestructure.Adapters.RepositoryGeneric;
import org.springframework.context.annotation.Bean;

public class AppConfig {
     @Bean
    public IRepositoryGeneric<Guia> guiaRepository() {
        return new RepositoryGeneric<>(Guia.class);
    }

    @Bean
    public GuiaService guiaService(IRepositoryGeneric<Guia> guiaRepository) {
        return new GuiaService(guiaRepository);
    }
}
