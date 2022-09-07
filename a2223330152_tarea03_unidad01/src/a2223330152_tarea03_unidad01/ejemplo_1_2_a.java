package a2223330152_tarea03_unidad01;

public class ejemplo_1_2_a {
	public static void main(String args[]) {
		Cpersona cantante1, cantante2, actor1;
		
		cantante1 = new Cpersona("Jose Alfredo Jimenez","canta");
		actor1 = new Cpersona("Joaquín Cosío Osuna","actua");
		cantante2 = new Cpersona("Pedro Infante","canta");
		//cantante2.nombre="José Pedro Infante Cruz";
		//cantante2.actividad="Canta Amorcito corazon";
		System.out.println(cantante1.toString());
		System.out.println(cantante2.toString());
		System.out.println(actor1.toString());
	}
}
