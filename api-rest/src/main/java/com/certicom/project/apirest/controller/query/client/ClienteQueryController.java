package com.certicom.project.apirest.controller.query.client;


import com.certicom.project.apirest.commons.UrlConfig;
import com.certicom.project.apirest.response.ResponseData;
import com.certicom.project.service.spec.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = UrlConfig.ClienteUrl.TAG)
@RequestMapping(value = UrlConfig.ClienteUrl.Query.PREFIX, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ClienteQueryController {

    private final ClienteService clienteService;

    @GetMapping(value = UrlConfig.ClienteUrl.Query.FIND_ALL)
    @Operation(summary = "Listar los cliente activos", tags = UrlConfig.ClienteUrl.TAG)
    public ResponseEntity<?> listar() throws Exception {
        try {
            var result = clienteService.finAllActive();

            return new ResponseEntity<>(new ResponseData<>(result), HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage(),e);
        }
    }
}
