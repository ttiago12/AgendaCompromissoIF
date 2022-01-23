/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.Cidade;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAOCidade extends DAOConexao {
    
    //metodo responsavel por retornar os dados de todas as cidades cadasradas no banco de dados
    
    public ArrayList<Cidade> buscarCidade (String UF){
        
            //conectar com banco  de dados (metodo que criamos la nem conexao)
            conectar();
            
            ArrayList<Cidade> cidades = new ArrayList<Cidade>();
            
            ResultSet rs;
            
            
            // aspas duplas java
            //aspas simples sql
            //+concatena
        try {
            rs = comando.executeQuery("SELECT * FROM cidades WHERE ufCidade = '" + UF + "';");
            
            while (rs.next()) {
                Cidade cid = new Cidade();
                cid.setCodigo(rs.getInt("idCidade"));
                cid.setUf(rs.getString("ufCidade"));
                cid.setNome(rs.getString("nomeCidade"));
                cidades.add(cid);
            }
            fechar();          
            return cidades;
            
        } catch (SQLException ex) {
            imprimirErros("Erro ao buscar as cidades. ", ex.getMessage());
            fechar();
            
            return null;
        }
    }
    
    public Cidade buscarCidade(int codigo){
        conectar();

        ResultSet rs;

        Cidade cid = new Cidade();
            
        try {
            rs = comando.executeQuery("SELECT * FROM cidades WHERE idCidade = '" + codigo + "';");
            
            while (rs.next()) {
                cid.setCodigo(rs.getInt("idCidade"));
                cid.setNome(rs.getString("ufCidade"));
                cid.setNome(rs.getString("nomeCidade"));
            }
            fechar();
            
            return cid;
        } catch (SQLException ex) {
            imprimirErros("Erro ao buscar cidade pelo código. ", ex.getMessage());
            fechar();
            
            return null;
        }      
    }   
    
    public int getIdCidade (String nome, String uf){
        conectar();

        ResultSet rs;

        int codigoCidade = 0;
            
        try {
            rs = comando.executeQuery("SELECT idCidade FROM cidades WHERE nomeCidade = '" + nome + "' AND ufCidade = '" + uf + "';");
            
            while (rs.next()) {
                codigoCidade = rs.getInt("idCidade");
            }
            fechar();
            
            return codigoCidade;
        } catch (SQLException ex) {
            imprimirErros("Erro ao buscar o código da cidade. ", ex.getMessage());
            fechar();
            
            return 0;
        }
    }
}
