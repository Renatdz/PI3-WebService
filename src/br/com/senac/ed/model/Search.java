package br.com.senac.ed.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Search {

	private String retornoHTTP = null;
	
	public Search(){
		//construtor vazio
	}
	public String stringLivro;
	
	public String consumirSite(String stringLivro) {
		//string web do site.
		String urlString = "http://www.ciadoslivros.com.br/pesquisa?t="+stringLivro+"&f=&sr=GERAL";
		
		try {
			URL url = new URL(urlString);
			
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
			
			// imprime o codigo resultante  
			//out.println(new String(newData));  
			
			
			this.retornoHTTP = new String(newData);
						
			return this.retornoHTTP;  
			 
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this.retornoHTTP;
		
	}

}

