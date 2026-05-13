package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class UnidadDeVenta {

	private String nombre;
	private Personal responsable;
	private double superficie;
	private long codigoUnico;
	private List<PlatosDelMenu> lstPlatos;
	private List<Personal> lstPersonal;
	private List<Pedido> lstPedidos;

	public UnidadDeVenta(String nombre, Personal responsable, double superficie, long codigoUnico) {
		super();
		this.nombre = nombre;
		this.responsable = responsable;
		this.superficie = superficie;
		this.codigoUnico = codigoUnico;
		this.lstPedidos = new ArrayList<Pedido>();
		this.lstPersonal = new ArrayList<Personal>();
		this.lstPlatos = new ArrayList<PlatosDelMenu>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Personal getResponsable() {
		return responsable;
	}

	public void setResponsable(Personal responsable) {
		this.responsable = responsable;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public long getCodigoUnico() {
		return codigoUnico;
	}

	public void setCodigoUnico(long codigoUnico) {
		this.codigoUnico = codigoUnico;
	}

	public List<PlatosDelMenu> getLstPlatos() {
		return lstPlatos;
	}

	public void setLstPlatos(List<PlatosDelMenu> lstPlatos) {
		this.lstPlatos = lstPlatos;
	}

	public List<Personal> getLstPersonal() {
		return lstPersonal;
	}

	public void setLstPersonal(List<Personal> lstPersonal) {
		this.lstPersonal = lstPersonal;
	}

	public List<Pedido> getLstPedidos() {
		return lstPedidos;
	}

	public void setLstPedidos(List<Pedido> lstPedidos) {
		this.lstPedidos = lstPedidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoUnico, lstPedidos, lstPersonal, lstPlatos, nombre, responsable, superficie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadDeVenta other = (UnidadDeVenta) obj;
		return codigoUnico == other.codigoUnico && Objects.equals(lstPedidos, other.lstPedidos)
				&& Objects.equals(lstPersonal, other.lstPersonal) && Objects.equals(lstPlatos, other.lstPlatos)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(responsable, other.responsable)
				&& Double.doubleToLongBits(superficie) == Double.doubleToLongBits(other.superficie);
	}

	@Override
	public String toString() {
		return "UnidadDeVenta [nombre=" + nombre + ", responsable=" + responsable + ", superficie=" + superficie
				+ ", codigoUnico=" + codigoUnico + ", lstPlatos=" + lstPlatos + ", lstPersonal=" + lstPersonal
				+ ", lstPedidos=" + lstPedidos + "]";
	}
	

	public abstract Double calculoCanon();

}
