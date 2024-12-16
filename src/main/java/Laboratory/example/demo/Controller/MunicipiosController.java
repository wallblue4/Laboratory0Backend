package Laboratory.example.demo.Controller;


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

    @GetMapping("/{id}")
    public ResponseEntity<Municipios> getMunicipioById(@PathVariable Long id) {
        Municipios municipio = municipiosService.getMunicipioById(id);
        return municipio != null ? ResponseEntity.ok(municipio) : ResponseEntity.notFound().build();
    }

    @GetMapping("/nombre")
    public Municipios getMunicipioByNombre(@RequestParam String nombre) {
        return municipiosService.getMunicipioByNombre(nombre);
    }

    @GetMapping("/ordenados")
    public List<Municipios> getAllMunicipiosOrdenados() {
        return municipiosService.getAllMunicipiosOrdenados();
    }
}
