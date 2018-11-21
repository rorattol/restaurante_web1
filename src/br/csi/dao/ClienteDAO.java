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

    String sql = "";
    PreparedStatement pre;
    ResultSet rs;
    boolean retorno = false;

    public boolean create(String nome, String email, String senha, String telefone) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "INSERT INTO cliente(nom_cliente, email_cliente, senha_cliente, tel_cliente) VALUES (?, ?, ?, ?);";
            pre = conn.prepareStatement(sql);
            pre.setString(1, nome);
            pre.setString(2, email);
            pre.setString(3, senha);
            pre.setString(4, telefone);
            pre.execute();
            
            retorno = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public Cliente read(int id) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "SELECT * FROM cliente WHERE id_cliente = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            rs = pre.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNome(rs.getString("nom_cliente"));
                c.setEmail(rs.getString("email_cliente"));
                c.setSenha(rs.getString("senha_cliente"));
                c.setTelefone(rs.getString("tel_cliente"));
                return c;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

      
    public Cliente read(String email, String senha) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "SELECT * FROM cliente WHERE email_cliente = ? and senha_cliente = ?;";
            pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, senha);
            rs = pre.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNome(rs.getString("nom_cliente"));
                c.setEmail(rs.getString("email_cliente"));
                c.setSenha(rs.getString("senha_cliente"));
                return c;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean update(Cliente cliente) {
        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            sql = "UPDATE cliente SET nom_cliente = ?, email_cliente = ?, senha_cliente = ?, tel_cliente = ? WHERE id_cliente = ?;";

            pre = conn.prepareStatement(sql);
            pre.setString(1, cliente.getNome());
            pre.setString(2, cliente.getEmail());
            pre.setString(3, cliente.getSenha());
            pre.setString(4, cliente.getTelefone());
            pre.setInt(5, cliente.getId());
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
            sql = "DELETE FROM cliente WHERE id_cliente = ?";
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

    public ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> usuarios = new ArrayList<>();

        try (Connection conn = new ConectaDB_postgres().getConexao()) {

            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM cliente");

            while (rs.next()) {

                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id_cliente"));
                cli.setNome(rs.getString("nom_cliente"));
                cli.setEmail(rs.getString("email_cliente"));
                cli.setSenha(rs.getString("senha_cliente"));
                cli.setTelefone(rs.getString("tel_cliente"));

                usuarios.add(cli);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return usuarios;
    }//fim getClientes
}
