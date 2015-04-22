package br.com.senac.ed.controller;

public class Livro {
	
	private String titulo;
	private String preco;
	private String autor;
	
	public Livro (){
	}
	
	public Livro (String titulo, String preco, String autor){
		this.setTitulo(titulo);
		this.setPreco(preco);
		this.setAutor(autor);
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
		
}
