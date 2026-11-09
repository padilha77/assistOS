package com.assistos.repository;

import com.assistos.model.Cliente;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

        private final List<Cliente> clientes = new ArrayList<>();

        // salvar dados do cliente
        public void salvar(Cliente cliente) {

            this.clientes.add(cliente);

        }

        // listar todos os clientes
        public List<Cliente> listar() {

            return List.copyOf(clientes);

        }

        // excluir cliente
        public void excluir(String id) {
        Cliente cliente = buscarPorId(id);

        if (cliente == null) {
            return;
        }
            clientes.remove(cliente);
        }

       // gerar ID automaticamente para cliente sendo cadastrado
        public String gerarId() {
        SecureRandom id = new SecureRandom();

        long idU = Math.abs(id.nextLong());
        System.out.println("ID do cliente: \n" + idU);

        return String.valueOf(idU);
    }

        // listar dados do cliente
        public void listarDados(Cliente cliente) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf()); System.out.println("RG: " + cliente.getRg());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("ID: " + cliente.getId());
        }

        // buscar cliente por ID
        public Cliente buscarPorId(String id) {
            for (Cliente cliente : clientes) {
                if (cliente.getId().equals(id)) {
                    return cliente;
                }
            }
            return null;
        }

        // aualizar dados do cliente
        public boolean atualizar(Cliente cliente) {
            Cliente cadastrado = buscarPorId(cliente.getId());
            if (cadastrado == null) {
                return false;
            }

            cadastrado.setNome(cliente.getNome());
            cadastrado.setCpf(cliente.getCpf());
            cadastrado.setTelefone(cliente.getTelefone());
            cadastrado.setEmail(cliente.getEmail());
            cadastrado.setRg(cliente.getRg());
            return true;
        }
}
