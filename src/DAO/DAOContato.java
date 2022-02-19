/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.CONTATO;
import MODEL.Cidade;
import MODEL.Usuario;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author tux
 */
public class DAOContato extends DAOConexao{
    
    public void inserir(CONTATO contato ){  

        conectar();
			
        String sql = " INSERT INTO CONTATOS ( nomeContato, telefoneContato,"
        +"celularContato, emailContato, ruaContato,"
        +"bairroContato, numeroContato, cepContato,"
        +"complementoContato, obsContato, idCidadeContato,idUsuarioContato, idContato) VALUES "
        + "('"+contato.getNome()+",'"+contato.getTelefone()+"','"+contato.getCelular()+"',"
        + "'"+contato.getEmail()+"','"+contato.getRua()+"','"+contato.getBairro()+"',"
        + "'"+contato.getNumero()+"', '"+contato.getCep()+"','"+contato.getComplemento()+"',"
        + "'"+contato.getObservacoes()+"','"+contato.getCidade().getCodigo()+"', "
        + "'"+contato.getNome()+"','"+contato.getUsuario()+"');";
       
        try {    
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"CONTATO CADASTRADO COM SUCESSO","mENSAGEM DO SISTEMA", 0);
        } catch (SQLException ex) {
            imprimirErros("Erro ao cadastrar CONTATO", ex.getMessage());
        }finally{
            fechar();
        }     
    }
}
