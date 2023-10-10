package com.certicom.project.service.spec;

import com.certicom.project.entities.sales.Venta;
import com.certicom.project.service.dto.VentaBodyDTO;
import com.certicom.project.service.dto.VentaDTO;

import java.util.Date;
import java.util.List;

public interface VentaService extends BasicService<VentaDTO> {


    List<VentaDTO> findByFecha(Date fecha);

    VentaDTO createOrUpdate(VentaBodyDTO ventaBodyDTO);

}
