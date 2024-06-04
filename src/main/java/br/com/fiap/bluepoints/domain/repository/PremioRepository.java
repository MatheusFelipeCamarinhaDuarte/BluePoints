package br.com.fiap.bluepoints.domain.repository;

import br.com.fiap.bluepoints.domain.entity.Premio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremioRepository extends JpaRepository<Premio, Long> {
}