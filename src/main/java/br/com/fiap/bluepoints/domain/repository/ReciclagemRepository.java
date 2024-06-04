package br.com.fiap.bluepoints.domain.repository;

import br.com.fiap.bluepoints.domain.entity.Reciclagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReciclagemRepository extends JpaRepository<Reciclagem, Long> {
}