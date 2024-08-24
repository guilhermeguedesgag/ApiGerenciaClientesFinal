package com.digihub.gerenciaclientes.service;

import com.digihub.gerenciaclientes.entity.Clientes;
import com.digihub.gerenciaclientes.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class ClientesService {
    @Autowired
    private ClientesRepository clientesRepository;

    // Método para listar todos os clientes
    public List<Clientes> listarClientes() {
        // Lógica para buscar todos os clientes do banco de dados
        return clientesRepository.findAll(); // lógica de retorno;
    }

    public List<Clientes> buscarClientesPorNome(String nome) {
        return clientesRepository.findByNomeContaining(nome);
    }


    //metodoparasalvarum cliente
    public Clientes salvarCliente(Clientes cliente) {

        return clientesRepository.save(cliente);// lógica de retorno;
    }

    //metodo para deletar clientes pelo nome
    public void deletarClientePorId(UUID id){

            clientesRepository.deleteById(id);
        }



    }





