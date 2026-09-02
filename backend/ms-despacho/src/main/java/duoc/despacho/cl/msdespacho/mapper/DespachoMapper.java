package duoc.despacho.cl.msdespacho.mapper;

import duoc.despacho.cl.msdespacho.DTO.DespachoRequest;
import duoc.despacho.cl.msdespacho.DTO.DespachoResponse;
import duoc.despacho.cl.msdespacho.model.Despacho;
import duoc.despacho.cl.msdespacho.model.EstadoDespacho;

public final class DespachoMapper {

    private DespachoMapper() {
    }

    public static Despacho toEntity(DespachoRequest request) {
        return Despacho.builder()
                .pedidoId(request.pedidoId())
                .direccionOrigen(request.direccionOrigen())
                .direccionDestino(request.direccionDestino())
                .conductorId(request.conductorId())
                .estado(request.estado() == null ? EstadoDespacho.CREADO : request.estado())
                .build();
    }

    public static DespachoResponse toResponse(Despacho despacho) {
        return new DespachoResponse(
                despacho.getId(),
                despacho.getPedidoId(),
                despacho.getDireccionOrigen(),
                despacho.getDireccionDestino(),
                despacho.getConductorId(),
                despacho.getEstado(),
                despacho.getFechaCreacion(),
                despacho.getFechaActualizacion()
        );
    }
}
