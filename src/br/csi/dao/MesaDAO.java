/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.dao;

import br.csi.model.Mesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
* create table mesa(
* id_mesa serial,
* reservado_mesa boolean,
* num_mesa int,
* lugares_mesa int,
* primary key (id_mesa));
* @author Lucas
**/
public class MesaDAO {
    
    public boolean create(int num_mesa, int qtdLugares) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            String sql = "INSERT INTO mesa (num_mesa, lugares_mesa, reservado_mesa) VALUES (?, ?, ?);";
            PreparedStatement pre =  conn.prepareStatement(sql);
            pre.setInt(1, num_mesa);
            pre.setInt(2, qtdLugares);
            pre.setBoolean(3, false);
            pre.executeUpdate();

            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Mesa read(int id) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            String sql = "SELECT * FROM mesa WHERE id_mesa = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Mesa m = new Mesa();
                m.setNumMesa(rs.getInt("num_mesa"));
                m.setLugares(rs.getInt("lugares_mesa"));
                m.setReservado(rs.getBoolean("reservado_mesa"));
                return m;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean update(Mesa mesa) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            String sql = "UPDATE mesa SET num_mesa = ?, lugares_mesa = ?, reservado_mesa = ? WHERE id_mesa = ?;";

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, mesa.getNumMesa());
            pre.setInt(2, mesa.getLugares());
            pre.setBoolean(3, mesa.isReservado());
            pre.setInt(4, mesa.getId());
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
            String sql = "DELETE FROM mesa WHERE id_mesa = ?";
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