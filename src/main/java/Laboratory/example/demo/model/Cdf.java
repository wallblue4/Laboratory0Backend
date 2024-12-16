package Laboratory.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cdf")
public class Cdf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JoinColumn(name = "id_persona")
    private Long persona;

    @ManyToOne
    @JoinColumn(name = "id_cdf")
    private Cdf cdf;

    private String fecha_registro;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPersona() { return persona; }
    public void setPersona(Personas persona) { this.persona = persona.getId(); }

    public Cdf getCdf() { return cdf; }
    public void setCdf(Cdf cdf) { this.cdf = cdf; }

    public String getFecha_registro() { return fecha_registro; }
    public void setFecha_registro(String fecha_registro) { this.fecha_registro = fecha_registro; }
}
