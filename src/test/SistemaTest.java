package test;

import java.time.LocalDate;

import model.Festival;
import model.Personal;
import model.Sistema;
import model.UnidadDeVenta;

public class SistemaTest {

	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		Festival f = new Festival(1, "test", "test", LocalDate.of(2026, 1, 1), LocalDate.of(2026, 2, 1));
		Personal p = new Personal(1, "Lucas", "Murakoshi", 11111111, LocalDate.of(2004, 4, 20), LocalDate.of(2017, 10, 1), 100000000d);
		UnidadDeVenta u = new UnidadDeVenta("Panchos Ricki", p , 100.00, 111111);
		
		try {
			System.out.println(sistema.eliminarEntidad(f));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(sistema.eliminarEntidad(p));
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(sistema.eliminarEntidad(u));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
