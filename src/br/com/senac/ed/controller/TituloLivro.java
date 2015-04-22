package br.com.senac.ed.controller;

import java.util.ArrayList;
import java.util.List;

public class TituloLivro {
	
	private List<String> titulos;
	
	public TituloLivro (){
	}
	
	public TituloLivro (List<String> titulos){
		this.titulos = titulos;
	}
	
	public List<String> getTitulos() {
		return this.titulos;
	}
	
	public void setTitulos (List<String> titulos){
		this.titulos = titulos;
	}
	 
	// ????
	public	ArrayList <String> livro = new ArrayList<String>();
	public  ArrayList <String> precoString = new ArrayList <String>();
	public  ArrayList <String> detalhes = new ArrayList <String>();
	
}
