package org.examen.repositorios;

import org.examen.entidades.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo
 */
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{
    
}
