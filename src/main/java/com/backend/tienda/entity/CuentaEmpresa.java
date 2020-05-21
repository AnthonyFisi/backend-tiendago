package com.backend.tienda.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cuentaempresa")
public class CuentaEmpresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcuentaempresa", updatable = false, nullable = false)
	private int idcuentaempresa;
	
	private int idtipocuenta;
	
	private boolean cuentaactiva;
	
	private Timestamp fecha_registrocuenta;
	
	private Timestamp fecha_vencimiento;
	
	private float montoabonado;
	
	private String detallecuenta;
	
	private int idusuario;

	public int getIdcuentaempresa() {
		return idcuentaempresa;
	}

	public void setIdcuentaempresa(int idcuentaempresa) {
		this.idcuentaempresa = idcuentaempresa;
	}

	public int getIdtipocuenta() {
		return idtipocuenta;
	}

	public void setIdtipocuenta(int idtipocuenta) {
		this.idtipocuenta = idtipocuenta;
	}

	public boolean isCuentaactiva() {
		return cuentaactiva;
	}

	public void setCuentaactiva(boolean cuentaactiva) {
		this.cuentaactiva = cuentaactiva;
	}

	public Timestamp getFecha_registrocuenta() {
		return fecha_registrocuenta;
	}

	public void setFecha_registrocuenta(Timestamp fecha_registrocuenta) {
		this.fecha_registrocuenta = fecha_registrocuenta;
	}

	public Timestamp getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Timestamp fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public float getMontoabonado() {
		return montoabonado;
	}

	public void setMontoabonado(float montoabonado) {
		this.montoabonado = montoabonado;
	}

	public String getDetallecuenta() {
		return detallecuenta;
	}

	public void setDetallecuenta(String detallecuenta) {
		this.detallecuenta = detallecuenta;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (cuentaactiva ? 1231 : 1237);
		result = prime * result + ((detallecuenta == null) ? 0 : detallecuenta.hashCode());
		result = prime * result + ((fecha_registrocuenta == null) ? 0 : fecha_registrocuenta.hashCode());
		result = prime * result + ((fecha_vencimiento == null) ? 0 : fecha_vencimiento.hashCode());
		result = prime * result + idcuentaempresa;
		result = prime * result + idtipocuenta;
		result = prime * result + idusuario;
		result = prime * result + Float.floatToIntBits(montoabonado);
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
		CuentaEmpresa other = (CuentaEmpresa) obj;
		if (cuentaactiva != other.cuentaactiva)
			return false;
		if (detallecuenta == null) {
			if (other.detallecuenta != null)
				return false;
		} else if (!detallecuenta.equals(other.detallecuenta))
			return false;
		if (fecha_registrocuenta == null) {
			if (other.fecha_registrocuenta != null)
				return false;
		} else if (!fecha_registrocuenta.equals(other.fecha_registrocuenta))
			return false;
		if (fecha_vencimiento == null) {
			if (other.fecha_vencimiento != null)
				return false;
		} else if (!fecha_vencimiento.equals(other.fecha_vencimiento))
			return false;
		if (idcuentaempresa != other.idcuentaempresa)
			return false;
		if (idtipocuenta != other.idtipocuenta)
			return false;
		if (idusuario != other.idusuario)
			return false;
		if (Float.floatToIntBits(montoabonado) != Float.floatToIntBits(other.montoabonado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CuentaEmpresa [idcuentaempresa=" + idcuentaempresa + ", idtipocuenta=" + idtipocuenta
				+ ", cuentaactiva=" + cuentaactiva + ", fecha_registrocuenta=" + fecha_registrocuenta
				+ ", fecha_vencimiento=" + fecha_vencimiento + ", montoabonado=" + montoabonado + ", detallecuenta="
				+ detallecuenta + ", idusuario=" + idusuario + "]";
	}
	
	

}
