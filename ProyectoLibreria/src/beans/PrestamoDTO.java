package beans;

public class PrestamoDTO {
	private String codPrestamo, codCliente, codLibro, fecSalida, fecMax, fecDevo;

	public String getCodPrestamo() {
		return codPrestamo;
	}

	public void setCodPrestamo(String codPrestamo) {
		this.codPrestamo = codPrestamo;
	}

	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public String getCodLibro() {
		return codLibro;
	}

	public void setCodLibro(String codLibro) {
		this.codLibro = codLibro;
	}

	public String getFecSalida() {
		return fecSalida;
	}

	public void setFecSalida(String fecSalida) {
		this.fecSalida = fecSalida;
	}

	public String getFecMax() {
		return fecMax;
	}

	public void setFecMax(String fecMax) {
		this.fecMax = fecMax;
	}

	public String getFecDevo() {
		return fecDevo;
	}

	public void setFecDevo(String fecDevo) {
		this.fecDevo = fecDevo;
	}
	
}
