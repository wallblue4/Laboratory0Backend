package Laboratory.example.demo.DTO;

import Laboratory.example.demo.model.Personas;

public class PersonaDTO {
    private Long id;
    private String nombre;
    private String sexo;
    private String fechaNac;
    private String telefono;
    private String viviendaDireccion;

    // Constructor para simplificar el mapeo
    public PersonaDTO(Personas persona) {
        this.id = persona.getId();
        this.nombre = persona.getNombre();
        this.sexo = persona.getSexo();
        this.fechaNac = persona.getFechaNac() != null ? persona.getFechaNac().toString() : null;
        this.telefono = persona.getTelefono();
        this.viviendaDireccion = persona.getViviendaActual() != null ? persona.getViviendaActual().getDireccion() : null;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getFechaNac() { return fechaNac; }
    public void setFechaNac(String fechaNac) { this.fechaNac = fechaNac; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getViviendaDireccion() { return viviendaDireccion; }
    public void setViviendaDireccion(String viviendaDireccion) { this.viviendaDireccion = viviendaDireccion; }
}
