package seguros.model;

public interface Reporte {
	
	String getTipo();
	
	int getId_estado();

	String getEstado();

	int getCantidad();

	Float getValor_prima();
}
