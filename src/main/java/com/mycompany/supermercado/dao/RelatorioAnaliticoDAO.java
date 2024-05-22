package com.mycompany.supermercado.dao;

import static com.mycompany.supermercado.dao.ClienteDAO.login;
import static com.mycompany.supermercado.dao.ClienteDAO.password;
import static com.mycompany.supermercado.dao.ClienteDAO.url;
import com.mycompany.supermercado.models.RelatorioAnalitico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RelatorioAnaliticoDAO {
     public static ArrayList<RelatorioAnalitico> listar(int idVenda){
        
        ArrayList<RelatorioAnalitico> lstAnalitico = new ArrayList<RelatorioAnalitico>();
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(url, login, password);
            
            PreparedStatement comandoSQL = conexao.prepareStatement(" SELECT ItemVenda.`CodigoProduto`, " +
            "Produto.`Nome`, " +
            "ItemVenda.`ValorUnitario`, " +
            "ItemVenda.`Quantidade` " +
            "FROM ItemVenda INNER JOIN `Produto` ON ItemVenda.`CodigoProduto` = Produto.`CodigoProduto` " +
            "WHERE  ItemVenda.`VendaID` = ?; ");
            
            comandoSQL.setInt(1, idVenda);
            ResultSet rs = comandoSQL.executeQuery();
        
        while(rs.next()) {
            String nome = rs.getString("Produto.Nome");
            double valor = rs.getDouble("ItemVenda.ValorUnitario");
            int quantidade = rs.getInt("ItemVenda.Quantidade");

           
            lstAnalitico.add(new RelatorioAnalitico(nome, valor, quantidade));
        }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lstAnalitico;
    }
}
