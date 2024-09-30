
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author victo
 */
public class Conexao {

    public static void main(String[] args) {
        
        try {
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/POO_A4",
                    "postgres", "123456");
            if (conexao != null){
                System.out.println("Banco conectado com sucesso!");
                Statement stm = conexao.createStatement();
                consultaDados(stm);
            } else {
                System.out.println("Ocorreu um erro inesperado.");
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco de dados: " + ex.getMessage());
        }
        
    }
    
    static void consultaDados(Statement stm){
        String query = "SELECT ID, NOME FROM pessoas";
        try {
        ResultSet result = stm.executeQuery(query);    
        while(result.next()){
            System.out.println("ID: " + result.getInt("id") + ", Nome: " + result.getString("nome"));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
