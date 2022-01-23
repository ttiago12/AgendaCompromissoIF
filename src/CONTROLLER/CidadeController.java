/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;
import DAO.DAOCidade;
import MODEL.Cidade;
import java.util.ArrayList;

/**
 *
 * 
 */
public class CidadeController {
    
    DAOCidade dao;
    
    public CidadeController(){
        dao = new DAOCidade();
    }
    
    public Cidade buscarCidades(int codigo){
        return dao.buscarCidade(codigo);
    }
    
    public ArrayList<Cidade> buscarCidades(String uf){
        return dao.buscarCidade(uf);
    }
    
    public int getIdCidade(String uf, String nome){
        return dao.getIdCidade(nome, uf);
    }
    
    public Cidade buscarCidade(String uf , String nome){
        return dao.buscarCidades(uf, nome);
    }
}
