package Laboratory.example.demo.DTO;

import Laboratory.example.demo.model.Viviendas;

public class ViviendaDTO {
    private Long id;
    private String direccion;
    private Integer capacidad;
    private Integer niveles;
    private String municipioNombre;

    // Constructor para simplificar el mapeo
    public ViviendaDTO(Viviendas vivienda) {
        this.id = vivienda.getId();
        this.direccion = vivienda.getDireccion();
        this.capacidad = vivienda.getCapacidad();
        this.niveles = vivienda.getNiveles();
        this.municipioNombre = vivienda.getMunicipio() != null ? vivienda.getMunicipio().getNombre() : null;
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

    public String getMunicipioNombre() { return municipioNombre; }
    public void setMunicipioNombre(String municipioNombre) { this.municipioNombre = municipioNombre; }
}
