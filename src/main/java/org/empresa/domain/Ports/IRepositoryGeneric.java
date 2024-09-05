package org.empresa.domain.Ports;

import java.util.Optional;

import org.empresa.domain.Entities.BaseEntity;

public interface IRepositoryGeneric<T extends BaseEntity<?>> {

    void save(T entity);

    Optional<T> findById(Object id);

    void update(T entity);

    void deleteById(Object id);

    Iterable<T> findAll();

}
