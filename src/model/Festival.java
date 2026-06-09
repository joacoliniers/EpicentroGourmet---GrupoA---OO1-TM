package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Festival {
	private int idFestival;
	private String nombre;
	private String temporada;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Costo costosFestival;
	private List<UnidadDeVenta> lstUnidadDeVentas;

	public Festival(int idFestival, String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin, Costo costosFestival) {
		super();
		this.idFestival = idFestival;
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costosFestival = costosFestival;
		this.lstUnidadDeVentas = new ArrayList<UnidadDeVenta>();
	}

	public int getIdFestival() {
		return idFestival;
	}

	public void setIdFestival(int idFestival) {
		this.idFestival = idFestival;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<UnidadDeVenta> getLstUnidadDeVentas() {
		return lstUnidadDeVentas;
	}
	
	public Costo getCostosFestival() {
		return costosFestival;
	}

	@Override
	public String toString() {
		return "Festival [idFestival=" + idFestival + ", nombre=" + nombre + ", temporada=" + temporada
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", lstUnidadDeVentas=" + lstUnidadDeVentas
				+ "]";
	}
	
	
	public Double calculoCanon(UnidadDeVenta u) throws Exception{
		
		if(u == null) {
			throw new Exception("ERROR: Unidad de venta no encontrada");
		}
		
		double canon = 0;
		if(u instanceof FoodTruck) {
			FoodTruck f = (FoodTruck) u;
			double costoConexion = 0;
			
			if(f.isConexionElectrica()) {
				costoConexion = this.costosFestival.getPlusElectricidad();
			}
			canon = (u.getSuperficie() * this.costosFestival.getCostoMontaje() + costoConexion);
					
		} else {
			PuestoDesarmable p = (PuestoDesarmable) u;
			canon = (u.getSuperficie() * this.costosFestival.getCostoSuperficie()) - (p.getTiempoMontaje() * this.costosFestival.getCostoMontaje());
		}
		return canon;
	}
	
	public UnidadDeVenta busqUnidadDeVentaPorId(long codigoUnicoUnidad) {
		UnidadDeVenta unidadBuscada = null;
		int i = 0;
		while (i < lstUnidadDeVentas.size() && unidadBuscada == null) {
			if (lstUnidadDeVentas.get(i).getCodigoUnico() == codigoUnicoUnidad) {
				unidadBuscada = lstUnidadDeVentas.get(i);
			}
			i++;
		}
		return unidadBuscada;
	}

	public PlatosDelMenu platoEstrella(UnidadDeVenta unidad) {
		PlatosDelMenu platoEstrella = null;
		int maxContador = 0;

		if (unidad != null) {
			for (PlatosDelMenu plato : unidad.getLstPlatos()) {
				int contador = unidad.contarPedidosDelPlato(plato, this.idFestival);
				if (contador > maxContador) {
					maxContador = contador;
					platoEstrella = plato;
				}
			}
		}

		return platoEstrella;
	}

}
