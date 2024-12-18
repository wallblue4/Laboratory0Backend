package Laboratory.example.demo.service;

import Laboratory.example.demo.model.Municipios;
import Laboratory.example.demo.model.Viviendas;
import Laboratory.example.demo.repository.ViviendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViviendasService {

    @Autowired
    private ViviendasRepository viviendasRepository;

    // Crear o actualizar una vivienda
    public Viviendas saveVivienda(Viviendas vivienda) {
        return viviendasRepository.save(vivienda);
    }

    // Obtener una vivienda por ID
    public Viviendas getViviendaById(Long id) {
        return viviendasRepository.findById(id).orElse(null);
    }

    public List<Viviendas> getAllViviendas() {
        return viviendasRepository.findAll();
    }

    // Eliminar una vivienda
    public void deleteVivienda(Long id) {
        viviendasRepository.deleteById(id);
    }

    // Buscar viviendas por capacidad
    public List<Viviendas> getViviendasByCapacidad(int capacidad) {
        return viviendasRepository.findByCapacidad(capacidad);
    }

    // Buscar viviendas por municipio
    public List<Viviendas> getViviendasByMunicipio(Municipios idMunicipio) {
        return viviendasRepository.findByMunicipio(idMunicipio);
    }

    // Contar viviendas con más de X niveles
    public long countViviendasConNivelesMayor(int niveles) {
        return viviendasRepository.countByNivelesGreaterThan(niveles);
    }

    // Consultar viviendas con capacidad mayor a un valor dado
    public List<Viviendas> getViviendasCapacidadMayor(int capacidad) {
        return viviendasRepository.findViviendasByCapacidadMayor(capacidad);
    }
}