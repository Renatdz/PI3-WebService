package br.com.senac.ed.controller;

/**
 * @author vinicius.ribeiro
 * @update renato1mendes
 * 
 * Classe pai das classes de busca. 
 * 
 */

public abstract class TrataUrlBusca {
	
	private String nomeLivro;
	
	public TrataUrlBusca (String nomeLivro){
		this.nomeLivro = nomeLivro;
	}
	
	public abstract void geraURL();
	public abstract String getURL();
	public abstract void setURL(String urlDoSite);

	//getter
	public String getNomeLivro() {
		return nomeLivro;
	}

}