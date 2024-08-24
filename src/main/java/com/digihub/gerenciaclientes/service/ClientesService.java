package com.digihub.gerenciaclientes.service;

import com.digihub.gerenciaclientes.entity.Clientes;
import com.digihub.gerenciaclientes.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientesService {
    @Autowired
    private ClientesRepository clientesRepository;

    // Método para listar todos os clientes
    public List<Clientes> listarClientes() {
        // Lógica para buscar todos os clientes do banco de dados
        return clientesRepository.findAll(); // lógica de retorno;
    }

    // Método para salvar um cliente
    public Clientes salvarCliente(Clientes cliente) {
        // Lógica para salvar o cliente no banco de dados

        return clientesRepository.save(cliente);// lógica de retorno;
    }
}

