package Laboratory.example.demo.Controller;


import Laboratory.example.demo.DTO.ViviendaDTO;
import Laboratory.example.demo.model.Municipios;
import Laboratory.example.demo.model.Viviendas;
import Laboratory.example.demo.service.ViviendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viviendas")
public class ViviendasController {

    @Autowired
    private ViviendasService viviendasService;

    @PostMapping
    public Viviendas createVivienda(@RequestBody Viviendas vivienda) {
        return viviendasService.saveVivienda(vivienda);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViviendaDTO> getViviendaById(@PathVariable Long id) {
        Viviendas vivienda = viviendasService.getViviendaById(id);
        return vivienda != null ? ResponseEntity.ok(new ViviendaDTO(vivienda)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVivienda(@PathVariable Long id) {
        viviendasService.deleteVivienda(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/capacidad")
    public List<Viviendas> getViviendasByCapacidad(@RequestParam int capacidad) {
        return viviendasService.getViviendasByCapacidad(capacidad);
    }

    @GetMapping("/municipio/{idMunicipio}")
    public List<Viviendas> getViviendasByMunicipio(@PathVariable Municipios idMunicipio) {
        return viviendasService.getViviendasByMunicipio(idMunicipio);
    }

    @GetMapping("/niveles-mayor")
    public long countViviendasConNivelesMayor(@RequestParam int niveles) {
        return viviendasService.countViviendasConNivelesMayor(niveles);
    }
}
