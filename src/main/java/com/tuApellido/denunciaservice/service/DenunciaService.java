package com.tuApellido.denunciaservice.service;

import com.tuApellido.denunciaservice.entity.Denuncia;
import com.tuApellido.denunciaservice.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denunciaRepository;

    public Denuncia registrar(Denuncia denuncia) {
        denuncia.setEstado(1);
        if (denuncia.getFecha() == null) {
            denuncia.setFecha(LocalDateTime.now());
        }
        return denunciaRepository.save(denuncia);
    }

    public List<Denuncia> listar(int offset, int limit) {
        if (limit <= 0) {
            limit = 5;
        }
        int page = offset / limit;
        Pageable pageable = PageRequest.of(page, limit);
        return denunciaRepository.findAll(pageable).getContent();
    }

    public Denuncia obtenerPorId(Integer id) {
        return denunciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Denuncia no encontrada con id: " + id));
    }

    public List<Denuncia> obtenerPorCiudadano(String dni) {
        return denunciaRepository.findByDni(dni);
    }

    public Denuncia atender(Integer id) {
        Denuncia denuncia = obtenerPorId(id);
        denuncia.setEstado(0);
        return denunciaRepository.save(denuncia);
    }
}