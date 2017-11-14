package com.jsftemplate.hibernate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class SQL {
	
	public static String sqlFolder = "/com/jsftemplate/sqlFiles/";
	
	public static String getQuery(String sqlFile, String queryName){
		String line = null;
		 		BufferedReader br = null;
		 		URL path = SQL.class.getResource(sqlFolder + sqlFile + ".sql");
		 		FileReader fr;
		 		try{
		 			fr = new FileReader(path.getPath());
		 			br = new BufferedReader(fr);
		 			String query = "";
		 			boolean writeQuery = false;
		 			while((line = br.readLine()) != null){
		 				if (line.contains("{")){
		 					if(line.equals(queryName + "{")){
		 						writeQuery = true;
		 						continue;
		 					}
		 				}
		 				if(line.contains("}")){
		 					writeQuery = false;
		 				}
		 				if(writeQuery){
		 					query += line;
		 				}
		 			}
		 			return query;
		 		}catch(IOException e){
		 			System.out.println(e.getMessage() + e.getCause().toString());
		 			return "";
		 		}finally{
		 			try{
		 				br.close();
		 			}catch(IOException  ioe){
		 				System.out.println(ioe.getMessage());
		 			}catch(NullPointerException npe){
		 				System.out.println(npe.getMessage());
		 			}
		 		}
	}
	
	public static SQLQuery getQueryByEntity(Session session, Class<?> entity, String queryName){
		String queryString = getQuery(entity.getSimpleName(), queryName);
		SQLQuery query = session.createSQLQuery(queryString);
		query.addEntity(entity);
		return query;
	}
}