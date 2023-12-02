/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Matheus Carrasco
 */
public class ConexaoBancoDeDados {
    
        Connection conBanco;
        
        public boolean abrirConexao() throws SQLException{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conBanco = DriverManager.getConnection("jdbc:mysql://127.0.0.1/clinica_medica","root","1234");
                System.out.println("Conectado com sucesso.");
                return true;
            }catch (ClassNotFoundException ex) {
                System.out.println("Driver do banco de dados não encontrado.");  
                return false;
            }
        }
        
        public boolean fecharConexao(){
            try{
                conBanco.close();
                return true;
            }catch (SQLException erro){
                erro.printStackTrace();
                return false;
            }
        }
        
        public Connection obterConexao(){
            return conBanco;
        }
        
        
       }


        
        /*
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1/clinica_medica","root","1234");
            ResultSet rsCliente = conexao.createStatement().executeQuery("SELECT * FROM paciente");
            
            while(rsCliente.next()){
                System.out.println("Nome: " + rsCliente.getString("Nome"));
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não encontrado.");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco de dados: " + ex.getMessage());
        }finally{
            if(conexao != null){
            conexao.close();
            }
        }
        
        */
