package model;

import java.time.LocalDate;
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

	public Pedido agregarPedido(LocalDate fecha, Festival festival) {
		long codPedido = 1;

		if (!this.lstPedidos.isEmpty()) {
			codPedido = this.lstPedidos.getLast().getCodigoPedido() + 1;
		}

		Pedido nuevoPedido = new Pedido(fecha, festival, this, codPedido);
		this.lstPedidos.add(nuevoPedido);
		return nuevoPedido;
	}

	public PlatosDelMenu traerPlato(String nombre) {

		PlatosDelMenu plato = null;
		for (PlatosDelMenu p : this.lstPlatos) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				plato = p;
			}
		}

		return plato;
	}

	public boolean agregarPlatoDelMenu(String nombre, Double precio, Double costoProduccion) {
		boolean bandera = false;

		if (this.traerPlato(nombre) == null) {
			PlatosDelMenu nuevoPlato = new PlatosDelMenu(nombre, precio, costoProduccion);
			bandera = this.lstPlatos.add(nuevoPlato);

		}

		return bandera;
	}

	public Pedido traerPedido(long codPedido) {
		Pedido pedido = null;
		for (Pedido p : this.lstPedidos) {
			if (p.getCodigoPedido() == codPedido) {
				pedido = p;
			}
		}

		return pedido;
	}

	public double recaudacionTotal() {
		double total = 0.0;
		for (Pedido p : this.lstPedidos) {
			total += p.calcularTotalPedido();
		}

		return total;
	}

	public double recaudacionTotal(LocalDate fechaDesde, LocalDate fechaHasta) {
		double total = 0.0;
		for (Pedido p : this.lstPedidos) {
			if (p.estaEnRangoDeFechas(fechaDesde, fechaHasta)) {
				total += p.calcularTotalPedido();
			}
		}
		return total;
	}

	public double costoTotal() {
		double costo = 0.0;
		for (Pedido p : this.lstPedidos) {
			costo += p.calcularCostoPedido();
		}

		return costo;
	}

	public double costoTotal(LocalDate fechaDesde, LocalDate fechaHasta) {
		double costo = 0.0;
		for (Pedido p : this.lstPedidos) {
			if (p.estaEnRangoDeFechas(fechaDesde, fechaHasta)) {
				costo += p.calcularCostoPedido();
			}
		}
		return costo;
	}

	public int contarPedidosDelPlato(PlatosDelMenu plato, int idFestival) {
	    int cantidadTotalVendida = 0;
	    
	    for (Pedido pedido : this.lstPedidos) {
	        if (pedido.getFestival().getIdFestival() == idFestival) {
	            
	            cantidadTotalVendida += pedido.obtenerCantidadDePlato(plato); 
	        }
	    }
	    return cantidadTotalVendida;
	}

	public double calculoGananciaUnidad() {

		return this.recaudacionTotal() - this.costoTotal();
	}

	public double calculoGananciaUnidad(LocalDate fechaDesde, LocalDate fechaHasta) {

		return this.recaudacionTotal(fechaDesde, fechaHasta) - this.costoTotal(fechaDesde, fechaHasta);
	}

	public double calculoSueldos() {
	    double total = 0.0;

	    for (Personal p : this.lstPersonal) {
	        total += p.liquidacionHaberes();
	    }
	    
	    if (this.responsable != null) {
	        total += this.responsable.liquidacionHaberes();
	    }

	    return total;
	}
	
	public abstract double calcularCanon(Costo costosFestival);
}
