package com.mycompany.supermercado.dao;

import static com.mycompany.supermercado.dao.ClienteDAO.login;
import static com.mycompany.supermercado.dao.ClienteDAO.password;
import static com.mycompany.supermercado.dao.ClienteDAO.url;
import static com.mycompany.supermercado.utils.ConverterData.convertToDate;
import static com.mycompany.supermercado.utils.ConverterData.convertToLocalDate;
import com.mycompany.supermercado.models.Produto;
import static com.mycompany.supermercado.views.TelaPrincipal.exibirMensagemItemVendido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProdutoDAO {

    public static boolean salvar(Produto obj) {
        boolean retorno = false;
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, password);

            PreparedStatement comandoSQL = conexao.prepareStatement(" INSERT INTO `produto`(CodigoProduto, Nome, Marca, Categoria, Valor, DataValidade, Quantidade, Status) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            comandoSQL.setLong(1, obj.getCodigo());
            comandoSQL.setString(2, obj.getNome());
            comandoSQL.setString(3, obj.getMarca());
            comandoSQL.setString(4, obj.getCategoria());
            comandoSQL.setDouble(5, obj.getValor());
            comandoSQL.setObject(6, convertToDate(obj.getValidade()));
            comandoSQL.setInt(7, obj.getQuantidade());
            comandoSQL.setBoolean(8, obj.getStatus());

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    public static ArrayList<Produto> listar() {

        ArrayList<Produto> lstProdutos = new ArrayList<Produto>();
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, password);

            PreparedStatement comandoSQL = conexao.prepareStatement(" SELECT * FROM `produto` ");

            ResultSet rs = comandoSQL.executeQuery();

            while (rs.next()) {
                long codigoProduto = rs.getLong("CodigoProduto");
                String nome = rs.getString("Nome");
                String marca = rs.getString("Marca");
                String categoria = rs.getString("Categoria");
                double valor = rs.getDouble("Valor");
                LocalDate dataValidade = convertToLocalDate(rs.getDate("DataValidade"));
                int quantidade = rs.getInt("Quantidade");
                boolean status = rs.getBoolean("Status");

                Produto novoProduto = new Produto(codigoProduto, nome, marca, categoria, valor, dataValidade, quantidade, status);
                lstProdutos.add(novoProduto);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstProdutos;
    }

    public static boolean alterar(Produto obj) {
        boolean retorno = false;
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, password);

            PreparedStatement comandoSQL = conexao.prepareStatement(" UPDATE produto SET Nome = ?, Marca = ?, Categoria = ?, Valor = ?, DataValidade = ?, Quantidade = ?, Status = ? "
                    + "WHERE CodigoProduto = ?");

            comandoSQL.setString(1, obj.getNome());
            comandoSQL.setString(2, obj.getMarca());
            comandoSQL.setString(3, obj.getCategoria());
            comandoSQL.setDouble(4, obj.getValor());
            comandoSQL.setObject(5, convertToDate(obj.getValidade()));
            comandoSQL.setInt(6, obj.getQuantidade());
            comandoSQL.setBoolean(7, obj.getStatus());
            comandoSQL.setLong(8, obj.getCodigo());

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas >= 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    public static boolean excluir(long idExcluir) {
        boolean retorno = false;
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, password);

            PreparedStatement comandoSQL = conexao.prepareStatement(" DELETE FROM `produto` WHERE CodigoProduto = ?");
            comandoSQL.setLong(1, idExcluir);

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLIntegrityConstraintViolationException e) {
            char letra = 'p';
            exibirMensagemItemVendido(letra);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    public static ArrayList<Produto> buscarPorTexto(String cod) {

        ArrayList<Produto> lstProdutos = new ArrayList<Produto>();
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, password);

            PreparedStatement comandoSQL = conexao.prepareStatement(" SELECT * FROM `produto` WHERE `Nome` = ?");
            comandoSQL.setString(1, cod);

            ResultSet rs = comandoSQL.executeQuery();

            while (rs.next()) {
                long codigoProduto = rs.getLong("CodigoProduto");
                String nome = rs.getString("Nome");
                String marca = rs.getString("Marca");
                String categoria = rs.getString("Categoria");
                double valor = rs.getDouble("Valor");
                LocalDate dataValidade = convertToLocalDate(rs.getDate("DataValidade"));
                int quantidade = rs.getInt("Quantidade");
                boolean status = rs.getBoolean("Status");

                Produto novoProduto = new Produto(codigoProduto, nome, marca, categoria, valor, dataValidade, quantidade, status);
                lstProdutos.add(novoProduto);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstProdutos;
    }

}
