package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReporteVenta {
	
	private UnidadDeVenta unidadDeVenta;
	private double recaudacionTotal;
	
	public ReporteVenta(UnidadDeVenta unidadDeVenta, double recaudacionTotal) {
		super();
		this.unidadDeVenta = unidadDeVenta;
		this.recaudacionTotal = recaudacionTotal;
	}
	
	public UnidadDeVenta getUnidadDeVenta() {
		return unidadDeVenta;
	}
	public void setUnidadDeVenta(UnidadDeVenta unidadDeVenta) {
		this.unidadDeVenta = unidadDeVenta;
	}
	public double getRecaudacionTotal() {
		return recaudacionTotal;
	}
	public void setRecaudacionTotal(double recaudacionTotal) {
		this.recaudacionTotal = recaudacionTotal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(recaudacionTotal, unidadDeVenta);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReporteVenta other = (ReporteVenta) obj;
		return Double.doubleToLongBits(recaudacionTotal) == Double.doubleToLongBits(other.recaudacionTotal)
				&& Objects.equals(unidadDeVenta, other.unidadDeVenta);
	}
	
	@Override
	public String toString() {
		return "ReporteVenta [unidadDeVenta=" + unidadDeVenta + ", recaudacionTotal=" + recaudacionTotal + "]";
	}
	
	

}
