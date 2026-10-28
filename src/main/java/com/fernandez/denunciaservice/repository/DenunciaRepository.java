package com.fernandez.denunciaservice.repository;

import com.fernandez.denunciaservice.entity.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {
    List<Denuncia> findByDni(String dni);
}
