package com.certicom.project.service.impl;

import com.certicom.project.entities.client.Cliente;
import com.certicom.project.repository.client.ClienteRepository;
import com.certicom.project.service.dto.ClienteDTO;
import com.certicom.project.service.spec.ClienteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {


    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<ClienteDTO> finById(Integer id) {

        var cliente = clienteRepository.findById(id).orElse(null);

        if(cliente!=null){
            var clienteDTO = modelMapper.map(cliente,ClienteDTO.class);
            return Optional.of(clienteDTO);
        }
        return Optional.empty();
    }

    @Override
    public List<ClienteDTO> findAll() {

        var listaDTO = clienteRepository
                .findAll()
                .stream()
                .map(c->modelMapper.map(c,ClienteDTO.class))
                .collect(Collectors.toList());
        return listaDTO;
    }

    @Override
    public List<ClienteDTO> finAllActive() {
        var listaDTO = clienteRepository
                .findAllActive()
                .stream()
                .map(c->modelMapper.map(c,ClienteDTO.class))
                .collect(Collectors.toList());
        return listaDTO;
    }

    @Override
    public ClienteDTO saveOrUpdate(ClienteDTO cliente) {

        if(cliente.getId()==null){
            var clienteNuevo = Cliente.builder()
                    .nombres(cliente.getNombres())
                    .apellidos(cliente.getApellidos())
                    .dni(cliente.getDni())
                    .telefono(cliente.getTelefono())
                    .email(cliente.getEmail())
                    .build();
            var result = clienteRepository.save(clienteNuevo);

            return modelMapper.map(result,ClienteDTO.class);
        }else{
            var clienteUpdate = clienteRepository.findById(cliente.getId()).orElse(null);

            if(clienteUpdate!=null){
                clienteUpdate.setNombres(cliente.getNombres());
                clienteUpdate.setApellidos(cliente.getApellidos());
                clienteUpdate.setDni(cliente.getDni());
                clienteUpdate.setTelefono(cliente.getTelefono());
                clienteUpdate.setEmail(cliente.getEmail());

                var result = clienteRepository.save(clienteUpdate);

                return modelMapper.map(result,ClienteDTO.class);
            }
            else {
                return null;
            }
        }

    }

    @Override
    public void delete(Integer id) {

    }
}
