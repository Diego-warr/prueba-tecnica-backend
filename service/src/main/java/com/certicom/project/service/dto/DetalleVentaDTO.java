package com.certicom.project.service.dto;

import com.certicom.project.entities.product.Producto;
import com.certicom.project.entities.sales.Venta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVentaDTO {

    private Integer id;

    private Integer ventaId;

    private Integer cantidad;

    private Integer productoId;
}
