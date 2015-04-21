package br.com.senac.ed.controller;

import java.util.ArrayList;


public class TituloLivro {
	
	String livros;
	
	public TituloLivro (){
		
	}
	
	public String getLivros() {
		return livros;
	}
	public void setLivros(String livros) {
		this.livros = livros;
	}
	 
	public	ArrayList <String> livro = new ArrayList<String>();
	 public  ArrayList <String> precoString = new ArrayList <String>();
	 public  ArrayList <String> detalhes = new ArrayList <String>();



}
