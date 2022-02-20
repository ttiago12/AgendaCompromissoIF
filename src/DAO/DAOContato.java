/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.Contato;
import MODEL.Cidade;
import MODEL.Usuario;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author tux
 */
public class DAOContato extends DAOConexao{
    
    public void inserir(Contato contato ){  

        conectar();
			
        String sql = " INSERT INTO CONTATOS ( nomeContato, telefoneContato,"
        +"celularContato, emailContato, ruaContato,"
        +"bairroContato, numeroContato, cepContato,"
        +"complementoContato, obsContato, idCidadeContato,idUsuarioContato, idContato) VALUES "
        + "('"+contato.getNome()+",'"+contato.getTelefone()+"','"+contato.getCelular()+"',"
        + "'"+contato.getEmail()+"','"+contato.getRua()+"','"+contato.getBairro()+"',"
        + "'"+contato.getNumero()+"', '"+contato.getCep()+"','"+contato.getComplemento()+"',"
        + "'"+contato.getObservacoes()+"','"+contato.getCidade().getCodigo()+"', "
        + "'"+contato.getUsuario().getCodigo()+"',);";
       
        try {    
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"CONTATO CADASTRADO COM SUCESSO","mENSAGEM DO SISTEMA", 0);
        } catch (SQLException ex) {
            imprimirErros("Erro ao cadastrar CONTATO", ex.getMessage());
        }finally{
            fechar();
        }     
    }
    
    public Contato buscarContato(int codigo){
        conectar();

        ResultSet rs;

        String sql = "SELECT * FROM CONTATOS INNER JOIN USUARIOS ON idUsuarioContato = idContato "
                + "WHERE idUsuarioContato = '" + codigo +"';";

        Contato cont = new Contato();
        
        try {    
            
            rs = comando.executeQuery(sql);
            
            while (rs.next()) { 
                                            
				
		cont.setCodigo(rs.getInt("idContato"));
		cont.setNome(rs.getString("nomeContato"));
                cont.setTelefone(rs.getString("telefoneContato"));
                cont.setCelular(rs.getString("celularContato"));
                cont.setEmail(rs.getString("emailContato"));
                cont.setRua(rs.getString("ruaContato"));
                cont.setBairro(rs.getString("bairroContato"));
                cont.setObservacoes(rs.getString("obsContato"));
               
				
		Cidade cid = new Cidade();
                
                cid.setCodigo(rs.getInt("idCidade"));
                cid.setUf(rs.getString("ufCidade"));
                cid.setNome(rs.getString("nomeCidade"));
                
                Usuario user = new Usuario();
                user.setCodigo(rs.getInt("idUsuarioContato"));
        
                cont.setUsuario(user);
                
            }
            fechar();
            return cont;
            
            } catch (SQLException ex) {
            imprimirErros("Erro ao buscar conato pelo usuario", ex.getMessage());
            fechar();
            
            return null;
            }
    }
    
    public void atualizar (Contato contato){
        conectar();

            String sql = "UPDATE CONTATOS SET nomeContato = '"+contato.getNome()+"',"
            + "telefoneContato = '"+contato.getNome()+"',"
            + "celularContato = '"+contato.getCelular()+"',"
            + "emailContato = '"+contato.getEmail()+"',"
            + "ruaContato = '"+contato.getRua()+"',"
            + "bairroContato = '"+contato.getBairro()+"',"
            + "numeroContato = '"+contato.getNumero()+"',"
            + "cepContato = '"+contato.getCep()+"',"
            + "complementoContato = '"+contato.getComplemento()+"'," 
            + "obsContato = '"+contato.getObservacoes()+"',"
            + "WHERE idContato = '"+contato.getCodigo()+"'";
                
        
        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Dados do CONTATO atualizado com sucesso !!!", "Mensagem do Sistema", 0);
        } catch (SQLException ex) {
            imprimirErros("Erro ao atualizar os dados do CONTATO. ", ex.getMessage());
        } finally {
            fechar ();
        }
    }
    
    //buscar todos os contatos de um determinado usuario
    //utilizando conceitos do polimorfismo
    public ArrayList<Contato> buscarContatos(int idUsuario){
        conectar();

        ResultSet rs;

        String sql = "SELECT * FROM CONTATOS INNER JOIN USUARIOS ON idUsuarioContato = idContato "
                + "WHERE idUsuarioContato = '" + idUsuario+"';";

        ArrayList<Contato> contato = new ArrayList<>();
        
        try {    
            rs = comando.executeQuery(sql);
            
            while (rs.next()) { 
                Contato cont = new Contato();
                              
				
		cont.setCodigo(rs.getInt("idContato"));
		cont.setNome(rs.getString("nomeContato"));
                cont.setTelefone(rs.getString("telefoneContato"));
                cont.setCelular(rs.getString("celularContato"));
                cont.setEmail(rs.getString("emailContato"));
                cont.setRua(rs.getString("ruaContato"));
                cont.setBairro(rs.getString("bairroContato"));
                cont.setObservacoes(rs.getString("obsContato"));
               
				
		Cidade cid = new Cidade();
                
                cid.setCodigo(rs.getInt("idCidade"));
                cid.setUf(rs.getString("ufCidade"));
                cid.setNome(rs.getString("nomeCidade"));
                
                Usuario user = new Usuario();
                user.setCodigo(rs.getInt("idUsuarioContato"));
        
                cont.setUsuario(user);
                contato.add(cont);
            }
            fechar();
            return contato;
            
            } catch (SQLException ex) {
            imprimirErros("Erro ao buscar conato pelo usuario", ex.getMessage());
            fechar();
            
            return null;
            }
    }
            
            
    
     // Metodo para excluir um contato  
    public  void apagar (int idContato){
        conectar();
        
        String sql = "DELETE FROM CONTATOS WHERE idContato = '"+idContato+"'";
        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Contato deletado com sucesso");
        } catch (SQLException e ){
            imprimirErros("Erro ao deletar o Contato", e.getMessage());
        } finally{
           fechar(); 
        }
    }
}
