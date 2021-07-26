package org.examen.controladores;

import java.util.List;
import org.examen.entidades.TipoVacuna;
import org.examen.exception.ResponseException;
import org.examen.exception.ServerErrors;
import org.examen.repositorios.TipoVacunaRepository;
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
public class TipoVacunaController {
    
    @Autowired
    private TipoVacunaRepository repository;
    
    @GetMapping("/Tvacunas")
    public List<TipoVacuna> all() {
        return repository.findAll();
    }
    
    @GetMapping("/Tvacunas/{id}")
    public TipoVacuna one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseException(ServerErrors.TIPO_VACUNA_NOT_FOUND.toString()));
    }
    
    @PostMapping("/Tvacunas")
    public TipoVacuna add(@RequestBody TipoVacuna newTipoVacuna) {
        return repository.save(newTipoVacuna);
    }
    
    @PutMapping("/Tvacunas/{id}")
    public TipoVacuna replace(@RequestBody TipoVacuna newTipoVacuna, @PathVariable Long id) {
        return repository.findById(id)
            .map(tv -> {
              tv.setNombre(newTipoVacuna.getNombre());
              tv.setDescripcion(newTipoVacuna.getDescripcion());
              tv.setDosis(newTipoVacuna.getDosis());
              return repository.save(tv);
            })
            .orElseThrow(() -> new ResponseException(ServerErrors.TIPO_VACUNA_NOT_FOUND.toString()));
    }
    
    @DeleteMapping("/Tvacunas/{id}")
    public TipoVacuna delete(@PathVariable Long id) {
        TipoVacuna Tvacunas = repository.findById(id)
                .orElseThrow(() -> new ResponseException(ServerErrors.TIPO_VACUNA_NOT_FOUND.toString()));
        repository.delete(Tvacunas);
        return Tvacunas;
    }   
    
}
