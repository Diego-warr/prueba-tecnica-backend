package com.certicom.project.apirest.controller.query.product;


import com.certicom.project.apirest.commons.UrlConfig;
import com.certicom.project.apirest.response.ResponseData;
import com.certicom.project.service.spec.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = UrlConfig.ProductoUrl.TAG)
@RequestMapping(value = UrlConfig.ProductoUrl.Query.PREFIX, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class ProductQueryController {

    private final ProductoService productoService;

    @GetMapping(value = UrlConfig.ProductoUrl.Query.LISTA_PAGINADA)
    @Operation(summary = "Listado de productos paginados", tags = UrlConfig.ProductoUrl.TAG)
    public ResponseEntity<?> productosPaginados(Pageable pageable){

        try{
            var result = productoService.findByPage(pageable);
            return new ResponseEntity<>(new ResponseData<>(result), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseData<>("Error al listar los productos"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
