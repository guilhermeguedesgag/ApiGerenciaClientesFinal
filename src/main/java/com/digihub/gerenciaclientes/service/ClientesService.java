package com.digihub.gerenciaclientes.service;

import com.digihub.gerenciaclientes.entity.Clientes;
import com.digihub.gerenciaclientes.exceptions.NotFoundException;
import com.digihub.gerenciaclientes.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;
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
    
        
     @ExceptionHandler   
    //metodo para atualizar clientes
    public Clientes atualizarCliente(UUID id, Clientes clienteAtualizado) {
        // Lógica para encontrar o cliente pelo ID e atualizar suas informações
        Optional<Clientes> optionalCliente = clientesRepository.findById(id);
        if (optionalCliente.isPresent()) {
            Clientes clienteExistente = optionalCliente.get();
            clienteExistente.setNome(clienteAtualizado.getNome());
            clienteExistente.setRepresentante(clienteAtualizado.getRepresentante());
            clienteExistente.setEstado(clienteAtualizado.getEstado());
            return clientesRepository.save(clienteExistente); // Salva as atualizações
        } else {
            throw new NotFoundException("Cliente não encontrado com o ID: " + id);
        }
    }



    }





