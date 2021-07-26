package org.examen.controladores;

import java.util.List;
import org.examen.entidades.Mascota;
import org.examen.exception.ResponseException;
import org.examen.exception.ServerErrors;
import org.examen.repositorios.MascotaRepository;
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
public class MascotaController {
    
    @Autowired
    private MascotaRepository repository;
    
    @GetMapping("/mascotas")
    public List<Mascota> all() {
        return repository.findAll();
    }
    
    @GetMapping("/mascotas/{id}")
    public Mascota one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseException(ServerErrors.MASCOTA_NOT_FOUND.toString()));
    }
    
    @PostMapping("/mascotas")
    public Mascota add(@RequestBody Mascota newMascota) {
        return repository.save(newMascota);
    }
    
    @PutMapping("/mascotas/{id}")
    public Mascota replace(@RequestBody Mascota newMascota, @PathVariable Long id) {
        return repository.findById(id)
            .map(m -> {
              m.setNombre(newMascota.getNombre());
              m.setDescripcion(newMascota.getDescripcion());
              m.setFechaNacimiento(newMascota.getFechaNacimiento());
              m.setEdad(newMascota.getEdad());
              m.setSexo(newMascota.getSexo());
              return repository.save(m);
            })
            .orElseThrow(() -> new ResponseException(ServerErrors.MASCOTA_NOT_FOUND.toString()));
    }
    
    @DeleteMapping("/mascotas/{id}")
    public Mascota delete(@PathVariable Long id) {
        Mascota mascota = repository.findById(id)
                .orElseThrow(() -> new ResponseException(ServerErrors.MASCOTA_NOT_FOUND.toString()));
        repository.delete(mascota);
        return mascota;
    }   
}
