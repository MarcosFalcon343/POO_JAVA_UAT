package a2223330152_Tarea06_Unidad2_JAVA;

public class Alumnos {
	 private String nombre;
     private double calificacion;
     private char aula;
     public Alumnos(String _nombre, double _calificacion, char _aula)
     {
         if (_calificacion > 10)
         {
             calificacion = 10;
         }
         else if (_calificacion < 0)
         {
             calificacion = 0;
         }
         else
         {
             calificacion = _calificacion;
         }
         nombre = _nombre;
         aula = _aula;
     }
     public String getNombre()
     {
         return nombre;
     }
     public double getCalificacion()
     {
         return calificacion;
     }
     public char getAula()
     {
         return aula;
     }
}
