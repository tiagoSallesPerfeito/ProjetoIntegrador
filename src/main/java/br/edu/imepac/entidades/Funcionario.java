/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.entidades;

import java.util.Date;

/**
 *
 * @author Matheus Carrasco
 */
public class Funcionario {
    
    private int codFuncionario;
    private String nome;
    private String rg;
    private int CPF;
    private String endereco;
    private String telefone;
    private String numCTPS;
    private String numPis;
    private Date dataNascimento;
    
    public Funcionario(){        
    }
    
    public Funcionario(int codFuncionario, String nome, String rg, int CPF, String endereco, String telefone, String numCTPS, String numPis, Date dataNascimento) {
        this.codFuncionario = codFuncionario;
        this.nome = nome;
        this.rg = rg;
        this.CPF = CPF;
        this.endereco = endereco;
        this.telefone = telefone;
        this.numCTPS = numCTPS;
        this.numPis = numPis;
        this.dataNascimento = dataNascimento;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNumCTPS() {
        return numCTPS;
    }

    public void setNumCTPS(String numCTPS) {
        this.numCTPS = numCTPS;
    }

    public String getNumPis() {
        return numPis;
    }

    public void setNumPis(String numPis) {
        this.numPis = numPis;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
    
    
}