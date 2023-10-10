package com.certicom.project.repository.sales;

import com.certicom.project.entities.sales.Venta;
import com.certicom.project.repository.GenericMySqlEntityRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface VentaRepository extends GenericMySqlEntityRepository<Venta,Integer> {

    @Query("SELECT V FROM Venta V WHERE V.id=:venta_id")
    Optional<Venta> findById(@Param("venta_id") Integer id);

    @Query("SELECT V FROM Venta V WHERE V.fecha=:fecha")
    List<Venta> findByFecha(@Param("fecha") Date fecha);
}
