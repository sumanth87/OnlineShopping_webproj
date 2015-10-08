package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vo.Product;

public class ProductDAO {
	
	public Connection getConnection(){
		
		
		Connection connection = null;
		
		try{
			
			//Step1 : Loading JDBC Drivers
			Class.forName("org.gjt.mm.mysql.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			
		}catch(Exception e){
			e.printStackTrace();
		}

		return connection;
	}
	
	public void updateProduct(Product product){
		
		System.out.println("*******ProductDAO : updateProduct()********");
		
		String updateQuery = "update test.product set product_name=?,product_price=?,product_description=? "
				+ "where product_id=?";
		
		Connection connection = null;
		
		try{
		
			connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			
			preparedStatement.setString(1,product.getName());
			preparedStatement.setFloat(2,product.getPrice());
			preparedStatement.setString(3,product.getDescription());
			preparedStatement.setInt(4,product.getId());
			
			int i = preparedStatement.executeUpdate();
			
			if(i==1){
				System.out.println("Record is updated successfully");
			}
			
			connection.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void deleteProduct(int id){
		
		
		try{
			
			String deleteQuery = "delete from test.product where product_id=?";
			
			Connection connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			
			preparedStatement.setInt(1,id);
			
			int i = preparedStatement.executeUpdate();
			
			if(i == 1){
				System.out.println("record deleted successfully");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void addProduct(Product product){
		
	}
	
	public ArrayList<Product> getProducts() throws SQLException{

		ArrayList<Product> productsList = new ArrayList<>();
		
		Connection connection = null;
		
		try{
		
			connection = getConnection();
			
			String selectQuery = "select * from test.product";
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while (resultSet.next()) {
				
				Product product = new Product();
				
				product.setId(resultSet.getInt("product_id"));
				product.setName(resultSet.getString("product_name"));
				product.setPrice(resultSet.getFloat("product_price"));
				product.setDescription(resultSet.getString("product_description"));
				
				productsList.add(product);
				
			}
			
			resultSet.close();
			
		
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection!=null){
				connection.close();
			}
		}
		
		return productsList;

	}
	
	public Product getProductById(int id){
		
		Product product = null;
		
		String selectQuery = "select * from test.product where product_id=?";
		
		try{
						
			Connection connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			
			preparedStatement.setInt(1,id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				product = new Product();
				
				product.setId(resultSet.getInt("product_id"));
				product.setName(resultSet.getString("product_name"));
				product.setPrice(resultSet.getFloat("product_price"));
				product.setDescription(resultSet.getString("product_description"));
						
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return product;
		
	}
	
	
}
