package model;

import java.util.Objects;

public class FoodTruck extends UnidadDeVenta {

	private String patente;
	private boolean conexionElectrica;

	public FoodTruck(String nombre, Personal responsable, double superficie, long codigoUnico, String patente,
			boolean conexionElectrica) {

		super(nombre, responsable, superficie, codigoUnico);
		this.patente = patente;
		this.conexionElectrica = conexionElectrica;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public boolean isConexionElectrica() {
		return conexionElectrica;
	}

	public void setConexionElectrica(boolean conexionElectrica) {
		this.conexionElectrica = conexionElectrica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(conexionElectrica, patente);
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
		FoodTruck other = (FoodTruck) obj;
		return conexionElectrica == other.conexionElectrica && Objects.equals(patente, other.patente);
	}

	@Override
	public String toString() {
		return "FoodTruck [patente=" + patente + ", conexionElectrica=" + conexionElectrica + "]";
	}

//	Food Truck: (Superficie * $500) + $2000 si requiere conexión eléctrica.
	@Override
	public Double calculoCanon() {
		double canon = this.getSuperficie() * 500;
		if (this.conexionElectrica) {
			canon += 2000;
		}
		return canon;
	}
}
