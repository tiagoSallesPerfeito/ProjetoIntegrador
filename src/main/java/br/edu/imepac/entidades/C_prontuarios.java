/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.entidades;

/**
 *
 * @author Matheus Carrasco
 */
public class C_prontuarios {
    
    private int registro_agenda;
    private String historico;
    private String receituario;
    private String exames;
    private int codigo_paciente;
    
    public C_prontuarios(){
        registro_agenda = 0;
        historico = "";
        receituario = "";
        exames = "";
        codigo_paciente = 0;
    }

    public C_prontuarios(   int registro_agenda, 
                            String historico, 
                            String receituario, 
                            String exames, 
                            int codigo_paciente) {
        this.registro_agenda = registro_agenda;
        this.historico = historico;
        this.receituario = receituario;
        this.exames = exames;
        this.codigo_paciente = codigo_paciente;
    }

    public int getRegistroAgenda() {
        return registro_agenda;
    }
    public void setRegistroAgenda(int registro_agenda) {
        this.registro_agenda = registro_agenda;
    }

    public String getHistorico() {
        return historico;
    }
    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getReceituario() {
        return receituario;
    }
    public void setReceituario(String receituario) {
        this.receituario = receituario;
    }

    public String getExames() {
        return exames;
    }
    public void setExames(String exames) {
        this.exames = exames;
    }

    public int getCodigoPaciente() {
        return codigo_paciente;
    }
    public void setCodigoPaciente(int codigo_paciente) {
        this.codigo_paciente = codigo_paciente;
    }
}
