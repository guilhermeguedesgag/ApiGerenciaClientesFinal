package com.digihub.gerenciaclientes.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.dao.UncategorizedDataAccessException;

import java.util.UUID;

@Entity
@Getter
@ToString

public class Clientes {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;
        private String nome;
        private String representante;
        private String estado;


    public Clientes() {
    }


    // Construtor completo
    public Clientes(String nome, String representante, String estado) {
//        this.id = id;
        this.nome = nome;
        this.representante = representante;
        this.estado = estado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}


