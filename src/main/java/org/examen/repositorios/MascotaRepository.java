package org.examen.repositorios;

import org.examen.entidades.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo
 */
public interface MascotaRepository extends JpaRepository<Mascota, Long>{
    
}
