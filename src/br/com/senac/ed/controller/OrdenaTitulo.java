package br.com.senac.ed.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.senac.ed.controller.Livro;


public class OrdenaTitulo{
	
	public ObservableList<String> ordernarCrescente (ObservableList<String> titulos){
		
		Collections.sort(titulos);
		
		return titulos;
		
	}
	
	public ObservableList<String> ordenarDecrescente (ObservableList<String> titulos){
		
		titulos.sort(Collections.reverseOrder());
		
		return titulos;
		
	}

}
	


