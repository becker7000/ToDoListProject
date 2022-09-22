package cic.diplojava.myapp.ejb.modelo;

// Usando JPA
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name="tareas")
public class TareaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false) // Este dato no es opcional
    @Column(name="id") //Se asocia con su columna (paso opcional)
    private Integer id;

    @Basic(optional = true)
    @Size(max=45)
    @Column(name="actividad")
    private String actividad;


    @Basic(optional = true)
    @Size(max=100)
    @Column(name="descripcion")
    private String descripcion;

    public TareaEntity(){

    }

    public TareaEntity(Integer id, String actividad, String descripcion) {
        this.id = id;
        this.actividad = actividad;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    // Sobreescribimos el método equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TareaEntity that = (TareaEntity) o;
        return id.equals(that.id) && actividad.equals(that.actividad) && descripcion.equals(that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actividad, descripcion);
    }



}
