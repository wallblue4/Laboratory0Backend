package Laboratory.example.demo.Controller;


import Laboratory.example.demo.model.Personas;
import Laboratory.example.demo.model.Posesiones;
import Laboratory.example.demo.model.Viviendas;
import Laboratory.example.demo.service.PosesionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posesiones")
public class PosesionesController {

    @Autowired
    private PosesionesService posesionesService;

    @PostMapping
    public Posesiones createPosesion(@RequestBody Posesiones posesion) {
        return posesionesService.savePosesion(posesion);
    }

    @GetMapping("/persona/{idPersona}")
    public List<Posesiones> getPosesionesByPersona(@PathVariable Personas idPersona) {
        return posesionesService.getPosesionesByPersona(idPersona);
    }

    @GetMapping("/vivienda/{idVivienda}")
    public List<Posesiones> getPosesionesByVivienda(@PathVariable Viviendas idVivienda) {
        return posesionesService.getPosesionesByVivienda(idVivienda);
    }

    @GetMapping("/count")
    public long countPosesiones() {
        return posesionesService.countPosesiones();
    }
}
