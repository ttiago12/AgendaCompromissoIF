/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package REPORTS;

import DAO.DAOConexao;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author tux
 */
public class RelatorioCompromissos extends DAOConexao{
    
    public void previewCompromissos(int idUsuario){
	String sql =  "SELECT * FROM COMPROMISSOS WHERE idUsuarioCompromisso = '"+idUsuario+"'";
	
	String reportSource = "./src/REPORTS/reportcompromissos.jrxml";
	String reportSourceJasper = "./src/REPORTS/reportcompromissos.jasper";
	String reportSourcePrint = "./src/REPORTS/reportcompromissos.jrprint";
	
        
        
	try{
                JasperCompileManager.compileReportToFile(reportSource);
		JasperCompileManager.compileReportToFile(reportSource);
		Map <String, Object> params = new HashMap <String, Object>();
		conectar();
		ResultSet rs  = comando.executeQuery(sql);
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
		JasperFillManager.fillReportToFile(reportSourceJasper, params , jrRS);
		JasperViewer.viewReport(reportSourcePrint, false , false);
	}catch(SQLException ex){
		JOptionPane.showMessageDialog(null, "ERRO AO BUSCAR TODOS OS COMPROMISSOS DO USUARIO."+ex.getMessage());
	}catch (JRException ex){
                JOptionPane.showMessageDialog(null, "1ERRO AO EMITIR O RELATORIO DE TODOS OS COMPROMISSOS"
                    +"DO USUARIO"+ex.getMessage());
        }finally{
            fechar();
	
	}
    }
    
    public void previewCompromissos(int idUsuario ,String titulo){
	String sql =  "SELECT * FROM COMPROMISSOS WHERE idUsuarioCompromisso = '"+idUsuario+"'"
                +"AND tituloCompromisso LIKE '"+titulo+"%';";
                
	
	String reportSource = "./src/REPORTS/reportcompromissos.jrxml";
	String reportSourceJasper = "./src/REPORTS/reportcompromissos.jasper";
	String reportSourcePrint = "./src/REPORTS/reportcompromissos.jrprint";
	
        
        
	try{
                JasperCompileManager.compileReportToFile(reportSource);
		JasperCompileManager.compileReportToFile(reportSource);
		Map <String, Object> params = new HashMap <String, Object>();
		conectar();
		ResultSet rs  = comando.executeQuery(sql);
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
		JasperFillManager.fillReportToFile(reportSourceJasper, params , jrRS);
		JasperViewer.viewReport(reportSourcePrint, false , false);
	}catch(SQLException ex){
		JOptionPane.showMessageDialog(null, "ERRO AO BUSCAR TODOS OS COMPROMISSOS DO USUARIO."+ex.getMessage());
	}catch (JRException ex){
                JOptionPane.showMessageDialog(null, "2ERRO AO EMITIR O RELATORIO DE TODOS OS COMPROMISSOS"
                    +"DO USUARIO"+ex.getMessage());
        }finally{
            fechar();
	
	}
    }
    
    public void previewCompromissos(int idUsuario , String dataInicio , String dataTermino){
	
        String sql =  "SELECT * FROM COMPROMISSOS WHERE idUsuarioCompromisso = '"+idUsuario+"'"
                +"AND dataInicioCompromisso BETWEEN  '"+dataInicio+"' AND '"+dataTermino+"'";
                
	
	String reportSource = "./src/REPORTS/reportcompromissos.jrxml";
	String reportSourceJasper = "./src/REPORTS/reportcompromissos.jasper";
	String reportSourcePrint = "./src/REPORTS/reportcompromissos.jrprint";
	
        
        
	try{
                JasperCompileManager.compileReportToFile(reportSource);
		JasperCompileManager.compileReportToFile(reportSource);
		Map <String, Object> params = new HashMap <String, Object>();
		conectar();
		ResultSet rs  = comando.executeQuery(sql);
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
		JasperFillManager.fillReportToFile(reportSourceJasper, params , jrRS);
		JasperViewer.viewReport(reportSourcePrint, false , false);
	}catch(SQLException ex){
		JOptionPane.showMessageDialog(null, "ERRO AO BUSCAR TODOS OS COMPROMISSOS DO USUARIO."+ex.getMessage());
	}catch (JRException ex){
                JOptionPane.showMessageDialog(null, "3ERRO AO EMITIR O RELATORIO DE TODOS OS COMPROMISSOS"
                    +"DO USUARIO"+ex.getMessage());
        }finally{
            fechar();
	
	}
    }
}
