package com.coderclase11.clientes.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="COMPROBANTE")
public class Comprobante {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    //bi-directional many-to-one association to Cliente
    @ManyToOne
    @JoinColumn(name="dni_cliente")
    private Cliente cliente;

    //bi-directional one-to-many association to Items
    @OneToMany(mappedBy="comprobante", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ItemsComprobante> itemsComprobantes;

    private Date fecha_creacion;

    public Comprobante() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<ItemsComprobante> getItemsComprobantes() {
        return itemsComprobantes;
    }

    public void setItemsComprobantes(Set<ItemsComprobante> itemsComprobantes) {
        this.itemsComprobantes = itemsComprobantes;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public ItemsComprobante addItemsComprobante(ItemsComprobante itemsComprobante) {
        getItemsComprobantes().add(itemsComprobante);
        itemsComprobante.setComprobante(this);
        return itemsComprobante;
    }

}






