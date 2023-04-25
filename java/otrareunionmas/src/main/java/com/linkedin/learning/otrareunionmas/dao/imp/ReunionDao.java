package com.linkedin.learning.otrareunionmas.dao.imp;

import com.linkedin.learning.otrareunionmas.dominio.Persona;
import com.linkedin.learning.otrareunionmas.dominio.Reunion;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ReunionDao extends AbstractDao<Reunion>{
    public ReunionDao() {
        setClazz(Reunion.class);
    }
    public Reunion proximaReunion() {
        String qlString = "FROM " + Reunion.class.getName() + " WHERE FECHA > now() ORDER BY FECHA ";
        Query query = getEntityManager().createQuery(qlString).setMaxResults(1);

        return (Reunion) query.getSingleResult();
    }

    public List<Reunion> reunionesMannana() {
        String qlString = "FROM " + Reunion.class.getName() + " WHERE FECHA BETWEEN ?1 AND ?2";
        Query query = getEntityManager().createQuery(qlString);

        LocalDate mannana = LocalDate.now().plus(1, ChronoUnit.DAYS);

        query.setParameter(1, mannana.atStartOfDay());
        query.setParameter(2, mannana.plus(1, ChronoUnit.DAYS).atStartOfDay());

        return query.getResultList();
    }

    public List<Reunion> reunionesParticipante(String numEmple) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Reunion> criteriaQuery = cb.createQuery(Reunion.class);

        Root<Persona> fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.where(cb.equal(fromPersona.get("numeroEmpleado"), numEmple));

        Join<Persona, Reunion> joinReunion = fromPersona.join("reuniones", JoinType.INNER);

        CriteriaQuery<Reunion> cq = criteriaQuery.multiselect(joinReunion);
        TypedQuery<Reunion> query = getEntityManager().createQuery(cq);
        return query.getResultList();
    }
}
