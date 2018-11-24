/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.dao;

import br.csi.model.Ingrediente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * create table ingrediente(
 * id_ingrediente serial,
 * nom_ingrediente varchar(50),
 * primary key (id_ingrediente));
 * @author Lucas
 */
public class IngredienteDAO {

    String sql = "";
    PreparedStatement pre;
    ResultSet rs;
    boolean retorno = false;

    public boolean create(String ingrediente){
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "INSERT INTO ingrediente (nom_ingrediente) VALUES (? );";
            pre = conn.prepareStatement(sql);
            pre.setString(1, ingrediente);
            pre.execute();
            
            retorno = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
    
    public Ingrediente read(int id) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "SELECT * FROM ingrediente WHERE id_ingrediente = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            rs = pre.executeQuery();
            while (rs.next()) {
                Ingrediente ing = new Ingrediente();
                ing.setId(rs.getInt("id_ingrediente"));
                ing.setNome(rs.getString("nom_ingrediente"));
                return ing;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean update(Ingrediente ingrediente) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "UPDATE ingrediente SET nom_ingrediente = ? WHERE id_ingrediente = ?;";
            pre = conn.prepareStatement(sql);
            pre.setString(1, ingrediente.getNome());
            pre.setInt(2, ingrediente.getId());
            if (pre.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return retorno;
    }

    public boolean delete(int id) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {
            sql = "DELETE FROM ingrediente WHERE id_ingrediente = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            if (pre.executeUpdate() > 0) {
                retorno = true;
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public ArrayList<Ingrediente> getIngredientes() {

        ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

        try (Connection conn = new ConectaDB_postgres().getConexao()) {
            sql = "select * from ingrediente;";
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Ingrediente ing = new Ingrediente();
                ing.setId(rs.getInt("id_ingrediente"));
                ing.setNome(rs.getString("nom_ingrediente"));
                ingredientes.add(ing);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ingredientes;
    }
}
