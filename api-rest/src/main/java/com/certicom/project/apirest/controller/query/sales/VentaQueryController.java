package com.certicom.project.apirest.controller.query.sales;


import com.certicom.project.apirest.commons.UrlConfig;
import com.certicom.project.apirest.response.ResponseData;
import com.certicom.project.service.spec.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@Tag(name = UrlConfig.VentaUrl.TAG)
@RequestMapping(value = UrlConfig.VentaUrl.Query.PREFIX, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class VentaQueryController {

    private final VentaService ventaService;

    @GetMapping(value = UrlConfig.VentaUrl.Query.CONSULTA_POR_FECHA)
    @Operation(summary = "Listado de ventas por fechas", tags = UrlConfig.VentaUrl.TAG)
    public ResponseEntity<?> ventaByFecha(
            @RequestParam(name = "fecha")
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha){

        try {

            var result = ventaService.findByFecha(fecha);

            return new ResponseEntity<>(new ResponseData<>(result), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseData<>("Error al obtener las ventas"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = UrlConfig.VentaUrl.Query.CONSULTA_POR_ID)
    @Operation(summary = "Retorna una venta por su id", tags = UrlConfig.VentaUrl.TAG)
    public ResponseEntity<?> ventaById(@RequestParam(name = "venta_id") Integer ventaId){
        try {

            var result = ventaService.finById(ventaId);

            if(result.isPresent()){
                return new ResponseEntity<>(new ResponseData<>(result.get()), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(new ResponseData<>("No existe una venta con ese ID"), HttpStatus.NO_CONTENT);
            }

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseData<>("Error al obtener las ventas"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
