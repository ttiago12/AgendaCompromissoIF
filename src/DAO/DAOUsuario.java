/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package DAO;

import MODEL.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tux
 */
public class DAOUsuario extends DAOConexao{
    public void inserir(Usuario usuario){
        
            //conecta com o banco de dados
            conectar();
            
            //insere os dados no banco e dados
            String sql = "INSERT INTO USUARIOS (nomeUsuario, telefoneUsuario, celularUsuario,"
                    + " emailUsuario, ruaUsuario, bairroUsuario,"
                    + "numeroUsuario, cepUsuario, complementoUsuario, cpfUsuario, "
                    + "senhaUsuario, idCidadeUsuario) VALUES"
                    
                    //'"+objeto.get---()+'",'"
                    //+objeto.get---()+,'"
                    + "( '"+usuario.getNome()+"','"+usuario.getTelefone()+"','"			
                    +usuario.getCelular()+"','"+usuario.getEmail()+"','"
                    +usuario.getRua()+"','"+usuario.getBairro()+"','"
                    +usuario.getNumero()+"','"+usuario.getComplemento()+"','"
                    +usuario.getCep()+"','"+usuario.getCpf()+"','"
                    //objeto do tipo cidade e pegamos o codigo dentro dele
                    +usuario.getSenha()+"','"+usuario.getCidade().getCodigo()+"');";
        try {    
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"USUARIO CADASTRADO COM SUCESSO","mENSAGEM DO SISTEMA", 0);
        } catch (SQLException ex) {
            imprimirErros("Erro ao cadastrar usuário", ex.getMessage());
        }finally{
            fechar();
        }
                      
    }
    
    //metodo de verificacao de senha
    
    public Usuario verificarUsuario(String login , String senha){
        conectar();
        
        ResultSet rs;
        
        
    }
}
