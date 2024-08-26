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

    // metodo para buscar todos os clientes
    public List<Clientes> listarClientes() {
        
        return clientesRepository.findAll(); // lógica de retorno;
    }

    // metodo para buscar os clientes por nome
    public List<Clientes> listaClientesPorNome(String nome) {
        return clientesRepository.findByNomeContaining(nome);
    }

    // metodo para buscar os clientes por representante
    public List<Clientes> listaClientesPorRepresentante(String representante ) {
        return clientesRepository.findByRepresentanteContaining(representante);
    }

    // metodo para buscar os clientes por estado
    public List<Clientes> listaClientesPorEstado(String estado ) {
        return clientesRepository.findByEstadoContaining(estado);
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





