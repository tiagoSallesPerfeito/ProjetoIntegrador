/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.DAO;

import br.edu.imepac.entidades.C_prontuarios;
import br.edu.imepac.util.Conversao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author Matheus Carrasco
 */
public class Prontuarios {
    
    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistro;
    
    public void configurarConexao(Connection conBanco){
        this.conBanco = conBanco;
    }
    
    public boolean registrarAtendimento(C_prontuarios prontuario){
        String strComandoSQL;
        
        try{
            strComandoSQL = "INSERT INTO prontuario_paciente(Registro_Agenda,"
                    + " Historico, Receituario, Exames, Codigo_Paciente)"
                    + " VALUES(" + prontuario.getRegistroAgenda() + ","
                    + " '" + prontuario.getHistorico() + "',"
                    + " '" + prontuario.getReceituario() + "',"
                    + " '" + prontuario.getExames() + "',"
                    + " '" + prontuario.getCodigoPaciente() + ")";
            
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            
            strComandoSQL = "UPDATE agenda_consulta SET Atendido = 'S'"
                    + " WHERE Registro_Agenda = " + prontuario.getRegistroAgenda();
            
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            
            return true;            
        }catch(Exception erro){
            erro.printStackTrace(); 
            return false;
        }
    }
    
    public ResultSet listarAgenda(){            
        Conversao converter = new Conversao();
        Date dtData = new Date(System.currentTimeMillis());
        String strComandoSQL, strData;
        strData = converter.dataInvertida(dtData);
        
            try {
            strComandoSQL = "SELECT agenda_consulta.Registro_Agenda AS RegistroAgenda,"
                    + " agenda_consulta.Codigo_Paciente AS CodigoPaciente,"
                    + " agenda_consulta.Hora AS HoraConsulta,"
                    + " agenda_consulta.Cancelado,"
                    + " pacientes.Nome AS NomePaciente"
                    + " FROM agenda_consulta, pacientes"
                    + " WHERE (agenda_consulta.Codigo_Paciente = pacientes.Codigo_Paciente)"
                    + " AND (agenda_consulta.Cancelado <> 'S')"
                    + " AND (agenda_consulta.Atendido <> 'S')"
                    + " AND (agenda_consulta.Data = '" + strData + "')"
                    + " ORDER BY HoraConsulta";
                   
            psComando = conBanco.prepareStatement(strComandoSQL); 
            rsRegistro = psComando.executeQuery(); 
            return rsRegistro;
            
        }catch (Exception erro){
            erro.printStackTrace(); 
            return null;
        }
    }
        
    public ResultSet listarHistorico(int intCodigoPaciente){      
        String strComandoSQL;
        
        try {
            strComandoSQL = "SELECT prontuario_paciente.Codigo_Paciente AS RegistroAgenda,"
                    + " prontuario_paciente.Registro_Agenda AS RegistroAgenda,"
                    + " prontuario_paciente.Historico,"
                    + " prontuario_paciente.Receituario,"
                    + " prontuario_paciente.Exames,"
                    + " agenda_consulta.Data AS DataConsulta"
                    + " FROM prontuario_paciente, agenda_consulta"
                    + " WHERE (prontuario_paciente.Registro_Agenda ="
                    + " agenda_consulta.Registro_Agenda) AND"
                    + " (prontuario_paciente.Codigo_Paciente = " + intCodigoPaciente + ")"
                    + " ORDER BY DataConsulta";     
            psComando = conBanco.prepareStatement(strComandoSQL); 
            rsRegistro = psComando.executeQuery(); 
            return rsRegistro;
        }catch (Exception erro){
            erro.printStackTrace(); 
            return null;
        }
    }
}
