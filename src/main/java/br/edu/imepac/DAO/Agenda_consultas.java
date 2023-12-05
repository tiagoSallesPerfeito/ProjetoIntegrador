/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.DAO;

import br.edu.imepac.entidades.C_agenda_consultas;
import br.edu.imepac.entidades.C_convenios;
import br.edu.imepac.util.Conversao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author Matheus Carrasco
 */
public class Agenda_consultas {
    
    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistro;
    
    public void configurarConexao(Connection conBanco){
        this.conBanco = conBanco;
    }
    
    public boolean inserirRegistro(C_agenda_consultas agenda) { 
        Conversao converter = new Conversao();
        Date dtDataConsulta;        
        String strDataInvertida, strComandoSQL;    
        
        try { 
            
            dtDataConsulta = converter.StringToDate(agenda.getDataConsulta());
            
            if(dtDataConsulta != null){
                strDataInvertida = converter.dataInvertida(dtDataConsulta);
            }else{
                strDataInvertida = "null";
            }
            
            strComandoSQL = "INSERT INTO agenda_consulta (Codigo_Paciente,"
                    + "Codigo_Medico, Data, Hora, Retorno, Cancelado,"
                    + "Motivo_Cancelamento) VALUES ("
                    + agenda.getCodigoPaciente() + ", "
                    + agenda.getCodigoMedico() + ", "
                    + strDataInvertida + ", "
                    + "'" + agenda.getHoraConsulta() + "', "
                    + "'" + agenda.getRetornoConsulta() + "', "
                    + "'" + agenda.getConsultaCancelada() + "', "
                    + "'" + agenda.getMotivoCancelamento() + "')";
            
            psComando = conBanco.prepareStatement(strComandoSQL); 
            psComando.executeUpdate();
            return true;
        }catch (Exception erro){
            erro.printStackTrace(); 
            return false;
        }
    } 
    
    public ResultSet lerRegistro(int intRegistro){        
        String strComandoSQL;
        
            try {
                strComandoSQL = "SELECT * FROM agenda_consulta WHERE Registro_Agenda = "
                     + intRegistro;
            psComando = conBanco.prepareStatement(strComandoSQL); 
            rsRegistro = psComando.executeQuery(); 
            rsRegistro.next();
            return rsRegistro;
            
        }catch (Exception erro){
            erro.printStackTrace(); 
            return null;
        }
    }
    
    public boolean alterarRegistro(C_agenda_consultas agenda){
        String strComandoSQL;
        
        try{
            strComandoSQL = "UPDATE agenda_consulta SET Codigo_Medico = "
                    + agenda.getCodigoMedico() + ", "
                    + "Data = '" + agenda.getDataConsulta() + "', "
                    + "Hora = '" + agenda.getHoraConsulta() + "' "
                    + "WHERE Registro_Agenda = " + agenda.getRegistro();
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;
            
        }catch (Exception erro){
            erro.printStackTrace(); 
            return false;
        }
    }
    
    
    
}
