package seguros.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import seguros.exception.ResourceNotFoundException;
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

	@GetMapping("/polizas/vida")
	public List<Poliza> getPolizasDeVida() {
		return polizasRepository.findPolizasDeVida();
	}
	
	@GetMapping("/polizas/hogar")
	public List<Poliza> getPolizasDeHogar() {
		return polizasRepository.findPolizasDeHogar();
	}
	
	@GetMapping("/polizas/automovil")
	public List<Poliza> getPolizasDeAutomovil() {
		return polizasRepository.findPolizasDeAutomovil();
	}

	@GetMapping("/polizas/reporte")
	public List<Reporte> getReporte(@RequestParam("fechaDesde") Date fechaDesde,
			@RequestParam("fechaHasta") Date fechaHasta, @RequestParam("dniAgente") String dniAgente) {

		List<Reporte> reporte = polizasRepository.obtenerPolizasDeUnAgenteEntreFechas(dniAgente, fechaDesde,
				fechaHasta);
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
