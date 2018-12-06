package seguros.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@IdClass(CambioDeEstadoKey.class)
@Table(name = "cambio_de_estado")
@EntityListeners(AuditingEntityListener.class)

public class CambioDeEstado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_estado_anterior;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_estado_posterior;

	public Long getId_estado_anterior() {
		return id_estado_anterior;
	}

	public Long getId_estado_posterior() {
		return id_estado_posterior;
	}

}