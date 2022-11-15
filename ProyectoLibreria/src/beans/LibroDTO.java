package beans;

public class LibroDTO {
	private String codLibro, nomLibro, autor;
	private int tipoEdit, codTema, stock;
	private double precio;
	public String getCodLibro() {
		return codLibro;
	}
	public void setCodLibro(String codLibro) {
		this.codLibro = codLibro;
	}
	public String getNomLibro() {
		return nomLibro;
	}
	public void setNomLibro(String nomLibro) {
		this.nomLibro = nomLibro;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getTipoEdit() {
		return tipoEdit;
	}
	public void setTipoEdit(int tipoEdit) {
		this.tipoEdit = tipoEdit;
	}
	public int getCodTema() {
		return codTema;
	}
	public void setCodTema(int codTema) {
		this.codTema = codTema;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
