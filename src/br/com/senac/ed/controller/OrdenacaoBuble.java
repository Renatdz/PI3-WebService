package br.com.senac.ed.controller;

import javafx.collections.ObservableList;

/**
 * @author renato1mendes
 * @update vinicius.ribeiro
 * 
 * Classe concatena os dados para conex�o no site. 
 * 
 */
//bug da lib do javafx que o eclipse nao reconhece.
@SuppressWarnings("restriction")
public class OrdenacaoBuble {

	//Ordena��o utilizando o algoritmo Bubble Sort
	public ObservableList<String> ordenar(ObservableList<String> lista){
		for (int j = 0; j < lista.size(); j++) {
		     for (int i = j+1; i < lista.size(); i++) {
		         if (lista.get(i).compareToIgnoreCase(lista.get(j))<0) {
		             String temp  = lista.get(j);
		             lista.set(j, lista.get(i)); 
		             lista.set(i, temp);
		         }
		     }
		}
		
		return lista;
	}
	
}
