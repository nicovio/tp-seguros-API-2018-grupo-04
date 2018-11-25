package seguros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seguros.exception.ResourceNotFoundException;
import seguros.model.Poliza;
import seguros.repositorios.RepoPolizas;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PolizaController {

	@Autowired
	RepoPolizas polizasRepository;

	@GetMapping("/polizas")
	public List<Poliza> getPolizas() {
		return polizasRepository.findAll();
	}

	@PutMapping("polizas/cambiarEstado/{id}")
	public Poliza updateEstadoPoliza(@PathVariable(value = "id") Long polizaId, @Valid @RequestBody Poliza polizaDetails) {

		Poliza poliza = polizasRepository.findById(polizaId)
				.orElseThrow(() -> new ResourceNotFoundException("Poliza", "id", polizaId));

		poliza.setId_estado(polizaDetails.getId_estado());
		Poliza updatedPoliza = polizasRepository.save(poliza);
		return updatedPoliza;
	}

	@DeleteMapping("/polizas/{id}")
	public ResponseEntity<?> deletePoliza(@PathVariable(value = "id") Long polizaId) {
		Poliza poliza = polizasRepository.findById(polizaId)
				.orElseThrow(() -> new ResourceNotFoundException("Poliza", "id", polizaId));

		polizasRepository.delete(poliza);

		return ResponseEntity.ok().build();
	}

}
