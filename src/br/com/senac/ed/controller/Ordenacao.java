package br.com.senac.ed.controller;

import javafx.collections.ObservableList;

//bug da lib do javafx que o eclipse nao reconhece.
@SuppressWarnings("restriction")
public class Ordenacao{
		
	public ObservableList<String> ordenarComBuble(ObservableList<String> lista){
		OrdenacaoBuble buble = new OrdenacaoBuble();
		
		buble.ordenar(lista);
		
		return lista;
	}
	
	public ObservableList<String> ordenarComSort(ObservableList<String> lista){
		OrdenacaoBuble buble = new OrdenacaoBuble();
		
		buble.ordenar(lista);
		
		return lista;
	}
	
}
	


