package com.mycompany.supermercado.dao;

import com.mycompany.supermercado.models.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {
    
    static String url = "jdbc:mysql://localhost:3306/supermercadobc";
    static String login = "root";
    static String password = "Root123@";
    
    public static boolean salvar(Cliente obj) {
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(url, login, password);
            
            PreparedStatement comandoSQL = conexao.prepareStatement(" INSERT INTO `Cliente`(Nome, CPF, Telefone, Email, EstadoCivil, Sexo, Rua, Estado, Bairro, DataNascimento) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
            
            comandoSQL.setString(1, obj.getNome());
            comandoSQL.setLong(2, obj.getCpf());
            comandoSQL.setLong(3, obj.getTelefone());
            comandoSQL.setString(4, obj.getEmail());
            comandoSQL.setString(5, obj.getEstadoCivil());
            comandoSQL.setString(6, obj.getSexo());
            comandoSQL.setString(7, obj.getRua());            
            comandoSQL.setString(8, obj.getEstado());            
            comandoSQL.setString(9, obj.getBairro());
            comandoSQL.setObject(10, Cliente.convertToDate(obj.getDataNascimento()));
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
        
    }
    
    public static ArrayList<Cliente> listar(){
        
        ArrayList<Cliente> lstClientes = new ArrayList<Cliente>();
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(url, login, password);
            
            PreparedStatement comandoSQL = conexao.prepareStatement(" SELECT * FROM `Cliente` ");
            
        ResultSet rs = comandoSQL.executeQuery();
        
        while(rs.next()) {
            int clienteID = rs.getInt("ClienteID");
            String nome = rs.getString("Nome");
            long cpf = Long.parseLong(rs.getString("CPF"));
            long telefone = Long.parseLong(rs.getString("Telefone"));
            String email = rs.getString("Email");
            String estadoCivil = rs.getString("EstadoCivil");
            String sexo = rs.getString("Sexo");
            String rua = rs.getString("Rua");
            String estado = rs.getString("Estado");
            String bairro = rs.getString("Bairro");
            LocalDate data = Cliente.convertToLocalDate(rs.getDate("DataNascimento"));
            
            Cliente novoCliente = new Cliente(clienteID, nome, cpf, telefone, email, estadoCivil, sexo, rua, estado, bairro, data);
            lstClientes.add(novoCliente);
        }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lstClientes;
    }
}
