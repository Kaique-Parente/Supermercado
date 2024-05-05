package com.mycompany.supermercado.models;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Cliente {
    
    private Integer clienteID;
    private String nome;
    private Long cpf;
    private Long telefone;
    private String email;
    private String estadoCivil;
    private String sexo;
    private String rua;
    private String estado;
    private String bairro;
    private LocalDate dataNascimento;

    public Cliente(Integer clienteID, String nome, Long cpf, Long telefone, String email, String estadoCivil, String sexo, String rua, String estado, String bairro, LocalDate dataNascimento) {
        this.clienteID = clienteID;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.rua = rua;
        this.estado = estado;
        this.bairro = bairro;
        this.dataNascimento = dataNascimento;
    }

    public Cliente(String nome, Long cpf, Long telefone, String email, String estadoCivil, String sexo, String rua, String estado, String bairro, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.rua = rua;
        this.estado = estado;
        this.bairro = bairro;
        this.dataNascimento = dataNascimento;
    }

    public Integer getClienteID() {
        return clienteID;
    }

    public void setClienteID(Integer clienteID) {
        this.clienteID = clienteID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public static Date convertToDate(LocalDate data) {
        return Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
    public static LocalDate convertToLocalDate(Date data) {
        return Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
