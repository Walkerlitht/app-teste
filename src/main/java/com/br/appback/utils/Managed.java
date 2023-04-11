package com.br.appback.utils;

import jakarta.inject.Inject;

public abstract class Managed<T> {

    @Inject
    private jakarta.persistence.EntityManager entityManager;

    public Managed() {
    }

    private jakarta.persistence.EntityManager getEntityManager() {
        return this.entityManager;
    }

    protected void persist(Object entity) {
        getEntityManager().persist(entity);
    }

    protected T merge(T entity) {
        return getEntityManager().merge(entity);
    }

    protected void remove(Object entity) {
        getEntityManager().remove(entity);
    }
}
