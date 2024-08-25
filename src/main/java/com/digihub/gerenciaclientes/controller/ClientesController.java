package com.digihub.gerenciaclientes.controller;


import com.digihub.gerenciaclientes.entity.Clientes;
import com.digihub.gerenciaclientes.exceptions.NotFoundException;
import com.digihub.gerenciaclientes.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        System.out.println("Um campo foi deletado");
    }

    //Endpoint para atualizar um cliente existente

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Clientes> atualizarClientes(@PathVariable UUID id, @RequestBody Clientes clienteAtualizado) {
        try {
            // Chama o serviço para atualizar o cliente passando o ID e os novos dados
            Clientes cliente = clientesService.atualizarCliente(id, clienteAtualizado);
            return ResponseEntity.ok(cliente); // Retorna o cliente atualizado na resposta
        } catch (NotFoundException e) {
            // Se o cliente não for encontrado, retorna um status 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }




}

