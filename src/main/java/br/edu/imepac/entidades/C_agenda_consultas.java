/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.entidades;

/**
 *
 * @author Matheus Carrasco
 */
public class C_agenda_consultas {
    
    private int registro;
    private int codigo_paciente;
    private int codigo_medico;
    private String data_consulta;
    private String hora_consulta;
    private String retorno_consulta;
    private String consulta_cancelada;
    private String motivo_cancelamento;
    
    public C_agenda_consultas(){
        registro = 0;
        codigo_paciente = 0;
        codigo_medico = 0;
        data_consulta = "";
        hora_consulta = "";
        retorno_consulta = "";
        consulta_cancelada = "";
        motivo_cancelamento = "";
    }

    public C_agenda_consultas(  int codigo_paciente, 
                                int codigo_medico, 
                                String data_consulta, 
                                String hora_consulta, 
                                String retorno_consulta, 
                                String consulta_cancelada, 
                                String motivo_cancelamento) {
        this.codigo_paciente = codigo_paciente;
        this.codigo_medico = codigo_medico;
        this.data_consulta = data_consulta;
        this.hora_consulta = hora_consulta;
        this.retorno_consulta = retorno_consulta;
        this.consulta_cancelada = consulta_cancelada;
        this.motivo_cancelamento = motivo_cancelamento;
    }

    public int getRegistro() {
        return registro;
    }
    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public int getCodigoPaciente() {
        return codigo_paciente;
    }
    public void setCodigoPaciente(int codigo_paciente) {
        this.codigo_paciente = codigo_paciente;
    }

    public int getCodigoMedico() {
        return codigo_medico;
    }
    public void setCodigoMedico(int codigo_medico) {
        this.codigo_medico = codigo_medico;
    }

    public String getDataConsulta() {
        return data_consulta;
    }
    public void setDataConsulta(String data_consulta) {
        this.data_consulta = data_consulta;
    }

    public String getHoraConsulta() {
        return hora_consulta;
    }
    public void setHoraConsulta(String hora_consulta) {
        this.hora_consulta = hora_consulta;
    }

    public String getRetornoConsulta() {
        return retorno_consulta;
    }
    public void setRetornoConsulta(String retorno_consulta) {
        this.retorno_consulta = retorno_consulta;
    }

    public String getConsultaCancelada() {
        return consulta_cancelada;
    }
    public void setConsultaCancelada(String consulta_cancelada) {
        this.consulta_cancelada = consulta_cancelada;
    }

    public String getMotivoCancelamento() {
        return motivo_cancelamento;
    }
    public void setMotivoCancelamento(String motivo_cancelamento) {
        this.motivo_cancelamento = motivo_cancelamento;
    }
    
    
    
}
