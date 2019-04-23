package com.neuedu.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtils {

	private static Properties properties = new Properties();
	
	static {
		
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
		
		try {
			properties.load(inputStream);
			Class.forName(properties.getProperty("jdbc.driver"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),
					properties.getProperty("jdbc.username"),properties.getProperty("jdbc.password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void close(Connection connection,PreparedStatement preparedStatement) {
		try {
			
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(Connection connection,java.sql.PreparedStatement preparedStatement,ResultSet resultSet) {
		try {	
			
			if(resultSet != null) {
				resultSet.close();
			}
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
