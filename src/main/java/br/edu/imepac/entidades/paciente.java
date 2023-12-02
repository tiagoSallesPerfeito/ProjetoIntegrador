/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.entidades;

/**
 *
 * @author 231-001308
 */
public class paciente {
   private int registro;
     private int registroAgenda;
     private String historico;
     private String receituario;
     private String exames;
     public paciente (){
     } 

    public paciente(int registro, int registroAgenda, String historico, String receituario, String exames) {
        this.registro = registro;
        this.registroAgenda = registroAgenda;
        this.historico = historico;
        this.receituario = receituario;
        this.exames = exames;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public int getRegistroAgenda() {
        return registroAgenda;
    }

    public void setRegistroAgenda(int registroAgenda) {
        this.registroAgenda = registroAgenda;
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
     
     
 }

