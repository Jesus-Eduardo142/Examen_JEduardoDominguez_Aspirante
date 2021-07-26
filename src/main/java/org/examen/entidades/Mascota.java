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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Eduardo
 */
@Entity
@Table(name = "mascotas")
public class Mascota implements Serializable {
    
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(strategy = "increment", name = "increment")
    private Long id;
    
    @Column(length = 50)
    private String nombre;
    
    private String fechaNacimiento; 
    
    @Column(length = 25)
    private String sexo;
    
    private Integer edad;
    
    private String descripcion;  
    
    @JsonIgnoreProperties({"mascotas","hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Propietario propietario;
    
    @JsonIgnoreProperties({"vacunas","hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoMascota tipo;
    
    @JsonIgnoreProperties({"vacunas","hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private RazaMascota raza;
    
    @JsonIgnoreProperties({"mascota", "hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mascota", cascade = CascadeType.ALL)
    private List<Vacuna> vacunasMascotas;

    public Mascota() {
        this.vacunasMascotas = new ArrayList<>();
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public TipoMascota getTipo() {
        return tipo;
    }

    public void setTipo(TipoMascota tipo) {
        this.tipo = tipo;
    }

    public RazaMascota getRaza() {
        return raza;
    }

    public void setRaza(RazaMascota raza) {
        this.raza = raza;
    }

    public List<Vacuna> getVacunasMascotas() {
        return vacunasMascotas;
    }

    public void setVacunasMascotas(List<Vacuna> vacunasMascotas) {
        this.vacunasMascotas = vacunasMascotas;
    }
    
    
}