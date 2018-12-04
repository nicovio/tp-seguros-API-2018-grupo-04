package seguros.exception;

@SuppressWarnings("all")
public class Validaciones {

	public static void validarCambioEstado(Long id_estado) throws Exception {
		int idAnulado = 3;
		int idFinalizado = 4;

		if (id_estado == idAnulado || id_estado == idFinalizado) {
			throw new CambioDeEstadoNoPermitidoException();
		}
	}
}
