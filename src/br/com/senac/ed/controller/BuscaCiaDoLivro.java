package br.com.senac.ed.controller;

import java.io.IOException;

public class BuscaCiaDoLivro extends URL {

	private String urlDoSite;

	TituloLivro t = new TituloLivro();
	
	public BuscaCiaDoLivro (String nomeLivro){
		super(nomeLivro);
	}

	@Override
	public void geraURL(){
		String novoNomeLivro = getNomeLivro().replace(" ", "+");
		
		setURL("http://www.ciadoslivros.com.br/pesquisa?t="+novoNomeLivro+"&f=&sr=GERAL");
	}
	

	//getters and setters
	public void setURL(String urlDoSite){
		this.urlDoSite = urlDoSite;
	}
	
	public String getURL(){
		return this.urlDoSite;
	}

}