package com.linkedin.learning.otrareunionmas.dominio;

import javax.persistence.*;

@Entity
@Table(name = "ACTA")
public class Acta {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CONTENIDO")
    private String contenido;

    @OneToOne
    @JoinColumn
    private Reunion reunion;

    public Acta() {
        super();
    }

    public Acta(String contenido, Reunion reunion) {
        this.contenido = contenido;
        this.reunion = reunion;
        getReunion().setActa(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Reunion getReunion() {
        return reunion;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    @Override
    public String toString() {
        return "Acta{" +
                "id=" + id +
                ", contenido='" + contenido +
                '}';
    }
}
