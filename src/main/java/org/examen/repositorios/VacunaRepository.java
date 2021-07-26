package org.examen.repositorios;

import org.examen.entidades.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo
 */
public interface VacunaRepository extends JpaRepository<Vacuna, Long>{
    
}
