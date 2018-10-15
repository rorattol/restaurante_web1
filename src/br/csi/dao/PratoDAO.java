/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.dao;

import br.csi.model.Ingrediente;
import br.csi.model.Prato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * create table prato(
 * id_prato serial,
 * nom_prato varchar(50),
 * categoria_prato varchar(25),
 * descricao_prato varchar(100),
 * preco_prato float,
 * primary key (id_prato));
 * @author Lucas
 */
public class PratoDAO {

    private String sql = "";
    private PreparedStatement pre;
    private ResultSet rs;
    boolean retorno = false;

    public boolean create(Prato prato) {

        try (Connection conn = new ConectaDB_postgres().getConexao()) {
            conn.setAutoCommit(false);
            sql = "INSERT INTO prato (nom_prato, categoria_prato, descricao_prato, preco_prato) VALUES (?, ?, ?, ?);";
            pre = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, prato.getNomPrato());
            pre.setString(2, prato.getCategoriaPrato());
            pre.setString(3, prato.getDescricaoPrato());
            pre.setFloat(4, prato.getPrecoPrato());
            pre.execute();
            rs = pre.getGeneratedKeys();
            rs.next();

            
            if (rs.getInt(1) > 0) {
                
                for(Ingrediente ing : prato.getIngredientes()){
                    sql = "INSERT INTO prato_ingrediente (id_prato, id_ingrediente) values (?, ?)";
                    pre = conn.prepareStatement(sql);
                    pre.setInt(1, rs.getInt(1));
                    pre.setInt(2, ing.getId());
                    pre.execute();
                }
                
            }
            conn.commit();
            retorno = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public Prato read(int id) {
        Prato p = new Prato();
        
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "SELECT * FROM prato WHERE id_prato = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            rs = pre.executeQuery();
            while (rs.next()) {
                p.setNomPrato(rs.getString("nom_prato"));
                p.setCategoriaPrato(rs.getString("categoria_prato"));
                p.setDescricaoPrato(rs.getString("descricao_prato"));
                p.setPrecoPrato(rs.getFloat("preco_prato"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    public boolean update(Prato prato) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "UPDATE prato SET nom_prato = ?, categoria_prato = ?, descricao_prato = ?, preco_prato = ? WHERE id_prato = ?;";

            pre = conn.prepareStatement(sql);
            pre.setString(1, prato.getNomPrato());
            pre.setString(2, prato.getCategoriaPrato());
            pre.setString(3, prato.getDescricaoPrato());
            pre.setFloat(4, prato.getPrecoPrato());
            pre.setInt(5, prato.getId());
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
            sql = "DELETE FROM prato WHERE id_prato = ?";
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
    
    public ArrayList<Prato> getPratos() {
        
        ArrayList<Prato> pratos = new ArrayList<Prato>();
        
        try (Connection conn = new ConectaDB_postgres().getConexao()) {
            sql = "select * from prato;";
            pre = conn.prepareStatement(sql);
            
            
            rs = pre.executeQuery();
            while (rs.next()) {
                Prato p = new Prato();
                p.setNomPrato(rs.getString("nom_prato"));
                p.setCategoriaPrato(rs.getString("categoria_prato"));
                p.setDescricaoPrato(rs.getString("descricao_prato"));
                p.setPrecoPrato(rs.getFloat("preco_prato"));
                
                pratos.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pratos;
    }
    
}
