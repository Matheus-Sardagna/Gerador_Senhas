package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private String usuario = "root";
    private String senha = "0000";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "gerador_senha";

    public Connection obtemConexao (){
        try{
            String url = String.format("jdbc:mysql://%s:%s/%s?useSSL=false", host, porta, bd);
            return DriverManager.getConnection(url, usuario, senha);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
