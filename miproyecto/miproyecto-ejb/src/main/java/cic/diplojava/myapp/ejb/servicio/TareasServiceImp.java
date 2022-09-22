package cic.diplojava.myapp.ejb.servicio;

import cic.diplojava.myapp.ejb.modelo.TareaEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class TareasServiceImp extends AbstractServiceFacade<TareaEntity>
        implements TareasServiceLocal {

    @PersistenceContext(name = "tareasDS")
    private EntityManager entityManager;

    public TareasServiceImp() {
        super(TareaEntity.class);
    }

    @Override
    public List<TareaEntity> listar() {
        Query consulta =
                entityManager.createQuery("from TareaEntity",TareaEntity.class);
        return consulta.getResultList();
    }


    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
