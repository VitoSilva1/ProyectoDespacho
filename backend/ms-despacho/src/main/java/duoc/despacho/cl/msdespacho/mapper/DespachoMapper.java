package duoc.despacho.cl.msdespacho.mapper;

import duoc.despacho.cl.msdespacho.dto.DespachoRequest;
import duoc.despacho.cl.msdespacho.dto.DespachoResponse;
import duoc.despacho.cl.msdespacho.model.Despacho;
import duoc.despacho.cl.msdespacho.model.EstadoDespacho;

public final class DespachoMapper {

    private DespachoMapper() {
    }

    public static Despacho toEntity(DespachoRequest request) {
        return new Despacho(
                request.pedidoId(),
                request.direccionOrigen(),
                request.direccionDestino(),
                request.conductorId(),
                request.estado() == null ? EstadoDespacho.CREADO : request.estado()
        );
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
