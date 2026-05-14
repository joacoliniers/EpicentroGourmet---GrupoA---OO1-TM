package test;

import java.time.LocalDate;
import java.util.List;

import model.Festival;
import model.Personal;
import model.ReporteMayoresCanon;
import model.Sistema;
import model.UnidadDeVenta;

public class SistemaTest {

	public static void main(String[] args) {

		Sistema sistema = new Sistema(200.0);
		try {
			sistema.agregarFestival("Lollapalooza", "2026", LocalDate.of(2026, 3, 12), LocalDate.of(2026, 3, 14));
			sistema.agregarPersonal("Lucas", "Murakoshi", 11111111, LocalDate.of(2004, 4, 20),
					LocalDate.of(2017, 10, 1), 100000000d);

			Personal responsable = sistema.getLstPersonal().get(0);
			sistema.agregarUnidadFoodTruck("Food Truck A", responsable, 50.0, 1001L, "AB200XX", true);
			sistema.agregarUnidadPuestoDesarmable("Food Truck B", responsable, 60.0, 1002L, 3, 90);

			System.out.println("Lista de Unidades de Venta:");
			for (UnidadDeVenta u : sistema.getLstUnidades()) {
				System.out.println("	" + u);
			}

			Festival festival = sistema.getLstFestival().get(0);
			festival.getLstUnidadDeVentas().add(sistema.busqPorAtributoUnicoUnidad(1001L));
			festival.getLstUnidadDeVentas().add(sistema.busqPorAtributoUnicoUnidad(1002L));

			List<Personal> personalAuditoria = sistema.auditoriaPersonal(1);
			System.out.println("\nPersonal auditado en " + sistema.getLstFestival().get(0).getNombre() + ":\n "
					+ "\t" + personalAuditoria);

			// test de unidadesConMayorCanon
			sistema.agregarUnidadFoodTruck("Food Truck C", responsable, 55.0, 1003L, "CD300XX", false);
			sistema.agregarUnidadPuestoDesarmable("Food Truck D", responsable, 48.0, 1004L, 2, 50);

			festival.getLstUnidadDeVentas().add(sistema.busqPorAtributoUnicoUnidad(1003L));
			festival.getLstUnidadDeVentas().add(sistema.busqPorAtributoUnicoUnidad(1004L));

			ReporteMayoresCanon reporte = sistema.unidadesConMayorCanon(1);
			System.out.println("\nUnidades con mayor canon (mayor a menor):");
			for (UnidadDeVenta u : reporte.getLstMasGastaron()) {
				System.out.println("\t" + u.getNombre() + " - Canon: $" + u.calculoCanon());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
