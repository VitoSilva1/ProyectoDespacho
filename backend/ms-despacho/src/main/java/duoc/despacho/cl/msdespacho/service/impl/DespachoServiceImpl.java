package duoc.despacho.cl.msdespacho.service.impl;

import duoc.despacho.cl.msdespacho.dto.DespachoRequest;
import duoc.despacho.cl.msdespacho.dto.DespachoResponse;
import duoc.despacho.cl.msdespacho.exception.RecursoNoEncontradoException;
import duoc.despacho.cl.msdespacho.mapper.DespachoMapper;
import duoc.despacho.cl.msdespacho.model.Despacho;
import duoc.despacho.cl.msdespacho.model.EstadoDespacho;
import duoc.despacho.cl.msdespacho.repository.DespachoRepository;
import duoc.despacho.cl.msdespacho.service.DespachoService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DespachoServiceImpl implements DespachoService {

    private final DespachoRepository despachoRepository;

    public DespachoServiceImpl(DespachoRepository despachoRepository) {
        this.despachoRepository = despachoRepository;
    }

    @Override
    @Transactional
    public DespachoResponse crear(DespachoRequest request) {
        Despacho despacho = DespachoMapper.toEntity(request);
        return DespachoMapper.toResponse(despachoRepository.save(despacho));
    }

    @Override
    @Transactional(readOnly = true)
    public List<DespachoResponse> listar() {
        return despachoRepository.findAll()
                .stream()
                .map(DespachoMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public DespachoResponse buscarPorId(Long id) {
        return DespachoMapper.toResponse(obtenerDespacho(id));
    }

    @Override
    @Transactional
    public DespachoResponse actualizar(Long id, DespachoRequest request) {
        Despacho despacho = obtenerDespacho(id);
        despacho.setPedidoId(request.pedidoId());
        despacho.setDireccionOrigen(request.direccionOrigen());
        despacho.setDireccionDestino(request.direccionDestino());
        despacho.setConductorId(request.conductorId());
        if (request.estado() != null) {
            despacho.setEstado(request.estado());
        }
        return DespachoMapper.toResponse(despachoRepository.save(despacho));
    }

    @Override
    @Transactional
    public DespachoResponse actualizarEstado(Long id, EstadoDespacho estado) {
        Despacho despacho = obtenerDespacho(id);
        despacho.setEstado(estado);
        return DespachoMapper.toResponse(despachoRepository.save(despacho));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Despacho despacho = obtenerDespacho(id);
        despachoRepository.delete(despacho);
    }

    private Despacho obtenerDespacho(Long id) {
        return despachoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Despacho no encontrado con id: " + id));
    }
}
