package model;

import java.time.LocalDate;

public class Cajero extends Personal {

	private String turno;

	public Cajero(int id, String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			Double sueldoBase, String turno) {
		super(id, nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase);
		this.turno = turno;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
	    return super.toString() + " - Cajero [turno=" + turno + "]";
	}
	
	public double liquidacionHaberes() {
		
		return this.getSueldoBase() + (this.calcularAntiguedad().getYears() * 5000);
	}
}
