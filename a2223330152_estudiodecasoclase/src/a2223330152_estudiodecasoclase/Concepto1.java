package a2223330152_estudiodecasoclase;

public class Concepto1 {

	public String concepto;
	public String unidadmedida;
	public String precio;
	public String cantidad;
	
	public Concepto1(String concepto, String unidadmedida, double precio, double cantidad) {
		
		super();
		this.concepto = concepto;
		this.unidadmedida = unidadmedida;
		this.precio = String.valueOf(precio);
		this.cantidad = String.valueOf(cantidad);
	}
	
	public double getTotalconcepto() {
		return Double.parseDouble(this.cantidad) * Double.parseDouble(this.precio);
	}
	
	public String getMostrartotalconcepto() {
		String cadena = "El total del concepto " + this.concepto + " fue " + String.valueOf(getTotalconcepto());
		return cadena;
	}
}
