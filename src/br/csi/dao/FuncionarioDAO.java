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
import java.util.ArrayList;

/**
 * create table funcionario(
 * id_func serial,
 * nom_func varchar(75),
 * senha_func varchar(20),
 * email_func varchar(50),
 * primary key(id_func));
 *
 * @author Lucas
 */
public class FuncionarioDAO {

    String sql = "";
    PreparedStatement pre;
    ResultSet rs;
    boolean retorno = false;

    public boolean create(String nomeFunc, String emailFunc, String senhaFunc) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "INSERT INTO funcionario(nom_func, email_func, senha_func) VALUES (?, ?, ?);";
            pre = conn.prepareStatement(sql);
            pre.setString(1, nomeFunc);
            pre.setString(2, emailFunc);
            pre.setString(3, senhaFunc);
            pre.execute();

            retorno = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public Funcionario read(int id) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "SELECT * FROM funcionario WHERE id_func = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            rs = pre.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id_func"));
                f.setNome(rs.getString("nom_func"));
                f.setEmail(rs.getString("email_func"));
                f.setSenha(rs.getString("senha_func"));
                return f;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean update(Funcionario funcionario) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "UPDATE funcionario SET nom_func = ?, email_func = ?, senha_func = ? WHERE id_func = ?;";
            pre = conn.prepareStatement(sql);
            pre.setString(1, funcionario.getNome());
            pre.setString(2, funcionario.getEmail());
            pre.setString(3, funcionario.getSenha());
            pre.setInt(4, funcionario.getId());
            if (pre.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return retorno;
    }//PRONTO

    public boolean delete(int id) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {
            sql = "DELETE FROM funcionario WHERE id_func = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            if (pre.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }//PRONTO

    public ArrayList<Funcionario> getFuncionarios() {

        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        try (Connection conn = new ConectaDB_postgres().getConexao()) {
            sql = "select * from funcionario;";
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();

                f.setId(rs.getInt("id_func"));
                f.setNome(rs.getString("nom_func"));
                f.setSenha(rs.getString("senha_func"));
                f.setEmail(rs.getString("email_func"));
                funcionarios.add(f);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return funcionarios;
    }
}
