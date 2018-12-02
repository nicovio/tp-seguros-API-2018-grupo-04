package seguros.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonSimpleJsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;

import seguros.exception.ResourceNotFoundException;
import seguros.model.CriteriosReporte;
import seguros.model.Poliza;
import seguros.model.Reporte;
import seguros.repositorios.RepoPolizas;
import org.json.*;

@RestController
@RequestMapping("/api")
public class PolizaController {

	@Autowired
	RepoPolizas polizasRepository;

	@GetMapping("/polizas")
	public List<Poliza> getPolizas() {
		return polizasRepository.findAll();
	}

	@GetMapping("/polizas/reporte")
	public List<Reporte> getReporte(@Valid @RequestBody CriteriosReporte criterios) {

		List<Reporte> reporte = polizasRepository.obtenerPolizasDeUnAgenteEntreFechas(criterios.getDniAgente(),
				criterios.getFechaDesde(), criterios.getFechaHasta());
		return reporte;
	}

	@PutMapping("polizas/cambiarEstado/{id}")
	public Poliza updateEstadoPoliza(@PathVariable(value = "id") Long polizaId,
			@Valid @RequestBody Poliza polizaDetails) {

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
