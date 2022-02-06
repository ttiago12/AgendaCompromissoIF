/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.Compromisso;
import MODEL.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tux
 */
public class DAOCompromisso extends DAOConexao{
        
    //metodo responsavel por inserir os dados do compromisso
    public void inserir(Compromisso compromisso ){       
        //conecta com o banco de dados
        conectar();

        //insere os dados no banco e dados
        String sql =  "INSERT INTO COMPROMISSOS (tituloCompromisso, dataInicioCompromisso," 
            + " dataFimCompromisso, horaInicioCompromisso, horaFimCompromisso, localCompromisso,"
            + "descricaoCompromisso, idUsuarioCompromisso) VALUES "
               //EXEMPLO DE IN - VALUES ..."('"+valor+"','"+valor+"');";
            + "('"+compromisso.getTitulo()+"','"+compromisso.getDataInicio()+"'," 
            +"'"+compromisso.getDataTermino()+"','"+compromisso.getHoraInicio()+"'," 
            +"'"+compromisso.getHoraTermino()+"','"+compromisso.getLocal()+"',"
            +"'"+compromisso.getDescricao()+"', '"+compromisso.getUsuario().getCodigo()+"');"; 
             
                    
        try{           
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"COMPROMISSO CADASTRADO COM SUCESSO","mENSAGEM DO SISTEMA", 0);
        } catch (SQLException ex) {
            imprimirErros("Erro ao cadastrar compromisso", ex.getMessage());
        }finally{
            fechar();
        }                  
}
    
    //buscar compromisso pelo codigo 
    public Compromisso buscarCompromisso(int codigo , int idCompromisso){
        conectar();

        ResultSet rs;

        String sql = "SELECT * FROM COMPROMISSOS INNER JOIN USUARIO ON idCompromissoUsuario = idUsuario WHERE idUsuarioCompromisso = '" + codigo + "'AND idCompromisso = '"+idCompromisso+"';";

        Compromisso comp = new Compromisso();
        
        try {    
            rs = comando.executeQuery(sql);
            
            while (rs.next()) {            
                comp.setCodigo(rs.getInt("idCompromisso"));
                comp.setDataInicio(rs.getString("nomedataInicioCompromisso"));
                comp.setDataTermino(rs.getString("dataInicioCompromisso"));
                comp.setHoraInicio(rs.getString("horaInicioCompromisso"));
                comp.setHoraTermino(rs.getString("horaFimCompromisso"));
                comp.setLocal(rs.getString("localCompromisso"));
                comp.setTitulo(rs.getString("tituloCompromisso"));
                comp.setDescricao(rs.getString("descricaoCompromisso"));
                
				
		Usuario user = new Usuario();
		user.setCodigo(rs.getInt("idUsuarioCompromisso "));
				
		comp.setUsuario(user);
            }
            fechar();
            
            return comp;
            
        } catch (SQLException ex) {
            imprimirErros("Erro ao buscar compromisso pelo codigo", ex.getMessage());
            fechar();
            
            return null;
        }       
    }
    
    //buscar todos os compromisso pelo codigo 
    //utilizando conceitos do polimorfismo
    public ArrayList<Compromisso> buscarCompromisso(int idUsuario){
        conectar();

        ResultSet rs;

        String sql = "SELECT * FROM COMPROMISSOS INNER JOIN USUARIO ON idCompromissoUsuario = idUsuario "
                + "WHERE idCompromissoUsuario = '" + codigo + "'AND idCompromisso = '"+idCompromisso+"';";

        Compromisso comp = new Compromisso();
        
        try {    
            rs = comando.executeQuery(sql);
            
            while (rs.next()) {            
                comp.setCodigo(rs.getInt("idCompromisso"));
                comp.setDataInicio(rs.getString("nomedataInicioCompromisso"));
                comp.setDataTermino(rs.getString("dataInicioCompromisso"));
                comp.setHoraInicio(rs.getString("horaInicioCompromisso"));
                comp.setHoraTermino(rs.getString("horaFimCompromisso"));
                comp.setLocal(rs.getString("localCompromisso"));
                comp.setTitulo(rs.getString("tituloCompromisso"));
                comp.setDescricao(rs.getString("descricaoCompromisso"));
                
				
		Usuario user = new Usuario();
		user.setCodigo(rs.getInt("idCompromissoUsuario"));
				
		comp.setUsuario(user);
            }
            fechar();
            
            return comp;
            
        } catch (SQLException ex) {
            imprimirErros("Erro ao buscar compromisso pelo codigo", ex.getMessage());
            fechar();
            
            return null;
        }       
    }
    // Método para atualizar os dados do compromisso
    public void atualizar (Compromisso comp){
        conectar();

        String sql = "UPDATE COMPROMISSOS SET tituloCompromisso = '" + comp.getTitulo()
                + "dataInicioCompromisso = '" + comp.getDataInicio()+ "', "
                + "dataFimCompromisso = '" + comp.getDataTermino()+ "', "
                + "horaInicioCompromisso = '" + comp.getHoraInicio()+ "', "
                + "horaFimCompromisso = '" + comp.getHoraTermino()+ "', "
                + "localCompromisso = '" + comp.getLocal()+ "', "
                + "descricaoCompromisso = '" + comp.getDescricao()+ "', "
                + "WHERE idCompromisso = '"+comp.getCodigo()+"';";
                
        
        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Dados do compromisso atualizado com sucesso !!!", "Mensagem do Sistema", 0);
        } catch (SQLException ex) {
            imprimirErros("Erro ao atualizar os dados do compromisso. ", ex.getMessage());
        } finally {
            fechar ();
        }
    }

}
