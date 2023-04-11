package com.br.appback.utils;

import jakarta.ejb.Stateless;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Produces;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
public class EntityManager {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("appbanco");

    @Produces
    protected static javax.persistence.EntityManager getEntityManager() {return FACTORY.createEntityManager();}

    public EntityManager() {getEntityManager();}

}
