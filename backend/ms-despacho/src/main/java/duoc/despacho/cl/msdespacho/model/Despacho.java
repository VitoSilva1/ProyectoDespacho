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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "despachos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
