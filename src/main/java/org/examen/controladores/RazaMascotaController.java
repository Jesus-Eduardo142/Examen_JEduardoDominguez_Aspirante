package org.examen.controladores;

import java.util.List;
import org.examen.entidades.RazaMascota;
import org.examen.exception.ResponseException;
import org.examen.exception.ServerErrors;
import org.examen.repositorios.RazaMascotaRepository;
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
public class RazaMascotaController {
    
    @Autowired
    private RazaMascotaRepository repository;
    
     @GetMapping("/razas")
    public List<RazaMascota> all() {
        return repository.findAll();
    }
    
    @GetMapping("/razas/{id}")
    public RazaMascota one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseException(ServerErrors.RAZA_MASCOTA_NOT_FOUND.toString()));
    }
    
    @PostMapping("/razas")
    public RazaMascota add(@RequestBody RazaMascota newRazaMascota) {
        return repository.save(newRazaMascota);
    }
    
    @PutMapping("/razas/{id}")
    public RazaMascota replace(@RequestBody RazaMascota newRazaMascota, @PathVariable Long id) {
        return repository.findById(id)
            .map(rm -> {
              rm.setNombre(newRazaMascota.getNombre());
              return repository.save(rm);
            })
            .orElseThrow(() -> new ResponseException(ServerErrors.RAZA_MASCOTA_NOT_FOUND.toString()));
    }
    
    @DeleteMapping("/razas/{id}")
    public RazaMascota delete(@PathVariable Long id) {
        RazaMascota rMascota = repository.findById(id)
                .orElseThrow(() -> new ResponseException(ServerErrors.MASCOTA_NOT_FOUND.toString()));
        repository.delete(rMascota);
        return rMascota;
    }   
    
}
