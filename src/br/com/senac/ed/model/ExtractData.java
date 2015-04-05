package br.com.senac.ed.model;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class ExtractData {

	private String htmlSouce;
	public ArrayList<String> lista = new ArrayList<String>();
	
	public ExtractData(String htmlSource){
		this.htmlSouce = htmlSource;
	}
	
	public ArrayList<String> extract(){
		
		StringTokenizer st = new StringTokenizer(this.htmlSouce,"\t");
		
		while (st.hasMoreTokens()) {
			lista.add(st.nextToken());			
			System.out.println(st.nextToken());
		}
		
		return lista;
		
	}
	
}

