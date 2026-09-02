package duoc.despacho.cl.msdespacho.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "despachos")
public class Despacho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long pedidoId;

    @Column(nullable = false)
    private String direccionOrigen;

    @Column(nullable = false)
    private String direccionDestino;

    private Long conductorId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoDespacho estado;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaActualizacion;

    protected Despacho() {
    }

    public Despacho(
            Long pedidoId,
            String direccionOrigen,
            String direccionDestino,
            Long conductorId,
            EstadoDespacho estado
    ) {
        this.pedidoId = pedidoId;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.conductorId = conductorId;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public Long getConductorId() {
        return conductorId;
    }

    public void setConductorId(Long conductorId) {
        this.conductorId = conductorId;
    }

    public EstadoDespacho getEstado() {
        return estado;
    }

    public void setEstado(EstadoDespacho estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    @PrePersist
    void prePersist() {
        LocalDateTime ahora = LocalDateTime.now();
        fechaCreacion = ahora;
        fechaActualizacion = ahora;
        if (estado == null) {
            estado = EstadoDespacho.CREADO;
        }
    }

    @PreUpdate
    void preUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }
}
