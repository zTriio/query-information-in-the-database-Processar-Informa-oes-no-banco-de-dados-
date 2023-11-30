package projetoloja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		String url = "jdbc:mysql://localhost:3306/projetocomjava";
        String user = "root";
        String password = "1234";
        
        try (Connection connect = DriverManager.getConnection(url, user, password)) {
            Scanner scanner = new Scanner(System.in);
            
          while(true) {
        	System.out.println("\nDigite o nome do produto que deseja saber as informaçoes!!");
        	System.out.println("Caso Contrario Digite Sair para finalizar a Consulta!!");
            String nameproduct = scanner.nextLine();
            
            if ("sair".equalsIgnoreCase(nameproduct)) {
                System.out.println("\n Encerrando o programa. Até mais!\n");
                break;
            }
            String consultaSQL = "SELECT nome, preco FROM produto WHERE nome = ?";
            
			 try (PreparedStatement preparedStatement = connect.prepareStatement(consultaSQL)) {
                preparedStatement.setString(1, nameproduct);
                
                try (PreparedStatement preparedStatement1 = connect.prepareStatement(consultaSQL)) {
                    preparedStatement1.setString(1, nameproduct);
                    
                    try (ResultSet resultSet = preparedStatement1.executeQuery()) {
                    	
                        if (resultSet.next()) {
                            String name = resultSet.getString("nome");
                            double cost = resultSet.getDouble("preco");

                            ProductMessage productmessage = new ProductMessage(name, cost);

                            productmessage.MessageAlert();
                            
                        } else {
                            System.out.println("Produto nao Encontrado.");
                        }
                    }
                }
            }
          }
            scanner.close();
			connect.close();
        } catch (SQLException e ){
			e.printStackTrace();
		}
	}
}
