package com.certicom.project.apirest.controller.command.client;


import com.certicom.project.apirest.commons.UrlConfig;
import com.certicom.project.apirest.response.ResponseData;
import com.certicom.project.service.dto.ClienteDTO;
import com.certicom.project.service.spec.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.TableGenerators;

@Slf4j
@Tag(name = UrlConfig.ClienteUrl.TAG)
@RequestMapping(value = UrlConfig.ClienteUrl.Command.PREFIX, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class ClienteCommandController {

    private final ClienteService clienteService;

    @PostMapping(UrlConfig.ClienteUrl.Command.REGISTRAR)
    @Operation(summary = "Registrar un nuevo cliente", tags = UrlConfig.ClienteUrl.TAG)
    public ResponseEntity<?> registrar(@RequestBody ClienteDTO clienteDTO) throws Exception {

        try {
            var result = clienteService.saveOrUpdate(clienteDTO);

            if(result!=null){
                return new ResponseEntity<>(new ResponseData<>(result),HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(new ResponseData<>("Error al registrar el cliente"),HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage(),e);
        }
    }
}
