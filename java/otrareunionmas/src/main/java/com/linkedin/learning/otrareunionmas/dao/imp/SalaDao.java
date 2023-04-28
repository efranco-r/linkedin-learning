package com.linkedin.learning.otrareunionmas.dao.imp;

import com.linkedin.learning.otrareunionmas.dominio.Sala;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class SalaDao extends AbstractDao<Sala>{
    private static final String CAPACIDAD = "capacidad";
    public SalaDao() {
        setClazz(Sala.class);
    }

    public List<Sala> findSalasParaNViejo(int capacidadMinima) {
        String qlString = "FROM " + Sala.class.getName() + " WHERE CAPACIDAD >= ?1";

        Query query = getEntityManager().createQuery(qlString);
        query.setParameter(1, capacidadMinima);
        return query.getResultList();
    }

    public List<Sala> findSalasParaN(int num) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Sala> criteriaQuery = cb.createQuery(Sala.class);
        Root<Sala> root = criteriaQuery.from(Sala.class);
        criteriaQuery.select(root).where(cb.ge(root.get(CAPACIDAD), num));
        Query query = getEntityManager().createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<Sala> findSalasAdecuadasParaN(int num) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Sala> criteriaQuery = cb.createQuery(Sala.class);
        Root<Sala> root = criteriaQuery.from(Sala.class);

        Predicate capacidadMinima = cb.ge(root.get(CAPACIDAD), num);
        Predicate capacidadMaxima = cb.lessThanOrEqualTo(root.get(CAPACIDAD), num * 2);
        Predicate rangoCapacidad = cb.and(capacidadMinima, capacidadMaxima);

        criteriaQuery.select(root).where(rangoCapacidad);
        Query query = getEntityManager().createQuery(criteriaQuery);
        return query.getResultList();
    }
}
