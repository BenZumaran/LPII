package beans;

public class SolicitudDTO {
	String codUsuSolicitante, codUsuAprobador, fecCreacionSoli, fecAprobacionSoli,fecIniPrestamo,fecDevPrestamo,estadoSoli;
	int numPrestamo;
	
	public String getCodUsuSolicitante() {
		return codUsuSolicitante;
	}
	public void setCodUsuSolicitante(String codUsuSolicitante) {
		this.codUsuSolicitante = codUsuSolicitante;
	}
	public String getCodUsuAprobador() {
		return codUsuAprobador;
	}
	public void setCodUsuAprobador(String codUsuAprobador) {
		this.codUsuAprobador = codUsuAprobador;
	}
	public String getFecCreacionSoli() {
		return fecCreacionSoli;
	}
	public void setFecCreacionSoli(String fecCreacionSoli) {
		this.fecCreacionSoli = fecCreacionSoli;
	}
	public String getFecAprobacionSoli() {
		return fecAprobacionSoli;
	}
	public void setFecAprobacionSoli(String fecAprobacionSoli) {
		this.fecAprobacionSoli = fecAprobacionSoli;
	}
	public String getFecIniPrestamo() {
		return fecIniPrestamo;
	}
	public void setFecIniPrestamo(String fecIniPrestamo) {
		this.fecIniPrestamo = fecIniPrestamo;
	}
	public String getFecDevPrestamo() {
		return fecDevPrestamo;
	}
	public void setFecDevPrestamo(String fecDevPrestamo) {
		this.fecDevPrestamo = fecDevPrestamo;
	}
	public String getEstadoSoli() {
		return estadoSoli;
	}
	public void setEstadoSoli(String estadoSoli) {
		this.estadoSoli = estadoSoli;
	}
	public int getNumPrestamo() {
		return numPrestamo;
	}
	public void setNumPrestamo(int numPrestamo) {
		this.numPrestamo = numPrestamo;
	}	
	
}
