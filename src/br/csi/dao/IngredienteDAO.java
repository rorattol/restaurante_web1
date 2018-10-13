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

/**
 * create table ingrediente(
 * id_ingrediente serial,
 * nom_ingrediente varchar(50),
 * primary key (id_ingrediente));
 * @author Lucas
 */
public class IngredienteDAO {
    
    public boolean create(String ingrediente){
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            String sql = "INSERT INTO ingrediente (nom_ingrediente) VALUES (? );";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ingrediente);
            pre.execute();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public Ingrediente read(int id) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            String sql = "SELECT * FROM ingrediente WHERE id_ingrediente = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Ingrediente ing = new Ingrediente();
                ing.setIngrediente(rs.getString("nom_ingrediente"));
                return ing;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean update(Ingrediente ingrediente) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            String sql = "UPDATE ingrediente SET nom_ingrediente = ? WHERE id_ingrediente = ?;";

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ingrediente.getIngrediente());
            pre.setInt(5, ingrediente.getId());
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
            String sql = "DELETE FROM ingrediente WHERE id_ingrediente = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            if (pre.executeUpdate() > 0) {
                return true;
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }//PRONTO
}
