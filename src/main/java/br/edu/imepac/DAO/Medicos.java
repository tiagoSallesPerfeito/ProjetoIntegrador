/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.DAO;

import br.edu.imepac.entidades.C_convenios;
import br.edu.imepac.entidades.C_medicos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Matheus Carrasco
 */
public class Medicos {
    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistro;
    
    public void configurarConexao(Connection conBanco) {
        this.conBanco = conBanco;
    }

    public boolean inserirRegistro(C_medicos medico){
         String strComandoSQL;  
    
         try{
             strComandoSQL = "INSERT INTO medicos(Nome_Medico, CRM, Codigo_Especialidade)"
                     + " VALUES('" + medico.getNomeMedico() + "', "
                     + "'" + medico.getCRM() + "', "
                     + "'" + medico.getCodigoEspecialidade() + "')";
             psComando = conBanco.prepareStatement(strComandoSQL);
             psComando.executeUpdate();
             return true;     
             
        }catch (Exception erro){
            erro.printStackTrace(); 
            return false;
        }
    }
    
    public ResultSet lerRegistro(int intCodigoMedico){        
        String strComandoSQL;
        
            try {
            strComandoSQL = "SELECT * FROM medicos WHERE Codigo_Medico = "
                     + intCodigoMedico;
            psComando = conBanco.prepareStatement(strComandoSQL); 
            rsRegistro = psComando.executeQuery(); 
            rsRegistro.next();
            return rsRegistro;
            
        }catch (Exception erro){
            erro.printStackTrace(); 
            return null;
        }
    }
    
     public boolean alterarRegistro(C_medicos medico){
        String strComandoSQL;
        
        try{
            strComandoSQL = "UPDATE medicos SET Nome_Medico = '"
                    + medico.getNomeMedico() + "', "
                    + "CRM = '" + medico.getCRM() + "', "
                    + "Codigo_Especialidade = '" + medico.getCodigoEspecialidade() + "' "
                    + "WHERE Codigo_Medico = " + medico.getCodigoMedico();
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;
            
        }catch (Exception erro){
            erro.printStackTrace(); 
            return false;
        }
    }
     
    public boolean excluirRegistro(int intCodigoMedico){
                String strComandoSQL;        
        try { 
            strComandoSQL = "DELETE FROM medicos WHERE Codigo_Medico = " + intCodigoMedico; 
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;    
        }catch (Exception erro){
            erro.printStackTrace(); 
            return false;
        }
     }
      
    public ResultSet listarRegistros(){
        String strComandoSQL;        
        try { 
            strComandoSQL = "SELECT * FROM medicos ORDER BY Nome_Medico";
            psComando = conBanco.prepareStatement(strComandoSQL);
            rsRegistro = psComando.executeQuery();
            return rsRegistro;
        }catch (Exception erro){
            erro.printStackTrace(); 
            return null;
        } 
    }   
    
    public ResultSet listarMedicosEspecialidades(){
        String strComandoSQL;        
        try { 
            strComandoSQL = "SELECT medicos.Codigo_Medico AS CodigoMedico,"
                    + "medicos.Nome_Medico AS Medico,"
                    + "especialidades.Codigo_Especialidade AS CodigoEspecialidade,"
                    + "especialidades.Descrição_Especialidade AS Especialidade"
                    + " FROM medicos, especialidades"
                    + " WHERE medicos.Codigo_Especialidade = especialidades.Codigo_Especialidade"
                    + " ORDER BY medicos.Nome_Medico";    
            
            psComando = conBanco.prepareStatement(strComandoSQL);
            rsRegistro = psComando.executeQuery();            
           return rsRegistro;         
           
        }catch (Exception erro){
            erro.printStackTrace(); 
            return null;   
        }
    }
    
}














