package com.certicom.project.service.impl;

import com.certicom.project.entities.product.Producto;
import com.certicom.project.repository.product.ProductoRepository;
import com.certicom.project.service.dto.ProductoDTO;
import com.certicom.project.service.spec.ProductoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<ProductoDTO> finById(Integer id) {
        return productoRepository.findById(id).map(p->modelMapper.map(p,ProductoDTO.class));
    }

    @Override
    public List<ProductoDTO> findAll() {
        return productoRepository
                .findAll()
                .stream()
                .map(p->modelMapper.map(p,ProductoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductoDTO> finAllActive() {
        return productoRepository
                .findAll()
                .stream()
                .map(p->modelMapper.map(p,ProductoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO saveOrUpdate(ProductoDTO productoDTO) {
        if(productoDTO.getId()==null){
            var productoNuevo = Producto.builder()
                    .nombre(productoDTO.getNombre())
                    .precio(productoDTO.getPrecio())
                    .build();
            var result = productoRepository.save(productoNuevo);
            return modelMapper.map(result, ProductoDTO.class);
        }else{
            var productoUpdate = productoRepository.findById(productoDTO.getId()).orElse(null);

            if(productoUpdate!=null){
                productoUpdate.setNombre(productoDTO.getNombre());
                productoUpdate.setPrecio(productoDTO.getPrecio());

                var result = productoRepository.save(productoUpdate);
                return modelMapper.map(result,ProductoDTO.class);
            }else {
                return null;
            }
        }
    }

    @Override
    public void delete(Integer id) {

        var producto = productoRepository.findById(id).orElse(null);
        if(producto!=null && producto.isActivo()){
            productoRepository.delete(producto.getId());
        }
    }

    @Override
    public Page<ProductoDTO> findByPage(Pageable pageable) {

        Page<Producto> productosPaginado = productoRepository.findByPage(pageable);
        Page<ProductoDTO> produtosDTO = productosPaginado.map(p->modelMapper.map(p,ProductoDTO.class));
        return produtosDTO;
    }
}
