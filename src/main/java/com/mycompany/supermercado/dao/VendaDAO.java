package com.mycompany.supermercado.dao;

import static com.mycompany.supermercado.dao.ClienteDAO.login;
import static com.mycompany.supermercado.dao.ClienteDAO.password;
import static com.mycompany.supermercado.dao.ClienteDAO.url;
import com.mycompany.supermercado.models.ItemVenda;
import com.mycompany.supermercado.models.Venda;
import static com.mycompany.supermercado.utils.ConverterData.convertToDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDAO {

    public static boolean salvar(Venda obj) {
        boolean retorno = false;
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, password);

            PreparedStatement comandoSQL = conexao.prepareStatement(" INSERT INTO `Venda` (DataVenda, ValorVenda, ClienteID) VALUES (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            comandoSQL.setObject(1, convertToDate(obj.getDataVenda()));
            comandoSQL.setDouble(2, obj.getValorVenda());
            comandoSQL.setInt(3, obj.getIdCliente());

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {

                ResultSet rs = comandoSQL.getGeneratedKeys();

                if (rs.next()) {
                    int id = rs.getInt(1);
                    PreparedStatement comandoSQL2 = conexao.prepareStatement(" INSERT INTO `ItemVenda` (VendaID, CodigoProduto, Quantidade, ValorUnitario) VALUES (?,?,?,?)");
                    for (ItemVenda item : obj.getItens()) {
                        comandoSQL2.setInt(1, id);
                        comandoSQL2.setLong(2, item.getIdProduto());
                        comandoSQL2.setInt(3, item.getQtProduto());
                        comandoSQL2.setDouble(4, item.getVlrUnitario());

                    }
                    int linhasAfetadas2 = comandoSQL2.executeUpdate();
                    if (linhasAfetadas > 0) {
                        retorno = true;
                    }

                }

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;

    }
}
