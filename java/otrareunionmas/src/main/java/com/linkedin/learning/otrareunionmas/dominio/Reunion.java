package com.linkedin.learning.otrareunionmas.dominio;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "REUNION")
public class Reunion {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FECHA")
    private LocalDateTime fecha;
    @Column(name = "ASUNTO")
    private String asunto;
    @ManyToOne(fetch = FetchType.LAZY)
    private Sala sala;

    @OneToOne(mappedBy = "reunion")
    private Acta acta;

    @ManyToMany(mappedBy = "reuniones", cascade = CascadeType.ALL)
    private Set<Persona> participantes;

    public Reunion() {
        super();
        participantes = new HashSet<>();
    }

    public Reunion(Reunion reunion) {
        this.fecha = reunion.getFecha();
        this.asunto = reunion.getAsunto();
    }

    public Reunion(LocalDateTime fecha, String asunto) {
        this();
        this.fecha = fecha;
        this.asunto = asunto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Acta getActa() {
        return acta;
    }

    public void setActa(Acta acta) {
        this.acta = acta;
    }

    public Set<Persona> getParticipantes() {
        return participantes;
    }

    public void addParticipante(Persona participante) {
        participantes.add(participante);

        if (!participante.getReuniones().contains(this)) {
            participante.addReunion(this);
        }
    }

    @Override
    public String toString() {
        return "Reunion{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", asunto='" + asunto + '\'' +
                '}';
    }
}
