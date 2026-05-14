package arrayPrecipitacionAnual;
import java.util.Arrays;
import java.util.Scanner;
public class TestPrecipAnual {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PrecipitacionAnual listaPrecip = new PrecipitacionAnual();
		
		//Carga precipitaciones de los 12 meses con cargarPrecipActual
		for(int i=0; i<12; i++) {
			System.out.println("Cargue la precipitacion del mes " + (i+1) + ": ");
			double precipitacion = scan.nextDouble();
			listaPrecip.cargarPrecipActual(precipitacion);
		}
		
		//Mostrar resultados iniciales
		System.out.println("Promedio precipitaciones actual: " + listaPrecip.calcularPromedioActual());
		
		System.out.println("Promedio de precipitaciones anual: " + listaPrecip.calcularPromedioAnual());
		
		System.out.println("Desvios de precipitaciones anual: " + Arrays.toString(listaPrecip.calcularListaDesvios()));
		
		//Corregir un mes especifico con cargarPrecipMes
		System.out.println("\nCoregimos el valor del mes 5 (mayo). Ingrese nuevo valor: ");
		double nvoValor = scan.nextDouble();
		listaPrecip.cargarPrecipMes(4, nvoValor);
		
		//Mostrar resultados despues de la corrección
		System.out.println("Promedio precipitaciones actual (con correcion): " + listaPrecip.calcularPromedioActual());
		
		System.out.println("Promedio de precipitaciones anual (con correcion): " + listaPrecip.calcularPromedioAnual());
		
		System.out.println("Desvios de precipitaciones anual (con correcion): " + Arrays.toString(listaPrecip.calcularListaDesvios()));
		
		//Mostrar mes mas lluvioso
		System.out.println("Mes mas lluvioso: " + listaPrecip.mesMasLluvioso());
		
		//Mostrar mes menos lluvioso
		System.out.println("Mes menos lluvioso: " + listaPrecip.mesMenosLluvioso());
		scan.close();
	}

}
