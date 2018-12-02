package seguros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seguros.model.Estado;
import seguros.repositorios.RepoEstados;

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
