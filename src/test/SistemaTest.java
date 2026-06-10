package test;

import java.time.LocalDate;
import java.util.List;

import model.Costo;
import model.Festival;
import model.Pedido;
import model.Personal;
import model.ReporteMayoresCanon;
import model.Sistema;
import model.UnidadDeVenta;

public class SistemaTest {

	public static void main(String[] args) {

		Sistema sistema = new Sistema(200.0);
		Costo costos = new Costo(500.0, 10.0, 2000.0);
		Costo costos2 = new Costo(800.0, 40.0, 4000.0);

		System.out.println("1. Altas y Bajas.\n");
		sistema.agregarFestival("Unlapalooza", "2026", LocalDate.of(2026, 3, 12), LocalDate.of(2026, 3, 14), costos);
		sistema.agregarFestival("Unlapalooza", "2027", LocalDate.of(2027, 3, 12), LocalDate.of(2027, 3, 14), costos2);
		sistema.agregarCocinero("Juan", "Perez", 12345678L, LocalDate.of(1990, 1, 1), LocalDate.of(2020, 1, 1), 50000.0,
				"Italiana", 2000.0);
		sistema.agregarUnidadFoodTruck("Food Truck A", sistema.busqPorAtributoUnicoPersonal(12345678L), 50.0, 1001L, "AB200XX", true);
		sistema.agregarUnidadPuestoDesarmable("Food Truck B", sistema.busqPorAtributoUnicoPersonal(12345678L), 60.0, 1002L, 3, 90);
		sistema.agregarUnidadFoodTruck("Food Truck C", sistema.busqPorAtributoUnicoPersonal(12345678L), 55.0, 1003L, "CD300XX", false);
		sistema.agregarUnidadPuestoDesarmable("Food Truck D", sistema.busqPorAtributoUnicoPersonal(12345678L), 48.0, 1004L, 2, 50);
		System.out.println("Unidades de Venta agregadas:");
		for (UnidadDeVenta u : sistema.getLstUnidades()) {
			System.out.println("	" + u);
		}
		/* REVISAR PORQUE NO IMPRIME AL PERSONAL CORRECTAMENTE
		 * System.out.println("Personal agregado:");
		for (Personal p : sistema.getLstPersonal()) {
			System.out.println("	" + p);
		}*/
		System.out.println("Festivales agregados:");
		for (Festival f : sistema.getLstFestival()) {
			System.out.println("	" + f);
		}
		System.out.println("\n2. Búsqueda por Atributo Único.\n");
		System.out.println("Busco el festival con id 1:");
		System.out.println(sistema.busqPorAtributoUnicoFestival(1));
		/* REVISAR PORQUE NO IMPRIME AL PERSONAL CORRECTAMENTE
		 * System.out.println("\nBusco al personal con dni 12345678L:");
		System.out.println(sistema.busqPorAtributoUnicoPersonal(12345678L));*/
		System.out.println("\nBusco a la Unidad con codigo 1001L:");
		System.out.println(sistema.busqPorAtributoUnicoUnidad(1001L));

		Festival festival = sistema.getLstFestival().get(0);
		festival.getLstUnidadDeVentas().add(sistema.busqPorAtributoUnicoUnidad(1001L));
		festival.getLstUnidadDeVentas().add(sistema.busqPorAtributoUnicoUnidad(1002L));

		List<Personal> personalAuditoria = sistema.auditoriaPersonal(1);
		System.out.println("\nPersonal auditado en " + sistema.getLstFestival().get(0).getNombre() + ":\n " + "\t"
				+ personalAuditoria);

//			// test de unidadesConMayorCanon
		

		festival.getLstUnidadDeVentas().add(sistema.busqPorAtributoUnicoUnidad(1003L));
		festival.getLstUnidadDeVentas().add(sistema.busqPorAtributoUnicoUnidad(1004L));

		ReporteMayoresCanon reporte = sistema.unidadesConMayorCanon(1);
		System.out.println("\nUnidades con mayor canon (mayor a menor):");
		for (UnidadDeVenta u : reporte.getLstMasGastaron()) {
			try {
				double canon = festival.calculoCanon(u);
				System.out.println("\t" + u.getNombre() + " - Canon: $" + canon);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println("");
		sistema.busqPorAtributoUnicoUnidad(1001).agregarPlatoDelMenu("Hamburguesa Completa", 12000.0, 5500.0);
		sistema.busqPorAtributoUnicoUnidad(1001).agregarPlatoDelMenu("Super Pancho", 12000.0, 5500.0);
		sistema.busqPorAtributoUnicoUnidad(1002L).agregarPlatoDelMenu("Gaseosa", 3000.0, 1000.0);
		sistema.busqPorAtributoUnicoUnidad(1003L).agregarPlatoDelMenu("Papas Fritas", 6000.0, 2500.0);
		sistema.busqPorAtributoUnicoUnidad(1004L).agregarPlatoDelMenu("Choripan", 8000.0, 3500.0);

		sistema.abrirPedido(1, 1001);
		sistema.agregarItemAPedido(1, 1001, 1L, "HambUrguesa CoMPleta", 2);
		sistema.agregarItemAPedido(1, 1001, 1L, "super pancho", 2);

		sistema.abrirPedido(1, 1001);
		sistema.agregarItemAPedido(1, 1001, 2L, "super pancho", 5);

		sistema.abrirPedido(1, 1002L);
		sistema.agregarItemAPedido(1, 1002L, 1L, "gaseosa", 2);

		sistema.abrirPedido(1, 1003L);
		sistema.agregarItemAPedido(1, 1003L, 1L, "papas fritas", 4);

		sistema.abrirPedido(1, 1004L);
		sistema.agregarItemAPedido(1, 1004L, 1L, "choripan", 1);

		for (Pedido p : sistema.busqPorAtributoUnicoUnidad(1001).getLstPedidos()) {
			System.out.println(p);
		}

		System.out.println(sistema.reporteRecaudacion(1));
		for (UnidadDeVenta u : sistema.rankingUnidades()) {
			System.out.println("	" + u);
		}

		System.out.println(sistema.filtroPersonal(LocalDate.of(2019, 1, 12), LocalDate.of(2022, 1, 1)));

		// test platoEstrella
		System.out.println("\n--- Test Plato Estrella ---");

		model.PlatosDelMenu estrella = sistema.platoEstrella(1001L, 1);
		System.out.println("Plato estrella de unidad 1001: " + estrella);

		model.PlatosDelMenu estrellaVacia = sistema.platoEstrella(1002L, 1);
		System.out.println("Plato estrella de unidad 1002 (un solo pedido): " + estrellaVacia);

		model.PlatosDelMenu estrellaNull = sistema.platoEstrella(9999L, 1);
		System.out.println("Plato estrella de unidad inexistente: " + estrellaNull);

		model.PlatosDelMenu estrellaFestivalNull = sistema.platoEstrella(1001L, 99);
		System.out.println("Plato estrella con festival inexistente: " + estrellaFestivalNull);
	}

}
