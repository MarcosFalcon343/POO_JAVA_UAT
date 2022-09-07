package tienda;
import java.util.Scanner;
import java.lang.Integer;

public class Principal {

	//MATRICES
	private static String[][] articulos = {
			{"ID","PRODUCTO"},
			{"1","Mouse"},
			{"2","Teclado"},
			{"3","Monitor"},
			{"4","Fuente de Alimentacion"},
			{"5","Tarjeta Madre"},
			{"6","Memoria RAM"},
			{"7","Disco Duro HDD 1TB"},
			{"8","Discro Duro SDD 500GB"},
			{"9","Tarjeta Grafica"},
			{"10","Audifonos"}
	};
	private static String[][] productos= {
		{"ID","PRECIO"},
		{"1","150"},
		{"2","500"},
		{"3","1500"},
		{"4","1000"},
		{"5","700"},
		{"6","300"},
		{"7","500"},
		{"8","1000"},
		{"9","3000"},
		{"10","500"}
	};
	private static String [][] venta = new String[11][3];
	private static String [][] ventaDia = new String[11][2];

	//VARIABLES
	private static int opcion, fila, opcionVenta;
	private static float totalProducto, precio;
	private static String idProducto, cantidad;
	private static boolean correct = false;


	//METODOS
	public static void main(String[] args) {
		titles();
		Inicializar();
	}

	private static void clearVenta(int a, int b, String[][] matriz){
		for (int i = 1; i < a; i++) {
			for (int j = 0; j < b; j++){
				if(matriz[i][j] != null){
					matriz[i][j] = null;
				}
			}//Fin for j 
		}//Fin for i
	}

	private static void registrarVentaDia(float ventaT){
		boolean check = false;
		int i = 1;
		while(check !=  true || i > 10 ) {
			if(ventaDia[i][0] == null && ventaDia[i][1] == null){
				ventaDia[i][0] = String.valueOf(i);;
				ventaDia[i][1] = String.valueOf(ventaT);
				check = true;

			}else {
				i++;
			}
		}

		if(i <= 10 && check == true){
			System.out.println("LA VENTA SE FINALIZO CORRECTAMENTE");
		}else{
			System.out.println("LA VENTA NO SE FINALIZO CORRECTAMENTE :(");
		}
	}//FIN registrarVentaDia

	private static void finalizarVenta(){
		float totalVenta = 0;
		for (int i = 1; i < 11; i++){
			if(venta[i][0] != null && venta[i][1] != null && venta[i][2] != null){
				totalVenta = totalVenta + Float.parseFloat(venta[i][2]);
			}
		}

		if(totalVenta != 0){
		System.out.println("La venta fue de: $" + totalVenta);
		registrarVentaDia(totalVenta);
		clearVenta(10,3,venta);
		}else {
			System.out.println("La venta NO finalizo correctamente");
		}
		System.out.println("MENU PRINCIPAL");
	}//FIN finalizarVenta

	private static void Inicializar() {
		while(opcion != 4){
			System.out.println("MENU PRINCIPAL");
			System.out.println("Opciones:");
			System.out.println("1:	Venta");
			System.out.println("2:	Reporte de venta");
			System.out.println("3:	Listados Articulos, Produtos");
			System.out.println("4:	Fin");
			System.out.print("Opcion....: ");
			Scanner sc = new Scanner(System.in);
			opcion = sc.nextInt();

			switch(opcion){
				case 1:
					ventaMenu();
					break;
				case 2:
					mostrarMatriz(11,2,ventaDia);
					break;
				case 3:
					mostrarArtPro();
					break;
			}
		}
		System.out.println("FIN DEL PROGRAMA");
	}//Fin Inicializar

	private static void ventaMenu(){
		while(opcionVenta != 3){
				System.out.println("");
				System.out.println("MENU DE VENTA");
				System.out.println("Opciones:");
				System.out.println("1:	Mostrar Tabla de Venta");
				System.out.println("2:	Agregar Venta");
				System.out.println("3:	Finalizar Venta");
				System.out.print("Opcion....: ");
				Scanner sc = new Scanner(System.in);
				opcionVenta = sc.nextInt();

				switch(opcionVenta){
					case 1:
						mostrarMatriz(11,3,venta);
						break;
					case 2:
						registrarVenta();
						break;
					case 3:
						finalizarVenta();
						break;
				}
			}
		opcionVenta = 0;
	}//FIN ventaMenu

	private static void registrarVenta(){
		fila = 1;
		correct = false;
		while(correct != true || fila > 10){
			if(venta[fila][0] == null && venta[fila][1] == null && venta[fila][2] == null){;
				System.out.print("INGRESE EL ID DEL PRODUCTO...:");
				Scanner sc = new Scanner(System.in);
				idProducto = sc.nextLine();
				venta[fila][0] = idProducto;
				
				System.out.print("INGRESE LA CANTIDAD DEL PRODUCTO...:");
				cantidad = sc.nextLine();
				venta[fila][1] = cantidad;

				precio = obtenerPrecio(11, idProducto, productos);
				totalProducto =  Integer.parseInt(venta[fila][1]) * precio;
				venta[fila][2] =  String.valueOf(totalProducto);


				correct = true;
			}else{
				fila++;
			}
		}

		if(fila < 10 && correct == true){
			System.out.println("LA VENTA SE GUARDO CORRECTAMENTE");
			System.out.println("");
		}else{
			System.out.println("LA VENTA NO SE GUARDO CORRECTAMENTE :(");
			System.out.println("");
		}
	}//FIN registrarVenta

	private static int obtenerPrecio(int a, String elemento, String[][] matriz){
		int devolver = 0;
		
		for(int i = 0; i < a; i++){
			if(matriz[i][0].equals(elemento)){
				devolver = Integer.parseInt(matriz[i][1]);
				return devolver;
			}
		}
		return devolver;
	}//Fin obtenerPrecio

	private static void mostrarArtPro(){
		System.out.println("ARTICULOS");
		mostrarMatriz(11,2,articulos);
		System.out.println("");
		System.out.println("PRODUCTOS");
		mostrarMatriz(11,2,productos);
		System.out.println("");
	}//FIN mostrarArtPro

	private static void mostrarMatriz(int a, int b, String[][] matriz){
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++){
				if(matriz[i][j] != null){
					System.out.print("[");
					System.out.print(matriz[i][j]);
					System.out.print("]");
				}
			}//Fin for j 
			System.out.println("");
		}//Fin for i
	}//Fin de mostrarMatriz

	private static void titles(){
		venta[0][0] = "ID PRODUCTO";
		venta[0][1] = "CANTIDAD";
		venta[0][2] = "TOTAL";
		
		ventaDia[0][0] = "ID VENTA";
		ventaDia[0][1] = "Total";
	}//FIN titles

}
