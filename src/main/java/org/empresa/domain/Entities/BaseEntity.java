package org.empresa.domain.Entities;

import java.time.LocalDateTime;

public class BaseEntity<T> {

    private T id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private boolean eliminado;

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion() {
        this.fechaCreacion = LocalDateTime.now();
    }
    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion() {
        this.fechaModificacion = LocalDateTime.now();;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado() {
        this.eliminado = true;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
