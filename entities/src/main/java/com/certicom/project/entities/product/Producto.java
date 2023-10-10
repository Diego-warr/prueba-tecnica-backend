package com.certicom.project.entities.product;

import com.certicom.project.entities.AbstractEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "producto")
public class Producto extends AbstractEntity {

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "precio", columnDefinition = "decimal(10,2)")
    private BigDecimal precio;
}
