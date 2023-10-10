package com.certicom.project.repository.sales;

import com.certicom.project.entities.sales.DetalleVenta;
import com.certicom.project.repository.GenericMySqlEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends GenericMySqlEntityRepository<DetalleVenta, Integer> {
}
