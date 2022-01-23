/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DAOConexao {
    protected java.sql.Connection con;
    protected java.sql.Statement comando;
   
    //metodo responsavel por conecta o banco de dados
    protected void conectar(){
        try {
            con = (java.sql.Connection) ConFactory.conexao(ConFactory.MYSQL);
            comando = (java.sql.Statement) con.createStatement();
        } catch (ClassNotFoundException ex) {
            imprimirErros("Erro ao carregar o drive do banco de dados. ", ex.getMessage());
        } catch (SQLException ex) {
            imprimirErros("Erro ao conectar no banco de dados. ", ex.getMessage());
        }
    }
    
    //metodo para retornar erro
    protected void imprimirErros (String msg, String msgErro){
        JOptionPane.showMessageDialog(null, msg + "\nErro: " + msgErro , "Erro crítico", 0);
        System.exit(0);
    }
    
    
    //metodo responsavel por fechar
    protected void fechar(){
        try {
            comando.close();
            con.close();
        } catch (SQLException ex) {
            imprimirErros("Erro ao fechar a conexão com o banco de Dados. ", ex.getMessage());
        }
    }
}
