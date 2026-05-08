package model;

public class PlatosDelMenu {
	private String nombre;
	private Double precio;
	private Double costoProduccion;

	public PlatosDelMenu(String nombre, Double precio, Double costoProduccion) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.costoProduccion = costoProduccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getCostoProduccion() {
		return costoProduccion;
	}

	public void setCostoProduccion(Double costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

	@Override
	public String toString() {
		return "PlatosDelMenu [nombre=" + nombre + ", precio=" + precio + ", costoProduccion=" + costoProduccion + "]";
	}

}
