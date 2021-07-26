package org.examen.controladores;

import java.util.List;
import org.examen.entidades.TipoMascota;
import org.examen.exception.ResponseException;
import org.examen.exception.ServerErrors;
import org.examen.repositorios.TipoMascotaRepository;
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
public class TipoMascotaController {
    
    @Autowired
    private TipoMascotaRepository repository;
    
    @GetMapping("/Tmascotas")
    public List<TipoMascota> all() {
        return repository.findAll();
    }
    
    @GetMapping("/Tmascotas/{id}")
    public TipoMascota one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseException(ServerErrors.TIPO_MASCOTA_NOT_FOUND.toString()));
    }
    
    @PostMapping("/Tmascotas")
    public TipoMascota add(@RequestBody TipoMascota newTipoMascota) {
        return repository.save(newTipoMascota);
    }
    
    @PutMapping("/Tmascotas/{id}")
    public TipoMascota replace(@RequestBody TipoMascota newTipoMascota, @PathVariable Long id) {
        return repository.findById(id)
            .map(tm -> {
              tm.setNombre(newTipoMascota.getNombre());
              return repository.save(tm);
            })
            .orElseThrow(() -> new ResponseException(ServerErrors.TIPO_MASCOTA_NOT_FOUND.toString()));
    }
    
    @DeleteMapping("/Tmascotas/{id}")
    public TipoMascota delete(@PathVariable Long id) {
        TipoMascota tMascota = repository.findById(id)
                .orElseThrow(() -> new ResponseException(ServerErrors.TIPO_MASCOTA_NOT_FOUND.toString()));
        repository.delete(tMascota);
        return tMascota;
    }
    
}
