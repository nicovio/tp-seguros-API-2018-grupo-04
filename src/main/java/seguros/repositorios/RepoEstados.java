package seguros.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import seguros.model.Estado;

@Repository
public interface RepoEstados extends JpaRepository<Estado, Long> {

	@Query(value = "select * from estado where estado.id  in (select cde.id_estado_posterior from cambio_de_estado as cde where :estadoId = cde.id_estado_anterior)", nativeQuery = true)
	List<Estado> getEstadosPosibles(@Param("estadoId") Long estadoId);

}
