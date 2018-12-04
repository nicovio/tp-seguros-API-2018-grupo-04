package seguros.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import seguros.exception.CambioDeEstadoNoPermitidoException;
import seguros.exception.Validaciones;

@Entity
@Table(name = "poliza")
@EntityListeners(AuditingEntityListener.class)

public class Poliza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate fecha_inicio;

	private LocalDate fecha_fin;

	private Float prima;

	private Float porcentaje_de_comision;

	private Long id_estado;

	private String Tipo;

	public Long getId() {
		return id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_estado", insertable = false, updatable = false)
	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public LocalDate getFecha_inicio() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fecha = LocalDate.parse(fecha_inicio.toString(), df);
		return fecha;
	}

	public LocalDate getFecha_fin() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fecha = LocalDate.parse(fecha_fin.toString(), df);
		return fecha;
	}

	public Float getPrima() {
		return prima;
	}

	public Float getPorcentaje_de_comision() {
		return porcentaje_de_comision;
	}

	public Long getId_estado() {
		return id_estado;
	}

	public void cambiarEstado(Long id_estado) throws Exception {
		Validaciones.validarCambioEstado(this.id_estado);
		this.id_estado = id_estado;
	}

	public String getTipo() {
		return Tipo;
	}

}