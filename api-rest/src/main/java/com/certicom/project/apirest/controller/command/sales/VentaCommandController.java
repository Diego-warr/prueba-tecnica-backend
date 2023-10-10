package com.certicom.project.apirest.controller.command.sales;


import com.certicom.project.apirest.commons.UrlConfig;
import com.certicom.project.apirest.response.ResponseData;
import com.certicom.project.service.dto.VentaBodyDTO;
import com.certicom.project.service.spec.VentaService;
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

@Slf4j
@Tag(name = UrlConfig.VentaUrl.TAG)
@RequestMapping(value = UrlConfig.VentaUrl.Command.PREFIX, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class VentaCommandController {

    private final VentaService ventaService;

    @PostMapping(value = UrlConfig.VentaUrl.Command.REGISTRO)
    @Operation(summary = "Registro de venta", tags = UrlConfig.VentaUrl.TAG)
    public ResponseEntity<?> registro(@RequestBody VentaBodyDTO ventaBodyDTO) throws Exception {
        try{
            var result = ventaService.createOrUpdate(ventaBodyDTO);

            if(result!=null){
                return new ResponseEntity<>(new ResponseData<>(result), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(new ResponseData<>("Error al regitrar la venta"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage(),e);
        }
    }
}
