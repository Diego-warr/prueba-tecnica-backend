package com.certicom.project.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaBodyDTO {

    private Integer id;

    private Integer clienteId;

    private Date fecha;

    List<DetalleVentaDTO> detalles;
}
