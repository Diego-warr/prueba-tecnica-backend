package com.certicom.project.service.impl;

import com.certicom.project.entities.client.Cliente;
import com.certicom.project.entities.sales.DetalleVenta;
import com.certicom.project.entities.sales.Venta;
import com.certicom.project.repository.sales.DetalleVentaRepository;
import com.certicom.project.repository.sales.VentaRepository;
import com.certicom.project.service.dto.DetalleVentaDTO;
import com.certicom.project.service.dto.VentaBodyDTO;
import com.certicom.project.service.dto.VentaDTO;
import com.certicom.project.service.spec.VentaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;
    private final DetalleVentaRepository detalleVentaRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<VentaDTO> finById(Integer id) {
        return ventaRepository.findById(id).map(v->modelMapper.map(v,VentaDTO.class));
    }

    @Override
    public List<VentaDTO> findAll() {
        return null;
    }

    @Override
    public List<VentaDTO> finAllActive() {
        return null;
    }

    @Override
    public VentaDTO saveOrUpdate(VentaDTO ventaDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<VentaDTO> findByFecha(Date fecha) {
        return ventaRepository.findByFecha(fecha)
                .stream()
                .map(v->modelMapper.map(v,VentaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public VentaDTO createOrUpdate(VentaBodyDTO ventaBodyDTO) {

        if(ventaBodyDTO.getId()==null){
            var cliente = new Cliente();
            cliente.setId(ventaBodyDTO.getClienteId());
            var ventaEntity = Venta.builder()
                    .clienteId(cliente).fecha(ventaBodyDTO.getFecha()).build();
            var resulVenta = ventaRepository.save(ventaEntity);

            var detalles = ventaBodyDTO.getDetalles()
                    .stream()
                    .peek(d->d.setVentaId(resulVenta.getId()))
                    .map(ds->modelMapper.map(ds, DetalleVenta.class))
                    .collect(Collectors.toList());
            var resultDetalles = detalleVentaRepository.saveAll(detalles)
                    .stream()
                    .map(d->modelMapper.map(d, DetalleVentaDTO.class)).collect(Collectors.toList());

            var ventaDTO = modelMapper.map(resulVenta,VentaDTO.class);
            ventaDTO.setDetalles(resultDetalles);

            return ventaDTO;
        }
        return null;

    }
}
