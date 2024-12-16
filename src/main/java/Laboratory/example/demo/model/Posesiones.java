package Laboratory.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "posesiones", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_persona", "id_vivienda"})})
public class Posesiones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Personas persona;

    @ManyToOne
    @JoinColumn(name = "id_vivienda")
    private Viviendas vivienda;

    private String fecha_posesion;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Personas getPersona() { return persona; }
    public void setPersona(Personas persona) { this.persona = persona; }

    public Viviendas getVivienda() { return vivienda; }
    public void setVivienda(Viviendas vivienda) { this.vivienda = vivienda; }

    public String getFecha_posesion() { return fecha_posesion; }
    public void setFecha_posesion(String fecha_posesion) { this.fecha_posesion = fecha_posesion; }
}
