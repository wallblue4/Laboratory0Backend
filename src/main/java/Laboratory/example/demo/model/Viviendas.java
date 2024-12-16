package Laboratory.example.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "viviendas")
public class Viviendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;
    private Integer capacidad;
    private Integer niveles;

    @ManyToOne
    @JoinColumn(name = "id_municipio")
    @JsonBackReference
    private Municipios municipio;

    @OneToMany(mappedBy = "viviendaActual")
    private List<Personas> habitantes;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }

    public Integer getNiveles() { return niveles; }
    public void setNiveles(Integer niveles) { this.niveles = niveles; }

    public Municipios getMunicipio() { return municipio; }
    public void setMunicipio(Municipios municipio) { this.municipio = municipio; }

    public List<Personas> getHabitantes() { return habitantes; }
    public void setHabitantes(List<Personas> habitantes) { this.habitantes = habitantes; }
}