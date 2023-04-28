package com.linkedin.learning.otrareunionmas.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SuppressWarnings("java:S125")
public class EntityManagerUtil {
    private EntityManagerUtil() {
        super();
    }

    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OtraReunionMas");
        return factory.createEntityManager();
    }

    /*
    public static void main(String[] args) {
        EntityManager manager = EntityManagerUtil.getEntityManager();
        System.out.println("EntityManager class ==> " + manager.getClass().getCanonicalName());
    }
    */
}
