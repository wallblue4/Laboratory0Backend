package Laboratory.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gobernadores", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_persona", "id_municipio"})})
public class Gobernadores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Personas persona;

    @ManyToOne
    @JoinColumn(name = "id_municipio")
    private Municipios municipio;

    private String fecha_registro;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Personas getPersona() { return persona; }
    public void setPersona(Personas persona) { this.persona = persona; }

    public Municipios getMunicipio() { return municipio; }
    public void setMunicipio(Municipios municipio) { this.municipio = municipio; }

    public String getFecha_registro() { return fecha_registro; }
    public void setFecha_registro(String fecha_registro) { this.fecha_registro = fecha_registro; }
}
