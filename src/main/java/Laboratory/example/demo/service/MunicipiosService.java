package Laboratory.example.demo.service;


import Laboratory.example.demo.model.Municipios;
import Laboratory.example.demo.repository.MunicipiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipiosService {

    @Autowired
    private MunicipiosRepository municipiosRepository;

    // Crear o actualizar un municipio
    public Municipios saveMunicipio(Municipios municipio) {
        return municipiosRepository.save(municipio);
    }

    // Obtener municipio por ID
    public Municipios getMunicipioById(Long id) {
        return municipiosRepository.findById(id).orElse(null);
    }

    // Buscar municipio por nombre
    public Municipios getMunicipioByNombre(String nombre) {
        return municipiosRepository.findByNombre(nombre);
    }

    // Listar municipios ordenados alfabéticamente
    public List<Municipios> getAllMunicipiosOrdenados() {
        return municipiosRepository.findAllByOrderByNombreAsc();
    }
}
