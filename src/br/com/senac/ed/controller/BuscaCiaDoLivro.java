package br.com.senac.ed.controller;

import java.util.ArrayList;

public class BuscaCiaDoLivro extends URL {	
	
	private String retorno;
	
	public BuscaCiaDoLivro (String nomeLivro){
		super (nomeLivro);	
	}
	
	public String retornarURL (){	
		return urlDoSite ;	
	}
	@Override
	public void geraUrl(String nomeLivro) {	
		
		retorno = nomeLivro.replace("", "+");
		setUrlDoSite("http://www.ciadoslivros.com.br/pesquisa?t="+retorno+"&f=&sr=GERAL");
		 
	}
	
	public String getUrlDoSite (){
		
		return this.urlDoSite;
	}
	
	public void setUrlDoSite (String urlDoSite){
		
		this.urlDoSite = urlDoSite;
		
	}

	

}
