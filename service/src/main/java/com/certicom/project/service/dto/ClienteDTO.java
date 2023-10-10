package com.certicom.project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable {

    private Integer id;

    private String nombres;

    private String apellidos;

    private String dni;

    private String telefono;

    private String email;
}
