package Laboratory.example.demo.Controller;


import Laboratory.example.demo.model.Cdf;
import Laboratory.example.demo.model.Personas;
import Laboratory.example.demo.service.CdfService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cdf")
@CrossOrigin(origins = "*")
@Tag(name = "CDF", description = "Controlador para la gestión de CDF (Centros de Formación)")
public class CdfController {

    @Autowired
    private CdfService cdfService;

    @Operation(summary = "Crear CDF",
            description = "Crea un nuevo Centro de Formación (CDF) y lo guarda en la base de datos.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "CDF creado con éxito.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cdf.class))),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida.",
                            content = @Content(schema = @Schema(ref = "#/components/schemas/Error")))
            })
    @PostMapping
    public ResponseEntity<Cdf> createCdf(@Valid @RequestBody Cdf cdf) {
        Cdf createdCdf = cdfService.saveCdf(cdf);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCdf);
    }

    @Operation(summary = "Obtener CDF por Persona",
            description = "Recupera una lista de Centros de Formación (CDF) asociados a una persona específica.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de CDF obtenida con éxito.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cdf.class))),
                    @ApiResponse(responseCode = "404", description = "Persona no encontrada.",
                            content = @Content(schema = @Schema(ref = "#/components/schemas/Error")))
            })
    @GetMapping("/persona/{idPersona}")
    public ResponseEntity<List<Cdf>> getCdfByPersona(@PathVariable Long idPersona) {
        List<Cdf> cdfs = cdfService.getCdfByPersona(idPersona);
        return ResponseEntity.ok(cdfs);
    }

    @Operation(summary = "Contar CDF",
            description = "Obtiene el número total de Centros de Formación (CDF) registrados en el sistema.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cantidad de CDF contada con éxito.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class)))
            })
    @GetMapping("/count")
    public ResponseEntity<Long> countCdf() {
        long count = cdfService.countCdf();
        return ResponseEntity.ok(count);
    }
}
