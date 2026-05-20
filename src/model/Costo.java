package model;

import java.util.Objects;

public class Costo {
	
	private double costoSuperficie;
	private double costoMontaje;
	private double plusElectricidad;
	
	public Costo(double costoSuperficie, double costoMontaje, double plusElectricidad) {
		super();
		this.costoSuperficie = costoSuperficie;
		this.costoMontaje = costoMontaje;
		this.plusElectricidad = plusElectricidad;
	}
	
	

	public double getCostoSuperficie() {
		return costoSuperficie;
	}



	public void setCostoSuperficie(double costoSuperficie) {
		this.costoSuperficie = costoSuperficie;
	}



	public double getCostoMontaje() {
		return costoMontaje;
	}



	public void setCostoMontaje(double costoMontaje) {
		this.costoMontaje = costoMontaje;
	}



	public double getPlusElectricidad() {
		return plusElectricidad;
	}



	public void setPlusElectricidad(double plusElectricidad) {
		this.plusElectricidad = plusElectricidad;
	}



	public double getSueldoBase() {
		return sueldoBase;
	}



	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}



	@Override
	public int hashCode() {
		return Objects.hash(costoMontaje, costoSuperficie, plusElectricidad, sueldoBase);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Costo other = (Costo) obj;
		return Double.doubleToLongBits(costoMontaje) == Double.doubleToLongBits(other.costoMontaje)
				&& Double.doubleToLongBits(costoSuperficie) == Double.doubleToLongBits(other.costoSuperficie)
				&& Double.doubleToLongBits(plusElectricidad) == Double.doubleToLongBits(other.plusElectricidad)
				&& Double.doubleToLongBits(sueldoBase) == Double.doubleToLongBits(other.sueldoBase);
	}



	@Override
	public String toString() {
		return "Costo [costoSuperficie=" + costoSuperficie + ", costoMontaje=" + costoMontaje + ", plusElectricidad="
				+ plusElectricidad + ", sueldoBase=" + sueldoBase + "]";
	}
	
	

}
