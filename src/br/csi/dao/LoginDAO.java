/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lucas
 */
public class LoginDAO {

    String sql = "";
    PreparedStatement pre;
    ResultSet rs;
    boolean retorno = false;

    public boolean autenticarCliente(String login, String senha) {



        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "SELECT * FROM cliente WHERE senha_cliente = ? and email_cliente = ?;";
            pre = conn.prepareStatement(sql);
            pre.setString(1, senha);
            pre.setString(2, login);
            rs = pre.executeQuery();
            while (rs.next()) {
                retorno = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
    
    public boolean autenticarFuncionario(String login, String senha) {

        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "SELECT * FROM funcionario WHERE senha_func= ? and email_func = ?;";
            pre = conn.prepareStatement(sql);
            pre.setString(1, senha);
            pre.setString(2, login);
            rs = pre.executeQuery();
            while (rs.next()) {
                retorno = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
    
}