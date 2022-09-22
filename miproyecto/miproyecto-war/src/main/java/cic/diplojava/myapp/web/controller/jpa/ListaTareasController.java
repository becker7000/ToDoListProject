package cic.diplojava.myapp.web.controller.jpa;

import cic.diplojava.myapp.ejb.modelo.TareaEntity;
import cic.diplojava.myapp.ejb.servicio.TareasServiceLocal;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value ="listaTareasController")
@RequestScoped
public class ListaTareasController {

    private static final Logger logger=
            Logger.getLogger(ListaTareasController.class.getName());

    private TareaEntity tarea;
    private List<TareaEntity> tareasLista;

    @Inject
    private TareasServiceLocal tareasService;

    @PostConstruct
    public void iniciarDatos(){
        tareasLista = tareasService.listar();
        tarea= new TareaEntity();
        for(TareaEntity tarea : tareasLista){
            logger.log(Level.INFO,"Actividad: {0}",tarea.getActividad());
            logger.log(Level.INFO,"Descripcion: {0}",tarea.getDescripcion());
        }
    }

    public TareaEntity getTarea() {
        return tarea;
    }

    public void setTarea(TareaEntity tarea) {
        this.tarea = tarea;
    }

    public TareasServiceLocal getTareasService() {
        return tareasService;
    }

    public void setTareasService(TareasServiceLocal tareasService) {
        this.tareasService = tareasService;
    }

    public List<TareaEntity> getTareasLista() {
        return tareasLista;
    }

    public void setTareasLista(List<TareaEntity> tareasLista) {
        this.tareasLista = tareasLista;
    }

    public void agregarTarea(){
        logger.log(Level.INFO,"Tarea agregada correctamente");
        tareasService.crear(tarea);
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Tarea guardada","Tarea guardada");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("altaTareas",mensaje);
    }

    public void borrarTarea(){
        tareasService.borrar(tarea);
        iniciarDatos();
        FacesContext.getCurrentInstance().addMessage(
                null,new FacesMessage("Registro de empleado eliminado")
        );
        PrimeFaces.current().ajax().update(":formTareas:mensajes",
                "formTareas:tablaTareas");
    }

}
