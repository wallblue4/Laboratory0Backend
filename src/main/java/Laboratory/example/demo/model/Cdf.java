package Laboratory.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "cdf")
public class Cdf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The person ID cannot be null")
    @Min(value = 1, message = "ID must be greater than or equal to 1")
    @Max(value = 9999999999L, message = "ID must be less than or equal to 9999999999")
    @JoinColumn(name = "id_persona")
    private Long persona;

    @ManyToOne
    @JoinColumn(name = "id_vivienda", nullable = false)
    private Viviendas vivienda;

    @NotBlank(message = "The registration date cannot be blank")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "The registration date must follow the format YYYY-MM-DD")
    private String fecha_registro;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPersona() { return persona; }
    public void setPersona(Personas persona) { this.persona = persona.getId(); }

    public Viviendas getVivienda() { return vivienda; }
    public void setVivienda(Viviendas vivienda) { this.vivienda = vivienda; }

    public String getFecha_registro() { return fecha_registro; }
    public void setFecha_registro(String fecha_registro) { this.fecha_registro = fecha_registro; }
}
