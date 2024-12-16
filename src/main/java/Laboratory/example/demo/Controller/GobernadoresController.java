package Laboratory.example.demo.Controller;

import Laboratory.example.demo.model.Gobernadores;
import Laboratory.example.demo.model.Municipios;
import Laboratory.example.demo.model.Personas;
import Laboratory.example.demo.service.GobernadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gobernadores")
public class GobernadoresController {

    @Autowired
    private GobernadoresService gobernadoresService;

    @PostMapping
    public Gobernadores createGobernador(@RequestBody Gobernadores gobernador) {
        return gobernadoresService.saveGobernador(gobernador);
    }

    @GetMapping("/persona/{idPersona}")
    public Gobernadores getGobernadorByPersona(@PathVariable Personas idPersona) {
        return gobernadoresService.getGobernadorByPersona(idPersona);
    }

    @GetMapping("/municipio/{idMunicipio}")
    public List<Gobernadores> getGobernadoresByMunicipio(@PathVariable Municipios idMunicipio) {
        return gobernadoresService.getGobernadoresByMunicipio(idMunicipio);
    }
}