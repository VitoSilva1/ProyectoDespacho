package duoc.despacho.cl.msdespacho.DTO;

import duoc.despacho.cl.msdespacho.model.EstadoDespacho;

public record DespachoRequest(
        Long pedidoId,
        String direccionOrigen,
        String direccionDestino,
        Long conductorId,
        EstadoDespacho estado
) {
}
