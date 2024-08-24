package com.digihub.gerenciaclientes.controller;


import com.digihub.gerenciaclientes.entity.Clientes;
import com.digihub.gerenciaclientes.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

//@Controller
@RestController
@RequestMapping
public class ClientesController {

    @Autowired
    private ClientesService clientesService;


    // Endpoint para listar todos os clientes
    @GetMapping("/clientes")
    public List<Clientes> listar(){

//            return clientesService.buscarClientesPorNome(nome);
//        }
//    public List<Clientes> listar(@RequestParam(value = "nome", required = false)String nome) {
//        if (nome != null){
//            return clientesService.buscarClientesPorNome(nome);
//        }

        return clientesService.listarClientes();  // Chamando o serviço para buscar os clientes
    }

    // Endpoint para criar um novo cliente
    @PostMapping("/clientes")
    public Clientes criarCliente(@RequestBody Clientes cliente) {
        return clientesService.salvarCliente(cliente);  // Chamando o serviço para salvar o cliente
    }

    //Endpoint para deletar clientes pelo nome
    @DeleteMapping("{id}")
    public void deletarClientePorId(@RequestParam UUID id){
        clientesService.deletarClientePorId(id);
    }


}

