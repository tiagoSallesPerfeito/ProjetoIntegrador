/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.entidades;

/**
 *
 * @author 231-001063
 */
public class Usuarios {
    private int registroUsuario;
    private String identificacaoUsuario;
    private String senhaAcesso;
    private boolean cadastroFuncionario;
    private boolean cadastroUsuario;
    private boolean cadastroPaciente;
    private boolean cadastroEspecialidade;
    private boolean cadastroMedico;
    private boolean cadastroConvenio;
    private boolean agendamentoConculta;
    private boolean cancelamentConsulta;
    private boolean moduloAdministrativo;
    private boolean moduloAgendamento;
    private boolean moduloAtendimento;
        
    public Usuarios (){
        
    }

    public Usuarios(int registroUsuario, String identificacaoUsuario, String senhaAcesso, boolean cadastroFuncionario, boolean cadastroUsuario, boolean cadastroPaciente, boolean cadastroEspecialidade, boolean cadastroMedico, boolean cadastroConvenio, boolean agendamentoConculta, boolean cancelamentConsulta, boolean moduloAdministrativo, boolean moduloAgendamento, boolean moduloAtendimento) {
        this.registroUsuario = registroUsuario;
        this.identificacaoUsuario = identificacaoUsuario;
        this.senhaAcesso = senhaAcesso;
        this.cadastroFuncionario = cadastroFuncionario;
        this.cadastroUsuario = cadastroUsuario;
        this.cadastroPaciente = cadastroPaciente;
        this.cadastroEspecialidade = cadastroEspecialidade;
        this.cadastroMedico = cadastroMedico;
        this.cadastroConvenio = cadastroConvenio;
        this.agendamentoConculta = agendamentoConculta;
        this.cancelamentConsulta = cancelamentConsulta;
        this.moduloAdministrativo = moduloAdministrativo;
        this.moduloAgendamento = moduloAgendamento;
        this.moduloAtendimento = moduloAtendimento;
    }

    public int getRegistroUsuario() {
        return registroUsuario;
    }

    public void setRegistroUsuario(int registroUsuario) {
        this.registroUsuario = registroUsuario;
    }

    public String getIdentificacaoUsuario() {
        return identificacaoUsuario;
    }

    public void setIdentificacaoUsuario(String identificacaoUsuario) {
        this.identificacaoUsuario = identificacaoUsuario;
    }

    public String getSenhaAcesso() {
        return senhaAcesso;
    }

    public void setSenhaAcesso(String senhaAcesso) {
        this.senhaAcesso = senhaAcesso;
    }

    public boolean isCadastroFuncionario() {
        return cadastroFuncionario;
    }

    public void setCadastroFuncionario(boolean cadastroFuncionario) {
        this.cadastroFuncionario = cadastroFuncionario;
    }

    public boolean isCadastroUsuario() {
        return cadastroUsuario;
    }

    public void setCadastroUsuario(boolean cadastroUsuario) {
        this.cadastroUsuario = cadastroUsuario;
    }

    public boolean isCadastroPaciente() {
        return cadastroPaciente;
    }

    public void setCadastroPaciente(boolean cadastroPaciente) {
        this.cadastroPaciente = cadastroPaciente;
    }

    public boolean isCadastroEspecialidade() {
        return cadastroEspecialidade;
    }

    public void setCadastroEspecialidade(boolean cadastroEspecialidade) {
        this.cadastroEspecialidade = cadastroEspecialidade;
    }

    public boolean isCadastroMedico() {
        return cadastroMedico;
    }

    public void setCadastroMedico(boolean cadastroMedico) {
        this.cadastroMedico = cadastroMedico;
    }

    public boolean isCadastroConvenio() {
        return cadastroConvenio;
    }

    public void setCadastroConvenio(boolean cadastroConvenio) {
        this.cadastroConvenio = cadastroConvenio;
    }

    public boolean isAgendamentoConculta() {
        return agendamentoConculta;
    }

    public void setAgendamentoConculta(boolean agendamentoConculta) {
        this.agendamentoConculta = agendamentoConculta;
    }

    public boolean isCancelamentConsulta() {
        return cancelamentConsulta;
    }

    public void setCancelamentConsulta(boolean cancelamentConsulta) {
        this.cancelamentConsulta = cancelamentConsulta;
    }

    public boolean isModuloAdministrativo() {
        return moduloAdministrativo;
    }

    public void setModuloAdministrativo(boolean moduloAdministrativo) {
        this.moduloAdministrativo = moduloAdministrativo;
    }

    public boolean isModuloAgendamento() {
        return moduloAgendamento;
    }

    public void setModuloAgendamento(boolean moduloAgendamento) {
        this.moduloAgendamento = moduloAgendamento;
    }

    public boolean isModuloAtendimento() {
        return moduloAtendimento;
    }

    public void setModuloAtendimento(boolean moduloAtendimento) {
        this.moduloAtendimento = moduloAtendimento;
    }
    
}
