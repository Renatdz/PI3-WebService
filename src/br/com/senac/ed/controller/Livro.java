package br.com.senac.ed.controller;

/**
 * @author vinicius.ribeiro, renato1mendes
 * 
 * Classe que recebe atributos do livro
 * 
 */

public class Livro implements ILivro{
	
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
