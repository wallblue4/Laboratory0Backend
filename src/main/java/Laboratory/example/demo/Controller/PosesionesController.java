package Laboratory.example.demo.Controller;


import Laboratory.example.demo.DTO.PosesionesDTO;
import Laboratory.example.demo.model.Personas;
import Laboratory.example.demo.model.Posesiones;
import Laboratory.example.demo.model.Viviendas;
import Laboratory.example.demo.service.PosesionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/posesiones")
public class PosesionesController {

    @Autowired
    private PosesionesService posesionesService;

    @PostMapping
    public Posesiones createPosesion(@RequestBody Posesiones posesion) {
        return posesionesService.savePosesion(posesion);
    }

    @GetMapping
    public ResponseEntity<List<PosesionesDTO>> getAllPosesiones() {
        List<Posesiones> posesiones = posesionesService.getAllPosesiones();
        List<PosesionesDTO> posesionesDTO = posesiones.stream()
                .map(PosesionesDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(posesionesDTO);
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
