package com.br.appback.utils;

public abstract class Managed<T> extends EntityManager {

    public Managed() {
    }

    protected void persist(Object entity) {
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
        getEntityManager().close();
    }

    protected T merge(T entity) {
        T t =  getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();
        getEntityManager().close();

        return t;
    }

    protected void remove(Object entity) {
        getEntityManager().remove(entity);
        getEntityManager().getTransaction().commit();
        getEntityManager().close();
    }
}
