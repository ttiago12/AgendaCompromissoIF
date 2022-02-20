/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import DAO.DAOContato;
import MODEL.Contato;
import java.util.ArrayList;

/**
 *
 * @author tux
 */
public class ContatoController {
    DAOContato dao;
    
    public ContatoController(){
        dao = new DAOContato();
    }
    
    public void inserir(Contato contato){
        dao.inserir(contato);
    }
    
    /*public Contato apagarContato(int idContato){
        return dao.buscarContato(idContato);
    }*/
    
	 public void atualizar (Contato contato){
        dao.atualizar(contato);
    }
	
    public Contato buscarContato(int idContato){
        return dao.buscarContato(idContato);
    }
	
	 public ArrayList<Contato> buscarContatos(int idUsuario){
        return dao.buscarContatos(idUsuario);
    }
    
	/* public ArrayList<Contato> buscarContatos(int idUsuario , String nome){
        return dao.buscarContato(idUsuario,nome);
    }*/
}
