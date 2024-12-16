package Laboratory.example.demo.service;


import Laboratory.example.demo.DTO.PersonaDTO;
import Laboratory.example.demo.model.Personas;
import Laboratory.example.demo.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonasService {

    @Autowired
    private PersonasRepository personasRepository;

    // Crear o actualizar una persona
    public Personas savePersona(Personas persona) {

        return personasRepository.save(persona);
    }

    // Obtener una persona por ID
    public Personas getPersonaById(Long id) {
        return personasRepository.findById(id).orElse(null);
    }

    // Eliminar una persona
    public void deletePersona(Long id) {
        personasRepository.deleteById(id);
    }

    // Buscar personas por nombre
    public List<Personas> getPersonasByNombre(String nombre) {
        return personasRepository.findByNombre(nombre);
    }

    // Buscar personas por sexo
    public List<Personas> getPersonasBySexo(String sexo) {
        return personasRepository.findBySexo(sexo);
    }

    // Buscar personas nacidas después de una fecha específica
    public List<Personas> getPersonasNacidasDespues(Date fecha) {
        return personasRepository.findByFechaNac(fecha);
    }

    // Obtener personas sin vivienda actual
    public List<Personas> getPersonasSinVivienda() {
        return personasRepository.findPersonasSinVivienda();
    }
}