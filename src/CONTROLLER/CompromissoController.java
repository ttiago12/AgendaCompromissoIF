/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import DAO.DAOCompromisso;
import MODEL.Compromisso;
import java.util.ArrayList;

/**
 *
 * @author tux
 */
public class CompromissoController {
    DAOCompromisso dao;
    
    public CompromissoController(){
        dao = new DAOCompromisso();
    
    }
    
    public void inserir(Compromisso compromisso){
       dao.inserir(compromisso);
    }
    public Compromisso buscarCompromisso(int codigo, int idCompromisso){
        return dao.buscarCompromisso(codigo, idCompromisso);
    }
    public void atualizar (Compromisso comp){
        dao.atualizar(comp);
    }
    
    public ArrayList<Compromisso> buscarCompromisso(int idUsuario){
     return dao.buscarCompromisso(idUsuario);
    }
    public ArrayList<Compromisso> buscarCompromisso(int idUsuario, String titulo){
        return dao.buscarCompromisso(idUsuario, titulo);
    }
    public ArrayList<Compromisso> buscarCompromisso(int idUsuario, String  dataInicio, String dataTermino){
        return dao.buscarCompromisso(idUsuario, dataInicio, dataTermino);
    }
    public  void apagar (int idCompromisso){
        dao.apagar(idCompromisso);
    }
}
