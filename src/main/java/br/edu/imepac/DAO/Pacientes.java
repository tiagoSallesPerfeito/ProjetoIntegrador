/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.DAO;

import br.edu.imepac.entidades.C_pacientes;
import br.edu.imepac.util.Conversao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author Matheus Carrasco
 */
public class Pacientes {
    
    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistro;
    
    public void configurarConexao(Connection conBanco) {
        this.conBanco = conBanco;
    }
    
    public boolean inserirRegistro(C_pacientes paciente){
        Conversao converter = new Conversao();
        Date dtDataNascimento;
        String strDataInvertida, strComandoSQL;
        
        try{
            dtDataNascimento = converter.StringToDate(paciente.getDataNascimento());
            
            if(dtDataNascimento != null){
                strDataInvertida = converter.dataInvertida(dtDataNascimento);
            }else{
                strDataInvertida = "null";
            }
            
            if(!(strDataInvertida.equals("null"))){
                strDataInvertida =  "'" + strDataInvertida + "'";
            }
            
            strComandoSQL = "INSERT INTO pacientes(Nome, Numero_RG, Orgao_Emissor, "
                    + "Numero_CPF, Endereco, Numero, Complemento, Bairro, Cidade, "
                    + "Estado, Telefone, Celular, Data_Nascimento, Sexo, Tem_Convenio, "
                    + "Codigo_Convenio, Senha_Acesso) VALUES ("
                    + "'" + paciente.getNomeCompleto() + "', "
                    + "'" + paciente.getNumeroRg() + "', "
                    + "'" + paciente.getOrgaoEmissor() + "', "
                    + "'" + paciente.getNumeroCpf() + "', "
                    + "'" + paciente.getEndereco() + "', "
                    + "'" + paciente.getNumero() + "', "
                    + "'" + paciente.getComplemento() + "', "
                    + "'" + paciente.getBairro() + "', "
                    + "'" + paciente.getCidade() + "', "
                    + "'" + paciente.getEstado() + "', "
                    + "'" + paciente.getTelefone() + "', "
                    + "'" + paciente.getCelular() + "', "
                    + "" + strDataInvertida + ", "
                    + "'" + paciente.getSexo() + "', "
                    + "'" + paciente.getTemConvenio() + "', "
                    + "'" + paciente.getCodigoConvenio() + "', "
                    + "'" + paciente.getSenhaAcesso() + "');";
            
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;
        }catch (Exception erro){
            erro.printStackTrace();
            return false;
        }
    }
    
    public int localizarRegistro(String strCampo, String strValor) {        
        int intCodigoPaciente = 0;
        String strComandoSQL;

        try{
            
            if(strCampo.equalsIgnoreCase("NOME")){
                strComandoSQL = "SELECT Codigo_Paciente FROM pacientes WHERE "
                            + "Nome LIKE '%" + strValor.toUpperCase() + "%'";
            }else if(strCampo.equals("RG")){
                strComandoSQL = "SELECT Codigo_Paciente FROM pacientes WHERE "
                            + "Numero_RG = '" + strValor + "'";                   
            }else{
                strComandoSQL = "SELECT Codigo_Paciente FROM pacientes WHERE "
                            + "Numero_CPF = '" + strValor + "'";     
            }
            psComando = conBanco.prepareStatement(strComandoSQL);
            rsRegistro = psComando.executeQuery();
            rsRegistro.next();
            
            intCodigoPaciente = rsRegistro.getInt("Codigo_Paciente");
                            
        }catch (Exception erro){
            erro.printStackTrace(); 
        }        
        return intCodigoPaciente;
    }
    
     public ResultSet lerRegistro(int intCodigoPaciente){        
        String strComandoSQL;
        
        try {
            strComandoSQL = "SELECT * FROM pacientes WHERE Codigo_Paciente = "
                     + intCodigoPaciente;
            psComando = conBanco.prepareStatement(strComandoSQL); 
            rsRegistro = psComando.executeQuery(); 
            rsRegistro.next();
            return rsRegistro;
        }catch (Exception erro){
            erro.printStackTrace(); 
            return null;
        }
    }
     
    public ResultSet listarRegistros(String strNome){
        String strComandoSQL;        
        try { 
            
            if(strNome.equals("")){
                strComandoSQL = "SELECT * FROM pacientes ORDER BY Nome";
            }else{
                strComandoSQL = "SELECT Codigo_Paciente, Nome, Numero_RG, "
                        + "Numero_CPF FROM pacientes WHERE Nome LIKE '%"
                        + strNome.toUpperCase() + "%' ORDER BY Nome";                        
            }
            psComando = conBanco.prepareStatement(strComandoSQL);
            rsRegistro = psComando.executeQuery();
            return rsRegistro;
            
        }catch (Exception erro){
            erro.printStackTrace(); 
            return null;
        } 
    }
}
