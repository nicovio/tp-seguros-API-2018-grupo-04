package seguros.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import seguros.exception.ResourceNotFoundException;
import seguros.model.ParametrosReporte;
import seguros.model.Poliza;
import seguros.model.Reporte;
import seguros.repositorios.RepoPolizas;

@CrossOrigin(origins = "http://localhost:4200")
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
	public List<Reporte> getReporte(@Valid @RequestBody ParametrosReporte parametros) {

		List<Reporte> reporte = polizasRepository.obtenerPolizasDeUnAgenteEntreFechas(parametros.getDniAgente(),
				parametros.getFechaDesde(), parametros.getFechaHasta());
		return reporte;
	}

	@PutMapping("/polizas/cambiarEstado/{id}")
	public ResponseEntity<?> updateEstadoPoliza(@PathVariable(value = "id") Long polizaId,
			@Valid @RequestBody Poliza polizaDetails) throws Exception {

		Poliza poliza = polizasRepository.findById(polizaId)
				.orElseThrow(() -> new ResourceNotFoundException("Poliza", "id", polizaId));

		poliza.cambiarEstado(polizaDetails.getId_estado());
		polizasRepository.save(poliza);
		return ResponseEntity.ok().build();
	}
}
