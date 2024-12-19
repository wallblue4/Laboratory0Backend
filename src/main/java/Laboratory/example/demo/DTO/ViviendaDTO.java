package Laboratory.example.demo.DTO;

import Laboratory.example.demo.model.Personas;
import Laboratory.example.demo.model.Viviendas;

import java.util.List;

public class ViviendaDTO {
    private Long id;
    private String direccion;
    private Integer capacidad;
    private Integer niveles;
    private Long municipioNombre;
    private List<Personas> habitantes;

    // Constructor para simplificar el mapeo
    public ViviendaDTO(Viviendas vivienda) {
        this.id = vivienda.getId();
        this.direccion = vivienda.getDireccion();
        this.capacidad = vivienda.getCapacidad();
        this.niveles = vivienda.getNiveles();
        this.municipioNombre = vivienda.getMunicipio() != null ? vivienda.getMunicipio().getId() : null;
        this.habitantes = vivienda.getHabitantes();
    }
    public ViviendaDTO(){

    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }

    public Integer getNiveles() { return niveles; }
    public void setNiveles(Integer niveles) { this.niveles = niveles; }

    public Long getMunicipioNombre() { return municipioNombre; }
    public void setMunicipioNombre(Long municipioNombre) { this.municipioNombre = municipioNombre; }

    public List<Personas> getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(List<Personas> habitantes) {
        this.habitantes = habitantes;
    }
}
