package duoc.despacho.cl.msdespacho.controller;

import duoc.despacho.cl.msdespacho.dto.DespachoRequest;
import duoc.despacho.cl.msdespacho.dto.DespachoResponse;
import duoc.despacho.cl.msdespacho.model.EstadoDespacho;
import duoc.despacho.cl.msdespacho.service.DespachoService;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/despachos")
public class DespachoController {

    private final DespachoService despachoService;

    public DespachoController(DespachoService despachoService) {
        this.despachoService = despachoService;
    }

    @PostMapping
    public ResponseEntity<DespachoResponse> crear(@RequestBody DespachoRequest request) {
        DespachoResponse response = despachoService.crear(request);
        return ResponseEntity
                .created(URI.create("/api/despachos/" + response.id()))
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<DespachoResponse>> listar() {
        return ResponseEntity.ok(despachoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespachoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(despachoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DespachoResponse> actualizar(
            @PathVariable Long id,
            @RequestBody DespachoRequest request
    ) {
        return ResponseEntity.ok(despachoService.actualizar(id, request));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<DespachoResponse> actualizarEstado(
            @PathVariable Long id,
            @RequestParam EstadoDespacho estado
    ) {
        return ResponseEntity.ok(despachoService.actualizarEstado(id, estado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        despachoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
