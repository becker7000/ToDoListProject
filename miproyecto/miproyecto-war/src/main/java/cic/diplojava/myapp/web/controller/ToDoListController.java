package cic.diplojava.myapp.web.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value="toDoListController")
@RequestScoped
public class ToDoListController {

    private static final Logger logger =
            Logger.getLogger(ToDoListController.class.getName());

    private String actividad; // Texto
    private String descripcion; // Text Area
    private String errorActividad;

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void agregarTarea(){
        logger.log(Level.INFO,"Actividad: "+actividad);
        logger.log(Level.INFO,"Descripción: "+descripcion);
        if(actividad.isEmpty()){
            FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "La actividad está vacía",
                            "Actividad vacía");
            FacesContext.getCurrentInstance().addMessage("formTareas:errorActividad",mensaje);
        }
        if(descripcion.isEmpty()){
            FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "La descripción está vacía",
                            "Descripción vacía");
            FacesContext.getCurrentInstance().addMessage("formTareas:errorDescripcion",mensaje);
        }
        if(!actividad.isEmpty() && !descripcion.isEmpty()){
            FacesMessage mensaje =
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Tarea agregada correctamente",
                            "Tarea agregada");
            FacesContext.getCurrentInstance().addMessage("formTareas:info",mensaje);
        }
    }

}
