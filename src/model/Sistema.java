package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Personal> lstPersonal;
	private List<Festival> lstFestival;
	private List<UnidadDeVenta> lstUnidades;
	private double rendimientoEconomico;

	public Sistema() {
		super();
		this.lstPersonal = new ArrayList<Personal>();
		this.lstFestival = new ArrayList<Festival>();
		this.lstUnidades = new ArrayList<UnidadDeVenta>();
	}

	public double getRendimientoEconomico() {
		return rendimientoEconomico;
	}

	public void setRendimientoEconomico(double rendimientoEconomico) {
		this.rendimientoEconomico = rendimientoEconomico;
	}

	public List<Personal> getLstPersonal() {
		return lstPersonal;
	}

	public List<Festival> getLstFestival() {
		return lstFestival;
	}

	public List<UnidadDeVenta> getLstUnidades() {
		return lstUnidades;
	}

	@Override
	public String toString() {
		return "Sistema [lstPersonal=" + lstPersonal + ", lstFestival=" + lstFestival + ", lstUnidades=" + lstUnidades
				+ ", rendimientoEconomico=" + rendimientoEconomico + "]";
	}
	
	
	// agregarFestival
	public boolean agregarFestival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFinal) {
		return false;
	}
	
	// agregarUnidad
	public boolean agregarUnidad(String nombre, Personal responsable, Double superficie, Long codigoUnicoUnidad) {
		return false;
	}
	
	// agregarPersonal
	
	// eliminarFestival
	
	// eliminarEntidad
	public boolean eliminarEntidad(Festival festival) throws Exception {
		
		if(this.lstFestival.isEmpty()) {
			throw new Exception("Lista Festival vacia");
		}
		
		boolean bandera = false;
		int i = 0;
		while(!bandera && i < this.lstFestival.size()) {
			if(this.lstFestival.get(i).getIdFestival() == festival.getIdFestival()) {
				bandera = true;
			} else {
				i++;
			}
		}
		
		Festival f = this.lstFestival.get(i);
		return this.lstFestival.remove(f);
	}
	
public boolean eliminarEntidad(UnidadDeVenta unidad) throws Exception {
		
		if(this.lstUnidades.isEmpty()) {
			throw new Exception("Lista Unidades vacia");
		}
		
		boolean bandera = false;
		int i = 0;
		while(!bandera && i < this.lstUnidades.size()) {
			if(this.lstUnidades.get(i).getCodigoUnico() == unidad.getCodigoUnico()) {
				bandera = true;
			} else {
				i++;
			}
		}
		
		UnidadDeVenta u = this.lstUnidades.get(i);
		return this.lstUnidades.remove(u);
	}


	public boolean eliminarEntidad(Personal personal) throws Exception {
		
		if(this.lstPersonal.isEmpty()) {
			throw new Exception("Lista Personal vacia");
		}
		
		boolean bandera = false;
		int i = 0;
		while(!bandera && i < this.lstPersonal.size()) {
			if(this.lstPersonal.get(i).getDni() == personal.getDni()) {
				bandera = true;
			} else {
				i++;
			}
		}
		
		Personal p = this.lstPersonal.get(i);
		return this.lstPersonal.remove(p);
	}
	
	// busquedaPorAtributo
	
	

}
