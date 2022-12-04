package beans;

public class PrestamoDTO {
	private String codUsuario, estadoPrestamo;
	private int numPrestamo, numSolicitud;
	private double deudaPrestamo;
	public String getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getEstadoPrestamo() {
		return estadoPrestamo;
	}
	public void setEstadoPrestamo(String estadoPrestamo) {
		this.estadoPrestamo = estadoPrestamo;
	}
	public int getNumPrestamo() {
		return numPrestamo;
	}
	public void setNumPrestamo(int numPrestamo) {
		this.numPrestamo = numPrestamo;
	}
	public int getNumSolicitud() {
		return numSolicitud;
	}
	public void setNumSolicitud(int numSolicitud) {
		this.numSolicitud = numSolicitud;
	}
	public double getDeudaPrestamo() {
		return deudaPrestamo;
	}
	public void setDeudaPrestamo(double deudaPrestamo) {
		this.deudaPrestamo = deudaPrestamo;
	}
	
	
}
