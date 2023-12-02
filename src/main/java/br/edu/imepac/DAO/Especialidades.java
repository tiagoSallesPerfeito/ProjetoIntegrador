/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Matheus Carrasco
 */
public class Especialidades {
    
    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistro;
    
    public void configurarConexao(Connection conBanco){
        this.conBanco = conBanco;
    }
    
    public boolean inserirRegistro(String strDescricao) { 
        String strComandoSQL;        
        try { 
            strComandoSQL = "INSERT INTO especialidades(Descricao_Especialidade) VALUES('"+ strDescricao +"')"; 
            psComando = conBanco.prepareStatement(strComandoSQL); 
            psComando.executeUpdate();
            return true;
        }catch (Exception erro){
            erro.printStackTrace(); 
            return false;
        }
    }
    
    public boolean alterarRegistro(int intCodigo, String strDescricao){
        String strComandoSQL;
        try { 
            strComandoSQL = "UPDATE especialidades SET Descricao_Especialidade = '"+ strDescricao +"' WHERE Codigo_Especialidade = " + intCodigo; 
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;    
        }catch (Exception erro){
            erro.printStackTrace(); 
            return false;
        }
    }

    public boolean excluirRegistro(int intCodigo){
        String strComandoSQL;        
        try { 
            strComandoSQL = "DELETE FROM especialidades WHERE Codigo_Especialidade = " + intCodigo; 
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;    
        }catch (Exception erro){
            erro.printStackTrace(); 
            return false;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}