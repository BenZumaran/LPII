package beans;

public class LibroDTO {
	private String codLibro, descLibro, codGenero, autorLibro, estadoLibro;
	private int anioLibro, stockLibro, numPrestamoActual;
	public String getCodLibro() {
		return codLibro;
	}
	public void setCodLibro(String codLibro) {
		this.codLibro = codLibro;
	}
	public String getDescLibro() {
		return descLibro;
	}
	public void setDescLibro(String descLibro) {
		this.descLibro = descLibro;
	}
	public String getCodGenero() {
		return codGenero;
	}
	public void setCodGenero(String codGenero) {
		this.codGenero = codGenero;
	}
	public String getAutorLibro() {
		return autorLibro;
	}
	public void setAutorLibro(String autorLibro) {
		this.autorLibro = autorLibro;
	}
	public String getEstadoLibro() {
		return estadoLibro;
	}
	public void setEstadoLibro(String estadoLibro) {
		this.estadoLibro = estadoLibro;
	}
	public int getAnioLibro() {
		return anioLibro;
	}
	public void setAnioLibro(int anioLibro) {
		this.anioLibro = anioLibro;
	}
	public int getStockLibro() {
		return stockLibro;
	}
	public void setStockLibro(int stockLibro) {
		this.stockLibro = stockLibro;
	}
	public int getNumPrestamoActual() {
		return numPrestamoActual;
	}
	public void setNumPrestamoActual(int numPrestamoActual) {
		this.numPrestamoActual = numPrestamoActual;
	}
	
}
