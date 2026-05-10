package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sistema {

	private List<Personal> lstPersonal;
	private List<Festival> lstFestival;
	private List<UnidadDeVenta> lstUnidades;
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

	// agregarFestival
	public boolean agregarFestival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFinal) {
		return false;
	}

	// agregarUnidad
	public boolean agregarUnidad(String nombre, Personal responsable, Double superficie, Long codigoUnicoUnidad) {
		return false;
	}

	// agregarPersonal
	public boolean agregarPersonal(String nombre, String apellido, long dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, double sueldoBase) {

		boolean retorno = false;

		if (lstPersonal.isEmpty()) {

			int id = 1;

			Personal p = new Personal(id, nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase);
			lstPersonal.add(p);
			retorno = true;
		} else {

			int i = 0;
			boolean encontrado = false;

			while (i < lstPersonal.size() && !encontrado) {

				if (this.busqPorAtributoUnicoPersonal(dni) != null) {

					encontrado = true;
				} else {

					i++;
				}
			}

			if (!encontrado) {

				int id = lstPersonal.getLast().getId();

				Personal p = new Personal(id + 1, nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase);
				lstPersonal.add(p);
				retorno = true;
			}
		}

		return retorno;
	}
	// eliminarFestival

	// eliminarEntidad
	public boolean eliminarEntidad(Festival festival) throws Exception {

		if (this.lstFestival.isEmpty()) {
			throw new Exception("Lista Festival vacia");
		}

		boolean bandera = false;
		int i = 0;
		while (!bandera && i < this.lstFestival.size()) {
			if (this.lstFestival.get(i).getIdFestival() == festival.getIdFestival()) {
				bandera = true;
			} else {
				i++;
			}
		}

		Festival f = this.lstFestival.get(i);
		return this.lstFestival.remove(f);
	}

	public boolean eliminarEntidad(UnidadDeVenta unidad) throws Exception {

		if (this.lstUnidades.isEmpty()) {
			throw new Exception("Lista Unidades vacia");
		}

		boolean bandera = false;
		int i = 0;
		while (!bandera && i < this.lstUnidades.size()) {
			if (this.lstUnidades.get(i).getCodigoUnico() == unidad.getCodigoUnico()) {
				bandera = true;
			} else {
				i++;
			}
		}

		UnidadDeVenta u = this.lstUnidades.get(i);
		return this.lstUnidades.remove(u);
	}

	public boolean eliminarEntidad(Personal personal) throws Exception {

		if (this.lstPersonal.isEmpty()) {
			throw new Exception("Lista Personal vacia");
		}

		boolean bandera = false;
		int i = 0;
		while (!bandera && i < this.lstPersonal.size()) {
			if (this.lstPersonal.get(i).getDni() == personal.getDni()) {
				bandera = true;
			} else {
				i++;
			}
		}

		Personal p = this.lstPersonal.get(i);
		return this.lstPersonal.remove(p);
	}

	// busquedaPorAtributo

	public UnidadDeVenta busqPorAtributoUnicoUnidad(long codigoUnico) {

		UnidadDeVenta u = null;

		if (!lstUnidades.isEmpty()) {

			int i = 0;
			boolean encontrado = false;

			while (i < lstUnidades.size() && !encontrado) {

				if (lstUnidades.get(i).getCodigoUnico() == codigoUnico) {

					u = lstUnidades.get(i);
					encontrado = true;

				} else {

					i++;
				}
			}

		}

		return u;
	}

	public Personal busqPorAtributoUnicoPersonal(long dni) {

		Personal p = null;

		if (!lstPersonal.isEmpty()) {

			int i = 0;
			boolean encontrado = false;

			while (i < lstPersonal.size() && !encontrado) {

				if (lstPersonal.get(i).getDni() == dni) {

					p = lstPersonal.get(i);
					encontrado = true;

				} else {

					i++;
				}
			}

		}

		return p;
	}

}
