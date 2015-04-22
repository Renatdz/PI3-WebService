package br.com.senac.ed.controller;

import java.util.ArrayList;

public class TituloLivro {
	
	private ArrayList<String> titulos;
	
	public TituloLivro (){
	}
	
	public TituloLivro (ArrayList<String> titulos){
		this.titulos = titulos;
	}
	
	public ArrayList<String> getTitulos() {
		return this.titulos;
	}
	
	public void setTitulos (ArrayList<String> titulos){
		this.titulos = titulos;
	}
	
	 
	// ????
	public	ArrayList <String> livro = new ArrayList<String>();
	public  ArrayList <String> precoString = new ArrayList <String>();
	public  ArrayList <String> detalhes = new ArrayList <String>();
	
}
