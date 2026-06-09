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
		
		try {
			sistema.agregarFestival("Lollapalooza", "2026", LocalDate.of(2026, 3, 12), LocalDate.of(2026, 3, 14), costos);
			sistema.agregarCocinero("Juan", "Perez", 12345678L, LocalDate.of(1990, 1, 1), LocalDate.of(2020, 1, 1), 50000.0, "Italiana", 2000.0);
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

//			// test de unidadesConMayorCanon
			sistema.agregarUnidadFoodTruck("Food Truck C", responsable, 55.0, 1003L, "CD300XX", false);
			sistema.agregarUnidadPuestoDesarmable("Food Truck D", responsable, 48.0, 1004L, 2, 50);
			
			festival.getLstUnidadDeVentas().add(sistema.busqPorAtributoUnicoUnidad(1003L));
			festival.getLstUnidadDeVentas().add(sistema.busqPorAtributoUnicoUnidad(1004L));

			ReporteMayoresCanon reporte = sistema.unidadesConMayorCanon(1);
			System.out.println("\nUnidades con mayor canon (mayor a menor):");
			for (UnidadDeVenta u : reporte.getLstMasGastaron()) {
				double canon = festival.calculoCanon(u);
				System.out.println("\t" + u.getNombre() + " - Canon: $" + canon);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
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

		for(Pedido p : sistema.busqPorAtributoUnicoUnidad(1001).getLstPedidos()) {
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
