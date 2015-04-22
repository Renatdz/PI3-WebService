package br.com.senac.ed.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrdenaTitulo{
	
	public ArrayList<String> ordernarCrescente (ArrayList<String> titulos){
		
		Collections.sort(titulos, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
	            return s1.compareToIgnoreCase(s2);
	        }
		});
		
		return titulos;
		
	}
	
	public ArrayList<String> ordenarDecrescente (ArrayList<String> titulos){
		
		titulos.sort(Collections.reverseOrder());
		
		return titulos;
		
	}

}
	


