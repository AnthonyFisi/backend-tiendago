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
	
	private int idempresa;

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

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	
	
	

}
