package test;

import java.time.LocalDate;

import model.Festival;
import model.Personal;
import model.Sistema;
import model.UnidadDeVenta;

public class SistemaTest {

	public static void main(String[] args) {
		
		Sistema sistema = new Sistema(200.0);
		try {
			sistema.agregarFestival("Lollapalooza", "2026", LocalDate.of(2026, 3, 12), LocalDate.of(2026, 3, 14));
			sistema.agregarPersonal("Lucas", "Murakoshi", 11111111,LocalDate.of(2004, 4, 20), LocalDate.of(2017, 10, 1) , 100000000d);
			for(Festival f : sistema.getLstFestival()) {
				System.out.println(f);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	
	}

}
