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

	@Query(value = 
			"select pol.tipo,"
		  + "       pol.id_estado,"
		  + "       est.descripcion as estado,"
		  + "       count(pol.id) as cantidad,"
		  + "       sum(pol.prima) as valor_prima"
		  + "  from poliza as pol"
		  + " inner join tomador as tom "
		  + "    on pol.id = tom.id_poliza "
		  + " inner join estado as est "
		  + "    on pol.id_estado = est.id "
		  + " where pol.fecha_inicio >= :fechaDesde "
		  + "   and pol.fecha_inicio <= :fechaHasta "
		  + "   and tom.dni_agente = :dniAgente "
		  + " group by pol.tipo,"
		  + "          pol.id_estado,"
		  + "          est.descripcion"
		  + " order by pol.tipo,"
		  + "          est.descripcion"
		  , nativeQuery = true)
	List<Reporte> obtenerPolizasDeUnAgenteEntreFechas(@Param("dniAgente") String dniAgente,
			@Param("fechaDesde") Date fechaDesde, @Param("fechaHasta") Date fechaHasta);
}