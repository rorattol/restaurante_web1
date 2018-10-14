/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.dao;

import br.csi.model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * create table pedido(
 * id_mesa int,
 * id_prato int,
 * id_pedido serial,
 * observacao_pedido varchar(75),
 * primary key (id_pedido),
 * foreign key (id_mesa) references mesa,
 * foreign key (id_prato) references prato);
 * @author Lucas
 */
public class PedidoDAO {

    String sql = "";
    PreparedStatement pre;
    ResultSet rs;
    boolean retorno = false;

    public boolean create(int idMesa, int idPrato, String observacao) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "INSERT INTO pedido (id_mesa, id_prato, observacao_pedido, data_hora) VALUES (?, ?, ?, current_date);";
            pre = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setInt(1, idMesa);
            pre.setInt(2, idPrato);
            pre.setString(3, observacao);
            pre.execute();
            rs = pre.getGeneratedKeys();
            rs.next();

//            if (rs.getInt(1) > 0) {
//                
//                
//                Cliente cli = new Cliente();
//                cli.setId(rs.getInt(1)); // seta pro usaurio o id do usuario gerado no banco
//                
//                sql="INSERT INTO cliente(nome, email, senha, telefone) VALUES (?, ?, ?, ?);";//insert no funcionario
//                
//                return rs.getInt(1); //é a mesma coisa que o id so usuario que foi gerado na inserção
//            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public Pedido read(int id) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "SELECT * FROM pedido WHERE id_pedido = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            rs = pre.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
           //     p.setMesaReservada(rs.getInt("id_mesa"));
           //     p.setPratosReservados(rs.getString("id_prato"));
                p.setObservacao(rs.getString("observacao_pedido"));
                p.setHoraReservada(rs.getString("data_hora"));
                return p;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean update(Pedido pedido) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "UPDATE pedido SET id_mesa = ?, id_prato = ? , observacao_pedido, = ? WHERE id_pedido = ?;";

            pre = conn.prepareStatement(sql);
  //          pre.setString(1, pedido.getMesaReservada());
//            pre.setString(2, pedido.getPratosReservados());
            pre.setString(3, pedido.getObservacao());
            pre.setInt(4, pedido.getId());
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
            sql = "DELETE FROM peiddo WHERE id_pedido = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            if (pre.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }//PRONTO
    
}
