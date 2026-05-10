package model;

import java.time.LocalDate;

public class Cocinero extends Personal{
	private String turno;

	public Cocinero(int id, String nombre, String apellido, long dni, LocalDate fechaNacimineto, LocalDate fechaIngreso,
			Double sueldoBase, String turno) {
		super(id, nombre, apellido, dni, fechaNacimineto, fechaIngreso, sueldoBase);
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
		return "Cocinero [turno=" + turno + "]";
	}
}
