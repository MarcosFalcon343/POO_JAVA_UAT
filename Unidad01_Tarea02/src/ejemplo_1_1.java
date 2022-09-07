public class ejemplo_1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cpersona cantante1, cantante2, actor1;
		
		cantante1 = new Cpersona("Jose Alfredo Jimenez","canta");
		actor1 = new Cpersona("Joaquín Cosío Osuna","actua");
		cantante2 = new Cpersona("Pedro Infante","canta");
		System.out.println(cantante1.toString());
		System.out.println(cantante2.toString());
		System.out.println(actor1.toString());
	}

}
