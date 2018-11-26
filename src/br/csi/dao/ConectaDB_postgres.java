/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lucas
 */
public class ConectaDB_postgres {
    private static final String url = "jdbc:postgresql://localhost:5432/web_restaurante";
    private static final String user = "postgres";
    private static final String password = "12345";


    /**
     * TESTE
      * @return CONEXAO DB
     */
    public Connection getConexao(){
        Connection conn = null;

        
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return conn;
    }
}
