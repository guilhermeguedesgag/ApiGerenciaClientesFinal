package com.digihub.gerenciaclientes.repository;

import com.digihub.gerenciaclientes.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClientesRepository extends JpaRepository <Clientes, UUID>{
    List<Clientes> findByNomeContaining(String nome);
    List <Clientes> findByRepresentanteContaining(String representante);
    List <Clientes> findByEstadoContaining(String estado);
}
