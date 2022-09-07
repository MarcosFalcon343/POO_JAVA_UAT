package a2223330152_tareas_unidad2;
import java.util.Random;
public class principal {

	public static String[] nombres = {"Marcos","Andrea","Carlos","Karla","Melisa","Abril","Eduardo","Humberto","Adriana","Lucia"};
	static Random random = new Random();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cmateria materia = new Cmateria("Matematicas",10);
		
		System.out.println("Materia: " + materia.getMateria());
		
		for(int i = 0; i < 10; i++) {
			materia.setAlumno(nombres[i], String.valueOf(random.nextInt(100+1)+1), random.nextInt(10+1)+1, i);
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.println(materia.datoAlumno(i) + "\n");
		}
		
		System.out.println("El promedio grupal es: " + materia.promedio(10));
		
	}

}
