package seguros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import seguros.model.Estado;
import seguros.repositorios.RepoEstados;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EstadoController {

	@Autowired
	RepoEstados estadosRepository;

	@GetMapping("/estados/{id}")
	public List<Estado> getEstados(@PathVariable(value = "id") Long estadoId) {
		return estadosRepository.getEstadosPosibles(estadoId);
	}

}
