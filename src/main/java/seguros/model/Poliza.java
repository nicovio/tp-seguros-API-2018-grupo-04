package seguros.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "poliza")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
//        allowGetters = true)

public class Poliza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date fecha_inicio;

	private Date fecha_fin;

	private Float prima;

	private Float porcentaje_de_comision;

	private int id_estado;

	private String Tipo;

	public Long getId() {
		return id;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public Float getPrima() {
		return prima;
	}

	public Float getPorcentaje_de_comision() {
		return porcentaje_de_comision;
	}

	public int getId_estado() {
		return id_estado;
	}
	
	public void setId_estado(int id_estado) {
		this.id_estado = id_estado;
	}
	
	public String getTipo() {
		return Tipo;
	}

}