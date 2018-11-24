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
import java.util.ArrayList;

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

    String sql = "";
    PreparedStatement pre;
    ResultSet rs;
    boolean retorno = false;

    public boolean create(Mesa mesa) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "INSERT INTO mesa (num_mesa, lugares_mesa, reservado_mesa) VALUES (?, ?, ?);";
            pre =  conn.prepareStatement(sql);
            pre.setInt(1, mesa.getNumMesa());
            pre.setInt(2, mesa.getLugares());
            pre.setBoolean(3, false);
            pre.executeUpdate();

            retorno = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public Mesa read(int id) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "SELECT * FROM mesa WHERE id_mesa = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            rs = pre.executeQuery();
            while (rs.next()) {
                Mesa mesa = new Mesa();
                mesa.setId(rs.getInt("id_mesa"));
                mesa.setNumMesa(rs.getInt("num_mesa"));
                mesa.setLugares(rs.getInt("lugares_mesa"));
                mesa.setReservado(rs.getBoolean("reservado_mesa"));
                return mesa;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean update(Mesa mesa) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "UPDATE mesa SET num_mesa = ?, lugares_mesa = ?, reservado_mesa = ? WHERE id_mesa = ?;";

            pre = conn.prepareStatement(sql);
            pre.setInt(1, mesa.getNumMesa());
            pre.setInt(2, mesa.getLugares());
            pre.setBoolean(3, mesa.isReservado());
            pre.setInt(4, mesa.getId());
            pre.executeUpdate();
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
            sql = "DELETE FROM mesa WHERE id_mesa = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            if (pre.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public ArrayList<Mesa> getMesas() {

        ArrayList<Mesa> mesas = new ArrayList<Mesa>();

        try (Connection conn = new ConectaDB_postgres().getConexao()) {
            sql = "select * from mesa;";
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Mesa m = new Mesa();

                m.setLugares(rs.getInt("lugares_mesa"));
                m.setNumMesa(rs.getInt("num_mesa"));
                m.setReservado(rs.getBoolean("reservado_mesa"));
                m.setId(rs.getInt("id_mesa"));

                mesas.add(m);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mesas;
    }
}