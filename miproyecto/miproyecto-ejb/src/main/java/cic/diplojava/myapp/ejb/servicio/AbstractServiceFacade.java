package cic.diplojava.myapp.ejb.servicio;

import jakarta.persistence.EntityManager;

public abstract class AbstractServiceFacade<T> {

    private Class<T> claseEntidad;

    public AbstractServiceFacade(Class<T> claseEntidad) {
        this.claseEntidad = claseEntidad;
    }

    public T crear(T entidad){
        EntityManager entityManager = getEntityManager();
        entityManager.persist(entidad);
        return entidad;
    }

    public T actualizar(T entidad){
        T entcopia;
        if(entidad!=null){
            entcopia=getEntityManager().merge(entidad);
            return entcopia;
        }
        return null;
    }

    public void borrar(T entidad){
        getEntityManager().remove(getEntityManager().merge(entidad));
    }

    protected abstract EntityManager getEntityManager();

}
