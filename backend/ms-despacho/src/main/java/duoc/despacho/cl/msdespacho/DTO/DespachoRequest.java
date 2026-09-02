package duoc.despacho.cl.msdespacho.dto;

import duoc.despacho.cl.msdespacho.model.EstadoDespacho;

public record DespachoRequest(
        Long pedidoId,
        String direccionOrigen,
        String direccionDestino,
        Long conductorId,
        EstadoDespacho estado
) {
}
