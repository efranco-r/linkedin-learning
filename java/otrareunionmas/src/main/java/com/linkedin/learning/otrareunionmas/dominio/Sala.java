package com.linkedin.learning.otrareunionmas.dominio;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SALA")
public class Sala {
    @Id
    @Column(name = "ID", length = 20)
    private String id;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "CAPACIDAD")
    private int capacidad;

    @OneToMany(mappedBy = "sala")
    private List<Reunion> reuniones;

    public Sala() {
        super();
    }

    public Sala(String id, String descripcion, int capacidad) {
        this.id = id;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
