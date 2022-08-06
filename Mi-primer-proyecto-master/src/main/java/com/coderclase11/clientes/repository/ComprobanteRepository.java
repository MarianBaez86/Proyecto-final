package com.coderclase11.clientes.repository;

import com.coderclase11.clientes.model.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprobanteRepository extends JpaRepository <Comprobante, Long> {
}
