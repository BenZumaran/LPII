package beans;

public class ReciboDTO {
	private String codUsuarioCobranza, codigoDocumento ,numDocRecibo, fechaRecibo;
	private int numRecibo, numPrestamo;
	private double importeRecibo;
	public String getCodUsuarioCobranza() {
		return codUsuarioCobranza;
	}
	public void setCodUsuarioCobranza(String codUsuarioCobranza) {
		this.codUsuarioCobranza = codUsuarioCobranza;
	}
	public String getCodigoDocumento() {
		return codigoDocumento;
	}
	public void setCodigoDocumento(String codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}
	public String getNumDocRecibo() {
		return numDocRecibo;
	}
	public void setNumDocRecibo(String numDocRecibo) {
		this.numDocRecibo = numDocRecibo;
	}
	public String getFechaRecibo() {
		return fechaRecibo;
	}
	public void setFechaRecibo(String fechaRecibo) {
		this.fechaRecibo = fechaRecibo;
	}
	public int getNumRecibo() {
		return numRecibo;
	}
	public void setNumRecibo(int numRecibo) {
		this.numRecibo = numRecibo;
	}
	public int getNumPrestamo() {
		return numPrestamo;
	}
	public void setNumPrestamo(int numPrestamo) {
		this.numPrestamo = numPrestamo;
	}
	public double getImporteRecibo() {
		return importeRecibo;
	}
	public void setImporteRecibo(double importeRecibo) {
		this.importeRecibo = importeRecibo;
	}
		
}
	