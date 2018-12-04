package seguros.exception;

public class CambioDeEstadoNoPermitidoException extends Exception{
	public void mensajeError() {
		System.out.println("No se puede cambiar un estado final");
	}
}
