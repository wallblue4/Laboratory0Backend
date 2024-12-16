package Laboratory.example.demo.model;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personas")
public class Personas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo_doc;
    private String nombre;
    private Date fechaNac;
    private String sexo;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_vivienda_actual", nullable = true)
    private Viviendas viviendaActual;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipo_doc() { return tipo_doc; }
    public void setTipo_doc(String tipo_doc) { this.tipo_doc = tipo_doc; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Date getFechaNac() { return fechaNac; }
    public void setFechaNac(Date fecha_nac) { this.fechaNac = fecha_nac; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Viviendas getViviendaActual() { return viviendaActual; }
    public void setViviendaActual(Viviendas viviendaActual) { this.viviendaActual = viviendaActual; }
}