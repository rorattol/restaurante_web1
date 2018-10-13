/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.dao;

import br.csi.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
create table cliente(
id_cliente serial,
nom_cliente varchar(75),
tel_cliente varchar(20),
senha_cliente varchar(20),
email_cliente varchar(50),
primary key (id_cliente));
 */
public class ClienteDAO {

    public boolean create(String nome, String email, String senha, String telefone) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            String sql = "INSERT INTO cliente(nom_cliente, email_cliente, senha_cliente, tel_cliente) VALUES (?, ?, ?, ?);";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, nome);
            pre.setString(2, email);
            pre.setString(3, senha);
            pre.setString(4, telefone);
            pre.execute();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Cliente read(int id) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNomeCliente(rs.getString("nome"));
                c.setEmailCliente(rs.getString("email"));
                c.setSenhaCliente(rs.getString("senha"));
                c.setTelefoneCliente(rs.getString("telefone"));
                return c;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

      
    public Cliente read(String email, String senha) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            String sql = "SELECT * FROM cliente WHERE email_cliente = ? and senha_cliente = ?;";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, senha);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNomeCliente(rs.getString("nome"));
                c.setEmailCliente(rs.getString("email"));
                c.setSenhaCliente(rs.getString("senha"));
                return c;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean update(Cliente cliente) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            String sql = "UPDATE cliente SET nom_cliente = ?, email_cliente = ?, senha_cliente = ?, tel_cliente = ? WHERE id_cliente = ?;";

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cliente.getNomeCliente());
            pre.setString(2, cliente.getEmailCliente());
            pre.setString(3, cliente.getSenhaCliente());
            pre.setString(4, cliente.getTelefoneCliente());
            pre.setInt(5, cliente.getId());
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
            String sql = "DELETE FROM cliente WHERE id_cliente = ?";
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

    public ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> usuarios = new ArrayList<>();

        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente");

            while (rs.next()) {

                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id_cliente"));
                cli.setNomeCliente(rs.getString("nom_cliente"));
                cli.setEmailCliente(rs.getString("email_cliente"));
                cli.setSenhaCliente(rs.getString("senha_cliente"));
                cli.setTelefoneCliente(rs.getString("tel_cliente"));

                usuarios.add(cli);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return usuarios;
    }//fim getClientes
}
