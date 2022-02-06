/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package DAO;

import MODEL.Cidade;
import MODEL.Usuario;
import java.sql.ResultSet;
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

        String sql = "SELECT * FROM USUARIOS INNER JOIN CIDADES ON idCidadeUsuario = idCidade WHERE cpfUsuario = '" + login + "' AND "
                + "senhaUsuario = '" + senha +"';";

        Usuario user = new Usuario();
        
        try {    
            rs = comando.executeQuery(sql);
            
            while (rs.next()) {            
                user.setCodigo(rs.getInt("idUsuario"));
                user.setNome(rs.getString("nomeUsuario"));
                user.setTelefone(rs.getString("telefoneUsuario"));
                user.setCelular(rs.getString("celularUsuario"));
                user.setEmail(rs.getString("emailUsuario"));
                user.setRua(rs.getString("ruaUsuario"));
                user.setNumero(rs.getInt("numeroUsuario"));
                user.setBairro(rs.getString("bairroUsuario"));
                user.setCep(rs.getString("cepUsuario"));
                user.setComplemento(rs.getString("complementoUsuario"));
                user.setCpf(rs.getString("cpfUsuario"));
                user.setSenha(rs.getString("senhaUsuario"));
                
                Cidade cid = new Cidade();
                
                cid.setCodigo(rs.getInt("idCidade"));
                cid.setUf(rs.getString("ufCidade"));
                cid.setNome(rs.getString("nomeCidade"));
                
                user.setCidade(cid);
            }
            fechar();
            
            return user;
        } catch (SQLException ex) {
            imprimirErros("Erro ao validar usuário. ", ex.getMessage());
            fechar();
            
            return null;
        }

        
    }
    
    //metodo para buscar o usuario pelo codigo 
    
    public Usuario buscarUsuario(int codigo){
        conectar();

        ResultSet rs;

        String sql = "SELECT * FROM USUARIOS INNER JOIN CIDADES ON idCidadeUsuario = idCidade WHERE idUsuario = '" + codigo + "';";

        Usuario user = new Usuario();
        
        try {    
            rs = comando.executeQuery(sql);
            
            while (rs.next()) {            
                user.setCodigo(rs.getInt("idUsuario"));
                user.setNome(rs.getString("nomeUsuario"));
                user.setTelefone(rs.getString("telefoneUsuario"));
                user.setCelular(rs.getString("celularUsuario"));
                user.setEmail(rs.getString("emailUsuario"));
                user.setRua(rs.getString("ruaUsuario"));
                user.setNumero(rs.getInt("numeroUsuario"));
                user.setBairro(rs.getString("bairroUsuario"));
                user.setCep(rs.getString("cepUsuario"));
                user.setComplemento(rs.getString("complementoUsuario"));
                user.setCpf(rs.getString("cpfUsuario"));
                user.setSenha(rs.getString("senhaUsuario"));
                
                Cidade cid = new Cidade();
                
                cid.setCodigo(rs.getInt("idCidade"));
                cid.setUf(rs.getString("ufCidade"));
                cid.setNome(rs.getString("nomeCidade"));
                
                user.setCidade(cid);
            }
            fechar();
            
            return user;
        } catch (SQLException ex) {
            imprimirErros("Erro ao buscar usuário pelo codigo", ex.getMessage());
            fechar();
            
            return null;
        }

        
    }
    
    //Metodo para atualizar os dados do usuario
     public void atualizar (Usuario user){
        conectar();

        String sql = "UPDATE USUARIOS SET nomeUsuario = '" + user.getNome()+"',"
                + "telefoneUsuario = '" + user.getTelefone()+ "', "
                + "celularUsuario = '" + user.getCelular()+ "', "
                + "emailUsuario = '" + user.getEmail()+ "', "
                + "ruaUsuario = '" + user.getRua() + "', "
                + "bairroUsuario = '" + user.getBairro() + "', "
                + "numeroUsuario = '" + user.getNumero() + "', "
                + "cepUsuario = '" + user.getCep()+ "', "
                + "complementoUsuario = '" + user.getComplemento() + "', "
                + "cpfUsuario = '" + user.getCpf() + "', "
                + "senhaUsuario = '" + user.getSenha()+ "', "
                + "idCidadeUsuario = '" + user.getCidade().getCodigo() + "' "
                + "WHERE idUsuario = '" + user.getCodigo() + "';";
        
        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "DAdos do Usuário atualizado com sucesso!!!", "Mensagem do Sistema", 0);
        } catch (SQLException ex) {
            imprimirErros("Erro ao atualizar os dados do usuário. ", ex.getMessage());
        } finally {
            fechar ();
        }
    }
    
}
