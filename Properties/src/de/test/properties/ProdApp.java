package de.test.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import models.SQLLogin;

public class ProdApp {
  
	
	public static Properties readPropertiesFile(String filename){
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(filename);

			// load a properties file
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;

	}
	
	
	public static SQLLogin getSQLLogin() {

		SQLLogin sqlLogin = new SQLLogin();
		Properties prop = readPropertiesFile("config.properties");
		sqlLogin.setHost( prop.getProperty("database") );  
		sqlLogin.setUser( prop.getProperty("dbuser") );
		sqlLogin.setPassword( prop.getProperty("dbpassword") );
		return sqlLogin;
	}
	
	public static void main(String[] args) {

		SQLLogin login = getSQLLogin();
		System.out.println(login.getHost() + " " + login.getUser() + " " + login.getPassword());
  }
}