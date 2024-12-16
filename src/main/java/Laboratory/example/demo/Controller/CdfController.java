package Laboratory.example.demo.Controller;


import Laboratory.example.demo.model.Cdf;
import Laboratory.example.demo.model.Personas;
import Laboratory.example.demo.service.CdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cdf")
public class CdfController {

    @Autowired
    private CdfService cdfService;

    @PostMapping
    public Cdf createCdf(@RequestBody Cdf cdf) {
        return cdfService.saveCdf(cdf);
    }

    @GetMapping("/persona/{idPersona}")
    public List<Cdf> getCdfByPersona(@PathVariable Long idPersona) {
        return cdfService.getCdfByPersona(idPersona);
    }

    @GetMapping("/count")
    public long countCdf() {
        return cdfService.countCdf();
    }
}
