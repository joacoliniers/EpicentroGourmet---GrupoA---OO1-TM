package model;

import java.time.LocalDate;

public class Pedido {
	private LocalDate fechaTransacccion;
	private Festival idFestival;
	private UnidadDeVenta codigoUnicoUnidad;
	private Long codigoPedido;

	public Pedido(LocalDate fechaTransacccion, Festival idFestival, UnidadDeVenta codigoUnicoUnidad,
			Long codigoPedido) {
		super();
		this.fechaTransacccion = fechaTransacccion;
		this.idFestival = idFestival;
		this.codigoUnicoUnidad = codigoUnicoUnidad;
		this.codigoPedido = codigoPedido;
	}

	public LocalDate getFechaTransacccion() {
		return fechaTransacccion;
	}

	public void setFechaTransacccion(LocalDate fechaTransacccion) {
		this.fechaTransacccion = fechaTransacccion;
	}

	public Festival getIdFestival() {
		return idFestival ;
	}

	public void setIdFestival(Festival idFestival) {
		this.idFestival = idFestival;
	}

	public UnidadDeVenta getCodigoUnicoUnidad() {
		return codigoUnicoUnidad;
	}

	public void setCodigoUnicoUnidad(UnidadDeVenta codigoUnicoUnidad) {
		this.codigoUnicoUnidad = codigoUnicoUnidad;
	}

	public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	@Override
	public String toString() {
		return "Pedido [fechaTransacccion=" + fechaTransacccion + ", idFestival=" + idFestival + ", codigoUnicoUnidad="
				+ codigoUnicoUnidad + ", codigoPedido=" + codigoPedido + "]";
	}

}
