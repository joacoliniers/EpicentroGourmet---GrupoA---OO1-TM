package model;

import java.util.Objects;

public class PuestoDesarmable extends UnidadDeVenta{
	
	private int cantCarpas;
	private int tiempoMontaje;
	
	public PuestoDesarmable(String nombre, Personal responsable, double superficie, long codigoUnico, int cantCarpas,
			int tiempoMontaje) {
		super(nombre, responsable, superficie, codigoUnico);
		this.cantCarpas = cantCarpas;
		this.tiempoMontaje = tiempoMontaje;
	}
	

	public int getCantCarpas() {
		return cantCarpas;
	}



	public void setCantCarpas(int cantCarpas) {
		this.cantCarpas = cantCarpas;
	}



	public int getTiempoMontaje() {
		return tiempoMontaje;
	}



	public void setTiempoMontaje(int tiempoMontaje) {
		this.tiempoMontaje = tiempoMontaje;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cantCarpas, tiempoMontaje);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PuestoDesarmable other = (PuestoDesarmable) obj;
		return cantCarpas == other.cantCarpas && tiempoMontaje == other.tiempoMontaje;
	}

	@Override
	public String toString() {
		return "PuestoDesarmable [cantCarpas=" + cantCarpas + ", tiempoMontaje=" + tiempoMontaje + "]";
	}
	
	

}
