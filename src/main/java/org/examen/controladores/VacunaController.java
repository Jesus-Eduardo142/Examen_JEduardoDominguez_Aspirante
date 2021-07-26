package org.examen.controladores;

import java.util.List;
import org.examen.entidades.Vacuna;
import org.examen.exception.ResponseException;
import org.examen.exception.ServerErrors;
import org.examen.repositorios.VacunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eduardo
 */
@RestController
@RequestMapping("/api")
public class VacunaController {
    
    @Autowired
    private VacunaRepository repository;
    
    @GetMapping("/vacunas")
    public List<Vacuna> all() {
        return repository.findAll();
    }
    
    @GetMapping("/vacunas/{id}")
    public Vacuna one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseException(ServerErrors.VACUNA_NOT_FOUND.toString()));
    }
    
    @PostMapping("/vacunas")
    public Vacuna add(@RequestBody Vacuna newVacuna) {
        return repository.save(newVacuna);
    }
    
    @PutMapping("/vacunas/{id}")
    public Vacuna replace(@RequestBody Vacuna newVacuna, @PathVariable Long id) {
        return repository.findById(id)
            .map(v -> {
              v.setFecha(newVacuna.getFecha());
              v.setObservacion(newVacuna.getObservacion());
              return repository.save(v);
            })
            .orElseThrow(() -> new ResponseException(ServerErrors.VACUNA_NOT_FOUND.toString()));
    }
    
    @DeleteMapping("/vacunas/{id}")
    public Vacuna delete(@PathVariable Long id) {
        Vacuna vacuna = repository.findById(id)
                .orElseThrow(() -> new ResponseException(ServerErrors.VACUNA_NOT_FOUND.toString()));
        repository.delete(vacuna);
        return vacuna;
    }   
    
}
