package com.backend.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="horario")
public class Horario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idhorario", updatable = false, nullable = false)
	private int idhorario;
	
	private String horario_nombre;
	
	private String comentario;
	
	private int horario_inicio;
	
	private int horario_fin;

	public int getIdhorario() {
		return idhorario;
	}

	public void setIdhorario(int idhorario) {
		this.idhorario = idhorario;
	}

	public String getHorario_nombre() {
		return horario_nombre;
	}

	public void setHorario_nombre(String horario_nombre) {
		this.horario_nombre = horario_nombre;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getHorario_inicio() {
		return horario_inicio;
	}

	public void setHorario_inicio(int horario_inicio) {
		this.horario_inicio = horario_inicio;
	}

	public int getHorario_fin() {
		return horario_fin;
	}

	public void setHorario_fin(int horario_fin) {
		this.horario_fin = horario_fin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + horario_fin;
		result = prime * result + horario_inicio;
		result = prime * result + ((horario_nombre == null) ? 0 : horario_nombre.hashCode());
		result = prime * result + idhorario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horario other = (Horario) obj;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (horario_fin != other.horario_fin)
			return false;
		if (horario_inicio != other.horario_inicio)
			return false;
		if (horario_nombre == null) {
			if (other.horario_nombre != null)
				return false;
		} else if (!horario_nombre.equals(other.horario_nombre))
			return false;
		if (idhorario != other.idhorario)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Horario [idhorario=" + idhorario + ", horario_nombre=" + horario_nombre + ", comentario=" + comentario
				+ ", horario_inicio=" + horario_inicio + ", horario_fin=" + horario_fin + "]";
	}
	
	
	
	

}
