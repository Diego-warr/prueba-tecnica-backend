package com.certicom.project.service.dto;

import com.certicom.project.entities.client.Cliente;
import com.certicom.project.entities.sales.DetalleVenta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO implements Serializable {

    private Integer id;

    private ClienteDTO clienteId;

    private Date fecha;

    List<DetalleVentaDTO> detalles;
}
