package Laboratory.example.demo.Controller;


import Laboratory.example.demo.DTO.MunicipioDTO;
import Laboratory.example.demo.model.Municipios;
import Laboratory.example.demo.service.MunicipiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/municipios")
public class MunicipiosController {

    @Autowired
    private MunicipiosService municipiosService;

    @PostMapping
    public Municipios createMunicipio(@RequestBody Municipios municipio) {
        return municipiosService.saveMunicipio(municipio);
    }

    @GetMapping
    public ResponseEntity<List<MunicipioDTO>> getAllMunicipios() {
        List<Municipios> municipios = municipiosService.getAllMunicipios();
        List<MunicipioDTO> municipiosDTO = municipios.stream()
                .map(MunicipioDTO::new)
                .toList();
        return ResponseEntity.ok(municipiosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MunicipioDTO> getMunicipioById(@PathVariable Long id) {
        Municipios municipio = municipiosService.getMunicipioById(id);
        return municipio != null ? ResponseEntity.ok(new MunicipioDTO(municipio)) : ResponseEntity.notFound().build();
    }


    @GetMapping("/nombre")
    public Municipios getMunicipioByNombre(@RequestParam String nombre) {
        return municipiosService.getMunicipioByNombre(nombre);
    }

    @GetMapping("/ordenados")
    public List<Municipios> getAllMunicipiosOrdenados() {
        return municipiosService.getAllMunicipiosOrdenados();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePosesiones(@PathVariable Long id) {
        municipiosService.deleteMunicipio(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Municipios> updateMunicipio(@PathVariable Long id, @RequestBody Municipios updatedMunicipio) {
        Municipios result = municipiosService.updateMunicipio(id, updatedMunicipio);
        if (result == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 si no se encuentra el municipio
        }
        return ResponseEntity.ok(result); // Retorna 200 con el municipio actualizado
    }
}
