package model;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Personal> lstPersonal;
	private List<Festival> lstFestival;
	private List<UnidadDeVenta> lstUnidades;
	private double rendimientoEconomico;

	public Sistema(double rendimientoEconomico) {
		super();
		this.lstPersonal = new ArrayList<Personal>();
		this.lstFestival = new ArrayList<Festival>();
		this.lstUnidades = new ArrayList<UnidadDeVenta>();
		this.rendimientoEconomico = rendimientoEconomico;
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
	
	// agregarUnidad
	
	// agregarPersonal
	
	// eliminarFestival
	
	// eliminarEntidad
	
	// busquedaPorAtributo
	
	

}
