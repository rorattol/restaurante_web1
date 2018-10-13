/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.dao;

import br.csi.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
* create table funcionario(
* id_func serial,
* nom_func varchar(75),
* senha_func varchar(20),
* email_func varchar(50),
* primary key(id_func));
 * @author Lucas
 */
public class FuncionarioDAO {

    public boolean create(String nomeFunc, String emailFunc, String senhaFunc) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            String sql = "INSERT INTO funcionario(nom_func, email_func, senha_func) VALUES (?, ?, ?);";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, nomeFunc);
            pre.setString(2, emailFunc);
            pre.setString(3, senhaFunc);
            pre.execute();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Funcionario read(int id) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            String sql = "SELECT * FROM funcionario WHERE id_func = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setNomeFunc(rs.getString("nome_func"));
                f.setEmailFunc(rs.getString("email_func"));
                f.setSenhaFunc(rs.getString("senha_func"));
                return f;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

      
    public Funcionario read(String email, String senha) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            String sql = "SELECT * FROM funcionario WHERE email_func = ? and senha_func = ?;";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, senha);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setNomeFunc(rs.getString("nome"));
                f.setEmailFunc(rs.getString("email"));
                f.setSenhaFunc(rs.getString("senha"));
                return f;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean update(Funcionario funcionario) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            String sql = "UPDATE funcionario SET nom_func = ?, email_func = ?, senha_func = ? WHERE id_func = ?;";

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, funcionario.getNomeFunc());
            pre.setString(2, funcionario.getEmailFunc());
            pre.setString(3, funcionario.getSenhaFunc());
            pre.setInt(5, funcionario.getId());
            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }//PRONTO

    public boolean delete(int id) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {
            String sql = "DELETE FROM funcionario WHERE id_func = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }//PRONTO

}
