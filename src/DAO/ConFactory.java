/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tux
 */
public class ConFactory {
    // variavel de conexao
    
       
    public static final int MYSQL = 0;
    //driver do mysql , qual drive iremos utilizar 
    private static final String MYSQLDriver = "com.mysql.cj.jdbc.Driver";
    //pegar o caminho de onde o banco de dados esta configurado
    private static final String URL = "jdbc:mysql://localhost:3306/agendacompromisso";
    //usuario de banco de dados
    private static final String USUARIO = "root";
    //senha do banco de dados
    private static final String SENHA = "12345678";
    
    
    //metodo responsavel o drive do BD  que sera utilizado
    public static Connection conexao(int bancoDados) throws ClassNotFoundException, SQLException {
        switch(bancoDados){
            case MYSQL: {
                Class.forName(MYSQLDriver);
                break;
            }
        }
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
