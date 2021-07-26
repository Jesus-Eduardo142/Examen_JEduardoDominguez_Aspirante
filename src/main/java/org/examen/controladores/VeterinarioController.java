package org.examen.controladores;

import java.util.List;
import org.examen.entidades.Veterinario;
import org.examen.exception.ResponseException;
import org.examen.exception.ServerErrors;
import org.examen.repositorios.VeterinarioRepository;
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
public class VeterinarioController {

    @Autowired
    private VeterinarioRepository repository;

    @GetMapping("/veterinarios")
    public List<Veterinario> all() {
        return repository.findAll();
    }

    @GetMapping("/veterinarios/{id}")
    public Veterinario one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseException(ServerErrors.VETERINARIO_NOT_FOUND.toString()));
    }

    @PostMapping("/veterinarios")
    public Veterinario add(@RequestBody Veterinario newVeterinario) {
        return repository.save(newVeterinario);
    }

    @PutMapping("/veterinarios/{id}")
    public Veterinario replace(@RequestBody Veterinario newVeterinario, @PathVariable Long id) {
        return repository.findById(id)
                .map(vet -> {
                    vet.setNombre(newVeterinario.getNombre());
                    vet.setApellidoPaterno(newVeterinario.getApellidoPaterno());
                    vet.setApellidoMaterno(newVeterinario.getApellidoMaterno());
                    vet.setCorreoElectronico(newVeterinario.getCorreoElectronico());
                    vet.setDireccion(newVeterinario.getDireccion());
                    vet.setTelefono(newVeterinario.getNombre());
                    return repository.save(vet);
                })
                .orElseThrow(() -> new ResponseException(ServerErrors.VETERINARIO_NOT_FOUND.toString()));
    }

    @DeleteMapping("/veterinarios/{id}")
    public Veterinario delete(@PathVariable Long id) {
        Veterinario veterinario = repository.findById(id)
                .orElseThrow(() -> new ResponseException(ServerErrors.VETERINARIO_NOT_FOUND.toString()));
        repository.delete(veterinario);
        return veterinario;
    }

}
