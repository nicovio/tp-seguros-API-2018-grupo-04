package seguros.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import seguros.model.Poliza;
import seguros.model.Reporte;

@Repository
public interface RepoPolizas extends JpaRepository<Poliza, Long> {

	@Query(value = "select est.descripcion as estado ,tipo, count(poliza.ID) as cantidad, sum(prima) as valor_prima from poliza inner join tomador on poliza.ID = tomador.ID_Poliza inner join estado as est on poliza.id_estado = est.id where Fecha_Inicio >= :fechaDesde and Fecha_Inicio <= :fechaHasta and DNI_Agente = :dniAgente group by poliza.tipo, poliza.ID_Estado order by poliza.tipo, poliza.ID_Estado ", nativeQuery = true)
	List<Reporte> obtenerPolizasDeUnAgenteEntreFechas(@Param("dniAgente") String dniAgente,
			@Param("fechaDesde") Date fechaDesde, @Param("fechaHasta") Date fechaHasta);
}