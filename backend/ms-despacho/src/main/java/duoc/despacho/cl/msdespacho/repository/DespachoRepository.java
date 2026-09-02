package duoc.despacho.cl.msdespacho.repository;

import duoc.despacho.cl.msdespacho.model.Despacho;
import duoc.despacho.cl.msdespacho.model.EstadoDespacho;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespachoRepository extends JpaRepository<Despacho, Long> {

    List<Despacho> findByEstado(EstadoDespacho estado);

    List<Despacho> findByConductorId(Long conductorId);
}
