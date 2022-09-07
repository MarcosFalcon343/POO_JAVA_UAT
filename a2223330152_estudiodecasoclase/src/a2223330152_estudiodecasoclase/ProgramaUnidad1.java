package a2223330152_estudiodecasoclase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ProgramaUnidad1 {
	
	static Concepto1 listaconceptos[][];
	static Proyecto1 proyecto;
	static double sumassegmento[];
	static int posmanodeobra, posmaquinaria, posmateriales, posservicios;
	static double subtotal;
	
	public static void inicializar() throws NumberFormatException, IOException{

		double incremento, iva, margenganancia;
		BufferedReader entrada;
		
		sumassegmento = new double[4];
		listaconceptos = new Concepto1[4][3];
		posmateriales = -1;
		posmaquinaria = -1;
		posservicios = -1;
		posmanodeobra = -1;
		
		entrada = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(" Introduce porcentaje de IVA ");
		iva = Double.parseDouble(entrada.readLine());
		System.out.println(" Introduce el porcentaje incremento de precios ");
		incremento = Double.parseDouble(entrada.readLine());
		System.out.println(" Introduce el margen de ganancia ");
		margenganancia = Double.parseDouble(entrada.readLine());
		
		proyecto = new Proyecto1(iva, incremento, margenganancia);
		
	}

	public static void capturarconceptos(int n, String textoc, int pos) throws IOException{
		BufferedReader entrada;
		String concepto,umedida;
		double precio,cantidad;
		Concepto1 nodo;
		
		entrada = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce el concepto " + (pos + 1) + " de " + textoc);
		concepto = entrada.readLine();
		System.out.println("Introduce la unidad de medida de " + concepto);
		umedida = entrada.readLine();
		System.out.println("Introduce el precio " + concepto);
		precio = Double.parseDouble(entrada.readLine());
		System.out.println("Introduce la cantidad " + concepto);
		cantidad = Double.parseDouble(entrada.readLine());
		nodo = new Concepto1(concepto,umedida,precio,cantidad);
		listaconceptos[n][pos] = nodo;
	}
	
	public static void subtotales(int pos, String textoc, int tipo) {
		int ciclo;
		double sumas;
		Concepto1 nodo;
		sumas = 0;
		for(ciclo = 0;  ciclo <= 3; ciclo++) 
			if(ciclo <= pos) {
				nodo = listaconceptos[tipo][ciclo];
				System.out.println(nodo.getMostrartotalconcepto());
				sumas = sumas + nodo.getTotalconcepto();
			}
			
			if ((ciclo >-1)) {
				sumassegmento[tipo] = sumas;
				subtotal = subtotal + sumassegmento[tipo];
				System.out.println("El total del " + textoc + " fue ---->  " + sumassegmento[tipo]);
			}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		double subtotalobra,tiva,total;
		String op;
		int opmenu;
		BufferedReader entrada;
		
		entrada = new BufferedReader(new InputStreamReader(System.in));
		inicializar();
		opmenu = 0;
		while((opmenu != 6)) {
			System.out.println("1.- Material ");
			System.out.println("2.- Mano de obra ");
			System.out.println("3.- Maquinaria ");
			System.out.println("4.- Servicios ");
			System.out.println("5.- Reporte ");
			System.out.println("6.- Salida ");
			System.out.println("Que opcion deseas [1...6]");
			
			opmenu = Integer.parseInt(entrada.readLine());
			
			switch(opmenu) {
				case 1:
					op = "s";
					while ((posmateriales < 2) && ((op.equals("s")) || (op.equals("S")))){
						System.out.print("Deseas agregar concepto de material [S/N]");
						op = entrada.readLine();
						if((op.equals("S")) || (op.equals("s"))) {
							posmateriales = posmateriales+ 1;
							capturarconceptos(0,"Maerial",posmateriales);
						}
					}
					break;
				
				case 2:
					op = "s";
					while((posmanodeobra < 2) && ((op.equals("s")) || (op.equals("S")))) {
						System.out.println("Deseas agregar concepto de material [S/N]");
						op = entrada.readLine();
						if((op.equals("S")) || (op.equals("s"))) {
							posmanodeobra++;
							capturarconceptos(1,"Mano de Obra",posmanodeobra);
						}
					}
					break;
				
				case 3:
					op = "s";
					while((posmanodeobra < 2) && ((op.equals("s")) || (op.equals("S")))) {
						System.out.println("Deseas agregar concepto de maquinaria [S/N]");
						op = entrada.readLine();
						if((op.equals("S")) || (op.equals("s"))) {
							posmaquinaria++;
							capturarconceptos(2,"Maquinaria",posmaquinaria);
						}
					}
					break;
					
				case 4:
					op = "s";
					while((posmanodeobra < 2) && ((op.equals("s")) || (op.equals("S")))) {
						System.out.println("Deseas agregar concepto de servicio [S/N]");
						op = entrada.readLine();
						if((op.equals("S")) || (op.equals("s"))) {
							posservicios++;
							capturarconceptos(3,"Servicios",posservicios);
						}
					}
					break;
				
				case 5:
					subtotal = 0;
					subtotales(posmateriales,"Materiales",0);
					subtotales(posmanodeobra,"Mano de obra",1);
					subtotales(posmaquinaria,"Maquinaria",2);
					subtotales(posservicios,"Servicios",3);
					System.out.println("El subtotal de la obra fue--->  " + subtotal);
					tiva = (subtotal * (proyecto.getIva())/100);
					System.out.println("El IVA de la obra fue--->  " + tiva);
					subtotalobra = subtotal + tiva;
					System.out.println("El subtotal de la obra con iva fue--->  " + subtotalobra);
					total = (subtotalobra * (proyecto.genInflacion()/100)) + (subtotalobra * (proyecto.genMargenganancia()/100)) + subtotalobra;
					System.out.println("El total de la obra es --->  " + total);
					break;
			}
		}
		
		
	}
}
