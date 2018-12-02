package seguros.model;

import java.util.Date;

public class CriteriosReporte {

	private Date fechaDesde;
	private Date fechaHasta;
	private String dniAgente;

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public String getDniAgente() {
		return dniAgente;
	}
}
