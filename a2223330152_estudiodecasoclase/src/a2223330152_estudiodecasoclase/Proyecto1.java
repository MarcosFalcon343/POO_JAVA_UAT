package a2223330152_estudiodecasoclase;

public class Proyecto1 {

	public String iva;
	public String inflacion;
	public String margenganencia;
	
	public double getIva() {
		return Double.parseDouble(this.iva);
	}
	
	public double genInflacion() {
		return Double.parseDouble(inflacion);
	}
	
	public double genMargenganancia() {
		return Double.parseDouble(margenganencia);
	}
	
	public Proyecto1(double iva, double inflacion, double margenganancia) {
		
		this.iva = String.valueOf(iva);
		this.inflacion = String.valueOf(inflacion);
		this.margenganencia = String.valueOf(margenganancia);
	}
}
