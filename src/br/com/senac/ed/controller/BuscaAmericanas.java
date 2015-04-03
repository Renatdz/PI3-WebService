package br.com.senac.ed.controller;

public class BuscaAmericanas extends URL{
	
	public BuscaAmericanas (String urlDoSite){
		
		super(urlDoSite);
		this.urlDoSite = "http://busca.americanas.com.br/busca.php?q=harry+potter&p=harry+potter&typeclick=1&ranking=1&ac_pos=header";
	}

	public String retornarURL (){
		
		return urlDoSite ;
		
	}
	
	
}
