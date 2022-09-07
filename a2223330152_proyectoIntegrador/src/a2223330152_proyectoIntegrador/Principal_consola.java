package a2223330152_proyectoIntegrador;

import java.io. BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text. SimpleDateFormat;
import java.util.Date;

public class Principal_consola {
	static String productos[][];
	static String ventas[][];
	static int posventas=-1;
	static int tamventas=100;
	static String fecha;
	
	public static String rellenarespacios(String dato, int tamano) { 
		String cadena;
		cadena=dato;
		for(int ciclo=dato.length()-1;ciclo<tamano;ciclo++) 
			cadena=cadena+" ";
		return cadena;
	}
	
	public static String mostrarmenu(String[] opciones) {
		String cadena=""; 
		for(String info: opciones)
			cadena=cadena+info+"\n";
			cadena=cadena+"Que opcion deseas";
		return cadena;
	
	}

	public static boolean evaluarnumerico(String dato, int tipo) {
		boolean valido=true;
		try {
			switch (tipo) {
				case 1 : {int x = Integer.parseInt(dato); }break;
				case 2 : {double x = Double.parseDouble(dato); };break;
			}
		}
		catch (NumberFormatException e){valido=false;}
		return valido;
	}

	public static String leer(String texto) {
		String cadena = "";
		try {
			cadena = dialogo(texto);
			if(cadena!= null) cadena = cadena.trim();
		}
		catch(Exception e) {
			cadena = null;
		}
		return cadena;
	}

	public static String dialogo(String texto) throws IOException{
		String cadena;
		System.out.println(texto + " : ");
		BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
		cadena = lectura.readLine();
		return cadena;
	}
	
	public static String desplegarMenu(String Titulo1, String[] menu) throws IOException{
		String cadena;
		System.out.println(Titulo1+"\n"+"\n");
		for(int ciclo=0; ciclo < menu.length; ciclo++) {
			System.out.println(menu[ciclo]);
		}
		cadena = dialogo("\n Que opcion deseas");
		return cadena;
	}
	
	public static String leer(String texto, int tipo) {
		String cadena = "";
		try {
			cadena = dialogo(texto);
			if(cadena != null) {
				cadena = cadena.trim();
				if((tipo == 1) || (tipo==2)) if(!evaluarnumerico(cadena,tipo)) cadena = null;
			}
		}
		catch(Exception e) {
			cadena = null;
		}
		return cadena;
	}
	


}
