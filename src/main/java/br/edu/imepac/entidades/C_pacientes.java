/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.entidades;

/**
 *
 * @author Matheus Carrasco
 */
public class C_pacientes extends C_pessoa {
    
    private int codigo_paciente, codigo_convenio;
    private String tem_convenio, senha_acesso;

    public C_pacientes() {
        super("", "", "", "",
                "", "", "", "",
                "", "", "", "", "",
                "", "", "");
        this.tem_convenio = "N";
        this.senha_acesso = "";
    }

    public C_pacientes(int codigo_convenio, 
            String tem_convenio, 
            String nome_completo, 
            String numero_rg,
            String orgao_emissor, 
            String numero_cpf, 
            String endereco, 
            String numero, 
            String complemento,
            String bairro, 
            String cidade, 
            String estado, 
            String telefone, 
            String celular, 
            String sexo,
            String dia_nascimento, 
            String mes_nascimento, 
            String ano_nascimento) {
        super(nome_completo, numero_rg, orgao_emissor, numero_cpf, endereco, 
                numero, complemento, bairro, cidade, estado, telefone, celular, 
                sexo, dia_nascimento, mes_nascimento, ano_nascimento);
        
        this.codigo_convenio = codigo_convenio;
        this.tem_convenio = tem_convenio;
    }

    public int getCodigoPaciente() {
        return codigo_paciente;
    }
    public void setCodigoPaciente(int codigo_paciente) {
        this.codigo_paciente = codigo_paciente;
    }

    public int getCodigoConvenio() {
        return codigo_convenio;
    }
    public void setCodigoConvenio(int codigo_convenio) {
        this.codigo_convenio = codigo_convenio;
    }

    public String getTemConvenio() {
        return tem_convenio;
    }
    public void setTemConvenio(String tem_convenio) {
        this.tem_convenio = tem_convenio;
    }

    public String getSenhaAcesso() {
        return senha_acesso;
    }
    public void setSenhaAcesso(String senha_acesso) {
        this.senha_acesso = senha_acesso.toUpperCase();
    }
}
