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

        String sql = "SELECT * FROM USUARIOS INNER JOIN USUARIO ON idCompromissoUsuario = idUsuario WHERE idCompromissoUsuario = '" + codigo + "';";

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
}
