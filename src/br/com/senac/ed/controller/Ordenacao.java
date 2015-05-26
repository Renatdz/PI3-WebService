package br.com.senac.ed.controller;

import java.util.Collections;

import javafx.collections.ObservableList;


/**
 * @author vinicius.ribeiro, renato1mendes
 * 
 * Classe de ordenação sort. 
 * 
 */

//bug da lib do javafx que o eclipse nao reconhece.
@SuppressWarnings("restriction")
public class Ordenacao{
		
	public ObservableList<String> ordenarComBuble(ObservableList<String> lista){
		OrdenacaoBuble buble = new OrdenacaoBuble();
		
		buble.ordenar(lista);
		
		return lista;
	}
	
	// Ordenação por Colletcions.sort
	public ObservableList<String> ordenarComSort(ObservableList<String> lista){
		
		Collections.sort(lista);
		
		return lista;
	}
	
}
	


