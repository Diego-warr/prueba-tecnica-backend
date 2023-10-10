package com.certicom.project.entities.sales;

import com.certicom.project.entities.AbstractEntity;
import com.certicom.project.entities.client.Cliente;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "venta")
public class Venta extends AbstractEntity {

    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne(targetEntity = Cliente.class)
    private Cliente clienteId;


    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @OneToMany(cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER,
            mappedBy = "ventaId",
            targetEntity = DetalleVenta.class)
    List<DetalleVenta> detalles;
}
