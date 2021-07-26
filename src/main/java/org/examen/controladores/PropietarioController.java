package org.examen.controladores;

import java.util.List;
import org.examen.entidades.Propietario;
import org.examen.exception.ResponseException;
import org.examen.exception.ServerErrors;
import org.examen.repositorios.PropietarioRepository;
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
public class PropietarioController {

    @Autowired
    private PropietarioRepository repository;

    @GetMapping("/propietarios")
    public List<Propietario> all() {
        return repository.findAll();
    }

    @GetMapping("/propietarios/{id}")
    public Propietario one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseException(ServerErrors.PROPIETARIO_NOT_FOUND.toString()));
    }

    @PostMapping("/propietarios")
    public Propietario add(@RequestBody Propietario newPropietario) {
        return repository.save(newPropietario);
    }

    @PutMapping("/propietarios/{id}")
    public Propietario replace(@RequestBody Propietario newPropietario, @PathVariable Long id) {
        return repository.findById(id)
                .map(p -> {
                    p.setNombre(newPropietario.getNombre());
                    p.setApellidoPaterno(newPropietario.getApellidoPaterno());
                    p.setApellidoMaterno(newPropietario.getApellidoMaterno());
                    p.setCorreoElectronico(newPropietario.getCorreoElectronico());
                    p.setDireccion(newPropietario.getDireccion());
                    p.setTelefono(newPropietario.getNombre());
                    return repository.save(p);
                })
                .orElseThrow(() -> new ResponseException(ServerErrors.PROPIETARIO_NOT_FOUND.toString()));
    }

    @DeleteMapping("/propietarios/{id}")
    public Propietario delete(@PathVariable Long id) {
        Propietario propietario = repository.findById(id)
                .orElseThrow(() -> new ResponseException(ServerErrors.PROPIETARIO_NOT_FOUND.toString()));
        repository.delete(propietario);
        return propietario;
    }

}
