/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import DAO.DAOUsuario;
import MODEL.Usuario;

public class UsuarioController {
    
    DAOUsuario dao;
    
    public UsuarioController(){
        dao = new DAOUsuario();
    }
    
    public void inserir(Usuario usuario){
        dao.inserir(usuario);
    }
    
    public Usuario verificarUsuario(String login , String senha){
        return dao.verificarUsuario(login, senha);
    }
    
    public Usuario buscarUsuario(int codigo){
        return dao.buscarUsuario(codigo);
    }
}
