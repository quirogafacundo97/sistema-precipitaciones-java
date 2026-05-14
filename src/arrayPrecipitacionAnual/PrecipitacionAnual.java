package arrayPrecipitacionAnual;

public class PrecipitacionAnual {
	private double [] listaPrecipitaciones;
	private int indiceACargar;
	private String [] meses =  {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
	
	public PrecipitacionAnual() {
		listaPrecipitaciones = new double[12];
		indiceACargar = 0;
	}
	
	//Metodo para cargar precipitacion del mes actual
	public void cargarPrecipActual(double valor) {
		if(indiceACargar < listaPrecipitaciones.length) {
			listaPrecipitaciones[indiceACargar] = valor;
			indiceACargar++;
		}
		else {
			System.out.println("Ya se cargaron los 12 meses");
		}
		
	}
	
	//Metodo para cargar precipitacion de un mes especifico
	public void cargarPrecipMes(int indice, double valor) {
		if(indice>0 && indice< listaPrecipitaciones.length) {
			listaPrecipitaciones[indice] = valor;
		}
		else {
			System.out.println("Indice invalido");
		}
	}
	
	//Metodo para calcular promedio de precipitaciones actual
	public double calcularPromedioActual()	{
		if(indiceACargar==0) {
			return 0;
		}
		double sum = 0;
		for (int i=0; i<indiceACargar; i++) {
			sum+= listaPrecipitaciones[i];
		}
		
		double promedio = sum / indiceACargar;
		
		return promedio;
	}
	
	//Metodo para calcular promedio de precipitaciones anual
	public double calcularPromedioAnual() {
		double sum = 0;
		for(int i = 0; i<listaPrecipitaciones.length; i++) {
			sum+= listaPrecipitaciones[i];
		}
		
		double promedio = sum / listaPrecipitaciones.length;
		
		return promedio;
	}
	
	//Metodo para calcular los devios de precipitaciones de cada mes
	public double[] calcularListaDesvios(){
		double[] listaDesvios = new double[12];
		
		double promedioAnual = calcularPromedioAnual();
		
		for(int i=0; i<listaPrecipitaciones.length; i++) {
			listaDesvios[i] = listaPrecipitaciones[i] - promedioAnual;
		}
		
		return listaDesvios;
	}
	
	//Metodo para conocer el mes mas lluvioso
	public String mesMasLluvioso() {
		double may = listaPrecipitaciones[0];
		int pos = 0;
		for(int i = 1; i<listaPrecipitaciones.length; i++) {
			if(listaPrecipitaciones[i] > may) {
				may = listaPrecipitaciones[i];
				pos = i;
			}
		}
		return meses[pos] + " con " + may + " mm";
	}
	
	//Metodo para conocer el mes menos lluvioso
	public String mesMenosLluvioso() {
		double men = listaPrecipitaciones[0];
		int pos = 0;
		for(int i = 1; i<listaPrecipitaciones.length; i++) {
			if(listaPrecipitaciones[i] < men) {
				men = listaPrecipitaciones[i];
				pos = i;
			}
		}
		return meses[pos] + " con " + men + " mm";
	}
}
