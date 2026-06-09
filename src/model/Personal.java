package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Personal {
	
	private int id;
	private String nombre;
	private String apellido;
	private long dni;
	private LocalDate fechaNacimiento;
	private LocalDate fechaIngreso;
	private Double sueldoBase;
	
	public Personal(int id, String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			Double sueldoBase) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.sueldoBase = sueldoBase;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(Double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	@Override
	public String toString() {
		return "Personal [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaNacimiento="
				+ fechaNacimiento + ", fechaIngreso=" + fechaIngreso + ", sueldoBase=" + sueldoBase + "]";
	}
	
	abstract double liquidacionHaberes();
	
	public int calculoAnosAntiguedad() {
	    
	    LocalDate hoy = LocalDate.now();
	    LocalDate ingreso = this.getFechaIngreso();
	    
	    return Period.between(ingreso, hoy).getYears();
	}
}
