package com.certicom.project.apirest.controller.command.product;


import com.certicom.project.apirest.commons.UrlConfig;
import com.certicom.project.apirest.response.ResponseData;
import com.certicom.project.service.dto.ProductoDTO;
import com.certicom.project.service.spec.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = UrlConfig.ProductoUrl.TAG)
@RequestMapping(value = UrlConfig.ProductoUrl.Command.PREFIX, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class ProductoCommandController {

    private final ProductoService productoService;

    @PostMapping(value = UrlConfig.ProductoUrl.Command.REGISTRO)
    @Operation(summary = "Registrar un nuevo producto", tags = UrlConfig.ProductoUrl.TAG)
    public ResponseEntity<?> registrar(@RequestBody ProductoDTO productoDTO) throws Exception {

        try {
            var result = productoService.saveOrUpdate(productoDTO);

            if(productoDTO!=null){
                return new ResponseEntity<>(new ResponseData<>(result), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(new ResponseData<>("Error al registrar el producto"),HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage(),e);
        }
    }

    @PutMapping(value = UrlConfig.ProductoUrl.Command.ACTUALIZAR)
    @Operation(summary = "Actualizar un producto", tags = UrlConfig.ProductoUrl.TAG)
    public ResponseEntity<?> actualizar(@RequestBody ProductoDTO productoDTO) throws Exception {
        try {
            var result = productoService.saveOrUpdate(productoDTO);

            if(productoDTO!=null){
                return new ResponseEntity<>(new ResponseData<>(result), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(new ResponseData<>("Error al regitrar el producto"),HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage(),e);
        }
    }

    @DeleteMapping(value=UrlConfig.ProductoUrl.Command.ELIMINAR+"/{producto_id}")
    @Operation(summary = "Eliminación lógica de un producto", tags = UrlConfig.ProductoUrl.TAG)
    public ResponseEntity<?> eliminar(@PathVariable(name = "producto_id") Integer productoId){

        try{
            productoService.delete(productoId);
            return new ResponseEntity<>(new ResponseData<>("Producto eliminado correctamente"), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseData<>("Error al eliminar el producto"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
