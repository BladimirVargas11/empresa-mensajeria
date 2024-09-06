package org.empresa.domain.Services;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import org.empresa.domain.Entities.Estado;
import org.empresa.domain.Entities.Guia;
import org.empresa.domain.Ports.IRepositoryGeneric;
import org.empresa.domain.Ports.Services.IGuiaService;

public class GuiaService implements IGuiaService {

    private final IRepositoryGeneric<Guia> guiaRepository;

    public GuiaService(IRepositoryGeneric<Guia> guiaRepository) {
        this.guiaRepository = guiaRepository;
    }

    @Override
    public Guia crearGuia(Guia guia) {
        guiaRepository.save(guia);
        return guia;
    }

    @Override
    public Guia obtenerGuiaPorNumero(int numeroGuia) {
        Optional<Guia> guia = guiaRepository.findById(numeroGuia);
        return guia.orElse(null);
    }

    @Override
    public List<Guia> obtenerTodasLasGuias() {
        return (List<Guia>) guiaRepository.findAll();
    }

    @Override
    public Guia actualizarGuia(Guia guia) {
        Optional<Guia> existingGuia = guiaRepository.findById(guia.getNumeroGuia());
        if (existingGuia.isPresent()) {
            guiaRepository.update(guia);
            return guia;
        }
        return null;
    }

    @Override
    public boolean eliminarGuia(int numeroGuia) {
        Optional<Guia> guia = guiaRepository.findById(numeroGuia);
        if (guia.isPresent()) {
            guiaRepository.deleteById(numeroGuia);
            return true;
        }
        return false;
    }

    @Override
    public double calcularValorGuia(Guia guia) {
        return guia.calcularValor();
    }

    @Override
    public void cambiarEstadoGuia(int numeroGuia, String nuevoEstado) {
        Optional<Guia> guia = guiaRepository.findById(numeroGuia);
        if (guia.isPresent()) {
            Guia g = guia.get();
            g.cambiarEstado(Estado.valueOf(nuevoEstado));
            guiaRepository.update(g);
        }
    }

    @Override
    public List<Guia> obtenerGuiasPorEstado(String estado) {
        Iterable<Guia> todasLasGuiasIterable = guiaRepository.findAll();

        // Convertir Iterable a List para usar Stream
        List<Guia> todasLasGuias = new ArrayList<>();
        todasLasGuiasIterable.forEach(todasLasGuias::add);

        // Paso 2: Convertir el estado de String a Enum
        Estado estadoEnum = Estado.valueOf(estado);

        // Paso 3: Filtrar las guías por el estado proporcionado
        List<Guia> guiasFiltradas = todasLasGuias.stream()
                .filter(guia -> guia.getEstado().equals(estadoEnum))
                .collect(Collectors.toList());

        return guiasFiltradas;
    }

    @Override
    public List<Guia> obtenerGuiasPorNombreDestinatario(String nombreDestinatario) {
        return ((List<Guia>) guiaRepository.findAll())
                .stream()
                .filter(guia -> guia.getDestinatario().getNombreCompania().equalsIgnoreCase(nombreDestinatario))
                .collect(Collectors.toList());
    }
}
