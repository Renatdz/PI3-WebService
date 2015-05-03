package br.com.senac.ed.controller;

import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.senac.ed.controller.Livro;

public class OrdenaTitulo{
		
	public ObservableList<String> ordenarCrescente(ObservableList<String> titulos){
		for(int j = 0; j < titulos.size(); j++)
		{
		     for (int i = j+1; i < titulos.size(); i++)
		     {
		         if(titulos.get(i).compareToIgnoreCase(titulos.get(j))<0)
		         {
		             String temp  = titulos.get(j);
		             titulos.set(j, titulos.get(i)); 
		             titulos.set(i, temp);
		         }
		     }
		}
		
		return titulos;
	}
		
	public ObservableList<String> ordenarDecrescente (ObservableList<String> titulos){
		
		titulos.sort(Collections.reverseOrder());
		
		return titulos;
	}

}
	


