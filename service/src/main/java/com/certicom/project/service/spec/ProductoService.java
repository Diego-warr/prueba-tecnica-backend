package com.certicom.project.service.spec;

import com.certicom.project.entities.product.Producto;
import com.certicom.project.service.dto.ProductoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoService extends BasicService<ProductoDTO>{

    Page<ProductoDTO> findByPage(Pageable pageable);

}
