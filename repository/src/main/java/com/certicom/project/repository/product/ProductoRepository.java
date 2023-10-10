package com.certicom.project.repository.product;

import com.certicom.project.entities.product.Producto;
import com.certicom.project.repository.GenericMySqlEntityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProductoRepository extends GenericMySqlEntityRepository<Producto,Integer> {


    @Query("SELECT P FROM Producto P WHERE P.activo=true ORDER BY P.id DESC ")
    Page<Producto> findByPage(Pageable pageable);

    @Modifying
    @Query("UPDATE Producto P SET P.activo=false WHERE P.id=:producto_id")
    void delete(@Param("producto_id") Integer productoId);

}
