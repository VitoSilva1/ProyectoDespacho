package duoc.despacho.cl.msdespacho.service;

import duoc.despacho.cl.msdespacho.dto.DespachoRequest;
import duoc.despacho.cl.msdespacho.dto.DespachoResponse;
import duoc.despacho.cl.msdespacho.model.EstadoDespacho;
import java.util.List;

public interface DespachoService {

    DespachoResponse crear(DespachoRequest request);

    List<DespachoResponse> listar();

    DespachoResponse buscarPorId(Long id);

    DespachoResponse actualizar(Long id, DespachoRequest request);

    DespachoResponse actualizarEstado(Long id, EstadoDespacho estado);

    void eliminar(Long id);
}
