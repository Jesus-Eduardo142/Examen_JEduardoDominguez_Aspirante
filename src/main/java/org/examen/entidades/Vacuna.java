package org.examen.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Eduardo
 */
@Entity
@Table(name = "vacunas")
public class Vacuna implements Serializable {
    
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(strategy = "increment", name = "increment")
    private Long id;
    
    private String fecha;
    
    private String Observacion;
    
    @JsonIgnoreProperties({"vacunas","hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoVacuna tipo;
    
    @JsonIgnoreProperties({"vacunas","hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Veterinario veterinario;
    
    @JsonIgnoreProperties({"vacunasMascotas","propietario","hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Mascota mascota;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public TipoVacuna getTipo() {
        return tipo;
    }

    public void setTipo(TipoVacuna tipo) {
        this.tipo = tipo;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    
    
}
