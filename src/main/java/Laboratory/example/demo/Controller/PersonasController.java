package Laboratory.example.demo.Controller;


import Laboratory.example.demo.DTO.PersonaDTO;
import Laboratory.example.demo.model.Personas;
import Laboratory.example.demo.service.PersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonasController {

    @Autowired
    private PersonasService personasService;

    @PostMapping
    public Personas createPersona(@RequestBody Personas persona) {
        return personasService.savePersona(persona);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> getPersonaById(@PathVariable Long id) {
        Personas persona = personasService.getPersonaById(id);
        return persona != null ? ResponseEntity.ok(new PersonaDTO(persona)) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        personasService.deletePersona(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nombre")
    public List<Personas> getPersonasByNombre(@RequestParam String nombre) {
        return personasService.getPersonasByNombre(nombre);
    }

    @GetMapping("/sexo")
    public List<Personas> getPersonasBySexo(@RequestParam String sexo) {
        return personasService.getPersonasBySexo(sexo);
    }

    @GetMapping("/nacidas-despues")
    public List<Personas> getPersonasNacidasDespues(@RequestParam Date fecha) {
        return personasService.getPersonasNacidasDespues(fecha);
    }

    @GetMapping("/sin-vivienda")
    public List<Personas> getPersonasSinVivienda() {
        return personasService.getPersonasSinVivienda();
    }
}