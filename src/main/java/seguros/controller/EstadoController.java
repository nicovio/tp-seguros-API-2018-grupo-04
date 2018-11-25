package seguros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import seguros.model.Estado;
import seguros.repositorios.RepoEstados;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EstadoController {

	@Autowired
	RepoEstados estadoRepository;

	@GetMapping("/estados")
	public List<Estado> getEstados() {
		return estadoRepository.findAll();
	}

}
