package br.com.casadocodigo.loja.model;

public class Produto {
	
	private String titulo;
	private String descricao;
	private String paginas;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPaginas() {
		return paginas;
	}
	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}
	
	@Override
	public String toString() {
		return titulo + "\n" + descricao +"\n"+paginas; 
	}
	
}
