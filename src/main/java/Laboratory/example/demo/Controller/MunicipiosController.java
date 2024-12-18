package Laboratory.example.demo.Controller;


import Laboratory.example.demo.DTO.MunicipioDTO;
import Laboratory.example.demo.model.Municipios;
import Laboratory.example.demo.service.MunicipiosService;
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
@RequestMapping("/api/municipios")
@CrossOrigin(origins = "*")
@Tag(name = "Municipios", description = "Controlador para la gestión de municipios")
public class MunicipiosController {

    @Autowired
    private MunicipiosService municipiosService;

    @Operation(summary = "Crear Municipio",
            description = "Crea un nuevo municipio y lo guarda en la base de datos.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Municipio creado con éxito.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Municipios.class))),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida.",
                            content = @Content(schema = @Schema(ref = "#/components/schemas/Error")))
            })
    @PostMapping
    public ResponseEntity<Municipios> createMunicipio(@Valid @RequestBody Municipios municipio) {
        Municipios createdMunicipio = municipiosService.saveMunicipio(municipio);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMunicipio);
    }

    @Operation(summary = "Obtener Municipio por ID",
            description = "Recupera los detalles de un municipio específico por su ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Municipio encontrado con éxito.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MunicipioDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Municipio no encontrado.",
                            content = @Content(schema = @Schema(ref = "#/components/schemas/Error")))
            })
    @GetMapping("/{id}")
    public ResponseEntity<MunicipioDTO> getMunicipioById(@PathVariable Long id) {
        Municipios municipio = municipiosService.getMunicipioById(id);
        return municipio != null ? ResponseEntity.ok(new MunicipioDTO(municipio)) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Obtener Municipio por Nombre",
            description = "Recupera los detalles de un municipio específico filtrado por nombre.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Municipio encontrado con éxito.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Municipios.class))),
                    @ApiResponse(responseCode = "404", description = "Municipio no encontrado.",
                            content = @Content(schema = @Schema(ref = "#/components/schemas/Error")))
            })
    @GetMapping("/nombre")
    public ResponseEntity<Municipios> getMunicipioByNombre(@RequestParam String nombre) {
        Municipios municipio = municipiosService.getMunicipioByNombre(nombre);
        return municipio != null ? ResponseEntity.ok(municipio) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Obtener Todos los Municipios Ordenados",
            description = "Recupera una lista de todos los municipios ordenados alfabéticamente.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de municipios obtenida con éxito.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Municipios.class)))
            })
    @GetMapping("/ordenados")
    public ResponseEntity<List<Municipios>> getAllMunicipiosOrdenados() {
        List<Municipios> municipios = municipiosService.getAllMunicipiosOrdenados();
        return ResponseEntity.ok(municipios);
    }
}

