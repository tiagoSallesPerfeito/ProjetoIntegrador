/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.DAO;

import br.edu.imepac.entidades.C_usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Matheus Carrasco
 */
public class Usuarios {

    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistro;

    public void configurarConexao(Connection conBanco) {
        this.conBanco = conBanco;
    }

    public boolean inserirRegistro(C_usuarios usuario) {
        String strComandoSQL;

        try {
            strComandoSQL = "INSERT INTO usuarios (Identificacao_Usuario, "
                    + "Senha_Acesso, "
                    + "Cadastro_Funcionario, "
                    + "Cadastro_Usuario, "
                    + "Cadastro_Paciente, "
                    + "Cadastro_Especialidade, "
                    + "Cadastro_Medico, "
                    + "Cadastro_Convenio, "
                    + "Agendamento_Consulta, "
                    + "Cancelamento_Consulta, "
                    + "Modulo_Administrativo, "
                    + "Modulo_Agendamento, "
                    + "Modulo_Atendimento) values ('" + usuario.getIdUsuario() + 
                    "','" + usuario.getSenhaAcesso() + 
                    "','" + usuario.getCadastroFuncionario() + 
                    "','" + usuario.getCadastroUsuario() + 
                    "','"+ usuario.getCadastroPaciente() + 
                    "','" + usuario.getCadastroEspecialidade() + 
                    "','" + usuario.getCadastroMedico() + 
                    "','" + usuario.getCadastroConvenio() + 
                    "','" + usuario.getAgendamentoConsulta() + 
                    "','" + usuario.getCancelamentoConsulta() + 
                    "','" + usuario.getModuloAdministrativo() + 
                    "','" + usuario.getModuloAgendamento() + 
                    "','" + usuario.getModuloAtendimento() + "');"; 
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;
        }catch (Exception erro){
            erro.printStackTrace(); 
            return false;
        }
    }
    
    public int localizarRegistro(String strUsuario) {        
        int intCodigoUsuario = 0;
        String strComandoSQL;

        try{
            strComandoSQL = "SELECT Registro_Usuario FROM usuarios WHERE "
                            + "Identificacao_Usuario = '" + strUsuario + "'";
            rsRegistro = psComando.executeQuery();
            rsRegistro.next();
            
            intCodigoUsuario = rsRegistro.getInt("Registro_Usuario");
                            
        }catch (Exception erro){
            erro.printStackTrace(); 
        }        
        return intCodigoUsuario;
    }
    
    public ResultSet lerRegistro(int intCodigoUsuario){        
        String strComandoSQL;
        
        try {
            strComandoSQL = "SELECT * FROM usuarios WHERE Registro_Usuario = "
                     + intCodigoUsuario;
            psComando = conBanco.prepareStatement(strComandoSQL); 
            rsRegistro = psComando.executeQuery(); 
            rsRegistro.next();
            return rsRegistro;
        }catch (Exception erro){
            erro.printStackTrace(); 
            return null;
        }
    }
    
    public boolean alterarRegistro(C_usuarios usuario){
        String strComandoSQL;
        
        try{
            strComandoSQL = "UPDATE usuarios SET Identificacao_Usuario = '" 
                            + usuario.getIdUsuario() + "', " + 
                            "Senha_Acesso = " + usuario.getSenhaAcesso() + "', " +
                            "Cadastro_Funcionario = " + usuario.getCadastroFuncionario() + "', " +
                            "Cadastro_Usuario = " + usuario.getCadastroUsuario() + "', " +
                            "Cadastro_Paciente = " + usuario.getCadastroPaciente() + "', " + 
                            "Cadastro_Especialidade = " + usuario.getCadastroEspecialidade() + "', " +
                            "Cadastro_Medico = " + usuario.getCadastroMedico() + "', " +
                            "Cadastro_Convenio = " + usuario.getCadastroConvenio() + "', " +
                            "Agendamento_Consulta = " + usuario.getAgendamentoConsulta() + "', " +
                            "Cancelamento_Consulta = " + usuario.getCancelamentoConsulta() + "', " +
                            "Modulo_Administrativo = " + usuario.getModuloAdministrativo() + "', " +
                            "Modulo_Agendamento = " + usuario.getModuloAgendamento() + "', " +
                            "Modulo_Atendimento = " + usuario.getModuloAtendimento() +  "', " +
                            " WHERE Registro_Usuario = " + usuario.getCodigoUsuario();
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;
            
        }catch (Exception erro){
            erro.printStackTrace(); 
            return false;
        }
    }
    
    public boolean excluirRegistro(int intCodigoUsuario){
                String strComandoSQL;        
        try { 
            strComandoSQL = "DELETE FROM usuarios WHERE Registro_Usuario = " + intCodigoUsuario; 
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;    
        }catch (Exception erro){
            erro.printStackTrace(); 
            return false;
        }
    }
}
