package model;

import java.time.LocalDate;

public class Cocinero extends Personal {
	private String especialidad;
	private Double plusFijo;

	public Cocinero(int id, String nombre, String apellido, long dni, LocalDate fechaNacimineto, LocalDate fechaIngreso,
			Double sueldoBase, String especialidad, Double plusFijo) {
		super(id, nombre, apellido, dni, fechaNacimineto, fechaIngreso, sueldoBase);
		this.especialidad = especialidad;
		this.plusFijo = plusFijo;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Double getPlusFijo() {
		return plusFijo;
	}

	public void setPlusFijo(Double plusFijo) {
		this.plusFijo = plusFijo;
	}

	@Override
	public String toString() {
		return "Cajero [especialidad=" + especialidad + ", plusFijo=" + plusFijo + "]";
	}
}
