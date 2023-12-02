/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.DAO;

import br.edu.imepac.entidades.C_convenios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Matheus Carrasco
 */
public class Convenios {
    
    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistro;
    
    public void configurarConexao(Connection conBanco){
        this.conBanco = conBanco;
    }
       
    public boolean inserirRegistro(C_convenios convenio) { 
        String strComandoSQL;    
        
        try { 
            strComandoSQL = "INSERT INTO convenios (Empresa_Convenio, CNPJ, "
                    + "Telefone) VALUES('"+ convenio.getNomeConvenio() + "',"
                    + "'" + convenio.getCNPJ() + "',"
                    + "'" + convenio.getTelefone() + "')";
            psComando = conBanco.prepareStatement(strComandoSQL); 
            psComando.executeUpdate();
            return true;
        }catch (Exception erro){
            erro.printStackTrace(); 
            return false;
        }
    } 
    
     public ResultSet lerRegistro(int intCodigoConvenio){        
        String strComandoSQL;
        
                try {
            strComandoSQL = "SELECT * FROM convenios WHERE Codigo_Convenio = "
                     + intCodigoConvenio;
            psComando = conBanco.prepareStatement(strComandoSQL); 
            rsRegistro = psComando.executeQuery(); 
            rsRegistro.next();
            return rsRegistro;
            
        }catch (Exception erro){
            erro.printStackTrace(); 
            return null;
        }
    }
     
    public boolean alterarRegistro(C_convenios convenio){
        String strComandoSQL;
        
        try{
            strComandoSQL = "UPDATE convenios SET Empresa_Convenio = '"
                    + convenio.getNomeConvenio() + "', "
                    + "CNPJ = '" + convenio.getCNPJ() + "', "
                    + "Telefone = '" + convenio.getTelefone() + "' "
                    + "WHERE Codigo_Convenio = " + convenio.getCodigoConvenio();
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;
            
        }catch (Exception erro){
            erro.printStackTrace(); 
            return false;
        }
    }
    
     public boolean excluirRegistro(int intCodigoConvenio){
                String strComandoSQL;        
        try { 
            strComandoSQL = "DELETE FROM convenios WHERE Codigo_Convenio = " + intCodigoConvenio; 
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
            strComandoSQL = "SELECT * FROM convenios ORDER BY Empresa_Convenio";
            psComando = conBanco.prepareStatement(strComandoSQL);
            rsRegistro = psComando.executeQuery();
            return rsRegistro;
        }catch (Exception erro){
            erro.printStackTrace(); 
            return null;
        } 
    }
}
