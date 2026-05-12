package test;

import java.time.LocalDate;
import java.util.List;

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
			
			Personal responsable = sistema.getLstPersonal().get(0);
			sistema.agregarUnidad("Food Truck A", responsable, 50.0, 1001L);
			sistema.agregarUnidad("Food Truck B", responsable, 60.0, 1002L);
			
			Festival festival = sistema.getLstFestival().get(0);
			festival.getLstUnidadDeVentas().add(sistema.busqPorAtributoUnicoUnidad(1001L));
			festival.getLstUnidadDeVentas().add(sistema.busqPorAtributoUnicoUnidad(1002L));
			
			List<Personal> personalAuditoria = sistema.auditoriaPersonal(1);
			System.out.println("Personal auditado en " + sistema.getLstFestival().get(0).getNombre() + ": " + personalAuditoria);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

}
