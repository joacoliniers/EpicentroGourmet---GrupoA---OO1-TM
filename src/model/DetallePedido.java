package model;

public class DetallePedido {
	private int idItem;
	private PlatosDelMenu plato;
	private int cantidad;

	public DetallePedido(int idItem, PlatosDelMenu plato, int cantidad) {
		super();
		this.idItem = idItem;
		this.plato = plato;
		this.cantidad = cantidad;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public PlatosDelMenu getPlato() {
		return plato;
	}

	public void setPlato(PlatosDelMenu plato) {
		this.plato = plato;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "DetallePedido [idItem=" + idItem + ", plato=" + plato + ", cantidad=" + cantidad + "]";
	}
}
