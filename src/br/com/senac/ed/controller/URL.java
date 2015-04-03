package br.com.senac.ed.controller;

//import java.util.ArrayList;

public abstract class URL {
	
	private String nomeLivro;
	
	public URL (String nomeLivro){
		this.nomeLivro = nomeLivro;
	}
	
	public abstract void geraURL();
	public abstract String getURL();
	public abstract void setURL(String urlDoSite);

	//getter
	public String getNomeLivro() {
		return nomeLivro;
	}
	
	//ArrayList <Object> livros = new ArrayList <Object>();
	//ArrayList <Object> precos = new ArrayList <Object>();

}