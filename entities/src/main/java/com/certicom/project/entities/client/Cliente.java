package com.certicom.project.entities.client;

import com.certicom.project.entities.AbstractEntity;
import com.certicom.project.entities.sales.Venta;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "cliente")
public class Cliente  extends AbstractEntity {

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "dni", columnDefinition = "varchar(10)", nullable = false)
    private String dni;

    @Column(name = "telefono", columnDefinition = "varchar(12)", nullable = false)
    private String telefono;

    @Column(name = "email", columnDefinition = "varchar(60)", nullable = false)
    private String email;

    @OneToMany(cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER,
            mappedBy = "clienteId",
            targetEntity = Venta.class)
    List<Venta> ventas;
}
