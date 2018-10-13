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

    public boolean autenticarCliente(String login, String senha) {

        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            String sql = "SELECT * FROM cliente WHERE senha_cliente = ? and email_cliente = ?;";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, senha);
            pre.setString(2, login);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean autenticarFuncionario(String login, String senha) {

        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            String sql = "SELECT * FROM funcionario WHERE senha_func= ? and email_func = ?;";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, senha);
            pre.setString(2, login);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
}
