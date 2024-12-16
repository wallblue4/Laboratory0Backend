package Laboratory.example.demo.service;


import Laboratory.example.demo.model.Personas;
import Laboratory.example.demo.model.Posesiones;
import Laboratory.example.demo.model.Viviendas;
import Laboratory.example.demo.repository.PosesionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosesionesService {

    @Autowired
    private PosesionesRepository posesionesRepository;

    // Crear o actualizar una posesión
    public Posesiones savePosesion(Posesiones posesion) {
        return posesionesRepository.save(posesion);
    }

    // Obtener posesiones de una persona
    public List<Posesiones> getPosesionesByPersona(Personas idPersona) {
        return posesionesRepository.findByPersona(idPersona);
    }

    // Obtener posesiones de una vivienda
    public List<Posesiones> getPosesionesByVivienda(Viviendas idVivienda) {
        return posesionesRepository.findByVivienda(idVivienda);
    }

    // Contar todas las posesiones
    public long countPosesiones() {
        return posesionesRepository.count();
    }
}
