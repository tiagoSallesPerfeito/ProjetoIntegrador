/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.entidades;

/**
 *
 * @author Matheus Carrasco
 */
public class C_funcionarios extends C_pessoa {
    
    private int codigo_funcionario;
    private String numero_ctps;
    private String numero_pis;

    public C_funcionarios() {
        super(  "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "", "");
        this.numero_ctps = "";
        this.numero_pis = "";
    }

    public C_funcionarios(  int codigo_funcionario, 
                            String numero_ctps, String numero_pis, 
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
        super(nome_completo, numero_rg, orgao_emissor, numero_cpf,endereco, 
             numero, complemento, bairro, cidade, estado, telefone,celular, 
             sexo, dia_nascimento, mes_nascimento, ano_nascimento);
        this.numero_ctps = numero_ctps;
        this.numero_pis = numero_pis;
    }

    public int getCodigo_funcionario() {
        return codigo_funcionario;
    }
    public void setCodigo_funcionario(int codigo_funcionario) {
        this.codigo_funcionario = codigo_funcionario;
    }

    public String getNumero_ctps() {
        return numero_ctps;
    }
    public void setNumero_ctps(String numero_ctps) {
        this.numero_ctps = numero_ctps;
    }

    public String getNumero_pis() {
        return numero_pis;
    }
    public void setNumero_pis(String numero_pis) {
        this.numero_pis = numero_pis;
    }
}
