package beans;

public class PrestamoDTO {
	private String codUsuario, fechaIniPrestamo, fechaFinPrestamo;
	private int numDetPrestamo, numSolicitud;
	private double deudaPrestamo;
	public String getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getFechaIniPrestamo() {
		return fechaIniPrestamo;
	}
	public void setFechaIniPrestamo(String fechaIniPrestamo) {
		this.fechaIniPrestamo = fechaIniPrestamo;
	}
	public String getFechaFinPrestamo() {
		return fechaFinPrestamo;
	}
	public void setFechaFinPrestamo(String fechaFinPrestamo) {
		this.fechaFinPrestamo = fechaFinPrestamo;
	}
	public int getNumDetPrestamo() {
		return numDetPrestamo;
	}
	public void setNumDetPrestamo(int numDetPrestamo) {
		this.numDetPrestamo = numDetPrestamo;
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
