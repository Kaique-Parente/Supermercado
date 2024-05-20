package com.mycompany.supermercado.dao;

import static com.mycompany.supermercado.dao.ClienteDAO.login;
import static com.mycompany.supermercado.dao.ClienteDAO.password;
import static com.mycompany.supermercado.dao.ClienteDAO.url;
import com.mycompany.supermercado.models.RelatorioSintetico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RelatorioSinteticoDAO {

    public static ArrayList<RelatorioSintetico> listar(Date dataInicio, Date dataTermino) {

        ArrayList<RelatorioSintetico> lstRelatorioSintetico = new ArrayList<RelatorioSintetico>();
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, password);

            PreparedStatement comandoSQL = conexao.prepareStatement(" SELECT Venda.`VendaID`, "
                    + "Venda.`ClienteID`, "
                    + "Cliente.`Nome`, "
                    + "Venda.`DataVenda`,"
                    + "Venda.`ValorVenda` "
                    + "FROM `Venda` INNER JOIN Cliente ON Venda.`ClienteID` = Cliente.`ClienteID`"
                    + "WHERE `DataVenda` BETWEEN ? AND ?; ");

            comandoSQL.setDate(1, new java.sql.Date(dataInicio.getTime()));
            comandoSQL.setDate(2, new java.sql.Date(dataTermino.getTime()));
            ResultSet rs = comandoSQL.executeQuery();

            while(rs.next()){
                int idVenda = rs.getInt("Venda.VendaID");
                int idCiente = rs.getInt("Venda.ClienteID");
                String nome = rs.getString("Cliente.Nome");
                Date dataVenda = rs.getDate("Venda.DataVenda");
                float valorVenda = rs.getFloat("Venda.ValorVenda");
                
                lstRelatorioSintetico.add(new RelatorioSintetico(dataVenda, idCiente, idVenda, nome, valorVenda));
            }
            

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstRelatorioSintetico;
    }
}
