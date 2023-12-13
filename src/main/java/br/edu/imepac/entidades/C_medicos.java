/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.entidades;

/**
 *
 * @author Matheus Carrasco
 */
public class C_medicos {
    
    private int codigo_medico;
    private String nome_medico, CRM;
    private Integer codigo_especialidade;
    
    public C_medicos(){
        codigo_medico = 0;
        nome_medico = "";
        CRM = "";
        codigo_especialidade = 0;
    }

    public C_medicos(int codigo_medico, 
            String nome_medico, 
            String CRM, 
            int codigo_especialidade) {
        this.codigo_medico = codigo_medico;
        this.nome_medico = nome_medico.toUpperCase();
        this.CRM = CRM;
        this.codigo_especialidade = codigo_especialidade;
    }

    public int getCodigoMedico() {
        return codigo_medico;
    }
    public void setCodigoMedico(int codigo_medico) {
        this.codigo_medico = codigo_medico;
    }

    public String getNomeMedico() {
        return nome_medico;
    }
    public void setNomeMedico(String nome_medico) {
        this.nome_medico = nome_medico.toUpperCase();
    }

    public String getCRM() {
        return CRM;
    }
    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public int getCodigoEspecialidade() {
        return codigo_especialidade;
    }
    public void setCodigoEspecialidade(Integer codigo_especialidade) {
        this.codigo_especialidade = codigo_especialidade;
    }   
}
