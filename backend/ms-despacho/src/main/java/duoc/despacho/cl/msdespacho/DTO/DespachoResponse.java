package duoc.despacho.cl.msdespacho.dto;

import duoc.despacho.cl.msdespacho.model.EstadoDespacho;
import java.time.LocalDateTime;

public record DespachoResponse(
        Long id,
        Long pedidoId,
        String direccionOrigen,
        String direccionDestino,
        Long conductorId,
        EstadoDespacho estado,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaActualizacion
) {
}
