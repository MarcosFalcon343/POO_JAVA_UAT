package a2223330152_Tarea06_Unidad2_JAVA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class program {

	
	 public static void main(String[] args) throws NumberFormatException, IOException
	    {
		    BufferedReader entrada;
		    entrada = new BufferedReader(new InputStreamReader(System.in));
		    
	        System.out.println("Humano ingresa la cantidad de alumnos");
			int cantidadAlumnos = Integer. parseInt(entrada.readLine());
	        Alumnos[] a = new Alumnos[cantidadAlumnos];
	        for (int i = 0; i < cantidadAlumnos; i++)
	        {
	            System.out.println("Humano ingresa el NOMBRE del alumno " + (i + 1));
	            String nombre = entrada.readLine();
	            System.out.println("Humano ingresa la CALIFICACION del alumno " + (i + 1));
	            double calificacion = Double.parseDouble(entrada.readLine());
	            System.out.println("Humano ingresa el AULA del alumno " + (i + 1));
	            String Aula = entrada.readLine();
	            char aula = Aula.charAt(0);
	            a[i] = new Alumnos(nombre, calificacion, aula);
	        }

	        double suma = 0;
	        double promedio = 0;
	        int cantidadAlumnosSalon = 0;
	        System.out.println("Humano de que AULA quieres promediar las calificaciones");
	        String Salon = entrada.readLine();
	        char salon = Salon.charAt(0);
	        for (int i = 0; i < cantidadAlumnos; i++)
	        {
	            if (salon == a[i].getAula())
	            {
	                suma = suma + a[i].getCalificacion();
	                cantidadAlumnosSalon++;
	            }
	        }
	        promedio = suma / cantidadAlumnosSalon;
	        System.out.println("El promedio de los alumnos del salon " + salon + " es " + promedio);
	    }

}
