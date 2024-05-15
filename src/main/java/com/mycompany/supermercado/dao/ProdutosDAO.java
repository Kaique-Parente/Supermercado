package com.mycompany.supermercado.dao;

import static com.mycompany.supermercado.models.ConverterData.convertToDate;
import com.mycompany.supermercado.models.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutosDAO {
    
    static String url = "jdbc:mysql://localhost:3306/supermercadobc";
    static String login = "root";
    static String password = "Root123@";
    
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
            
            if(linhasAfetadas>0){
                retorno = true;
            }
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }
    
}
