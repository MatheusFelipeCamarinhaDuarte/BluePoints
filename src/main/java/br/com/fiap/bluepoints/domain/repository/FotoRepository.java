package br.com.fiap.bluepoints.domain.repository;

import br.com.fiap.bluepoints.domain.entity.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {
}