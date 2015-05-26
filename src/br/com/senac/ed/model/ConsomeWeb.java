package br.com.senac.ed.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
import java.net.URL;


public class ConsomeWeb {

	private String retornoHTTP = null;
	
	public ConsomeWeb(){
		//construtor vazio
	}
	
	public String consumirSite(String urlSite) throws IOException {
		//string web do site.
		URL url = new URL(urlSite);
		
		HttpURLConnection connection = 
				(HttpURLConnection) url.openConnection();
		
		connection.setRequestProperty("Request-Method", "GET");
		connection.setDoInput(true);
		connection.setDoOutput(false);
		
		connection.connect();
		
		BufferedReader br =  
			    new BufferedReader(new InputStreamReader(connection.getInputStream())); 
		
		// le ate o final  
		StringBuffer newData = new StringBuffer(10000);  
		String s = "";  
		while (null != ((s = br.readLine()))) {  
		    newData.append(s);  
		}  
		br.close();
		
		PrintWriter out = new PrintWriter(System.out, true); 
		
		// imprime o numero do resultado  
					out.println(  
					    "Resultado: "  
					        + connection.getResponseCode()  
					        + "/"  
					        + connection.getResponseMessage());
		 
		
		//atribui o html inteiro
		this.retornoHTTP = new String(newData);
					
		//retorna html
		return this.retornoHTTP;  
		
	}

}

