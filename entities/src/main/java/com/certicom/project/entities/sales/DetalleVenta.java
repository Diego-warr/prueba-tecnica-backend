package com.certicom.project.entities.sales;

import com.certicom.project.entities.AbstractEntity;
import com.certicom.project.entities.client.Cliente;
import com.certicom.project.entities.product.Producto;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta extends AbstractEntity {

    @JoinColumn(name = "venta_id", referencedColumnName = "id")
    @ManyToOne(targetEntity = Venta.class)
    private Venta ventaId;

    @Column(name = "cantidad", columnDefinition = "int")
    private Integer cantidad;

    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    @OneToOne(targetEntity = Producto.class)
    private Producto productoId;
}
