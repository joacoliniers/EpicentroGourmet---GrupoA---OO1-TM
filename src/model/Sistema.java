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
	public boolean agregarFestival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin,
			Costo costosFestival) {
		boolean agregado = false;

		int id = 1;
		if (!lstFestival.isEmpty()) {
			id = lstFestival.get(lstFestival.size() - 1).getIdFestival() + 1;
		}

		agregado = lstFestival.add(new Festival(id, nombre, temporada, fechaInicio, fechaFin, costosFestival));

		return agregado;
	}

	// agregarUnidadFoodTruck
	public boolean agregarUnidadFoodTruck(String nombre, Personal responsable, Double superficie,
			Long codigoUnicoUnidad, String patente, Boolean conexionElectrica) {
		boolean agregado = false;

		if (busqPorAtributoUnicoUnidad(codigoUnicoUnidad) == null) {
			FoodTruck unidad = new FoodTruck(nombre, responsable, superficie, codigoUnicoUnidad, patente,
					conexionElectrica);
			agregado = lstUnidades.add(unidad);
		}

		return agregado;
	}

	// agregarUnidadPuestoDesarmable
	public boolean agregarUnidadPuestoDesarmable(String nombre, Personal responsable, Double superficie,
			Long codigoUnicoUnidad, int cantCarpas, int tiempoMontaje) {
		boolean agregado = false;

		if (busqPorAtributoUnicoUnidad(codigoUnicoUnidad) == null) {
			PuestoDesarmable unidad = new PuestoDesarmable(nombre, responsable, superficie, codigoUnicoUnidad,
					cantCarpas, tiempoMontaje);
			agregado = lstUnidades.add(unidad);
		}

		return agregado;
	}

	// auditoriaPersonal
	public List<Personal> auditoriaPersonal(int idFestival) {
		List<Personal> personalAuditoria = new ArrayList<Personal>();

		Festival festival = busqPorAtributoUnicoFestival(idFestival);

		if (festival != null) {
			for (UnidadDeVenta unidad : festival.getLstUnidadDeVentas()) {

				// considera al responsable como parte del personal a auditar
				if (unidad.getResponsable() != null && !personalAuditoria.contains(unidad.getResponsable())) {
					personalAuditoria.add(unidad.getResponsable());
				}

				for (Personal personal : unidad.getLstPersonal()) {
					if (!personalAuditoria.contains(personal)) {
						personalAuditoria.add(personal);
					}
				}
			}
		}

		return personalAuditoria;
	}

	// unidadesConMayorCanon
	public ReporteMayoresCanon unidadesConMayorCanon(int idFestival) {
		ReporteMayoresCanon reporte = new ReporteMayoresCanon(null);
		Festival festival = this.busqPorAtributoUnicoFestival(idFestival);

		if (festival != null && !festival.getLstUnidadDeVentas().isEmpty()) {
			List<UnidadDeVenta> unidadesOrdenadas = new ArrayList<>(festival.getLstUnidadDeVentas());
			unidadesOrdenadas.sort((u1, u2) -> {
				try {
					double c1 = festival.calculoCanon(u1);
					double c2 = festival.calculoCanon(u2);
					return Double.compare(c2, c1);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					return 0;
				}
			});
			for (int i = 0; i < Math.min(3, unidadesOrdenadas.size()); i++) {
				reporte.getLstMasGastaron().add(unidadesOrdenadas.get(i));
			}
			if (!reporte.getLstMasGastaron().isEmpty()) {
				reporte.setUnidadesConMayorCanon(reporte.getLstMasGastaron().get(0));
			}
		}

		return reporte;
	}

	// agregarPersonal
	public boolean agregarCocinero(String nombre, String apellido, long dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, double sueldoBase, String especialidad, double plusFijo) {

		boolean retorno;

		if (this.busqPorAtributoUnicoPersonal(dni) != null) {
			retorno = false;

		} else {

			int id = 1;
			if (!lstPersonal.isEmpty()) {
				id = lstPersonal.getLast().getId() + 1;
			}

			Cocinero c = new Cocinero(id, nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase,
					especialidad, plusFijo);
			lstPersonal.add(c);
			retorno = true;
		}

		return retorno;
	}

	public boolean agregarCajero(String nombre, String apellido, long dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, double sueldoBase, String turno) {

		boolean retorno;

		if (this.busqPorAtributoUnicoPersonal(dni) != null) {
			retorno = false;

		} else {

			int id = 1;
			if (!lstPersonal.isEmpty()) {
				id = lstPersonal.getLast().getId() + 1;
			}

			Cajero c = new Cajero(id, nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase, turno);
			lstPersonal.add(c);
			retorno = true;
		}

		return retorno;
	}

	// eliminarEntidad
	public boolean eliminarEntidad(Festival festival) throws Exception {
		return this.lstFestival.remove(this.busqPorAtributoUnicoFestival(festival.getIdFestival()));
	}

	public boolean eliminarEntidad(UnidadDeVenta unidad) throws Exception {
		return this.lstUnidades.remove(this.busqPorAtributoUnicoUnidad(unidad.getCodigoUnico()));
	}

	public boolean eliminarEntidad(Personal personal) throws Exception {
		return this.lstPersonal.remove(this.busqPorAtributoUnicoPersonal(personal.getDni()));
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

	public Festival busqPorAtributoUnicoFestival(int idFestival) {
		Festival festivalABuscar = null;
		int i = 0;
		while (i < lstFestival.size() && festivalABuscar == null) {
			if (lstFestival.get(i).getIdFestival() == idFestival) {
				festivalABuscar = lstFestival.get(i);
			}
			i++;
		}
		return festivalABuscar;
	}

	public boolean abrirPedido(int idFestival, long codUnidad) {
		boolean bandera = false;

		Festival festival = busqPorAtributoUnicoFestival(idFestival);
		UnidadDeVenta unidad = festival.busqUnidadDeVentaPorId(codUnidad);

		if (unidad == null || festival == null) {
			bandera = false;
		} else {
			unidad.agregarPedido(LocalDate.now(), festival);
			bandera = true;
		}

		return bandera;
	}

	public boolean agregarItemAPedido(int idFestival, long codigoUnicoUnidad, long codPedido, String nombrePlato,
			int cantidad) {
		boolean bandera = false;

		Festival festival = busqPorAtributoUnicoFestival(idFestival);
		UnidadDeVenta unidad = festival.busqUnidadDeVentaPorId(codigoUnicoUnidad);

		Pedido pedidoExistente = unidad.traerPedido(codPedido);
		PlatosDelMenu platoPedido = unidad.traerPlato(nombrePlato);
		
		if(pedidoExistente != null || platoPedido != null) {
			bandera = pedidoExistente.agregarDetallePedido(platoPedido, cantidad);
		} 
		
		return bandera;
	}

}
