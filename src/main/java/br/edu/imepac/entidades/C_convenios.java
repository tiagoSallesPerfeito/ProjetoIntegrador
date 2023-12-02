/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.entidades;

/**
 *
 * @author Matheus Carrasco
 */
public class C_convenios {
    
    private String nomeConvenio, CNPJ, telefone;
    private int codigoConvenio;
    
    public C_convenios(){
        this.nomeConvenio = "";
        this.CNPJ = "";
        this.telefone = "";
        this.codigoConvenio = 0;
    }

    public C_convenios( String nomeConvenio, 
                        String CNPJ,
                        String telefone) {
        this.nomeConvenio = nomeConvenio;
        this.CNPJ = CNPJ;
        this.telefone = telefone;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }
    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getCodigoConvenio() {
        return codigoConvenio;
    }
    public void setCodigoConvenio(int codigoConvenio) {
        this.codigoConvenio = codigoConvenio;
    }   
}
