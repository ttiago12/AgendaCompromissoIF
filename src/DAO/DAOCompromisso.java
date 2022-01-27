/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.Compromisso;
import MODEL.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author tux
 */
public class DAOCompromisso extends DAOConexao{
    
    //metodo responsavel por inserir os dados do compromisso
    public void inserir(Compromisso Compromisso ){
        
            //conecta com o banco de dados
            conectar();
            
            //insere os dados no banco e dados
            String sql =  "INSERT INTO COMPROMISSOS (tituloCompromisso, dataInicioCompromisso," + ""
                + " dataFimCompromisso, horaInicioCompromisso, horaFimCompromisso, localCompromisso,"
                + "descricaoCompromisso, idUsuarioCompromisso) VALUES ('"  
                + Compromisso.getTitulo()+ "', '" +Compromisso.getDataInicio()+ "', '" 
                + Compromisso.getDataTermino() + "', '" + Compromisso.getHoraInicio() + "', '" 
                + Compromisso.getHoraTermino() + "', '"
                + Compromisso.getLocal()   + "', '" + Compromisso.getDescricao() 
                + "', '" + Compromisso.getUsuario().getCodigo()+ "');";
                    
        try{           
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"COMPROMISSO CADASTRADO COM SUCESSO","mENSAGEM DO SISTEMA", 0);
        } catch (SQLException ex) {
            imprimirErros("Erro ao compromisso", ex.getMessage());
        }finally{
            fechar();
        }
                      
    }
    
    //buscar compromisso
    public Compromisso buscarCompromisso(int codigo){
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
}
