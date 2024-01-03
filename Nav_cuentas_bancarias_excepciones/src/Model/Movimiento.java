package Model;

import java.time.LocalDateTime;

import Service.TipoMovimiento;//enumracion con el tipo de extraccion o reduccion

//Cada movimiento se define por: cantidad, fechaHora, tipo 
public class Movimiento {
	private double cantidad;
	private LocalDateTime fechaHora;//clase especial para represnetar fechas horas
	private TipoMovimiento tipo;
	
	public Movimiento(double cantidad, LocalDateTime fechaHora, TipoMovimiento tipo) {
		
		this.cantidad = cantidad;
		this.fechaHora = fechaHora;
		this.tipo = tipo;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public TipoMovimiento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimiento tipo) {
		this.tipo = tipo;
	}
	

}
