package com.br.appback.utils;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.Produces;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EntityManager {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("appbanco");

    @Produces
    @RequestScoped
    protected static jakarta.persistence.EntityManager getEntityManager() {return FACTORY.createEntityManager();}

    public EntityManager() {getEntityManager().getTransaction().begin();}


}
