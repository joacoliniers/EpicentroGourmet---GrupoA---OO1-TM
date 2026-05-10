package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sistema {
	
	private List<Personal>lstPersonal;
	private List<Festival>lstFestival;
	private List<UnidadDeVenta>lstUnidades;
	private double rendimientoEconomico;
	
	public Sistema(double rendimientoEconomico) {
		super();
		this.lstFestival = new ArrayList<Festival>();
		this.lstPersonal = new ArrayList<Personal>();
		this.lstUnidades = new ArrayList<UnidadDeVenta>();
		this.rendimientoEconomico = rendimientoEconomico;
	}

	public List<Personal> getLstPersonal() {
		return lstPersonal;
	}

	public void setLstPersonal(List<Personal> lstPersonal) {
		this.lstPersonal = lstPersonal;
	}

	public List<Festival> getLstFestival() {
		return lstFestival;
	}

	public void setLstFestival(List<Festival> lstFestival) {
		this.lstFestival = lstFestival;
	}

	public List<UnidadDeVenta> getLstUnidades() {
		return lstUnidades;
	}

	public void setLstUnidades(List<UnidadDeVenta> lstUnidades) {
		this.lstUnidades = lstUnidades;
	}

	public double getRendimientoEconomico() {
		return rendimientoEconomico;
	}

	public void setRendimientoEconomico(double rendimientoEconomico) {
		this.rendimientoEconomico = rendimientoEconomico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lstFestival, lstPersonal, lstUnidades, rendimientoEconomico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sistema other = (Sistema) obj;
		return Objects.equals(lstFestival, other.lstFestival) && Objects.equals(lstPersonal, other.lstPersonal)
				&& Objects.equals(lstUnidades, other.lstUnidades)
				&& Double.doubleToLongBits(rendimientoEconomico) == Double.doubleToLongBits(other.rendimientoEconomico);
	}

	@Override
	public String toString() {
		return "Sistema [lstPersonal=" + lstPersonal + ", lstFestival=" + lstFestival + ", lstUnidades=" + lstUnidades
				+ ", rendimientoEconomico=" + rendimientoEconomico + "]";
	}
	
	
	public Personal busqPorAtributoUnicoPersonal(long dni) {
		
		Personal p = null;
		
		if(!lstPersonal.isEmpty()) {
			
			int i = 0;
			boolean encontrado = false;
			
			while(i<lstPersonal.size() && !encontrado) {
				
				if(lstPersonal.get(i).getDni() == dni) {
					
					p = lstPersonal.get(i);
					encontrado = true;
					
				}else {
					
					i++;
				}
			}
			
		}
		
		return p;
	}
	
	public boolean agregarPersonal(String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, double sueldoBase) {
		
		boolean retorno = false;
		
		if(lstPersonal.isEmpty()) {
			
			int id = 1;
			
			Personal p = new Personal(id, nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase);
			lstPersonal.add(p);
			retorno = true;
		}else {
			
			int i = 0;
			boolean encontrado = false;
			
			while(i<lstPersonal.size() && !encontrado) {
				
				if(this.busqPorAtributoUnicoPersonal(dni) != null) {
					
					encontrado = true;
				}else {
					
					i++;
				}
			}
			
			if(!encontrado) {
				
				int id = lstPersonal.getLast().getId();
				
				Personal p = new Personal(id + 1, nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase);
				lstPersonal.add(p);
				retorno = true;
			}
		}
		
		return retorno;
	}
	
	public UnidadDeVenta busqPorAtributoUnicoUnidad(long codigoUnico) {
		
		UnidadDeVenta u = null;
		
		if(!lstUnidades.isEmpty()) {
			
			int i = 0;
			boolean encontrado = false;
			
			while(i<lstUnidades.size() && !encontrado) {
				
				if(lstUnidades.get(i).getCodigoUnico() == codigoUnico) {
					
					u = lstUnidades.get(i);
					encontrado = true;
					
				}else {
					
					i++;
				}
			}
			
		}
		
		return u; 
	}
	

}
