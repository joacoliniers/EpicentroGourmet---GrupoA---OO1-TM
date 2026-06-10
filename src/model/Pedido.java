package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private LocalDate fechaTransacccion;
	private Festival festival;
	private UnidadDeVenta unidadDeVenta;
	private long codigoPedido;

	private List<DetallePedido> lstDetallePedido;

	public Pedido(LocalDate fechaTransacccion, Festival festival, UnidadDeVenta unidadDeVenta, Long codigoPedido) {
		super();
		this.fechaTransacccion = fechaTransacccion;
		this.festival = festival;
		this.unidadDeVenta = unidadDeVenta;
		this.codigoPedido = codigoPedido;

		this.lstDetallePedido = new ArrayList<DetallePedido>();
	}

	public LocalDate getFechaTransacccion() {
		return fechaTransacccion;
	}

	public void setFechaTransacccion(LocalDate fechaTransacccion) {
		this.fechaTransacccion = fechaTransacccion;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setIdFestival(Festival festival) {
		this.festival = festival;
	}

	public UnidadDeVenta getUnicoUnidad() {
		return unidadDeVenta;
	}

	public void setCodigoUnicoUnidad(UnidadDeVenta codigoUnicoUnidad) {
		this.unidadDeVenta = codigoUnicoUnidad;
	}

	public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public List<DetallePedido> getLstDetallePedido() {
    return lstDetallePedido;
}

	@Override
	public String toString() {
		return "Pedido codigoPedido=" + codigoPedido + " [fechaTransacccion=" + fechaTransacccion + ", festival="
				+ festival.getNombre() + " " + festival.getTemporada() + ", codigoUnicoUnidad="
				+ unidadDeVenta.getCodigoUnico() + " detalle= " + lstDetallePedido+ "]";
	}

	public boolean agregarDetallePedido(PlatosDelMenu plato, int cantidad) {
		int idItem = 1;

		if (!this.lstDetallePedido.isEmpty()) {
			idItem = this.lstDetallePedido.getLast().getIdItem() + 1;
		}

		DetallePedido nuevoDetalle = new DetallePedido(idItem, plato, cantidad);
		return this.lstDetallePedido.add(nuevoDetalle);
	}
	
	public double calcularTotalPedido() {
		double total = 0.0;
		for(DetallePedido d : this.lstDetallePedido) {
			total += d.getCantidad() * d.getPlato().getPrecio();
		}
		
		return total;
	}
	
	public double calcularCostoPedido() {
		double costo = 0.0;
		for(DetallePedido d : this.lstDetallePedido) {
			costo += d.getCantidad() * d.getPlato().getCostoProduccion();
		}
		
		return costo;
	}
	
	public boolean estaEnRangoDeFechas(LocalDate fechaDesde, LocalDate fechaHasta) {
	    return !this.fechaTransacccion.isBefore(fechaDesde) && !this.fechaTransacccion.isAfter(fechaHasta);
	}
	
	public int obtenerCantidadDePlato(PlatosDelMenu platoBuscado) {
	    
	    int cantidadVendida = 0;
	    
	    for (DetallePedido detalle : this.lstDetallePedido) {
	        
	        if (detalle.getPlato().getNombre().equalsIgnoreCase(platoBuscado.getNombre())) {
	            
	            cantidadVendida = detalle.getCantidad();
	            
	        }
	    }
	    
	    return cantidadVendida;
	}
	
}
