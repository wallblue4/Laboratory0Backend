package Laboratory.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "municipios")
public class Municipios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "municipio")
    private List<Viviendas> viviendas;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Viviendas> getViviendas() { return viviendas; }
    public void setViviendas(List<Viviendas> viviendas) { this.viviendas = viviendas; }
}