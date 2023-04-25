package com.linkedin.learning.otrareunionmas.dao.imp;

import com.linkedin.learning.otrareunionmas.dao.IDao;
import com.linkedin.learning.otrareunionmas.utils.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public abstract class AbstractDao<T> implements IDao<T> {
    private EntityManager entityManager = EntityManagerUtil.getEntityManager();;

    private Class<T> clazz;

    public Optional<T> get(int id) {
        //TODO Implement me please!
        return Optional.ofNullable(entityManager.find(clazz, id));
    }

    public List<T> getAll() {
        String qlString = "FROM " + clazz.getName();
        Query query = entityManager.createQuery(qlString);

        return query.getResultList();
    }

    public void save(T type) {
        executeInsideTransaction(entityManager -> entityManager.persist(type));
    }

    public void update(T type) {
        executeInsideTransaction(entityManager -> entityManager.merge(type));
    }

    public void delete(T type) {
        executeInsideTransaction(entityManager -> entityManager.remove(type));
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
