package cic.diplojava.myapp.ejb.servicio;

import cic.diplojava.myapp.ejb.modelo.TareaEntity;
import jakarta.ejb.Local;

import java.util.List;

@Local // Interface local que va poder inyectarse dentro de wildfly
public interface TareasServiceLocal {

    List<TareaEntity> listar();
    public TareaEntity crear(TareaEntity entity);
    public TareaEntity actualizar(TareaEntity entity);
    public void borrar(TareaEntity entity);

}
