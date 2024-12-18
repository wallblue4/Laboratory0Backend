package Laboratory.example.demo.service;


import Laboratory.example.demo.model.Cdf;
import Laboratory.example.demo.repository.CdfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CdfService {

    @Autowired
    private CdfRepository cdfRepository;

    // Crear o actualizar un registro CDF
    public Cdf saveCdf(Cdf cdf) {
        return cdfRepository.save(cdf);
    }
    public List<Cdf> getAllCdf() {
        return cdfRepository.findAll();
    }

    // Buscar registros por persona
    public List<Cdf> getCdfByPersona(Long idPersona) {
        return cdfRepository.findByPersona(idPersona);
    }

    // Contar registros CDF
    public long countCdf() {
        return cdfRepository.count();
    }
}
