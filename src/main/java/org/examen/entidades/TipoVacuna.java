package org.examen.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Skylar
 */
@Entity
@Table(name = "tipos_vacunas")
public class TipoVacuna implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(strategy = "increment", name = "increment")
    private Long id;

    @Column(length = 50)
    private String nombre;

    private String descripcion;

    private Integer dosis;

    @JsonIgnoreProperties({"tipo","veterinario", "hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipo", cascade = CascadeType.ALL)
    private List<Vacuna> vacunas;

    public TipoVacuna() {
        this.vacunas = new ArrayList<>();
    }

    public TipoVacuna(Long id, String nombre, String descripcion, Integer dosis) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dosis = dosis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getDosis() {
        return dosis;
    }

    public void setDosis(Integer dosis) {
        this.dosis = dosis;
    }

}
