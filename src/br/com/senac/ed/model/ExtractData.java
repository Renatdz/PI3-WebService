package br.com.senac.ed.model;

import java.util.List;
import java.util.StringTokenizer;


public class ExtractData {

	private String htmlSouce;
	public List<String> lista;
	
	public ExtractData(String htmlSource){
		this.htmlSouce = htmlSource;
	}
	
	public List<String> extract(){
		
		StringTokenizer st = new StringTokenizer(this.htmlSouce,"\t");
		
		while (st.hasMoreTokens()) {
			//lista.add(st.nextToken());
			System.out.println(st.nextToken());
		}
		
		return lista;
		
	}
	
}

