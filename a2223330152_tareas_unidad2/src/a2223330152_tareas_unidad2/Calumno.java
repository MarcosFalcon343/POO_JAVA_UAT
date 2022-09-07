package a2223330152_tareas_unidad2;

public class Calumno {
	
	private String matricula;
	private String nombre;
	private int calif;
	
	public Calumno(String nombre, String matricula, int calficacion) {
		this.nombre = nombre;
		this.matricula = matricula;
		this.calif = calficacion;
	}
	
	public int getCalificacion() {
		return this.calif;
	}

	@Override
	public String toString() {
		return "Alumno [matricula=" + matricula + ", nombre=" + nombre + ", calif=" + calif + "]";
	}
	

}
