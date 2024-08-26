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
        return clientesRepository.findAll();
    }

    // metodo para buscar por nome
    public List <Clientes> listaClientesPorNome(String nome){
        List <Clientes> clientes = clientesRepository.findByNomeContaining(nome);
        if (clientes.isEmpty()){
            throw new NotFoundException("Nome informado: " + nome + " não encontrado no banco de dados.");
        }
        return  clientes;
    }


    // metodo para buscar os clientes por representante
    public List<Clientes> listaClientesPorRepresentante(String representante ) {
        List<Clientes> clientes = clientesRepository.findByRepresentanteContaining(representante);
        if (clientes.isEmpty()){
            throw new NotFoundException("Representante informado: "+ representante+  " não encontrado.");
        }
        return clientes;
    }



    // metodo para buscar os clientes por estado
    public List<Clientes> listaClientesPorEstado(String estado ) {
        List <Clientes> clientes = clientesRepository.findByEstadoContaining(estado);
        if (clientes.isEmpty()){
            throw new NotFoundException("Estado informado: "+ estado + " não encontrado.");
        }
        return clientes;
    }


    //metodoparasalvarum cliente
    public Clientes salvarCliente(Clientes cliente) {

        return clientesRepository.save(cliente);// lógica de retorno;
    }

    //metodo para deletar clientes pelo nome
    public void deletarClientePorId(UUID id){

            clientesRepository.deleteById(id);
    }


    //metodo para atualizar clientes através do UUID (id)
    @ExceptionHandler
    public Clientes atualizarCliente(UUID id, Clientes clienteAtualizado) {

        Optional<Clientes> optionalCliente = clientesRepository.findById(id);
        if (optionalCliente.isPresent()) {
            Clientes clienteExistente = optionalCliente.get();
            clienteExistente.setNome(clienteAtualizado.getNome());
            clienteExistente.setRepresentante(clienteAtualizado.getRepresentante());
            clienteExistente.setEstado(clienteAtualizado.getEstado());
            return clientesRepository.save(clienteExistente);
        } else {
            throw new NotFoundException("Cliente não encontrado com o ID: " + id);
        }
    }



}