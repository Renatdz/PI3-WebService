package br.com.senac.ed.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
	private Connection connection = null;
	private Statement statement   = null;
	private ResultSet resultSet   = null;
	
	public void connect() {
		String servidor = "jdbc:mysql://localhost/PI_schema";
		String usuario  = "root";
		String senha    = "";
		String driver   = "com.mysql.jdbc.Driver";
		
		try {//criando conexao
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement  = this.connection.createStatement(); 
			
		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		}
	}
	
	public boolean isConnected() {
		if(this.connection != null)
			return true;
		else
			return false;
	}
	
	public List<String> listHistoric() {
		try{
			String query   = "SELECT * FROM historic ORDER BY share_historic";
			this.resultSet = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			List<String> list = new ArrayList<String>();
			
			while(this.resultSet.next()) { 
				list.add(this.resultSet.getString("share_historic"));
			}
			
			return list;
			
		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		}
		return null;
	}
	
	public void insertHistoric(String shareHistoric) {
		try {
			String query = "INSERT INTO historic (share_historic) VALUES ('" + shareHistoric + "');";
			this.statement.execute(query);
			//System.out.println("inserido");
			
		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		}
	}
	
	public void disconnect() {
		try{
			this.connection.close();
	
		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		}
	}
	
   
}