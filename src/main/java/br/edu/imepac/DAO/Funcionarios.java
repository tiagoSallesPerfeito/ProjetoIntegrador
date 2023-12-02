/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.DAO;

import br.edu.imepac.entidades.C_funcionarios;
import br.edu.imepac.util.Conversao;
import com.google.protobuf.Internal.ListAdapter.Converter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author Matheus Carrasco
 */
public class Funcionarios {
    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistro;

    public void configurarConexao(Connection conBanco) {
        this.conBanco = conBanco;
    }
    
    public boolean inserirRegistro(C_funcionarios funcionario){
        Conversao Converter = new Conversao();
        Date dtDataNascimento;
        String strDataInvertida, strComandoSQL;
        
        try{
            dtDataNascimento = Converter.StringToDate(funcionario.getDataNascimento());
            
            if(dtDataNascimento != null){
                strDataInvertida = Converter.dataInvertida(dtDataNascimento);
            }else{
                strDataInvertida = "null";
            }
            if(!(strDataInvertida.equals("null"))){
                strDataInvertida = "'" + strDataInvertida + "'";
            }
            
            strComandoSQL = "INSERT INTO funcionarios (Nome_Completo, Numero_RG,"
                    + " Orgao_Emissor, Numero_CPF, Endereco, Numero, Complemento,"
                    + " Bairro, Cidade, Estado, Telefone, Celular, Numero_CTPS,"
                    + " Numero_PIS, Sexo, Data_Nascimento) VALUES ('" 
                    + funcionario.getNomeCompleto() + "',"
                    + funcionario.getNumeroRg() + "',"
                    + funcionario.getOrgaoEmissor() +"',"
                    + funcionario.getNumeroCpf() + "',"
                    + funcionario.getEndereco() + "',"
                    + funcionario.getNumero() + "',"
                    + funcionario.getComplemento() + "',"
                    + funcionario.getBairro() + "',"
                    + funcionario.getCidade() + "',"
                    + funcionario.getEstado() + "',"
                    + funcionario.getTelefone() + "',"
                    + funcionario.getCelular() + "',"
                    + funcionario.getNumero_ctps() + "',"
                    + funcionario.getNumero_pis() + "',"
                    + funcionario.getSexo() + "',"
                    + strDataInvertida + ")";

            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            
            return true;
            
        }catch (Exception erro){
            erro.printStackTrace(); 
            return false;            
        }
    }
    
    public int localizarRegistro(String strCampo, String strValor) {        
        int intCodigoFuncionario = 0;
        String strComandoSQL;
        
        try{
            if(strCampo.equals("NOME")){
                strComandoSQL = "SELECT Codigo_Funcionario From funcionarios WHERE"
                        + " Nome_Completo LIKE '%" + strValor + "%'";
            }else if(strCampo.equals("RG")){
                strComandoSQL = "SELECT Codigo_Funcionario From funcionarios WHERE"
                        + " Numero_RG = '" + strValor + "'";
            }else{
                strComandoSQL = "SELECT Codigo_Funcionario From funcionarios WHERE"
                        + " Numero_CPF = '" + strValor + "'";
            }
            
            psComando = conBanco.prepareStatement(strComandoSQL);
            rsRegistro = psComando.executeQuery();
            rsRegistro.next();
            
            intCodigoFuncionario = rsRegistro.getInt("Codigo_Funcionario");
            
        }catch(Exception erro){
            erro.printStackTrace();
        }
      return intCodigoFuncionario;        
    }  
    
    public ResultSet lerRegistro(int intCodigoFuncionario){        
        String strComandoSQL;
        
                try {
            strComandoSQL = "SELECT * FROM funcionarios WHERE Codigo_Funcionario = "
                     + intCodigoFuncionario;
            psComando = conBanco.prepareStatement(strComandoSQL); 
            rsRegistro = psComando.executeQuery(); 
            rsRegistro.next();
            return rsRegistro;
            
        }catch (Exception erro){
            erro.printStackTrace(); 
            return null;
        }
    }
    
    public boolean alterarRegistro(C_funcionarios funcionario){
        
        Conversao converter = new Conversao();
        Date dtDataNascimento;
        String strDataInvertida, strComandoSQL;
        
        try{
            dtDataNascimento = converter.StringToDate(funcionario.getDataNascimento());
            
            if(dtDataNascimento != null){
                strDataInvertida = converter.dataInvertida(dtDataNascimento);
                
            }else{
                strDataInvertida = "null";                
            }
            
            if(!(strDataInvertida.equals("null"))){
                strDataInvertida = "'" + strDataInvertida + "'";
            }
            
            strComandoSQL = "UPDATE funcionarios SET Nome_Completo = '"
                    + funcionario.getNomeCompleto() + "'," +
                    "Numero_RG = '" + funcionario.getNumeroRg() + "'," +
                    "Orgao_Emissor = '" + funcionario.getOrgaoEmissor() + "'," +
                    "Numero_CPF = '" + funcionario.getNumeroCpf() + "'," +  
                    "Endereco = '" + funcionario.getEndereco() + "'," +  
                    "Numero = '" + funcionario.getNumero() + "'," +
                    "Complemento = " + funcionario.getComplemento() + "'," +
                    "Bairro = " + funcionario.getBairro() + "'," +
                    "Cidade = " + funcionario.getCidade() + "'," +
                    "Estado = " + funcionario.getEstado() + "'," +
                    "Telefone = " + funcionario.getTelefone() + "'," +
                    "Celular = " + funcionario.getCelular() + "'," +
                    "Numero_CTPS = " + funcionario.getNumero_ctps() + "'," +
                    "Numero_PIS = " + funcionario.getNumero_pis() + "'," +
                    "Sexo = " + funcionario.getSexo() + "'," +
                    "Data_Nascimento = " + strDataInvertida + 
                    " WHERE Codigo_Funcionario = " + funcionario.getCodigo_funcionario();
            
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;
        
        }catch (Exception erro){
            erro.printStackTrace(); 
            return false;
        }
    }
    
        public boolean excluirRegistro(int intCodigoFuncionario){
                String strComandoSQL;        
        try { 
            strComandoSQL = "DELETE FROM usuarios WHERE Codigo_Funcionario = " + intCodigoFuncionario; 
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
            strComandoSQL = "SELECT * FROM funcionarios ORDER BY Nome_Completo";
            psComando = conBanco.prepareStatement(strComandoSQL);
            rsRegistro = psComando.executeQuery();
            return rsRegistro;
        }catch (Exception erro){
            erro.printStackTrace(); 
            return null;
        } 
    }
}
