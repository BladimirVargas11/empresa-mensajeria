package org.empresa.infraestructure.Adapters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.empresa.domain.Entities.BaseEntity;
import org.empresa.domain.Ports.IRepositoryGeneric;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RepositoryGeneric<T extends BaseEntity<?>> implements IRepositoryGeneric<T> {

    private final Map<Object, T> store = new HashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File file;

    public RepositoryGeneric(Class<T> entityType) {
        this.file = new File("src/main/resources/data/" + entityType.getSimpleName() + ".json");
        createFileIfNotExists();
        this.loadFromFile();
    }

    @Override
    public void save(T entity) {
        store.put(entity.getId(), entity);
        saveToFile();
    }

    @Override
    public Optional<T> findById(Object id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void update(T entity) {
        store.put(entity.getId(), entity);
        saveToFile();
    }

    @Override
    public void deleteById(Object id) {
        store.remove(id);
        saveToFile();
    }

    @Override
    public Iterable<T> findAll() {
        Iterable<T> iterable =  store.values();
        return iterable;
    }

    private void saveToFile() {
        try {
            Files.createDirectories(Paths.get(file.getParent()));
            objectMapper.writeValue(file, store.values());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save data to file", e);
        }
    }

    private void loadFromFile() {
        if (file.exists() && file.length() > 0) {
            try {
                // Leer los datos del archivo
                List<T> loadedData = objectMapper.readValue(file, new TypeReference<List<T>>() {});
                store.clear();
                for (T entity : loadedData) {
                    store.put(entity.getId(), entity);
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load data from file", e);
            }
        }
    }

    private void createFileIfNotExists() {
        try {
            if (!file.exists()) {
                // Crear el archivo vacío si no existe
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create file", e);
        }
    }
}
